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

import id.jrosmessages.std_msgs.ColorRGBAMessage;

/** @author aeon_flux aeon_flux@eclipso.ch */
public class Colors {

    public static final ColorRGBAMessage RED = new ColorRGBAMessage(.8F, .1F, .1F, 1);
    public static final ColorRGBAMessage GREEN = new ColorRGBAMessage(.1F, .8F, .1F, 1);
    public static final ColorRGBAMessage GREY = new ColorRGBAMessage(.9F, .9F, .9F, 1);
    public static final ColorRGBAMessage BLACK = new ColorRGBAMessage(.0F, .0F, .0F, 1);
    public static final ColorRGBAMessage YELLOW = new ColorRGBAMessage(1.0F, 1.0F, .0F, 1);
    public static final ColorRGBAMessage WHITE = new ColorRGBAMessage(1.F, 1.F, 1.F, 1);
}
