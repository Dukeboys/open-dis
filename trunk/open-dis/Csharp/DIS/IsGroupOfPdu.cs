using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.9.2 Information about a particular group of entities grouped together for the purposes of netowrk bandwidth         reduction or aggregation. Needs manual cleanup. The GED size requires a database lookup. UNFINISHED
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 * Modified for use with C#:
 * Peter Smith (Naval Air Warfare Center - Training Systems Division)
 */
[Serializable]
[XmlRoot]
[XmlInclude(typeof(EntityID))]
[XmlInclude(typeof(VariableDatum))]
public class IsGroupOfPdu : EntityManagementFamilyPdu
{
   /** ID of aggregated entities */
   protected EntityID  _groupEntityID = new EntityID(); 

   /** type of entities constituting the group */
   protected byte  _groupedEntityCategory;

   /** Number of individual entities constituting the group */
   protected byte  _numberOfGroupedEntities;

   /** padding */
   protected uint  _pad2;

   /** latitude */
   protected double  _latitude;

   /** longitude */
   protected double  _longitude;

   /** GED records about each individual entity in the group. @@@this is wrong--need a database lookup to find the actual size of the list elements */
   protected List<object> _groupedEntityDescriptions = new List<object>(); 

/** Constructor */
 public IsGroupOfPdu()
 {
    PduType = (byte)34;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _groupEntityID.getMarshalledSize();  // _groupEntityID
   marshalSize = marshalSize + 1;  // _groupedEntityCategory
   marshalSize = marshalSize + 1;  // _numberOfGroupedEntities
   marshalSize = marshalSize + 4;  // _pad2
   marshalSize = marshalSize + 8;  // _latitude
   marshalSize = marshalSize + 8;  // _longitude
   for(int idx=0; idx < _groupedEntityDescriptions.Count; idx++)
   {
        VariableDatum listElement = (VariableDatum)_groupedEntityDescriptions[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setGroupEntityID(EntityID pGroupEntityID)
{ _groupEntityID = pGroupEntityID;
}

public EntityID getGroupEntityID()
{ return _groupEntityID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="groupEntityID")]
public EntityID GroupEntityID
{
     get
{
          return _groupEntityID;
}
     set
{
          _groupEntityID = value;
}
}

public void setGroupedEntityCategory(byte pGroupedEntityCategory)
{ _groupedEntityCategory = pGroupedEntityCategory;
}

[XmlElement(Type= typeof(byte), ElementName="groupedEntityCategory")]
public byte GroupedEntityCategory
{
     get
{
          return _groupedEntityCategory;
}
     set
{
          _groupedEntityCategory = value;
}
}

public void setPad2(uint pPad2)
{ _pad2 = pPad2;
}

[XmlElement(Type= typeof(uint), ElementName="pad2")]
public uint Pad2
{
     get
{
          return _pad2;
}
     set
{
          _pad2 = value;
}
}

public void setLatitude(double pLatitude)
{ _latitude = pLatitude;
}

[XmlElement(Type= typeof(double), ElementName="latitude")]
public double Latitude
{
     get
{
          return _latitude;
}
     set
{
          _latitude = value;
}
}

public void setLongitude(double pLongitude)
{ _longitude = pLongitude;
}

[XmlElement(Type= typeof(double), ElementName="longitude")]
public double Longitude
{
     get
{
          return _longitude;
}
     set
{
          _longitude = value;
}
}

public void setGroupedEntityDescriptions(List<object> pGroupedEntityDescriptions)
{ _groupedEntityDescriptions = pGroupedEntityDescriptions;
}

public List<object> getGroupedEntityDescriptions()
{ return _groupedEntityDescriptions; }

[XmlElement(ElementName = "groupedEntityDescriptionsList",Type = typeof(List<object>))]
public List<object> GroupedEntityDescriptions
{
     get
{
          return _groupedEntityDescriptions;
}
     set
{
          _groupedEntityDescriptions = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _groupEntityID.marshal(dos);
       dos.writeByte( (byte)_groupedEntityCategory);
       dos.writeByte( (byte)_groupedEntityDescriptions.Count);
       dos.writeUint( (uint)_pad2);
       dos.writeDouble( (double)_latitude);
       dos.writeDouble( (double)_longitude);

       for(int idx = 0; idx < _groupedEntityDescriptions.Count; idx++)
       {
            VariableDatum aVariableDatum = (VariableDatum)_groupedEntityDescriptions[idx];
            aVariableDatum.marshal(dos);
       } // end of list marshalling

    } // end try 
    catch(Exception e)
    { 
      Trace.WriteLine(e);
      Trace.Flush();
    }
} // end of marshal method

public void unmarshal(DataInputStream dis)
{
    base.unmarshal(dis);

    try 
    {
       _groupEntityID.unmarshal(dis);
       _groupedEntityCategory = dis.readByte();
       _numberOfGroupedEntities = dis.readByte();
       _pad2 = dis.readUint();
       _latitude = dis.readDouble();
       _longitude = dis.readDouble();
        for(int idx = 0; idx < _numberOfGroupedEntities; idx++)
        {
           VariableDatum anX = new VariableDatum();
            anX.unmarshal(dis);
            _groupedEntityDescriptions.Add(anX);
        };

    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- IsGroupOfPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_groupEntityID=====" + System.Environment.NewLine);
       _groupEntityID.reflection(sb);
           sb.Append("byte\t _groupedEntityCategory\t " + _groupedEntityCategory.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _groupedEntityDescriptions\t " + _groupedEntityDescriptions.Count.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _pad2\t " + _pad2.ToString() + System.Environment.NewLine);
           sb.Append("double\t _latitude\t " + _latitude.ToString() + System.Environment.NewLine);
           sb.Append("double\t _longitude\t " + _longitude.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _groupedEntityDescriptions.Count; idx++)
       {
           sb.Append("VariableDatum\t " + _groupedEntityDescriptions[idx] + System.Environment.NewLine);
            VariableDatum aVariableDatum = (VariableDatum)_groupedEntityDescriptions[idx];
            aVariableDatum.reflection(sb);
       } // end of list marshalling

    } // end try 
    catch(Exception e)
    { 
      Trace.WriteLine(e);
      Trace.Flush();
}
    } // end of marshal method

 /**
  * The equals method doesn't always work--mostly it works only on on classes that consist only of primitives. Be careful.
  */
 public bool equals(IsGroupOfPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_groupEntityID.Equals( rhs._groupEntityID) )) ivarsEqual = false;
     if( ! (_groupedEntityCategory == rhs._groupedEntityCategory)) ivarsEqual = false;
     if( ! (_numberOfGroupedEntities == rhs._numberOfGroupedEntities)) ivarsEqual = false;
     if( ! (_pad2 == rhs._pad2)) ivarsEqual = false;
     if( ! (_latitude == rhs._latitude)) ivarsEqual = false;
     if( ! (_longitude == rhs._longitude)) ivarsEqual = false;

     for(int idx = 0; idx < _groupedEntityDescriptions.Count; idx++)
     {
        VariableDatum x = (VariableDatum)_groupedEntityDescriptions[idx];
        if( ! ( _groupedEntityDescriptions[idx].Equals(rhs._groupedEntityDescriptions[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
