
package edu.nps.moves.exi;

import java.io.*;
import java.util.*;

/**
 * Abstract class for comparing transformed XML files. Takes an XML file, schema (optionally)
 * and an output file, and provides a method to call to transform it, for example
 * into a gzipped file, exi file, or whatever. Also provides method (to be overridden)
 * to find the size.<p>
 *
 * This is used as a test harness for doing visual comparisions of various ways
 * to transform XML files, such as gzip, exi, etc.
 * 
 * @author mcgredo
 */
public abstract class XmlFileTransform
{
    protected String xmlFile;
    protected String xmlSchema = null;
    protected String transformedFile;
    protected String description;

   public XmlFileTransform(String description, String xmlFile, String xmlSchema, String transformedFile)
   {
       this.description = description;
       this.xmlFile = xmlFile;
       this.xmlSchema = xmlSchema;
       this.transformedFile = transformedFile;
   }

   public XmlFileTransform(String description, String xmlFile, String transformedFile)
   {
       this(description, xmlFile, (String)null, transformedFile);
   }

   public String getDescription()
   {
       return description;
   }

   public String getXmlFile()
   {
       return xmlFile;
   }

   public String getXmlSchema()
   {
       return xmlSchema;
   }

   /**
    * Should be called AFTER the transform has been finished.
    *
    * @return
    */
    public  long getTransformedSize()
    {
        try
        {
            File aFile = new File(transformedFile);
            return aFile.length();
        }
        catch(Exception e)
        {
            System.out.println("cant create file object for pathname " + transformedFile);
        }

        return -1;
    }

    public abstract void transformXmlFile();

    public Object[] getRowData()
    {
        Object[] rowData = new Object[5];
        rowData[0] = this.getXmlFile();
        rowData[1] = this.getDescription();
        rowData[2] = "--";
        rowData[3] = this.getTransformedSize();
        rowData[4] = "--";

        return rowData;
    }

    public static void main(String args[])
    {
        //String xmlFile = "AvclTelemetryTest1M.xml";
        String xmlFile = "somePdus.xml";
        String xmlSchema = "disJaxb.xsd";

        XmlNoOp noOp = new XmlNoOp("Plain, untransformed XML text file", xmlFile, "data/" + xmlFile);
        XmlGzip gzip = new XmlGzip("Gzipped XML text file", xmlFile, "data/" + xmlFile + ".gz");
        SeimensExiNoSchema exiNoSchema = new SeimensExiNoSchema("Seimens EXI, no Schema" , xmlFile, "data/" + xmlFile + "_schemaless.exi");
        SeimensExiSchema   exiSchema = new SeimensExiSchema("Seimens EXI, with schema", xmlFile, xmlSchema, "data/" + xmlFile + "_schema.exi");
        
        List<XmlFileTransform> tableData = new ArrayList<XmlFileTransform>();
        tableData.add(noOp);
        tableData.add(gzip);
        tableData.add(exiNoSchema);
        tableData.add(exiSchema);

       for(int idx = 0; idx < tableData.size(); idx++)
       {
          XmlFileTransform aTransform = tableData.get(idx);
          aTransform.transformXmlFile();
          System.out.println(aTransform.getDescription() + " Size:" + aTransform.getTransformedSize());
       }


    }
}
