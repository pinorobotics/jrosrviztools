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

public enum Scale {

    MEDIUM(new Vector3Message()
            .withX(0.01)
            .withY(0.01)
            .withZ(0.01)),
    LARGE(new Vector3Message()
            .withX(0.025)
            .withY(0.025)
            .withZ(0.025)),
    XLARGE(new Vector3Message()
            .withX(0.05)
            .withY(0.05)
            .withZ(0.05));
   
    private Vector3Message message;

    private Scale(Vector3Message message) {
        this.message = message;
    }
    
    public Vector3Message getMessage() {
        return message;
    }
    
}
