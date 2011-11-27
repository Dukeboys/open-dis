/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nps.moves.websocket.messages;

/**
 *
 * @author mcgredo
 */
public class RegisterObjectMessage extends Message
{
   public RegisterObjectMessage(int messageId)
   {
       super(Message.MessageType.RegisterObjectMessageType);
       this.setMessageId(messageId);
   }
    
}
