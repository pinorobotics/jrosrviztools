package pinorobotics.jrosrviztools;

import id.jrosmessages.geometry_msgs.PointMessage;

public class Coordinates {
    
    private PointMessage message = new PointMessage();

    public Coordinates(double x, double y, double z) {
        message.x = x;
        message.y = y;
        message.z = z;
    }

    public double getX() {
        return message.x;
    }

    public double getY() {
        return message.y;
    }

    public double getZ() {
        return message.z;
    }

    PointMessage getMessage() {
        return message;
    }
    
}
