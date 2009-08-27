
package edu.nps.moves.siso;

import java.io.*;
import java.math.*;
import java.util.*;
import javax.xml.bind.*;

import edu.nps.moves.siso.jaxb.*;

/**
 * Reads the SISO EBV XML document and turns it into java enumeration objects.
 * The SISO EBV document is available (as of this writing) at the SISO enum
 * mailing list, http://discussions.sisostds.org/default.asp?action=10&fid=31
 * 
 * 
 * @author DMcG, Jason Nelson
 * Modified by Peter Smith to output C#
 */
public class EBVReaderCsharp 
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
             
             // Retrieve the enumerations
             List<GenerictableT> genericList = data.getEnumOrBitmaskOrCet();
             for(int idx = 0; idx < genericList.size(); idx++)
             {
                 GenerictableT gen = genericList.get(idx);

                 //System.out.println("generic table ID " + gen.getId() + " cname=" + gen.getCname());
                 // For each enumeration in the XML that we are interested in, 
                 // generate a Java enumeration class
                 if(gen instanceof EnumT)
                 {
                     //System.out.println("generic table is an EnumT wtih cname " + gen.getCname());
                     EnumT en = (EnumT)gen;
                     List<EnumrowT> rows = en.getEnumrow();
                     //System.out.println("row ID=" + rows.get(0).getId());
                     //System.out.println("header length is " + en.getHeader().size());
                     //if(en.getHeader().size() == 0)
                     //    continue;
                     //HeaderT header = en.getHeader().get(0);
                     //ColT col = header.getCol().get(0);
                     
                     //System.out.println("column:" + gen.getCname());
                     
                    // Pdu Type
                     if(gen.getCname().equalsIgnoreCase("pduheader.pdutype"))
                     {
                         //System.out.println("PDU Type");
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("PduType", en);
                     }
                     
                     // Country. this uses a special writer so that we can also pick up the internet code for
                     // that country, eg US, UK, DE, etc.
                     if(gen.getCname().equalsIgnoreCase("es.type.country"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeCountryEnumeration("CountryType", en); 
                     }
                     
                     // Protocol family (entity interaction, logistics, etc
                     if(gen.getCname().equalsIgnoreCase("pduheader.protocolfamily"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ProtocolFamily", en); 
                     }
                     
                     // Force ID (friendly, enemy, neutral, etc.)
                     if(gen.getCname().equalsIgnoreCase("es.forceid"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ForceID", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.type.kind"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("EntityKind", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.type.kind.1.domain.1.cat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("PlatformLand", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.type.kind.1.domain.2.cat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("PlatformAir", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.type.kind.1.domain.3.cat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("PlatformSurface", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.type.kind.1.domain.4.cat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("PlatformSubSurface", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.type.kind.1.domain.5.cat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("PlatformSpace", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.type.kind.2.domain"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("MunitionDomain", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.type.kind.2.cat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("MunitionCategory", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.type.225.kind.3.subcat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("USWeaponsForLifeForms", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.type.222.kind.3.subcat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("CISWeaponsForLifeForms", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.type.224.kind.3.subcat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("UKWeaponsForLifeForms", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.type.71.kind.3.subcat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("FrenchWeaponsForLifeForms", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.type.78.kind.3.subcat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("GermanWeaponsForLifeForms", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("pduheader.protocolversion"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ProtocolVersion", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.type.kind.1.domain"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("EntityDomain", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.type.kind.4.subcat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("EnvironmentalKind", en); 
                     }
                    
                    if(gen.getCname().equalsIgnoreCase("es.type.kind.7.cat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("RadioCategory", en); 
                     }
                    
                    if(gen.getCname().equalsIgnoreCase("es.type.kind.7.version"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("RadioNomenclatureVersion", en); 
                     }
                    
                     if(gen.getCname().equalsIgnoreCase("es.type.kind.7.nomenclature"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("RadioNomenclature", en); 
                     }
                    
                    if(gen.getCname().equalsIgnoreCase("es.type.kind.8.domain.2.cat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ExpendableAirCategory", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.type.kind.8.domain.3.cat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ExpendableSurfaceCategory", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.type.kind.8.domain.4.cat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ExpendableSubsurfaceCategory", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.type.kind.9.cat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("SensorEmitterCategory", en); 
                     }
                                          
                     if(gen.getCname().equalsIgnoreCase("es.dra"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("DeadReckoningAlgorithm", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.markingtext"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("EntityMarking", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.markingtext.cctt.div"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("DivisionCorpsDesignation", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.markingtext.cctt.1cavunit"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("FirstCavHighLevelUnit", en); 
                     }
                    
                    if(gen.getCname().equalsIgnoreCase("es.markingtext.cctt.1infunit"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("FirstInfHighLevelUnit", en); 
                     }
                    
                    if(gen.getCname().equalsIgnoreCase("es.markingtext.cctt.company"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("CompanyBatteryTroop", en); 
                     }
                    
                     if(gen.getCname().equalsIgnoreCase("es.markingtext.cctt.platoon"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("PlatoonSection", en); 
                     }
                    
                    if(gen.getCname().equalsIgnoreCase("es.markingtext.cctt.vehicle"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Vehicle", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.markingtext.cctt.symbol1"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Bytes8_9_10_12", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.markingtext.cctt.symbol2"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Byte11", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.markingtext.chevron.symbol"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("DigitChevronCode", en); 
                     }
                    
                    if(gen.getCname().equalsIgnoreCase("es.vp.type"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ParameterTypeDesignator", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.vp.type.1.attached"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("AttachedParts", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.vp.type.0.articulated.offset"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ArticulatedPartsOffsetNumber", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("es.vp.type.0.articulated.index"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ArticulatedPartsIndexNumber", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("warfare.burstdescriptor.warhead"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Warhead", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("warfare.burstdescriptor.fuse"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Fuse", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("warfare.detonationresult"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("DetonationResult", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("log.servicerequest"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ServiceRequestPDU", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("log.repaircomplete.general"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("GeneralRepairCode", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("log.repaircomplete.drivetrain"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("DriveTrain", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("log.repaircomplete.hull"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("HullAirframeBody", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("log.repaircomplete.environment"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("InterfacesWithEnvironment", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("log.repaircomplete.weapons"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Weapons", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("log.repaircomplete.fuelsystem"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("FuelSystems", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("log.repaircomplete.electronics"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Electronics", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("log.repaircomplete.lifesupport"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("LifeSupportSystems", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("log.repaircomplete.hydraulic"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("HydraulicSystemsAndActuators", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("log.repaircomplete.auxilary"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("AuxiliaryCraft", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("log.repairresponse"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("RepairResponsePDU", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("simman.datumid"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("DatumSpecificationRecord", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("simman.stop.reason"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Reason", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("simman.ack.ackflag"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("AcknowledgeFlag", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("simman.ack.responseflag"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ResponseFlag", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("simman.actionrequest.actionid"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ActionID", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("simman.actionresponse.status"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("RequestStatus", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("simman.eventreport.eventtype"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("EventType", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("simman.reliability.service"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("RequiredReliabilityService", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.emission.name.electro"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ElectromagneticEmitters", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.emission.name.acoustic"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("AcousticEmitters", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.emission.name.other"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("OtherAcousticEmitters", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.emission.function"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Function", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.emission.stateupdate"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("StateUpdateIndicator", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.emission.beamfunction"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("BeamFunction", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.emission.hdtj"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("HighDensityTrackJam", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.designator.codename"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("CodeName", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.designator.code"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("DesignatorCode", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.iff.type"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("SystemType", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.iff.name"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("SystemName", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.iff.mode"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("SystemMode", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.iff.layerspecific"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("LayerSpecificInformation", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.iff.type.1.fop.altp4"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Type1AltParameter4", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.iff.type.1.sop.param1"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Type1OperationalParameter1", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.iff.type.1.sop.param2"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Type1OperationalParameter2", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.iff.type.2.fop.altp4"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Type2AltParameter4", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.iff.type.2.sop.param1"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Type2OperationalParameter1", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.iff.type.2.sop.param2"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Type2OperationalParameter2", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.iff.type.3.fop.altp4"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Type3AltParameter4", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.iff.type.3.sop.param1"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Type3OperationalParameter1", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.iff.type.3.sop.param2"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Type3OperationalParameter2", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.iff.type.4.fop.altp4"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Type4AltParameter4", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.iff.type.4.sop.param1"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Type4OperationalParameter1", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.iff.type.4.sop.param2"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Type4OperationalParameter2", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.iff.type.5.fop.altp4"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Type5AltParameter4", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.iff.type.5.sop.param1"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Type5OperationalParameter1", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.iff.type.5.sop.param2"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Type5OperationalParameter2", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.ua.statechangeupdate"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("StateChangeUpdateIndicator", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.ua.systemname"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("AcousticSystemName", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.ua.function"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Function", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.ua.activeparameterindex"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ActiveEmissionParameterIndex", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.ua.scanpattern"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ScanPattern", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.ua.passiveparameterindex"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("PassiveParameterIndex", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.ua.apaparameterindex"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("AdditionalPassiveActivity", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.sees.power.aircraft"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Aircraft", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.sees.power.helicopters"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Helicopters", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("der.sees.power.tanks"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Tanks", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.mod.major"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("MajorModulation", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.mod.major.1.detail"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("DetailedModAmpMod", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.mod.major.2.detail"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("DetailedModAmpAndAngle", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.mod.major.3.detail"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("DetailedModAngleMod", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.mod.major.4.detail"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("DetailedModCombinationMod", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.mod.major.5.detail"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("DetailedModPulseMod", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.mod.major.6.detail"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("DetailedModUnmodulatedMod", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.mod.major.7.detail"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("DetailedModCarrierPhaseShift", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.mod.system"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("RadioSystem", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.state"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("TransmitState", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.inputsource"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("InputSource", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.cryptosystem"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("CryptoSystem", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.antennapatterntype"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("AntennaPatternType", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.referencesystem"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ReferenceSystem", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.param.cctt.start"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("MessageStart", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.param.cctt.clear"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ClearChannel", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.param.jtids.mode1"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("XmitTermPriMode", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.param.jtids.mode2"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("XmitTermSecMode", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.param.jtids.sync"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("SynchronizationState", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.protocolid"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("UserProtocolIDNum", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.tx.tdltype"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("TDLType", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.rx.state"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ReceiverState", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.ic.controltype"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ControlType", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.ic.commtype"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("CommunicationType", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.ic.command"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Command", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.ic.transmitstate"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("XmitLineState", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.ic.deststate"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("DestLineState", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("radio.ic.param.type"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("RecordType", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("entity.collision.type"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("CollisionType", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("entity.mine.sensortype"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("SensorTypes", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("entity.mine.sensortype.1.subcat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Optical", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("entity.mine.sensortype.2.subcat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("FLIR", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("entity.mine.sensortype.3.subcat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("RADAR", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("entity.mine.sensortype.4.subcat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Magnetic", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("entity.mine.sensortype.5.subcat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Laser", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("entity.mine.sensortype.6.subcat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("SONAR", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("entity.mine.sensortype.7.subcat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Physical", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("entity.mine.sensortype.8.subcat"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Multispectral", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("eman.aggregate.state"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("AggregateState", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("eman.aggregate.formation"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Formation", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("eman.aggregate.type.kind"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("AggregateKind", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("eman.aggregate.type.subcategory"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Subcategory", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("eman.aggregate.type.specific"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Specific", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("eman.ispartof.nature"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Nature", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("eman.ispartof.position"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("Position", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("eman.ispartof.stationname"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("StationName", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("eman.isgroupof.category"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("GroupedEntityCategory", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("eman.isgroupof.reststatus"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("RestStatus", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("eman.tc.transfertype"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("TransferType", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("env.obj.objecttype.kind"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ObjectKind", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("env.gridded.fieldnumber"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("FieldNumber", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("env.gridded.coordinatesystem"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("CoordinateSystem", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("env.gridded.constantgrid"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ConstantGrid", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("env.gridded.sampletype"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("SampleType", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("env.gridded.datarepresentation"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("DataRepresentation", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("env.process.modeltype"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("ModelType", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("env.process.type.geometryrecord"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("GeometryRecordTypeField", en); 
                     }
                     
                     if(gen.getCname().equalsIgnoreCase("env.process.type.staterecord"))
                     {
                         EBVReaderCsharp reader = new EBVReaderCsharp();
                         reader.writeStandardEnumeration("StateRecordTypeField", en); 
                     }
                     
                     
                 }
                 
             }
                 
        }
        catch(Exception e)
        {
            System.out.println("oops, problem creating files");
        }
        
    }
    
    private void writeStandardEnumeration(String enumerationName, EnumT anEnumeration)
    {
    	String enumerationFile = "src/Csharp/disenum/" + enumerationName + ".cs";
        System.out.println("Writing standard enumeration " + enumerationFile);
        try
        {
              File outputFile = new File(enumerationFile);
              outputFile.createNewFile();
              PrintWriter pw = new PrintWriter(outputFile);
              int maxValue = 0;
            
              
              pw.println();
              pw.println("using System;");
              pw.println("using System.ComponentModel;");
              pw.println("using System.Reflection;");
              //pw.println("using DISnet.EnumNotFoundException;");
              pw.println();
              pw.println("/** Enumeration values for " + enumerationName);
              pw.println(" * The enumeration values are generated from the SISO DIS XML EBV document (R35), which was");
              pw.println(" * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31<p>");
              pw.println(" *");
              pw.println(" * Note that this has two ways to look up an enumerated instance from a value: a fast");
              pw.println(" * but brittle array lookup, and a slower and more garbage-intensive, but safer, method.");
              pw.println(" * if you want to minimize memory use, get rid of one or the other.<p>");
              pw.println(" *");
              pw.println(" * Copyright 2008-2009. This work is licensed under the BSD license, available at");
              pw.println(" * http://www.movesinstitute.org/licenses<p>");
              pw.println(" *");
              pw.println(" * @author DMcG, Jason Nelson");
              pw.println(" * Modified for use with C#:");
              pw.println(" * Peter Smith (Naval Air Warfare Center - Training Systems Division)");
              pw.println(" */");
              pw.println();
              pw.flush();
              
              pw.println("namespace DISnet"+ " \n{\n");
              pw.println("    public partial class DISEnumerations\n    {\n");  //PES decided to use partial classes that way I can add methods for all
              
              pw.println("        public enum " + enumerationName + " \n        {\n");
              
                         
              BigInteger val = anEnumeration.getId();
            
            boolean ofInterest = false;
            if(val.intValue() == 83)
                ofInterest = true;
              
              
              
              // enumeration names we have used so far
              Set enumNamesUsed = new HashSet();
              int usedCount = 1;
              
              List<EnumrowT> l = anEnumeration.getEnumrow();
              for(int idx = 0; idx < l.size(); idx++)
              {
                 EnumrowT er = l.get(idx);
                  
                 // Some entries in the EBV have missing descriptions. If that's the case, we just
                 // make up a description; we may get something on the wire with that enumerated
                 // value, and we want a valid enumeration object to match that, even if we don't
                 // have a good name or description for it.
                 String description = er.getDescription();
                 if((description == null) || description.equals(""))
                      description = "Missing Description";
                 
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
                 
                 pw.print("     [Description(\"" + description + "\")]\n");
                 pw.print("     " + enumName + " = " + enumValue);
                 //pw.print("    " + enumName + "(" + enumValue + ", " + "\"" + description + "\")" ) ;
                 if(idx != l.size() -1)
                 {
                     pw.print(",\n");
                 }
                 else
                 {
                     pw.print("\n     }");
                 }
                 pw.println();
                 
             }
            pw.println("\n    } //End Parial Class");
            pw.println("\n} //End Namespace");
            pw.flush();
            
            
            
          
              pw.flush();
              pw.close();
        }
        catch(Exception e)
        {
            System.out.println("writeStandard exception:" + e);
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
    private void writeCountryEnumeration(String enumerationName, EnumT anEnumeration)
    {
        System.out.println("Writing Country enumeration " + enumerationName);
              
        try
        {
        	String enumerationFile = "src/Csharp/disenum/" + enumerationName + ".cs";
        	File outputFile = new File(enumerationFile);
            outputFile.createNewFile();
            PrintWriter pw = new PrintWriter(outputFile);
            int maxValue = 0;
              
              // Properties file containing the key (two character internet domain name for
              // the country) and the value (text description of the country). 
              Properties internetCountries = new Properties();
              FileInputStream fis = new FileInputStream(new File("data/countryCodes.properties"));
              internetCountries.load(fis);
              
              pw.println();
              pw.println("using System;");
              pw.println("using System.ComponentModel;");
              pw.println("using System.Reflection;");
              pw.println("using EnumUtilities;");
              

              pw.println();
              pw.println("/** Enumeration values for " + enumerationName);
              pw.println(" * The enumeration values are generated from the SISO DIS XML EBV document (R35), which was");
              pw.println(" * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31<p>");
              pw.println(" *");
              pw.println(" * Note that this has two ways to look up an enumerated instance from a value: a fast");
              pw.println(" * but brittle array lookup, and a slower and more garbage-intensive, but safer, method.");
              pw.println(" * if you want to minimize memory use, get rid of one or the other.<p>");
              pw.println(" *");
              pw.println(" * Copyright 2008-2009. This work is licensed under the BSD license, available at");
              pw.println(" * http://www.movesinstitute.org/licenses<p>");
              pw.println(" *");
              pw.println(" * @author DMcG, Jason Nelson");
              pw.println(" */");
              pw.println();
              
              
              pw.println("namespace DISnet"+ " \n{\n");
              pw.println("    public partial class DISEnumerations\n    {\n");  //PES decided to use partial classes that way I can add methods for all
              
              pw.println("        public enum " + enumerationName + " \n        {\n");
  
              
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
                 
                 pw.print("     [Description(\"" + description + "\")]\n");
                 pw.print("     [InternetDomainCode(\"" + internetDomainCode + "\")]\n");
                 pw.print("     " + enumName + " = " + enumValue);
                 //pw.print("    " + enumName + "(" + enumValue + ", " + "\"" + description + "\"" + ", " + "\"" + internetDomainCode + "\")") ;
                 if(idx != l.size() -1)
                 {
                     pw.print(",");
                 }
                 else
                 {
                     pw.print("        }//End Enum\n");
                 }
                 
                 pw.println("");
                 
             }
              pw.println("\n    } //End Parial Class");
              pw.println("\n} //End Namespace");
            
            
          
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
        enumValue = enumValue.replace("#", "_");
        enumValue = enumValue.replace("^", "_CARET_");
        enumValue = enumValue.replace("<", "_LT_");
        enumValue = enumValue.replace(">", "_GT_");
        
        
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
