/*
 * Copyright 2022 jrosrviztools project
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
package pinorobotics.jrosrviztools.entities;

import id.jrosmessages.geometry_msgs.PointMessage;
import id.jrosmessages.geometry_msgs.PoseMessage;
import id.jrosmessages.geometry_msgs.QuaternionMessage;
import id.jrosmessages.geometry_msgs.Vector3Message;
import id.jrosmessages.std_msgs.ColorRGBAMessage;

/**
 * @author aeon_flux aeon_flux@eclipso.ch
 */
public class JRosRvizEntitiesTransformer {

    public PointMessage toPointMessage(Point point) {
        return new PointMessage(point.x(), point.y(), point.z());
    }

    public PoseMessage toPoseMessage(Pose pose) {
        return new PoseMessage()
                .withPosition(toPointMessage(pose.position()))
                .withQuaternion(toQuaternionMessage(pose.orientation()));
    }

    private QuaternionMessage toQuaternionMessage(Quaternion quaternion) {
        return new QuaternionMessage(
                quaternion.x(), quaternion.y(), quaternion.z(), quaternion.w());
    }

    public Vector3Message toVector3Message(Vector3 vector) {
        return new Vector3Message(vector.x(), vector.y(), vector.z());
    }

    public ColorRGBAMessage toColorRGBMessage(Color color) {
        return new ColorRGBAMessage(color.r(), color.g(), color.b(), color.a());
    }
}
