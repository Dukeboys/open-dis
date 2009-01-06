using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * 5.2.56. Purpose for joinging two entities
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
public class Relationship : Object
{
   /** Nature of join */
   protected ushort  _nature;

   /** position of join */
   protected ushort  _position;


/** Constructor */
 public Relationship()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // _nature
   marshalSize = marshalSize + 2;  // _position

   return marshalSize;
}


public void setNature(ushort pNature)
{ _nature = pNature;
}

[XmlElement(Type= typeof(ushort), ElementName="nature")]
public ushort Nature
{
     get
{
          return _nature;
}
     set
{
          _nature = value;
}
}

public void setPosition(ushort pPosition)
{ _position = pPosition;
}

[XmlElement(Type= typeof(ushort), ElementName="position")]
public ushort Position
{
     get
{
          return _position;
}
     set
{
          _position = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeUshort( (ushort)_nature);
       dos.writeUshort( (ushort)_position);
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
       _nature = dis.readUshort();
       _position = dis.readUshort();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- Relationship-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("ushort\t _nature\t " + _nature.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _position\t " + _position.ToString() + System.Environment.NewLine);
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
 public bool equals(Relationship rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_nature == rhs._nature)) ivarsEqual = false;
     if( ! (_position == rhs._position)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
