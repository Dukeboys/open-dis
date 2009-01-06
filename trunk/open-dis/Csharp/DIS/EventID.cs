using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.18. Identifies a unique event in a simulation via the combination of three values
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
public class EventID : Object
{
   /** The site ID */
   protected ushort  _site;

   /** The application ID */
   protected ushort  _application;

   /** the number of the event */
   protected ushort  _eventNumber;


/** Constructor */
 public EventID()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // _site
   marshalSize = marshalSize + 2;  // _application
   marshalSize = marshalSize + 2;  // _eventNumber

   return marshalSize;
}


public void setSite(ushort pSite)
{ _site = pSite;
}

[XmlElement(Type= typeof(ushort), ElementName="site")]
public ushort Site
{
     get
{
          return _site;
}
     set
{
          _site = value;
}
}

public void setApplication(ushort pApplication)
{ _application = pApplication;
}

[XmlElement(Type= typeof(ushort), ElementName="application")]
public ushort Application
{
     get
{
          return _application;
}
     set
{
          _application = value;
}
}

public void setEventNumber(ushort pEventNumber)
{ _eventNumber = pEventNumber;
}

[XmlElement(Type= typeof(ushort), ElementName="eventNumber")]
public ushort EventNumber
{
     get
{
          return _eventNumber;
}
     set
{
          _eventNumber = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeUshort( (ushort)_site);
       dos.writeUshort( (ushort)_application);
       dos.writeUshort( (ushort)_eventNumber);
    } // end try 
    catch(Exception e)
    { 
      Trace.WriteLine(e);
      Trace.Flush();
    }
} // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       _site = dis.readUshort();
       _application = dis.readUshort();
       _eventNumber = dis.readUshort();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- EventID-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("ushort\t _site\t " + _site.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _application\t " + _application.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _eventNumber\t " + _eventNumber.ToString() + System.Environment.NewLine);
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
 public bool equals(EventID rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_site == rhs._site)) ivarsEqual = false;
     if( ! (_application == rhs._application)) ivarsEqual = false;
     if( ! (_eventNumber == rhs._eventNumber)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
