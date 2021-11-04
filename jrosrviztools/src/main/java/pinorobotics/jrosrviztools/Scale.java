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

import id.jrosmessages.geometry_msgs.Vector3Message;

public class Scale {

    public static final Scale MEDIUM = new Scale(0.01);
    public static final Scale LARGE = new Scale(0.025);
    public static final Scale XLARGE = new Scale(0.05);
   
    private Vector3Message message;

    public Scale(double scale) {
        message = new Vector3Message(scale, scale, scale);
    }
    
    Vector3Message getMessage() {
        return message;
    }
    
}
