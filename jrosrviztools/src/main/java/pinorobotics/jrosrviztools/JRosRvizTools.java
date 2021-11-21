/*
 * Copyright 2021 jrosrviztools project
 * 
 * Website: https://github.com/pinorobotics/jrosrviztools
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * Authors:
 * - aeon_flux <aeon_flux@eclipso.ch>
 */
package pinorobotics.jrosrviztools;

import java.io.Closeable;
import java.io.IOException;

import id.jrosclient.JRosClient;
import id.jrosclient.TopicSubmissionPublisher;
import id.jrosmessages.geometry_msgs.PointMessage;
import id.jrosmessages.geometry_msgs.PoseMessage;
import id.jrosmessages.geometry_msgs.QuaternionMessage;
import id.jrosmessages.geometry_msgs.Vector3Message;
import id.jrosmessages.primitives.Duration;
import id.jrosmessages.primitives.Time;
import id.jrosmessages.std_msgs.ColorRGBAMessage;
import id.jrosmessages.std_msgs.HeaderMessage;
import id.jrosmessages.std_msgs.StringMessage;
import id.jrosmessages.visualization_msgs.MarkerArrayMessage;
import id.jrosmessages.visualization_msgs.MarkerMessage;
import id.jrosmessages.visualization_msgs.MarkerMessage.Action;
import id.jrosmessages.visualization_msgs.MarkerMessage.Type;
import id.xfunction.lang.XThread;
import id.xfunction.logging.XLogger;

/**
 * Set of methods to work with RViz
 */
public class JRosRvizTools implements Closeable {

    private static final XLogger LOGGER = XLogger.getLogger(JRosRvizTools.class);
    private static final String RVIZ_MARKER_TOPIC = "/rviz_visual_tools";
    private static final QuaternionMessage ORIENTATION = new QuaternionMessage()
                        .withW(1.0);
    private TopicSubmissionPublisher<MarkerArrayMessage> markerPublisher = new TopicSubmissionPublisher<>(MarkerArrayMessage.class, RVIZ_MARKER_TOPIC);
    private boolean markerPublisherActive;
    private JRosClient client;
    private String baseFrame;
    private volatile int nsCounter;

    public JRosRvizTools(JRosClient client, String baseFrame) {
        this.client = client;
        this.baseFrame = baseFrame;
    }
    
    /**
     * Send text message to RViz which will be displayed at the given position.
     */
    public void publishText(ColorRGBAMessage color, Vector3Message scale, PoseMessage pose, String text) throws Exception {
        LOGGER.entering("publishText");
        if (!markerPublisherActive) {
            client.publish(markerPublisher);
            markerPublisherActive = true;
        }
        publish(new MarkerMessage()
                .withHeader(createHeader())
                .withNs(new StringMessage(nextNameSpace()))
                .withType(Type.TEXT_VIEW_FACING)
                .withAction(Action.ADD)
                .withText(new StringMessage().withData(text))
                .withPose(pose.withQuaternion(ORIENTATION))
                .withColor(color)
                .withScale(scale)
                .withLifetime(Duration.UNLIMITED));
        LOGGER.exiting("publishText");
    }

    /**
     * Publish new marker to RViz
     * @param points Points with coordinates which describe marker position in space
     */
    public void publishMarkers(ColorRGBAMessage color, Vector3Message scale, MarkerMessage.Type markerType,
            PointMessage... points) throws Exception {
        LOGGER.entering("publishMarker");
        if (!markerPublisherActive) {
            client.publish(markerPublisher);
            markerPublisherActive = true;
        }
        var markers = new MarkerMessage[points.length];
        for (int i = 0; i < markers.length; i++) {
            markers[i] = new MarkerMessage()
                    .withHeader(createHeader())
                    .withNs(new StringMessage(nextNameSpace()))
                    .withType(markerType)
                    .withAction(Action.ADD)
                    .withPose(new PoseMessage()
                            .withPosition(points[i])
                            .withQuaternion(new QuaternionMessage()
                                    .withW(1.0)))
                    .withScale(scale)
                    .withColor(color)
                    .withLifetime(Duration.UNLIMITED);
        }
        publish(markers);
        LOGGER.exiting("publishMarker");
    }

    private String nextNameSpace() {
        return "@" + hashCode() + "." + nsCounter++;
    }

    @Override
    public void close() throws IOException {
        LOGGER.entering("close");
        if (markerPublisherActive) {
            markerPublisher.close();
            client.unpublish(RVIZ_MARKER_TOPIC);
        }
        markerPublisherActive = false;
        LOGGER.exiting("close");
    }
    
    private void publish(MarkerMessage... markers) {
        var message = new MarkerArrayMessage()
                .withMarkers(markers);
        while (markerPublisher.getNumberOfSubscribers() == 0) {
            LOGGER.fine("No subscribers");
            XThread.sleep(100);
        }
        markerPublisher.submit(message);
    }

    private HeaderMessage createHeader() {
        return new HeaderMessage()
                .withFrameId(baseFrame)
                .withStamp(Time.now());
    }
}
