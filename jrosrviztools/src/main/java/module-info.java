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
/**
 * Java module which allows to interact with RViz ROS (Robot Operating System).
 *
 * <p>It allows you to publish different kind of visualization information into RViz, among it text,
 * geometric shapes (cube, cylinder etc), points etc.
 *
 * <p>It is inspired by <a
 * href="https://github.com/PickNikRobotics/rviz_visual_tools">rviz_visual_tools</a> C++ library. It
 * does not require you to install rviz_visual_tools itself since it is not a JNI wrapper to it and
 * is completely Java based.
 *
 * <p>It is based on <a href="https://github.com/lambdaprime/jrosclient">jrosclient</a> module which
 * is a Java implementation of ROS client.
 *
 * @see <a href=
 *     "https://github.com/pinorobotics/jrosrviztools/blob/main/jrosrviztools/release/CHANGELOG.md">Releases</a>
 * @see <a href="https://github.com/pinorobotics/jrosrviztools">GitHub repository</a>
 * @author aeon_flux aeon_flux@eclipso.ch
 */
module jrosrviztools {

    // since many of our API relies on jrosclient.core classes we need to ensure
    // that all modules reading this module also read jrosclient.core
    requires transitive jrosclient;

    exports pinorobotics.jrosrviztools;
    exports pinorobotics.jrosrviztools.entities;
    exports pinorobotics.jrosrviztools.exceptions;
}
