package edu.nps.moves.logger;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import edu.nps.moves.dis.*;
import edu.nps.moves.jaxb.dis.*;
import edu.nps.moves.disutil.*;

/**
 * Writes the contents of the PDU buffer to the file in a separate thread.
 * 
 * This accepts Lists of PDUs from the reader thread and writes them out in
 * XML format. Since the reader thread may be faster at times than the writer,
 * we can queue up PDU lists and write them out as we get the chance.
 *
 * @author mcgredo
 */
public class LogWriter implements Runnable
{
    String exerciseName;
    
    boolean writing = false;
    
    boolean unqueuedPdus = false;
    
    BlockingQueue<List> listQueue = new LinkedBlockingQueue();
    
    /** Creates a new instance of LogWriter. Exercise name is used to
     * create a directory we write log files to
     */
    public LogWriter(String pExerciseName)
    {
        exerciseName = pExerciseName;
    }
    
    /** 
     * Irritating interaction with the reder thread. They may have read a
     * few PDUs, but don't have enough for a "full" list to send to us.
     * this keeps the writer thread alive until it sends the data to us.
     * @param state
     */
    public void setUnqueuedPdus(boolean state)
    {
        unqueuedPdus = state;
    }
    
    /**
     *  Add a list of PDUs to our write queue
     */
    public void addListToWriteQueue(List pduList)
    {
        try
        {
           listQueue.put(pduList);
           //System.out.println("enqued pdu list of size " + pduList.size());
        }
        catch(Exception e)
        {
            System.out.println("unable to add list to write queue" + e);
        }
    }
    
    /**
     * Create a directory to hold the log files
     */
    private void createLogDirectory()
    {
        try
        {
            // Create the directory the log files will be in; this is the exercise name.
            // It may be that this directory has already been created.
            File logDirectory = new File(exerciseName);
            boolean createdDirectory = logDirectory.mkdir();
            if(createdDirectory)
            {
                System.out.println("created log directory " + exerciseName);
            }
            else
            {
                //System.out.println("could not create log directory; assuming is is already there " + exerciseName);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    /**
     * Start writing PDUs. This blocks if it has no PDU lists to write.
     */
    public void run()
    {
        this.createLogDirectory();
        
        long startTime = System.currentTimeMillis();
        int count = 0;
        
        while(true)
        {
            try
            {
                // Blocks until there's something in the queue to take
                List pdusToLog = listQueue.take();

                // Flip on a boolean so we don't quit out of the thread while
                // still writing PDUs to disk
                writing = true;
                
                // Create a log file name, or the format "exerciseName_nnnnn"
                long time = System.currentTimeMillis();
                String fileName = exerciseName +"/" + exerciseName + "_" + time + ".xml";

                // Marshall the list out to a file
                XmlReadWrite xmlReadWrite = new XmlReadWrite();
                xmlReadWrite.marshalToXml(pdusToLog, fileName);
                
                writing = false;

            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        
    }
    
    /**
     *  Test to see whether we're done writing and it's OK to quit the thread
     */
    public boolean finishedWriting()
    {
        if((listQueue.isEmpty() == true) && (writing == false) && (unqueuedPdus == false))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
}
