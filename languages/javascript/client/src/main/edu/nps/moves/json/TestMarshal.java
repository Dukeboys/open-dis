/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nps.moves.json;

import edu.nps.moves.dis7mobile.*;
import org.codehaus.jackson.*;
import org.codehaus.jackson.map.*;
import java.io.*;

/**
 *
 * @author mcgredo
 */
public class TestMarshal 
{
    public static void main(String args[])
    {
        try
        {
            EntityStatePdu espdu = new EntityStatePdu();
            ObjectMapper mapper = new ObjectMapper();
            FileOutputStream out = new FileOutputStream("json.txt");
            
            System.out.println("can you json? " + mapper.canSerialize(espdu.getClass()));
            mapper.writeValue(out, espdu);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
    }
    
}
