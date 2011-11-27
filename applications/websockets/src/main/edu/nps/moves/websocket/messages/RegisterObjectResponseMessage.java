/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nps.moves.websocket.messages;

/**
 *
 * @author mcgredo
 */
public class RegisterObjectResponseMessage extends Message 
{
   public RegisterObjectResponseMessage(int messageId)
   {
       super(Message.MessageType.RegisterObjectResponseMessageType);
       this.setMessageId(messageId);
   }
    
}
