package edu.nps.moves.logger;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import edu.nps.moves.dis.*;
import edu.nps.moves.jaxb.dis.*;
import edu.nps.moves.disutil.*;

/**
 * Writes the contents of the buffer to the file in a separate thread.
 *
 * @author mcgredo
 */
public class LogWriter implements Runnable
{
    String exerciseName;
    
    boolean writing = false;
    
    boolean unqueuedPdus = false;
    
    BlockingQueue<List> listQueue = new LinkedBlockingQueue();
    
    /** Creates a new instance of LogWriter */
    public LogWriter(String pExerciseName)
    {
        exerciseName = pExerciseName;
    }
    
    public void setUnqueuedPdus(boolean state)
    {
        unqueuedPdus = state;
    }
    
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
    
    public void run()
    {
        this.createLogDirectory();
        
        long startTime = System.currentTimeMillis();
        int count = 0;
        
        while(true)
        {
            try
            {
                System.out.println("queue size: " + listQueue.size());
               
                // Blocks until there's something in the queue to take
                List pdusToLog = listQueue.take();
                //System.out.println("dequeued list of size " + pdusToLog.size());
                writing = true;
                long time = System.currentTimeMillis();
                String fileName = exerciseName +"/" + exerciseName + "_" + time + ".xml";

                // Marshall the list out to a file
                System.out.println("Starting to marshal to log file");
                XmlReadWrite xmlReadWrite = new XmlReadWrite();
                xmlReadWrite.marshalToXml(pdusToLog, fileName);

                
                long currentTime = System.currentTimeMillis();
                count = count + pdusToLog.size();
                long difference = currentTime - startTime;
                System.out.println("Finished marshalling to log file, " + count + " in " + difference);
                
                writing = false;

            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        
    }
    
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
