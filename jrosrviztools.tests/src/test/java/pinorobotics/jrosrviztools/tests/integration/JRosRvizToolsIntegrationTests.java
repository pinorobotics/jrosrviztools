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
package pinorobotics.jrosrviztools.tests.integration;

import id.jrosmessages.geometry_msgs.PointMessage;
import id.jrosmessages.geometry_msgs.PoseMessage;
import id.jrosmessages.visualization_msgs.MarkerMessage;
import pinorobotics.jrosrviztools.Colors;
import pinorobotics.jrosrviztools.JRosRvizTools;
import pinorobotics.jrosrviztools.Scales;

/**
 * ROS version agnostic tests.
 */
public class JRosRvizToolsIntegrationTests {

    public static void test_all(JRosRvizTools rvizTools) throws Exception {
        rvizTools.publishText(Colors.RED, Scales.XLARGE,
                new PoseMessage().withPosition(new PointMessage().withZ(1)),
                "Hello from Java");
        rvizTools.publishMarkers(Colors.RED, Scales.XLARGE,
                MarkerMessage.Type.SPHERE, new PointMessage(1,0,1));
    }
}