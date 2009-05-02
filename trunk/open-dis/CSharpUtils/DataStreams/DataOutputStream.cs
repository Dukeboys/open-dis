using System;
using System.Collections.Generic;
using System.Text;
using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;
using System.Runtime.InteropServices;

namespace DISnet.DataStreamUtilities
{
    /* Author Peter Smith (Naval Air Warfare Center - Training Systems Division) 01/23/2009
* Modifications: none
* Notes:
*/

    /// <summary>
    /// Class used to export PDU information from a DataStream
    /// </summary>
    public class DataOutputStream
    {
        //Instatiate a new DataStream for outputting data
        DISnet.DataStreamUtilities.DataStream dsPDU = new DataStream();

        /// <summary>
        /// Constructor to create the DataOutputStream
        /// </summary>
        public DataOutputStream(DISnet.DataStreamUtilities.EndianTypes.Endian endian)
        {
            dsPDU = new DataStream();
            Endian = endian;
        }

        /// <summary>
        /// Constructor to create a DataOutputStream from an existing DataStream and setting the type of Endian to use
        /// </summary>
        /// <param name="ds"></param>
        /// <param name="endian"></param>
        public DataOutputStream(DISnet.DataStreamUtilities.DataStream ds, DISnet.DataStreamUtilities.EndianTypes.Endian endian)
        {
            dsPDU = ds;
            Endian = endian;
        }

        /// <summary>
        /// Gets or Sets the Endian type
        /// </summary>
        public DISnet.DataStreamUtilities.EndianTypes.Endian Endian
        {
            get
            {
                return this.DS.Endian;
            }

            set
            {
                this.DS.Endian = value;
            }
        }

        /// <summary>
        /// Write a short value to the DataStream
        /// </summary>
        /// <param name="data">short value</param>
        public void writeShort(short data)
        {
            byte[] serializedData = System.BitConverter.GetBytes(data);

            if (this.Endian == DISnet.DataStreamUtilities.EndianTypes.Endian.BIG)
            {
                Array.Reverse(serializedData);
            }

            WriteData(serializedData);
        }

        /// <summary>
        /// Write a float value to the DataStream
        /// </summary>
        /// <param name="data">float</param>
        public void writeFloat(float data)
        {
            byte[] serializedData = System.BitConverter.GetBytes(data);

            if (this.Endian == DISnet.DataStreamUtilities.EndianTypes.Endian.BIG)
            {
                Array.Reverse(serializedData);
            }

            WriteData(serializedData);
        }

        /// <summary>
        /// Write a int value to the DataStream
        /// </summary>
        /// <param name="data">int32</param>
        public void writeInt(int data)
        {
            byte[] serializedData = System.BitConverter.GetBytes(data);

            if (this.Endian == DISnet.DataStreamUtilities.EndianTypes.Endian.BIG)
            {
                Array.Reverse(serializedData);
            }

            WriteData(serializedData);
        }

        /// <summary>
        /// Write a unsigned short value to the DataStream
        /// </summary>
        /// <param name="data">unsigned short</param>
        public void writeUshort(ushort data)
        {
            byte[] serializedData = System.BitConverter.GetBytes(data);

            if (this.Endian == DISnet.DataStreamUtilities.EndianTypes.Endian.BIG)
            {
                Array.Reverse(serializedData);
            }

            WriteData(serializedData);
        }

        /// <summary>
        /// Write a unsigned int value to the DataStream
        /// </summary>
        /// <param name="data">unsigned int</param>
        public void writeUint(uint data)
        {
            byte[] serializedData = System.BitConverter.GetBytes(data);

            if (this.Endian == DISnet.DataStreamUtilities.EndianTypes.Endian.BIG)
            {
                Array.Reverse(serializedData);
            }

            WriteData(serializedData);
        }
        
        /// <summary>
        /// Write a byte value to the DataStream
        /// </summary>
        /// <param name="data">byte</param>
        public void writeByte(byte data)
        {
            WriteData(data);
        }

        /// <summary>
        /// Write a byte array value to the DataStream
        /// </summary>
        /// <param name="data">byte</param>
        public void writeByte(byte[] data)
        {
            WriteData(data);
        }

        /// <summary>
        /// Write a double value to the DataStream
        /// </summary>
        /// <param name="data">double</param>
        public void writeDouble(double data)
        {
            byte[] serializedData = System.BitConverter.GetBytes(data);

            if (this.Endian == DISnet.DataStreamUtilities.EndianTypes.Endian.BIG)
            {
                Array.Reverse(serializedData);
            }

            WriteData(serializedData);
        }

        /// <summary>
        /// Write a long value to the DataStream
        /// </summary>
        /// <param name="data">long</param>
        public void writeLong(long data)
        {
            byte[] serializedData = System.BitConverter.GetBytes(data);

            if (this.Endian == DISnet.DataStreamUtilities.EndianTypes.Endian.BIG)
            {
                Array.Reverse(serializedData);
            }

            WriteData(serializedData);
        }


        /// <summary>
        /// Write a unsigned long value to the DataStream
        /// </summary>
        /// <param name="data">long</param>
        public void writeUlong(ulong data)
        {
            byte[] serializedData = System.BitConverter.GetBytes(data);

            if (this.Endian == DISnet.DataStreamUtilities.EndianTypes.Endian.BIG)
            {
                Array.Reverse(serializedData);
            }

            WriteData(serializedData);
        }

        /// <summary>
        /// Base method to write a byte value to the DataStream
        /// </summary>
        /// <param name="data">byte</param>
        private void WriteData(byte data)
        {
            dsPDU.Append(data);
            dsPDU.streamCounter += 1;
        }

        /// <summary>
        /// Base method to write an array of bytes to the DataStream
        /// </summary>
        /// <param name="data">byte array</param>
        private void WriteData(byte [] data)
        {
            dsPDU.Append(data);
            dsPDU.streamCounter += data.Length;
        }

        /// <summary>
        /// Converts the DataStream to a byte array
        /// </summary>
        /// <returns>byte array</returns>
        public byte[] ConvertToBytes()
        {
            return DS.ConvertToBytes();
        }

        /// <summary>
        /// Get the underlining DataStream
        /// </summary>
        public DataStream DS
        {
            get
            {
                return this.dsPDU;
            }
        }
    }

}
