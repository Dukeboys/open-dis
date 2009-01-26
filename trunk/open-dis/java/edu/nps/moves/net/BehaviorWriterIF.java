package edu.nps.moves.net;

import edu.nps.moves.dis.*;

/**
 * the BehaviorWriter interface is a bit tricky, because we may write to
 * so many possible desinations, including the network, files, and so
 * on. This interface lets you set up some very general defaults, which
 * will be handled by the concrete implementations.<p>
 *
 * In general, you write to a destination. That destination is represented
 * by objects, such as objects that represent an IP address and a port.
 * You can also set a "default destination", where things will go unless
 * you specify otherwise.<p>
 *
 * This is very weakly typed in order to gain generality. <p>
 *
 * @author DMcG
 * @version $Id;$
 */
 
public interface BehaviorWriterIF
{

  /**
   * Set a default destination, the destination that the plain
   * write(Pdu pdu) method will send to.
   *
   * @param obj object that describes default destination
   */
  public void setDefaultDestination(Object obj);
  
  /**
   * Set the default destination that the plain write(pdu) method
   * will send data to.
   *
   * @param obj1 first object that describes destination (eg, IP)
   * @param obj2 second object that describes destination (eg, port number)
   */
  public void setDefaultDestination(Object obj1, Object obj2);
  
  /**
   * Set the default destination that the plain write(pdu) method
   * will send data to.
   *
   * @param obj array of objects that specifies the destination
   */
  public void setDefaultDestination(Object obj[]);
  
  /**
   * Write a PDU to the default destination
   *
   * @param pdu the DIS PDU to be written
   */
  public void write(Pdu pdu);
  
  /**
   * Write a DIS pdu to the destination described by the object
   *
   * @param pdu the DIS pdu to write
   * @param destination Object that describes destination to write to
   */
  public void write(Pdu pdu, Object destination);
  
  /**
   * Write a DIS PDU to the destination described by the objects.
   *
   * @param pdu the DIS pdu to write
   * @param destination1 object that describes destination
   * @param destination2 object that describes destination
   */
  public void write(Pdu pdu, Object destination1, Object destination2);
  
  /**
   * write the DIS pdu to the destination described by the array of objects.
   *
   * @param pdu the dis pdu to write
   * @param dest array of objects that describe the destination to write to
   */
  public void write(Pdu pdu, Object dest[]);
}
  
  
