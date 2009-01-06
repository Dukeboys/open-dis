using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.4.3. Used when the antenna pattern type in the transmitter pdu is of value 2.         Specified the direction and radiation pattern from a radio transmitter's antenna.        NOTE: this class must be hand-coded to clean up some implementation details.
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
public class SphericalHarmonicAntennaPattern : Object
{
   protected byte  _order;


/** Constructor */
 public SphericalHarmonicAntennaPattern()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 1;  // _order

   return marshalSize;
}


public void setOrder(byte pOrder)
{ _order = pOrder;
}

[XmlElement(Type= typeof(byte), ElementName="order")]
public byte Order
{
     get
{
          return _order;
}
     set
{
          _order = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeByte( (byte)_order);
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
       _order = dis.readByte();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- SphericalHarmonicAntennaPattern-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("byte\t _order\t " + _order.ToString() + System.Environment.NewLine);
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
 public bool equals(SphericalHarmonicAntennaPattern rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_order == rhs._order)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
