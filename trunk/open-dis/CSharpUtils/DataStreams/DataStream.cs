using System;
using System.Collections.Generic;
using System.Text;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;

namespace DISnet.DataStreamUtilities
{
    /* Author Peter Smith (Naval Air Warfare Center - Training Systems Division) 01/23/2009
* Modifications: none
* Notes:
*/

    /// <summary>
    /// Base class for storing PDU information
    /// </summary>
    public class DataStream
    {
        //Counter used to keep track of where pointer is for the stream
        public int streamCounter;
        //Create the MemoryStream that will be used to hold the PDU data
        public MemoryStream msPDU;
        //Location to store a byte representation of the PDU
        public byte[] byteStream;

        //Test the machine to determine to see what it supports, this will be the default but can be overridden via constructor
        private DISnet.DataStreamUtilities.EndianTypes.Endian endianType = (BitConverter.IsLittleEndian ? DISnet.DataStreamUtilities.EndianTypes.Endian.LITTLE : DISnet.DataStreamUtilities.EndianTypes.Endian.BIG);

        /// <summary>
        /// Create new DataStream.  This will store all PDU information for either an InputStream or OutputStream
        /// </summary>
        public DataStream()
        {
            //Set default counter value to 0
            streamCounter = 0;
            //Create a new MemoryStream
            msPDU = new MemoryStream();
        }

        /// <summary>
        /// Re-Initializes the MemoryStream and streamCounter back to zero
        /// </summary>
        public void clear()
        {
            streamCounter = 0;
            msPDU = new MemoryStream();
        }

        /// <summary>
        /// Convert a MemoryStream to a byte array
        /// </summary>
        /// <returns>byte array</returns>
        public byte[] ConvertToBytes()
        {
            return msPDU.GetBuffer();
        }

        /// <summary>
        /// Used primarily to return a portion of a byte array for Endian conversion
        /// </summary>
        /// <param name="byteStream">source bytearray</param>
        /// <param name="startIndex">A 32-bit integer that represents the start index at which the conversion should begin</param>
        /// <param name="sizeOfData">A 32-bit integer that represents the size of the value type</param>
        /// <param name="temp">A byte array that will hold the byte representation of the value</param>
        public void ReturnByteArray(byte[] byteStream, int startIndex, int sizeOfData, out byte[] temp)
        {
            temp = new byte[sizeOfData];
            Array.Copy(byteStream, startIndex, temp, 0, sizeOfData);
        }

        /// <summary>
        /// Appends the byte array data to the MemoryStream
        /// </summary>
        /// <param name="data">byte array</param>
        public void Append(byte[] data)
        {
            msPDU.Seek(msPDU.Length, SeekOrigin.Begin);
            msPDU.Write(data, 0, data.Length);
        }

        /// <summary>
        /// Appends a single byte to the MemoryStream
        /// </summary>
        /// <param name="data"></param>
        public void Append(byte data)
        {
            msPDU.Seek(msPDU.Length, SeekOrigin.Begin);
            msPDU.WriteByte(data);
        }

        /// <summary>
        /// Gets or Sets the Endian type
        /// </summary>
        public DISnet.DataStreamUtilities.EndianTypes.Endian Endian
        {
            get
            {
                return endianType;
            }

            set
            {
                endianType = value;
            }                
        }
    }

  
}
