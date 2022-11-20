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
package pinorobotics.jrosrviztools;

import pinorobotics.jrosrviztools.entities.Color;
import pinorobotics.jrosrviztools.entities.MarkerType;
import pinorobotics.jrosrviztools.entities.Point;
import pinorobotics.jrosrviztools.entities.Pose;
import pinorobotics.jrosrviztools.entities.Vector3;

/**
 * Set of methods to work with RViz
 *
 * @author aeon_flux aeon_flux@eclipso.ch
 */
public interface JRosRvizTools extends AutoCloseable {

    void publishText(Color color, Vector3 scale, Pose pose, String text) throws Exception;

    /**
     * Publish new marker to RViz
     *
     * @param points Points with coordinates which describe marker position in space
     */
    void publishMarkers(Color color, Vector3 scale, MarkerType markerType, Point... points)
            throws Exception;
}
