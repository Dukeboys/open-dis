using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.7.4.2 When present, layer 2 should follow layer 1 and have the following fields. This requires manual cleanup.        the beamData attribute semantics are used in multiple ways. UNFINSISHED
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
[XmlInclude(typeof(LayerHeader))]
[XmlInclude(typeof(BeamData))]
[XmlInclude(typeof(FundamentalParameterDataIff))]
public class IffAtcNavAidsLayer2Pdu : IffAtcNavAidsLayer1Pdu
{
   /** layer header */
   protected LayerHeader  _layerHeader = new LayerHeader(); 

   /** beam data */
   protected BeamData  _beamData = new BeamData(); 

   /** Secondary operational data, 5.2.57 */
   protected BeamData  _secondaryOperationalData = new BeamData(); 

   /** variable length list of fundamental parameters. @@@This is wrong */
   protected List<FundamentalParameterDataIff> _fundamentalIffParameters = new List<FundamentalParameterDataIff>(); 

/** Constructor */
   ///<summary>
   ///Section 5.3.7.4.2 When present, layer 2 should follow layer 1 and have the following fields. This requires manual cleanup.        the beamData attribute semantics are used in multiple ways. UNFINSISHED
   ///</summary>
 public IffAtcNavAidsLayer2Pdu()
 {
 }

new public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _layerHeader.getMarshalledSize();  // _layerHeader
   marshalSize = marshalSize + _beamData.getMarshalledSize();  // _beamData
   marshalSize = marshalSize + _secondaryOperationalData.getMarshalledSize();  // _secondaryOperationalData
   for(int idx=0; idx < _fundamentalIffParameters.Count; idx++)
   {
        FundamentalParameterDataIff listElement = (FundamentalParameterDataIff)_fundamentalIffParameters[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


   ///<summary>
   ///layer header
   ///</summary>
public void setLayerHeader(LayerHeader pLayerHeader)
{ _layerHeader = pLayerHeader;
}

   ///<summary>
   ///layer header
   ///</summary>
public LayerHeader getLayerHeader()
{ return _layerHeader; 
}

   ///<summary>
   ///layer header
   ///</summary>
[XmlElement(Type= typeof(LayerHeader), ElementName="layerHeader")]
public LayerHeader LayerHeader
{
     get
{
          return _layerHeader;
}
     set
{
          _layerHeader = value;
}
}

   ///<summary>
   ///beam data
   ///</summary>
public void setBeamData(BeamData pBeamData)
{ _beamData = pBeamData;
}

   ///<summary>
   ///beam data
   ///</summary>
public BeamData getBeamData()
{ return _beamData; 
}

   ///<summary>
   ///beam data
   ///</summary>
[XmlElement(Type= typeof(BeamData), ElementName="beamData")]
public BeamData BeamData
{
     get
{
          return _beamData;
}
     set
{
          _beamData = value;
}
}

   ///<summary>
   ///Secondary operational data, 5.2.57
   ///</summary>
public void setSecondaryOperationalData(BeamData pSecondaryOperationalData)
{ _secondaryOperationalData = pSecondaryOperationalData;
}

   ///<summary>
   ///Secondary operational data, 5.2.57
   ///</summary>
public BeamData getSecondaryOperationalData()
{ return _secondaryOperationalData; 
}

   ///<summary>
   ///Secondary operational data, 5.2.57
   ///</summary>
[XmlElement(Type= typeof(BeamData), ElementName="secondaryOperationalData")]
public BeamData SecondaryOperationalData
{
     get
{
          return _secondaryOperationalData;
}
     set
{
          _secondaryOperationalData = value;
}
}

   ///<summary>
   ///variable length list of fundamental parameters. @@@This is wrong
   ///</summary>
public void setFundamentalIffParameters(List<FundamentalParameterDataIff> pFundamentalIffParameters)
{ _fundamentalIffParameters = pFundamentalIffParameters;
}

   ///<summary>
   ///variable length list of fundamental parameters. @@@This is wrong
   ///</summary>
public List<FundamentalParameterDataIff> getFundamentalIffParameters()
{ return _fundamentalIffParameters; }

   ///<summary>
   ///variable length list of fundamental parameters. @@@This is wrong
   ///</summary>
[XmlElement(ElementName = "fundamentalIffParametersList",Type = typeof(List<FundamentalParameterDataIff>))]
public List<FundamentalParameterDataIff> FundamentalIffParameters
{
     get
{
          return _fundamentalIffParameters;
}
     set
{
          _fundamentalIffParameters = value;
}
}

///<summary>
///Automatically sets the length of the marshalled data, then calls the marshal method.
///</summary>
new public void marshalAutoLengthSet(DataOutputStream dos)
{
       //Set the length prior to marshalling data
       this.setLength((ushort)this.getMarshalledSize());
       this.marshal(dos);
}

///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
new public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _layerHeader.marshal(dos);
       _beamData.marshal(dos);
       _secondaryOperationalData.marshal(dos);

       for(int idx = 0; idx < _fundamentalIffParameters.Count; idx++)
       {
            FundamentalParameterDataIff aFundamentalParameterDataIff = (FundamentalParameterDataIff)_fundamentalIffParameters[idx];
            aFundamentalParameterDataIff.marshal(dos);
       } // end of list marshalling

    } // end try 
    catch(Exception e)
    { 
      Trace.WriteLine(e);
      Trace.Flush();
    }
} // end of marshal method

new public void unmarshal(DataInputStream dis)
{
    base.unmarshal(dis);

    try 
    {
       _layerHeader.unmarshal(dis);
       _beamData.unmarshal(dis);
       _secondaryOperationalData.unmarshal(dis);
        for(int idx = 0; idx < _pad2; idx++)
        {
           FundamentalParameterDataIff anX = new FundamentalParameterDataIff();
            anX.unmarshal(dis);
            _fundamentalIffParameters.Add(anX);
        };

    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


   ///<summary>
   ///This allows for a quick display of PDU data.  The current format is unacceptable and only used for debugging.
   ///This will be modified in the future to provide a better display.  Usage: 
   ///pdu.GetType().InvokeMember("reflection", System.Reflection.BindingFlags.InvokeMethod, null, pdu, new object[] { sb });
   ///where pdu is an object representing a single pdu and sb is a StringBuilder.
   ///Note: The supplied Utilities folder contains a method called 'DecodePDU' in the PDUProcessor Class that provides this functionality
   ///</summary>
new public void reflection(StringBuilder sb)
{
    sb.Append("<IffAtcNavAidsLayer2Pdu>"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
    sb.Append("<layerHeader>"  + System.Environment.NewLine);
       _layerHeader.reflection(sb);
    sb.Append("</layerHeader>"  + System.Environment.NewLine);
    sb.Append("<beamData>"  + System.Environment.NewLine);
       _beamData.reflection(sb);
    sb.Append("</beamData>"  + System.Environment.NewLine);
    sb.Append("<secondaryOperationalData>"  + System.Environment.NewLine);
       _secondaryOperationalData.reflection(sb);
    sb.Append("</secondaryOperationalData>"  + System.Environment.NewLine);

       for(int idx = 0; idx < _fundamentalIffParameters.Count; idx++)
       {
           sb.Append("<fundamentalIffParameters"+ idx.ToString() + " type=\"FundamentalParameterDataIff\">" + System.Environment.NewLine);
            FundamentalParameterDataIff aFundamentalParameterDataIff = (FundamentalParameterDataIff)_fundamentalIffParameters[idx];
            aFundamentalParameterDataIff.reflection(sb);
           sb.Append("</fundamentalIffParameters"+ idx.ToString() + ">" + System.Environment.NewLine);
       } // end of list marshalling

    sb.Append("</IffAtcNavAidsLayer2Pdu>"  + System.Environment.NewLine);
    } // end try 
    catch(Exception e)
    { 
      Trace.WriteLine(e);
      Trace.Flush();
}
    } // end of marshal method

 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public bool equals(IffAtcNavAidsLayer2Pdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_layerHeader.Equals( rhs._layerHeader) )) ivarsEqual = false;
     if( ! (_beamData.Equals( rhs._beamData) )) ivarsEqual = false;
     if( ! (_secondaryOperationalData.Equals( rhs._secondaryOperationalData) )) ivarsEqual = false;

     for(int idx = 0; idx < _fundamentalIffParameters.Count; idx++)
     {
        FundamentalParameterDataIff x = (FundamentalParameterDataIff)_fundamentalIffParameters[idx];
        if( ! ( _fundamentalIffParameters[idx].Equals(rhs._fundamentalIffParameters[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
