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
   protected List<object> _fundamentalIffParameters = new List<object>(); 

/** Constructor */
 public IffAtcNavAidsLayer2Pdu()
 {
 }

public int getMarshalledSize()
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


public void setLayerHeader(LayerHeader pLayerHeader)
{ _layerHeader = pLayerHeader;
}

public LayerHeader getLayerHeader()
{ return _layerHeader; 
}

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

public void setBeamData(BeamData pBeamData)
{ _beamData = pBeamData;
}

public BeamData getBeamData()
{ return _beamData; 
}

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

public void setSecondaryOperationalData(BeamData pSecondaryOperationalData)
{ _secondaryOperationalData = pSecondaryOperationalData;
}

public BeamData getSecondaryOperationalData()
{ return _secondaryOperationalData; 
}

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

public void setFundamentalIffParameters(List<object> pFundamentalIffParameters)
{ _fundamentalIffParameters = pFundamentalIffParameters;
}

public List<object> getFundamentalIffParameters()
{ return _fundamentalIffParameters; }

[XmlElement(ElementName = "fundamentalIffParametersList",Type = typeof(List<object>))]
public List<object> FundamentalIffParameters
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


public void marshal(DataOutputStream dos)
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

public void unmarshal(DataInputStream dis)
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


public void reflection(StringBuilder sb)
{
    sb.Append("----- IffAtcNavAidsLayer2Pdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_layerHeader=====" + System.Environment.NewLine);
       _layerHeader.reflection(sb);
       sb.Append("=====_beamData=====" + System.Environment.NewLine);
       _beamData.reflection(sb);
       sb.Append("=====_secondaryOperationalData=====" + System.Environment.NewLine);
       _secondaryOperationalData.reflection(sb);

       for(int idx = 0; idx < _fundamentalIffParameters.Count; idx++)
       {
           sb.Append("FundamentalParameterDataIff\t " + _fundamentalIffParameters[idx] + System.Environment.NewLine);
            FundamentalParameterDataIff aFundamentalParameterDataIff = (FundamentalParameterDataIff)_fundamentalIffParameters[idx];
            aFundamentalParameterDataIff.reflection(sb);
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
