using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.37. Specifies the character set used inthe first byte, followed by up to 31 characters of text data.
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
public class AggregateMarking : Object
{
   /** The character set */
   protected byte  _characterSet;

   /** The characters */
   protected byte[]  _characters = new byte[31]; 


/** Constructor */
 public AggregateMarking()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 1;  // _characterSet
   marshalSize = marshalSize + 31 * 1;  // _characters

   return marshalSize;
}


public void setCharacterSet(byte pCharacterSet)
{ _characterSet = pCharacterSet;
}

[XmlElement(Type= typeof(byte), ElementName="characterSet")]
public byte CharacterSet
{
     get
{
          return _characterSet;
}
     set
{
          _characterSet = value;
}
}

public void setCharacters(byte[] pCharacters)
{ _characters = pCharacters;
}

public byte[] getCharacters()
{ return _characters; }

[XmlArray(ElementName="characters")]
public byte[] Characters
{
     get
{
          return _characters;
}
     set
{
          _characters = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeByte( (byte)_characterSet);

       for(int idx = 0; idx < _characters.Length; idx++)
       {
           dos.writeByte(_characters[idx]);
       } // end of array marshaling

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
       _characterSet = dis.readByte();
       for(int idx = 0; idx < _characters.Length; idx++)
       {
                _characters[idx] = dis.readByte();
       } // end of array unmarshaling
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- AggregateMarking-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("byte\t _characterSet\t " + _characterSet.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _characters.Length; idx++)
       {
           sb.Append("byte\t " + _characters[idx] + System.Environment.NewLine);
       } // end of array reflection

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
 public bool equals(AggregateMarking rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_characterSet == rhs._characterSet)) ivarsEqual = false;

     for(int idx = 0; idx < 31; idx++)
     {
          if(!(_characters[idx] == rhs._characters[idx])) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
