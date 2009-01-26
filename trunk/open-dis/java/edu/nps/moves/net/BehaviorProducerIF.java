package edu.nps.moves.net;

/**
 * The BehaviorProducer interface describes a class that listens
 * in its own thread for PDUs, then notifies any listeners when
 * they arrive.<p>
 *
 * This implements a listener pattern. Those interested in hearing
 * from the BehaviorProducerIF register with the object. When the BehaviorProducerIF
 * gets (or produces) a PDU, it notifies all listeners. Note that there is
 * no attempt to limit which listeners/consumers receive the PDU.<p>
 *
 * @author DMcG
 * @version $Id;$
 */
 
 public interface BehaviorProducerIF
 {

   /**
    * Add a listener that will be notified when a PDU is
    * ready.
    *
    * @param consumer the object that will be notified of the PDU
    */
   public void addListener(BehaviorConsumerIF consumer);
   
   /**
    * Remove a listener/consumer of PDUs from the notification list.
    *
    * @param consumer to be removed from the notification list
    */
   public void removeListener(BehaviorConsumerIF consumer);
   
   /**
    * This is a performance option. When a PDU arrives we want to distribute
    * it to all listeners. If we use a single copy of the object distributed
    * to all listeners this may cause problems if one listener modifies the
    * object and undermines the expectations of another listener. to avoid this
    * we can create a new copy of the PDU and hand off a new, unique copy of
    * the object to each listener. But this may cause some performance problems,
    * since it takes a while to allocate a new object.<p>
    *
    * The default behavior should be to distribute a new, unqiue copy to each
    * listener. this allows the user to override this behavior for better
    * performance.
    *
    * @param shouldCreateCopy true to create a new copy for each listener, false for a shared copy for each listener
    */
    public void setUseCopies(boolean shouldCreateCopy);
 }
