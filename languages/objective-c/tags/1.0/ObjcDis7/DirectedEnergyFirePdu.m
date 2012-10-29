#import "DirectedEnergyFirePdu.h" 


@implementation DirectedEnergyFirePdu

@synthesize munitionType;
@synthesize shotStartTime;
@synthesize commulativeShotTime;
@synthesize ApertureEmitterLocation;
@synthesize apertureDiameter;
@synthesize wavelength;
@synthesize peakIrradiance;
@synthesize pulseRepetitionFrequency;
@synthesize pulseWidth;
@synthesize flags;
@synthesize pulseShape;
@synthesize padding1;
@synthesize padding2;
@synthesize padding3;
@synthesize numberOfDERecords;
@synthesize dERecords;

-(id)init
{
  self = [super init];
  if(self)
  {
    [self setPduType:68];
    munitionType = [[EntityType alloc] init];
    shotStartTime = [[ClockTime alloc] init];
    commulativeShotTime = 0;
    ApertureEmitterLocation = [[Vector3Float alloc] init];
    apertureDiameter = 0;
    wavelength = 0;
    peakIrradiance = 0;
    pulseRepetitionFrequency = 0;
    pulseWidth = 0;
    flags = 0;
    pulseShape = 0;
    padding1 = 0;
    padding2 = 0;
    padding3 = 0;
    numberOfDERecords = 0;
    dERecords = [NSMutableArray arrayWithCapacity:1];
  } // end if(self)
  return self;
}


-(void)dealloc
{
  [munitionType release];
  [shotStartTime release];
  [ApertureEmitterLocation release];
  [dERecords release];
  [super dealloc];
}

-(void) marshalUsingStream:(DataOutput*) dataStream
{
    [super marshalUsingStream:dataStream]; // Marshal information in superclass first
    [munitionType marshalUsingStream:dataStream];
    [shotStartTime marshalUsingStream:dataStream];
    [dataStream writeFloat:commulativeShotTime];
    [ApertureEmitterLocation marshalUsingStream:dataStream];
    [dataStream writeFloat:apertureDiameter];
    [dataStream writeFloat:wavelength];
    [dataStream writeFloat:peakIrradiance];
    [dataStream writeFloat:pulseRepetitionFrequency];
    [dataStream writeInt:pulseWidth];
    [dataStream writeInt:flags];
    [dataStream writeByte:pulseShape];
    [dataStream writeUnsignedByte:padding1];
    [dataStream writeUnsignedInt:padding2];
    [dataStream writeUnsignedShort:padding3];
    [dataStream writeUnsignedShort:[dERecords count]];

     for(int idx = 0; idx < [dERecords count]; idx++)
     {
        StandardVariableSpecification* x = [dERecords objectAtIndex:idx];
        [x marshalUsingStream:dataStream];
     }

}

-(void) unmarshalUsingStream:(DataInput*)dataStream;
{
    [super unmarshalUsingStream:dataStream]; // unmarshal information in superclass first
    [munitionType unmarshalUsingStream:dataStream];
    [shotStartTime unmarshalUsingStream:dataStream];
    commulativeShotTime = [dataStream readFloat];
    [ApertureEmitterLocation unmarshalUsingStream:dataStream];
    apertureDiameter = [dataStream readFloat];
    wavelength = [dataStream readFloat];
    peakIrradiance = [dataStream readFloat];
    pulseRepetitionFrequency = [dataStream readFloat];
    pulseWidth = [dataStream readInt];
    flags = [dataStream readInt];
    pulseShape = [dataStream readByte];
    padding1 = [dataStream readUnsignedByte];
    padding2 = [dataStream readUnsignedInt];
    padding3 = [dataStream readUnsignedShort];
    numberOfDERecords = [dataStream readUnsignedShort];

     [dERecords removeAllObjects];
     for(int idx = 0; idx < numberOfDERecords; idx++)
     {
        StandardVariableSpecification* x;
        [x unmarshalUsingStream:dataStream];
        [dERecords addObject:x];
     }
}


-(int)getMarshalledSize
{
   int marshalSize = 0;

   marshalSize = [super getMarshalledSize];
   marshalSize = marshalSize + [munitionType getMarshalledSize];
   marshalSize = marshalSize + [shotStartTime getMarshalledSize];
   marshalSize = marshalSize + 4;  // commulativeShotTime
   marshalSize = marshalSize + [ApertureEmitterLocation getMarshalledSize];
   marshalSize = marshalSize + 4;  // apertureDiameter
   marshalSize = marshalSize + 4;  // wavelength
   marshalSize = marshalSize + 4;  // peakIrradiance
   marshalSize = marshalSize + 4;  // pulseRepetitionFrequency
   marshalSize = marshalSize + 4;  // pulseWidth
   marshalSize = marshalSize + 4;  // flags
   marshalSize = marshalSize + 1;  // pulseShape
   marshalSize = marshalSize + 1;  // padding1
   marshalSize = marshalSize + 4;  // padding2
   marshalSize = marshalSize + 2;  // padding3
   marshalSize = marshalSize + 2;  // numberOfDERecords

   for(int idx=0; idx < [dERecords count]; idx++)
   {
        StandardVariableSpecification* listElement = [dERecords objectAtIndex:idx];
        marshalSize = marshalSize + [listElement getMarshalledSize];
    }

    return marshalSize;
}

@end



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
