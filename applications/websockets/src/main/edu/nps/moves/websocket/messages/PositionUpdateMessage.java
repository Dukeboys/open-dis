
package edu.nps.moves.websocket.messages;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * A message that updates the (x, y, z) of an object, 
 * identified by its unique ID, in the world. <p>
 * 
 * This can be updated to include orientation, velocity, etc.<p>
 * 
 * Uses the jackson json library marshal to JSON, which is what's
 * passed between the client and server.
 * 
 * @author DMcG
 */
public class PositionUpdateMessage extends Message
{
    /** x position of object */
    private double x;
    
    /** y position of object */
    private double y;
    
    /** z position of object */
    private double z;
    
    /** Unique ID of object in world */
    private int objectId;

    public PositionUpdateMessage()
    {
        super(Message.MessageType.PositionUpdateMessageType);
    }; // needed for jaxb
    
    /**
     * Constructor
     * @param x
     * @param y
     * @param z
     * @param objectId 
     */
    public PositionUpdateMessage(double x, double y, double z, int objectId)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.objectId = objectId;
    }
    
    
    /**
     * @return the x
     */
    @XmlAttribute
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    @XmlAttribute
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the z
     */
    @XmlAttribute
    public double getZ() {
        return z;
    }

    /**
     * @param z the z to set
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * @return the objectId
     */
    @XmlAttribute
    public int getObjectId() {
        return objectId;
    }

    /**
     * @param objectId the objectId to set
     */
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }
    
}
