
package edu.nps.moves.websocket.messages;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// Jackson
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;

// open-dis
//import edu.nps.moves.dis.*;

/**
 * This uses Jackson and Jaxb to marshal java objects to JSON 
 * The Message class is the superclass of all messages passed between the
 * client and server.<p>
 * 
 * At the top level in this class we have messageId, which can be set by
 * the sender when generating a new message exchange. If necessary the
 * other side of the connection can use the incoming messageId and place
 * that in the inResponseToMessageId field; this lets the sender correlate
 * responses with the original message. If no message correlation is
 * needed this can be left at zero, a special number indicating no message
 * correlation is needed.<p>
 * 
 * Jackson tutorial here: http://wiki.fasterxml.com/JacksonInFiveMinutes
 * 
 * @author DMcG
 */
@XmlRootElement
public abstract class Message 
{
    /** For JSON marshalling */
    public enum MessageType  { PositionUpdateMessageType, RegisterObjectMessageType, RegisterObjectResponseMessageType };
    
    // Can be used to map JSON serialized objects to Java classes
    public static ObjectMapper mapper = new ObjectMapper();
    
    /** Message type enum */
    MessageType messageType;
    
    /** Can be set by side initiating a message exchange sequence */
    private int messageId = 0;
    
    /** In message conversations this is the ID of the message that initiated
     * the conversation
     */
    private int inResponseToMessageId = 0;
   

    public Message()
    {
        
    }
    
    public Message(MessageType messageType)
    {
        this.messageType = messageType;
    }
    
    
    /**
     * @return the messageId
     */
    @XmlAttribute
    public int getMessageId() {
        return messageId;
    }

    /**
     * @param messageId the messageId to set
     */
    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    /**
     * @return the inResponseToMessageId
     */
    @XmlAttribute
    public int getInResponseToMessageId() {
        return inResponseToMessageId;
    }

    /**
     * @param inResponseToMessageId the inResponseToMessageId to set
     */
    public void setInResponseToMessageId(int inResponseToMessageId) {
        this.inResponseToMessageId = inResponseToMessageId;
    }
    
    public static void main(String args[])
    {
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        PositionUpdateMessage positionMessage = new PositionUpdateMessage();
        positionMessage.setX(1.2);
        positionMessage.setY(2.1);
        positionMessage.setZ(2.4);
        positionMessage.setObjectId(1);
        
        /*
        /EntityStatePdu espdu = new EntityStatePdu();
        
        try
        {
            String jsonString = mapper.writeValueAsString(positionMessage);
            System.out.println("JSON serialized string is " + jsonString);
            
            String jsonEspduString = mapper.writeValueAsString(espdu);
            System.out.println("Entity state pdu as JSON:" + jsonEspduString);
            EntityStatePdu espdu2 = (EntityStatePdu)mapper.readValue(jsonEspduString, EntityStatePdu.class);
            System.out.println(espdu2.getProtocolVersion());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        */
        
        
    }
    
}
