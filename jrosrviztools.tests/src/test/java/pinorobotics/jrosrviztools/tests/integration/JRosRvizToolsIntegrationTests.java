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
package pinorobotics.jrosrviztools.tests.integration;

import pinorobotics.jrosrviztools.JRosRvizTools;
import pinorobotics.jrosrviztools.entities.Color;
import pinorobotics.jrosrviztools.entities.MarkerType;
import pinorobotics.jrosrviztools.entities.Point;
import pinorobotics.jrosrviztools.entities.Pose;
import pinorobotics.jrosrviztools.entities.Scales;

/**
 * ROS version agnostic tests.
 *
 * @author aeon_flux aeon_flux@eclipso.ch
 */
public class JRosRvizToolsIntegrationTests {

    public static void test_all(JRosRvizTools rvizTools) throws Exception {
        rvizTools.publishText(
                Color.RED, Scales.XLARGE, new Pose(new Point(0, 0, 1)), "Hello from Java");
        rvizTools.publishMarkers(Color.RED, Scales.XLARGE, MarkerType.SPHERE, new Point(1, 0, 1));
    }
}
