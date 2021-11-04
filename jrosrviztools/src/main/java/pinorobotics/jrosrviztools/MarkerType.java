package pinorobotics.jrosrviztools;

import id.jrosmessages.visualization_msgs.MarkerMessage;

public enum MarkerType {

    SPHERE(MarkerMessage.Type.SPHERE);
    
    private MarkerMessage.Type type;
    
    private MarkerType(MarkerMessage.Type type) {
        this.type = type;
    }
    
    MarkerMessage.Type getType() {
        return type;
    }
}
