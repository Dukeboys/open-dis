
package edu.nps.moves.siso;

import java.io.*;
import java.util.*;
import javax.xml.bind.*;

import edu.nps.moves.siso.jaxb.*;

/**
 * Reads the SISO EBV XML document and turns it into java enumeration objects.
 * The SISO EBV document is available (as of this writing) at the SISO enum
 * mailing list, http://discussions.sisostds.org/default.asp?action=10&fid=31
 * 
 * 
 * @author DMcG
 */
public class EBVReader 
{
    /** Location of EBV document. This should match up with the schema available
     * in the data directory. JAXB was used to generate the classes in 
     * edu.nps.moves.siso.jaxb, which is used to parse and databind the 
     * xml document--if the schema changes, you'll have to regenerate those
     * classes.
     */
    public static final String EBV_XML_DOCUMENT = "data/siso-std-010.xml";
    
    public static void main(String args[])
    {
        try
        {
            
            // Parse the EBV XML document
             JAXBContext context = JAXBContext.newInstance("edu.nps.moves.siso.jaxb");
             Unmarshaller unmarshaller = context.createUnmarshaller();
             Ebv data = (Ebv)unmarshaller.unmarshal(new FileInputStream("data/siso-std-010.xml"));
             System.out.println("data is " + data.getClass().getName());
             
             // Retrieve the enumerations
             List<GenerictableT> genericList = data.getEnumOrBitmaskOrCet();
             for(int idx = 0; idx < genericList.size(); idx++)
             {
                 GenerictableT gen = genericList.get(idx);
                 
                 // For each enumeration in the XML that we are interested in, 
                 // generate a Java enumeration class
                 if(gen instanceof EnumT)
                 {
                     EnumT en = (EnumT)gen;

                     // Pdu Type
                     if(en.getId().equalsIgnoreCase("pduheader.pdutype"))
                     {
                         EBVReader reader = new EBVReader();
                         reader.writeStandardEnumeration("PduType", "src/edu/nps/moves/disenum/PduType", en);
                     }
                     
                     // Country
                     if(en.getId().equalsIgnoreCase("es.type.country"))
                     {
                         EBVReader reader = new EBVReader();
                         reader.writeCountryEnumeration("CountryType", "src/edu/nps/moves/disenum/CountryType", en); 
                     }
                     
                     // Protocol family (entity interaction, logistics, etc
                     if(en.getId().equalsIgnoreCase("pduheader.protocolfamily"))
                     {
                         EBVReader reader = new EBVReader();
                         reader.writeStandardEnumeration("ProtocolFamily", "src/edu/nps/moves/disenum/ProtocolFamily", en); 
                     }
                     
                     // Force ID (friendly, enemy, neutral, etc.)
                     if(en.getId().equalsIgnoreCase("es.forceid"))
                     {
                         EBVReader reader = new EBVReader();
                         reader.writeStandardEnumeration("ForceID", "src/edu/nps/moves/disenum/ForceID", en); 
                     }
                     
                     if(en.getId().equalsIgnoreCase("es.type.kind"))
                     {
                         EBVReader reader = new EBVReader();
                         reader.writeStandardEnumeration("EntityKind", "src/edu/nps/moves/disenum/EntityKind", en); 
                     }
                     
                     if(en.getId().equalsIgnoreCase("es.type.kind.1.domain.1.cat"))
                     {
                         EBVReader reader = new EBVReader();
                         reader.writeStandardEnumeration("PlatformLand", "src/edu/nps/moves/disenum/PlatformLand", en); 
                     }
                     
                     if(en.getId().equalsIgnoreCase("es.type.kind.1.domain.2.cat"))
                     {
                         EBVReader reader = new EBVReader();
                         reader.writeStandardEnumeration("PlatformAir", "src/edu/nps/moves/disenum/PlatformAir", en); 
                     }
                     
                     if(en.getId().equalsIgnoreCase("es.type.kind.1.domain.3.cat"))
                     {
                         EBVReader reader = new EBVReader();
                         reader.writeStandardEnumeration("PlatformSurface", "src/edu/nps/moves/disenum/PlatformSurface", en); 
                     }
                     
                     if(en.getId().equalsIgnoreCase("es.type.kind.1.domain.4.cat"))
                     {
                         EBVReader reader = new EBVReader();
                         reader.writeStandardEnumeration("PlatformSubSurface", "src/edu/nps/moves/disenum/PlatformSubSurface", en); 
                     }
                     
                     if(en.getId().equalsIgnoreCase("es.type.kind.1.domain.5.cat"))
                     {
                         EBVReader reader = new EBVReader();
                         reader.writeStandardEnumeration("PlatformSpace", "src/edu/nps/moves/disenum/PlatformSpace", en); 
                     }
                     
                     if(en.getId().equalsIgnoreCase("es.type.kind.2.domain"))
                     {
                         EBVReader reader = new EBVReader();
                         reader.writeStandardEnumeration("MunitionDomain", "src/edu/nps/moves/disenum/MunitionDomain", en); 
                     }
                     
                     if(en.getId().equalsIgnoreCase("es.type.kind.2.cat"))
                     {
                         EBVReader reader = new EBVReader();
                         reader.writeStandardEnumeration("MunitionCategory", "src/edu/nps/moves/disenum/MunitionCategory", en); 
                     }
                     
                     if(en.getId().equalsIgnoreCase("es.type.225.kind.3.subcat"))
                     {
                         EBVReader reader = new EBVReader();
                         reader.writeStandardEnumeration("USWeaponsForLifeForms", "src/edu/nps/moves/disenum/USWeaponsForLifeForms", en); 
                     }
                     
                     if(en.getId().equalsIgnoreCase("es.type.222.kind.3.subcat"))
                     {
                         EBVReader reader = new EBVReader();
                         reader.writeStandardEnumeration("CISWeaponsForLifeForms", "src/edu/nps/moves/disenum/CISWeaponsForLifeForms", en); 
                     }
                     
                     if(en.getId().equalsIgnoreCase("es.type.224.kind.3.subcat"))
                     {
                         EBVReader reader = new EBVReader();
                         reader.writeStandardEnumeration("UKWeaponsForLifeForms", "src/edu/nps/moves/disenum/UKWeaponsForLifeForms", en); 
                     }
                     
                     if(en.getId().equalsIgnoreCase("es.type.71.kind.3.subcat"))
                     {
                         EBVReader reader = new EBVReader();
                         reader.writeStandardEnumeration("FrenchWeaponsForLifeForms", "src/edu/nps/moves/disenum/FrenchWeaponsForLifeForms", en); 
                     }
                     
                     if(en.getId().equalsIgnoreCase("es.type.78.kind.3.subcat"))
                     {
                         EBVReader reader = new EBVReader();
                         reader.writeStandardEnumeration("GermanWeaponsForLifeForms", "src/edu/nps/moves/disenum/GermanWeaponsForLifeForms", en); 
                     }
                     
                     if(en.getId().equalsIgnoreCase("pduheader.protocolversion"))
                     {
                         EBVReader reader = new EBVReader();
                         reader.writeStandardEnumeration("ProtocolVersion", "src/edu/nps/moves/disenum/ProtocolVersion", en); 
                     }
                     
                     if(en.getId().equalsIgnoreCase("es.type.kind.1.domain"))
                     {
                         EBVReader reader = new EBVReader();
                         reader.writeStandardEnumeration("EntityDomain", "src/edu/nps/moves/disenum/EntityDomain", en); 
                     }
                     
                    
                     
                     
                 }
                 
             }
                 
        }
        catch(Exception e)
        {
            System.out.println("oops");
        }
        
    }
    
    private void writeStandardEnumeration(String enumerationName, String enumerationFile, EnumT anEnumeration)
    {
        try
        {
              File outputFile = new File(enumerationFile + ".java");
              outputFile.createNewFile();
              PrintWriter pw = new PrintWriter(outputFile);
              int maxValue = 0;
            
              pw.println("package edu.nps.moves.disenum;");
              pw.println();
              pw.println("/** Enumeration values for " + enumerationName);
              pw.println(" * The enumeration values are generated from the SISO DIS XML EBV document, which was");
              pw.println(" * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31");
              pw.println(" *");
              pw.println(" * Copyright 2008. This work is licensed under the BSD license, available at");
              pw.println(" * http://www.movesinstitute.org/licenses");
              pw.println(" *");
              pw.println(" * @author DMcG");
              pw.println(" */");
              pw.println();
              
              pw.println("public enum " + enumerationName + " \n{\n");
              
              // enumeration names we have used so far
              Set enumNamesUsed = new HashSet();
              int usedCount = 1;
              
              List<EnumrowT> l = anEnumeration.getEnumrow();
            for(int idx = 0; idx < l.size(); idx++)
            {
                 EnumrowT er = l.get(idx);
                 
                 String description = er.getDescription();
                 String enumName = this.enumifyString(description);
                 int enumValue = (int)er.getId();
                 
                 // If we've seen this enumeration name before, add some exra text
                 // onto the end to make it unique
                 if(enumNamesUsed.contains(enumName))
                 {
                     enumName = enumName + "_" + usedCount; // eg M1_RIFLE to M1_RIFLE_1
                     usedCount++;
                 }
                 enumNamesUsed.add(enumName);
                 
                 // Remove embedded quotes from the description, screws up generated code
                 description = description.replace("\"", "");

                 
                 if(maxValue < enumValue)
                 {
                     maxValue = enumValue;
                 }
                 
                 pw.print("    " + enumName + "(" + enumValue + ", " + "\"" + description + "\")" ) ;
                 if(idx != l.size() -1)
                 {
                     pw.print(",");
                 }
                 else
                 {
                     pw.print(";");
                 }
                 pw.println();
                 
             }
            pw.println();
            
            pw.println("    /** The enumerated value */");
            pw.println("    public final int value;");
            pw.println("");
            pw.println("    /** Text/english description of the enumerated value */");
            pw.println("    public final String description;");
            pw.println();
            
            pw.println("/** This is an array, with each slot corresponding to an enumerated value");
            pw.println(" * and that slot containing the enumerated object. Use to look up enumerated object when you have the value");
            pw.println(" */");
            maxValue++;
            pw.println("static public " + enumerationName + " lookup[] = new " + enumerationName + "[" + maxValue + "];");
            pw.println();
            
            pw.println("/* initialize the array at class load time */");
            pw.println("static \n{");
            pw.println("    for(" + enumerationName + " anEnum:" +  enumerationName + ".values())");
            pw.println("    {");
            pw.println("        lookup[anEnum.value] = anEnum;");
            pw.println("    }");
            pw.println("}\n");
            
            pw.println("/** Constructor */");
            pw.println(enumerationName + "(int value, String description)");
            pw.println("{");
            pw.println("    this.value = value;");
            pw.println("    this.description = description;");
            pw.println("}");
            
            pw.println();
            pw.println("public int getValue()");
            pw.println("{");
            pw.println("  return value;");
            pw.println("}");
            pw.println();
            
            pw.println();
            pw.println("public String getDescription()");
            pw.println("{");
            pw.println("  return description;");
            pw.println("}");
            pw.println();
              
              pw.println("}");
            
          
              pw.flush();
              pw.close();
        }
        catch(Exception e)
        {
            System.out.println();
        }
        
    }
    
    /** Special case of country enumeration--we also want the two character internet code
     * for the country, eg "US", "UK", "FR", etc. The lookup algorithm for finding the
     * country is not perfect.
     * 
     * @param enumerationName
     * @param enumerationFile
     * @param anEnumeration
     */
    private void writeCountryEnumeration(String enumerationName, String enumerationFile, EnumT anEnumeration)
    {
        try
        {
              File outputFile = new File(enumerationFile + ".java");
              outputFile.createNewFile();
              PrintWriter pw = new PrintWriter(outputFile);
              int maxValue = 0;
              
              // Properties file containing the key (two character internet domain name for
              // the country) and the value (text description of the country). 
              Properties internetCountries = new Properties();
              FileInputStream fis = new FileInputStream(new File("data/countryCodes.properties"));
              internetCountries.load(fis);
              
            
              pw.println("package edu.nps.moves.disenum;");
              pw.println();
              pw.println("/** Enumeration values for " + enumerationName);
              pw.println(" * The enumeration values are generated from the SISO DIS XML EBV document, which was");
              pw.println(" * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31");
              pw.println(" *");
              pw.println(" * Copyright 2008. This work is licensed under the BSD license, available at");
              pw.println(" * http://www.movesinstitute.org/licenses");
              pw.println(" *");
              pw.println(" * @author DMcG");
              pw.println(" */");
              pw.println();
              
              pw.println("public enum " + enumerationName + " \n{\n");
              
              List<EnumrowT> l = anEnumeration.getEnumrow();
              for(int idx = 0; idx < l.size(); idx++)
              {
                 EnumrowT er = l.get(idx);
                 
                 String description = er.getDescription();
                 String enumName = this.enumifyString(description);
                 int enumValue = (int)er.getId();
                 String internetDomainCode = "Unknown";
                 
                 
                 Set entrySet = internetCountries.entrySet();
                 Iterator it = entrySet.iterator();
                 while(it.hasNext())
                 {
                     Map.Entry<String, String> anEntry = (Map.Entry<String, String>)it.next();
                     if(anEntry.getValue().equalsIgnoreCase(description))
                     {
                         internetDomainCode = anEntry.getKey();
                         break;
                     }
                 }
                 
                 // Keep track of this to find max index for lookup array
                 if(maxValue < enumValue)
                 {
                     maxValue = enumValue;
                 }
                 
                 pw.print("    " + enumName + "(" + enumValue + ", " + "\"" + description + "\"" + ", " + "\"" + internetDomainCode + "\")") ;
                 if(idx != l.size() -1)
                 {
                     pw.print(",");
                 }
                 else
                 {
                     pw.print(";");
                 }
                 pw.println();
                 
             }
            pw.println();
            
            pw.println("    /** The enumerated value */");
            pw.println("    public final int value;");
            pw.println("");
            pw.println("    /** Text/english description of the enumerated value */");
            pw.println("    public final String description;");
            pw.println();
            pw.println("    /** Internet domain code (US, FR, UK, CA, etc). This is a guess for many countries */");
            pw.println("    public final String internetDomainCode;");
            pw.println();
            
            pw.println("/** This is an array, with each slot corresponding to an enumerated value");
            pw.println(" * and that slot containing the enumerated object. Use to look up enumerated object when you have the value");
            pw.println(" */");
            maxValue++;
            pw.println("static public " + enumerationName + " lookup[] = new " + enumerationName + "[" + maxValue + "];");
            pw.println();
            
            pw.println("/* initialize the array at class load time */");
            pw.println("static \n{");
            pw.println("    for(" + enumerationName + " anEnum:" +  enumerationName + ".values())");
            pw.println("    {");
            pw.println("        lookup[anEnum.value] = anEnum;");
            pw.println("    }");
            pw.println("}\n");
            
            pw.println("/** Constructor */");
            pw.println(enumerationName + "(int value, String description, String internetDomainCode)");
            pw.println("{");
            pw.println("    this.value = value;");
            pw.println("    this.description = description;");
            pw.println("    this.internetDomainCode = internetDomainCode;");
            pw.println("}");
            
            pw.println();
            pw.println("public int getValue()");
            pw.println("{");
            pw.println("  return value;");
            pw.println("}");
            
            pw.println();
            pw.println("public String getDescription()");
            pw.println("{");
            pw.println("  return description;");
            pw.println("}");
            pw.println();
            
            pw.println("public String getInternetDomainCode()");
            pw.println("{");
            pw.println("  return internetDomainCode;");
            pw.println("}");
            pw.println();
              
              pw.println("}");
            
          
              pw.flush();
              pw.close();
        }
        catch(Exception e)
        {
            System.out.println();
        }
        
    }
    
    /**
     *  Changes an input string like "Entity State PDU" into "ENTITY_STATE_PDU"
     * 
     * @param text
     * @return
     */
    public String enumifyString(String text)
    {
        String enumValue = text.trim();
        enumValue = enumValue.toUpperCase();
        enumValue = enumValue.replace(" ", "_");
        enumValue = enumValue.replace("-", "_");
        enumValue = enumValue.replace("/", "_");
        enumValue = enumValue.replace("(", "");
        enumValue = enumValue.replace(")", "");
        enumValue = enumValue.replace(",", "");
        enumValue = enumValue.replace("'", "");
        enumValue = enumValue.replace("\"", "");
        enumValue = enumValue.replace(".", "");
        enumValue = enumValue.replace(";", "");
        enumValue = enumValue.replace(":", "");
        enumValue = enumValue.replace("&", "");
        enumValue = enumValue.replace("{", "_");
        enumValue = enumValue.replace("}", "_");
        
        
        // If it starts with a number, that's not a valid identifier. 
        // replace it with a leading character. Ack--there should be
        // a better regexp to cover this, but getting back references
        // working is not working for me.
        
        enumValue = enumValue.replaceAll("^0", "X_0");
        enumValue = enumValue.replaceAll("^1", "X_1");
        enumValue = enumValue.replaceAll("^2", "X_2");
        enumValue = enumValue.replaceAll("^3", "X_3");
        enumValue = enumValue.replaceAll("^4", "X_4");
        enumValue = enumValue.replaceAll("^5", "X_5");
        enumValue = enumValue.replaceAll("^6", "X_6");
        enumValue = enumValue.replaceAll("^7", "X_7");
        enumValue = enumValue.replaceAll("^8", "X_8");
        enumValue = enumValue.replaceAll("^9", "X_9");
        
        // Finally, replace repeated instances of _ with a single underscore
        enumValue = enumValue.replaceAll("(_+)", "_");
        
        return enumValue;
    }
    
    

}
