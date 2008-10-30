package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.7.4.2 When present, layer 2 should follow layer 1 and have the following fields. This requires manual cleanup.        the beamData attribute semantics are used in multiple ways. UNFINSISHED
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class IffAtcNavAidsLayer2Pdu extends IffAtcNavAidsLayer1Pdu implements Serializable
{
   /** layer header */
   protected LayerHeader  layerHeader = new LayerHeader(); 

   /** beam data */
   protected BeamData  beamData = new BeamData(); 

   /** Secondary operational data, 5.2.57 */
   protected BeamData  secondaryOperationalData = new BeamData(); 

   /** variable length list of fundamental parameters. @@@This is wrong */
   protected List fundamentalIffParameters = new ArrayList(); 

/** Constructor */
 public IffAtcNavAidsLayer2Pdu()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + layerHeader.getMarshalledSize();  // layerHeader
   marshalSize = marshalSize + beamData.getMarshalledSize();  // beamData
   marshalSize = marshalSize + secondaryOperationalData.getMarshalledSize();  // secondaryOperationalData
   for(int idx=0; idx < fundamentalIffParameters.size(); idx++)
   {
        FundamentalParameterDataIff listElement = (FundamentalParameterDataIff)fundamentalIffParameters.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setLayerHeader(LayerHeader pLayerHeader)
{ layerHeader = pLayerHeader;
}

@XmlElement
public LayerHeader getLayerHeader()
{ return layerHeader; 
}

public void setBeamData(BeamData pBeamData)
{ beamData = pBeamData;
}

@XmlElement
public BeamData getBeamData()
{ return beamData; 
}

public void setSecondaryOperationalData(BeamData pSecondaryOperationalData)
{ secondaryOperationalData = pSecondaryOperationalData;
}

@XmlElement
public BeamData getSecondaryOperationalData()
{ return secondaryOperationalData; 
}

public void setFundamentalIffParameters(List pFundamentalIffParameters)
{ fundamentalIffParameters = pFundamentalIffParameters;
}

@XmlElementWrapper(name="fundamentalIffParametersList" )
public List getFundamentalIffParameters()
{ return fundamentalIffParameters; }


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       layerHeader.marshal(dos);
       beamData.marshal(dos);
       secondaryOperationalData.marshal(dos);

       for(int idx = 0; idx < fundamentalIffParameters.size(); idx++)
       {
            FundamentalParameterDataIff aFundamentalParameterDataIff = (FundamentalParameterDataIff)fundamentalIffParameters.get(idx);
            aFundamentalParameterDataIff.marshal(dos);
       } // end of list marshalling

    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    super.unmarshal(dis);

    try 
    {
       layerHeader.unmarshal(dis);
       beamData.unmarshal(dis);
       secondaryOperationalData.unmarshal(dis);
        for(int idx = 0; idx < pad2; idx++)
        {
           FundamentalParameterDataIff anX = new FundamentalParameterDataIff();
            anX.unmarshal(dis);
            fundamentalIffParameters.add(anX);
        };

    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(IffAtcNavAidsLayer2Pdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (layerHeader.equals( rhs.layerHeader) )) ivarsEqual = false;
     if( ! (beamData.equals( rhs.beamData) )) ivarsEqual = false;
     if( ! (secondaryOperationalData.equals( rhs.secondaryOperationalData) )) ivarsEqual = false;

     for(int idx = 0; idx < fundamentalIffParameters.size(); idx++)
     {
        FundamentalParameterDataIff x = (FundamentalParameterDataIff)fundamentalIffParameters.get(idx);
        if( ! ( fundamentalIffParameters.get(idx).equals(rhs.fundamentalIffParameters.get(idx)))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
// Copyright (c) 1995-2009 held by the author(s).  All rights reserved.
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions
//  are met:
// 
//  * Redistributions of source code must retain the above copyright
// notice, this list of conditions and the following disclaimer.
// * Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer
// in the documentation and/or other materials provided with the
// distribution.
// * Neither the names of the Naval Postgraduate School (NPS)
//  Modeling Virtual Environments and Simulation (MOVES) Institute
// (http://www.nps.edu and http://www.MovesInstitute.org)
// nor the names of its contributors may be used to endorse or
//  promote products derived from this software without specific
// prior written permission.
// 
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// AS IS AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
// FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
// COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
// INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
// BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
// LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
// CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
// LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
// ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
// POSSIBILITY OF SUCH DAMAGE.
