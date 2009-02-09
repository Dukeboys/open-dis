
package edu.nps.moves.exi;

import java.io.*;
import java.util.zip.*;

/**
 * Creates a gzipped version of the XML file
 * 
 * @author mcgredo
 */
public class XmlGzip extends XmlFileTransform
{
   public XmlGzip(String description, String xmlFile, String xmlSchema, String transformedFile)
   {
      super(description, xmlFile, xmlSchema, transformedFile);
   }

   public XmlGzip(String description, String xmlFile, String transformedFile)
   {
       this(description, xmlFile, (String)null, transformedFile);
   }

    public void transformXmlFile()
    {
        String fileToZip[] = new String[1];
        fileToZip[0] = xmlFile;
        byte buf[] = new byte[2048];

        try
        {
             FileOutputStream os = new FileOutputStream(transformedFile);
             FileInputStream is = new FileInputStream(xmlFile);
             GZIPOutputStream zos = new GZIPOutputStream(os);

            int i = 0;
            while ((i = is.read(buf)) != -1)
            {
                zos.write(buf, 0, i);
            }

            zos.flush();
            zos.finish();
            zos.close();

            is.close();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }


}
