
package edu.nps.moves.exi;

import java.io.*;

/**
 * Does absolutely nothing to the XML file. The baseline.
 * @author mcgredo
 */
public class XmlNoOp extends XmlFileTransform
{
   public XmlNoOp(String description, String xmlFile, String xmlSchema, String transformedFile)
   {
     super(description, xmlFile, xmlSchema, transformedFile);
   }

   public XmlNoOp(String description, String xmlFile, String transformedFile)
   {
       this(description, xmlFile, (String)null, transformedFile);
   }

    /**
     * Do nothing at all to the original XML file; just copy it to the destination
     */
   @Override
    public void transformXmlFile()
    {
        byte[] buf = new byte[1024];

        try
        {
            OutputStream os = new FileOutputStream(transformedFile);
            InputStream is = new FileInputStream(xmlFile);
            int i = 0;
            while ((i = is.read(buf)) != -1)
            {
                os.write(buf, 0, i);
            }
            os.flush();
            os.close();
            is.close();
        }
        catch(Exception e)
        {
            System.out.println("bogosity in writing to destination");
        }

    }

}
