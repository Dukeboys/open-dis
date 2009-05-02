using System;
using System.Collections.Generic;
using System.Text;
using DISnet.DataStreamUtilities;
using System.Xml;
using System.Xml.Serialization;
using System.IO;


namespace DISnet.Utilities
{
    /* Author Peter Smith (Naval Air Warfare Center - Training Systems Division) 01/23/2009
* Modifications: none
* Notes:
*/

    public class PDUProcessor
    {
        private const uint PDU_TYPE_POSITION = 2;
        private const uint PDU_VERSION_POSITION = 0;
        private const uint PDU_LENGTH_POSITION = 8;

        private DISnet.DataStreamUtilities.EndianTypes.Endian edian = (BitConverter.IsLittleEndian ? DISnet.DataStreamUtilities.EndianTypes.Endian.LITTLE : DISnet.DataStreamUtilities.EndianTypes.Endian.BIG);
        private System.Xml.Serialization.XmlSerializer xmlSerializedData;

        /// <summary>
        /// Provides a means of processing PDU data 
        /// </summary>
        /// <param name="buf">byte array containing the pdu data to process</param>
        /// <param name="endian">format of value types</param>
        /// <returns>Collection of PDUs which are represented in base object class</returns>
        public List<object> ProcessPDU(byte[] buf, DISnet.DataStreamUtilities.EndianTypes.Endian endian)
        {
            Endian = endian;
            return ProcessPDU(buf);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="buf"></param>
        /// <param name="endian"></param>
        /// <param name="length">The standard size of a PDU header.  The size of the pdu will be read from the header. 
        /// Note: This value could have been a const but wanted to be more flexible</param>
        /// <returns></returns>
        public object ProcessPDU(Stream stream, DISnet.DataStreamUtilities.EndianTypes.Endian endian)
        {
            Endian = endian;
            return ProcessPDU(stream);
        }

        private object ProcessPDU(Stream stream)
        {
            
            int upToPDULength = (int)PDU_LENGTH_POSITION + sizeof(UInt16);
            int pduLength = 0;
            byte pdu_type;
            byte pdu_version;
            object PDU = null;

            long startingPosition = stream.Position;

            byte[] buf = new byte[upToPDULength];
            
            //Read in part of the stream up to the pdu length
            stream.Read(buf, 0, upToPDULength);

            try
            {
                if (this.edian == DISnet.DataStreamUtilities.EndianTypes.Endian.BIG)
                {
                    byte[] temp = new byte[sizeof(UInt16)];

                    Array.Copy(buf, (int)PDU_LENGTH_POSITION, temp, 0, temp.Length);
                    Array.Reverse(temp);
                    pduLength = System.BitConverter.ToUInt16(temp, 0);
                }
                else
                {
                    pduLength = System.BitConverter.ToUInt16(buf, (int)PDU_LENGTH_POSITION);
                }

                //Allocate space for the whole PDU
                byte[] PDUBufferStorage = new byte[pduLength];

                //Reset back to beginning
                stream.Position = startingPosition;

                //read in the whole PDU
                stream.Read(PDUBufferStorage, 0, pduLength);

                pdu_type = PDUBufferStorage[PDU_TYPE_POSITION];

                pdu_version = PDUBufferStorage[PDU_VERSION_POSITION];

                PDU = SwitchOnType(pdu_version, pdu_type, PDUBufferStorage);

            }
            catch (Exception ex)//Wow something bad just happened, could be bad/misalgined PDU
            {
                PDU = null;   
            }

            return PDU;
        }

        /// <summary>
        /// Process a received PDU.  Note that a datastream can contain multiple PDUs.  Therefore a
        /// List is used to hold one or more after decoding.
        /// </summary>
        /// <param name="buf">byte array of PDU(s)</param>
        /// <returns>Collection of all PDU(s) decoded</returns>
        private List<object> ProcessPDU(byte[] buf)
        {
            List<object> pduCollection = new List<object>();

            if (buf.Length < 1)
            {
                return pduCollection;
            }

            int length = buf.Length;
            byte pdu_type;
            byte pdu_version;
            int countBytes = 0;
            uint pduLength = 0;

            //used to interate over all PDU(s) within the byte array
            while (countBytes < length)
            {
                try
                {

                    if (this.edian == DISnet.DataStreamUtilities.EndianTypes.Endian.BIG)
                    {
                        byte[] temp = new byte[sizeof(UInt16)];

                        Array.Copy(buf, (int)PDU_LENGTH_POSITION + countBytes, temp, 0, temp.Length);
                        Array.Reverse(temp);
                        pduLength = System.BitConverter.ToUInt16(temp, 0);
                    }
                    else
                    {
                        pduLength = System.BitConverter.ToUInt16(buf, (int)PDU_LENGTH_POSITION + countBytes);
                    }

                    //Must be at end of datastream
                    if (pduLength == 0)
                        break;

                    pdu_type = buf[PDU_TYPE_POSITION + countBytes];

                    pdu_version = buf[PDU_VERSION_POSITION + countBytes];

                    byte[] PDUBufferStorage = new byte[pduLength];

                    Array.Copy(buf, countBytes, PDUBufferStorage, 0, (long)pduLength);

                    pduCollection.Add(SwitchOnType(pdu_version, pdu_type, PDUBufferStorage));

                    countBytes += (int)pduLength;

                }
                catch (Exception ex)//Wow something bad just happened, could be bad/misalgined PDU
                {
                    break;
                }
            }
            
            return pduCollection;
        }

         ///<summary>
         ///Returns an instance of the PDU based upon the pdu type passed in.  Note PDU will be represented as an Object for simplicity.
         ///</summary>
         ///<param name="pdu_version">Version of IEEE standard</param>
         ///<param name="pdu_type">Type of PDU</param>
         ///<param name="ds">PDU byte array containing the data</param>
         ///<returns></returns>         
        private object SwitchOnType(byte pdu_version, uint pdu_type, byte[] ds)
        {
            object pdu = null;

            DataInputStream dStream = new DataInputStream(ds, this.Endian);

            switch (pdu_version)
            {
                case 5: //1995
                    break;
                case 6: //1998
                    pdu = DISnet.Utilities.PDUBank.GetPDU(pdu_type);
                    break;
                default:
                    break;
            }


            if (pdu != null)
            {
                //Call the method of the underlining Type vice the Upper class method.
                ReturnUnmarshalledPDU(pdu, dStream);
            }

            return pdu;
        }

        /// <summary>
        /// Unmarshal all data into the pdu object.  This method calls the all the base unmarshals.
        /// </summary>
        /// <param name="pdu">object where the unmarshalled data will be stored</param>
        /// <param name="dStream">location of where the unmarshalled data is located</param>
        private static void ReturnUnmarshalledPDU(object pdu, DataInputStream dStream)
        {
            //unmarshal is the method name found in each of the PDU classes
            pdu.GetType().InvokeMember("unmarshal", System.Reflection.BindingFlags.InvokeMethod, null, pdu, new object[] { dStream });
        }

        /// <summary>
        /// Provided as a means to return a string representation of the underlining PDU data.  Note format is not yet optimized.
        /// </summary>
        /// <param name="pdu">PDU to parse</param>
        /// <returns>StringBuilder that represents the state of the PDU</returns>
        public StringBuilder DecodePDU(object pdu)
        {
            StringBuilder sb = new StringBuilder();
            pdu.GetType().InvokeMember("reflection", System.Reflection.BindingFlags.InvokeMethod, null, pdu, new object[] { sb });

            return sb;
        }

        /// <summary>
        /// Returns an XML version of the reflected PDU
        /// </summary>
        /// <param name="pdu">PDU to reflect into XML</param>
        /// <returns>StringBuilder</returns>
        public StringBuilder XmlDecodePDU(object pdu)
        {
            StringBuilder sb = new StringBuilder();
            System.IO.StringWriter stringWriter = new System.IO.StringWriter();

            try
            {
                xmlSerializedData = new XmlSerializer(pdu.GetType());
                xmlSerializedData.Serialize(stringWriter, pdu);

            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                sb.Append(stringWriter.ToString());
                stringWriter.Close();
            }

            return sb;
        }

        /// <summary>
        /// Type of endian used to process the data
        /// </summary>
        public DISnet.DataStreamUtilities.EndianTypes.Endian Endian
        {
            get
            {
                return this.edian;
            }

            set
            {
                this.edian = value;
            }
        }
    }    
}
