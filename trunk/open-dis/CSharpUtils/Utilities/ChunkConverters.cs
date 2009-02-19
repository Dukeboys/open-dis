using System;
using System.Collections.Generic;
using System.Text;
using System.Reflection;
using DIS1998net;

namespace DISnet.Utilities
{
 /* Author Peter Smith (Naval Air Warfare Center - Training Systems Division) 01/23/2009
  * Modifications: none
  * Notes:  Attempted to use Reflection and Generics to prevent the duplication of all of the methods.  Was sucessful with converting ChunkBytes
  * to an array but reflection did not work for the other methods. See Class commented out at the bottom.
 */
    /// <summary>
    /// Chunk Convertor for DIS 1998 (note same  methods could be reused with 1995)
    /// </summary>
    public class DIS1998ChunkConverter
    {
        /// <summary>
        /// Method to convert Eight Byte Chunks into an Array
        /// </summary>
        /// <param name="chunkList">List that holds the EightByteChunks</param>
        /// <returns>Byte array</returns>
        public Array EightByteChunksToArray(List<DIS1998net.EightByteChunk> chunkList)
        {
            DIS1998net.EightByteChunk byteChunkData = new DIS1998net.EightByteChunk();
            int lengthByteChunkData = byteChunkData.OtherParameters.Length;

            //Data passed in does not exist.
            if (chunkList.Count == 0)
                return null;

            //Create the appropriate sized buffer for this type
            byte[] chunkBuffer = new byte[chunkList.Count * lengthByteChunkData];

            //Go through each item and append to the buffer
            for (int i = 0; i < chunkList.Count; i++)
            {
                Buffer.BlockCopy(chunkList[i].OtherParameters, 0, chunkBuffer, i * lengthByteChunkData, lengthByteChunkData);
            }

            return (Array)chunkBuffer;
        }

        /// <summary>
        /// Method to convert Four Byte Chunks into an Array
        /// </summary>
        /// <param name="chunkList">List that holds the FourByteChunks</param>
        /// <returns>Byte array</returns>
        public Array FourByteChunksToArray(List<DIS1998net.FourByteChunk> chunkList)
        {
            DIS1998net.FourByteChunk byteChunkData = new DIS1998net.FourByteChunk();
            int lengthByteChunkData = byteChunkData.OtherParameters.Length;

            //Data passed in does not exist.
            if (chunkList.Count == 0)
                return null;

            byte[] chunkBuffer = new byte[chunkList.Count * lengthByteChunkData];

            for (int i = 0; i < chunkList.Count; i++)
            {
                Buffer.BlockCopy(chunkList[i].OtherParameters, 0, chunkBuffer, i * lengthByteChunkData, lengthByteChunkData);
            }

            return (Array)chunkBuffer;
        }

        /// <summary>
        /// Method to convert Two Byte Chunks into an Array
        /// </summary>
        /// <param name="chunkList">List that holds the TwoByteChunks</param>
        /// <returns>Byte array</returns>
        public Array TwoByteChunksToArray(List<DIS1998net.TwoByteChunk> chunkList)
        {
            DIS1998net.TwoByteChunk byteChunkData = new DIS1998net.TwoByteChunk();
            int lengthByteChunkData = byteChunkData.OtherParameters.Length;

            //Data passed in does not exist.
            if (chunkList.Count == 0)
                return null;

            byte[] chunkBuffer = new byte[chunkList.Count * lengthByteChunkData];

            for (int i = 0; i < chunkList.Count; i++)
            {
                Buffer.BlockCopy(chunkList[i].OtherParameters, 0, chunkBuffer, i * lengthByteChunkData, lengthByteChunkData);
            }

            return (Array)chunkBuffer;
        }

        /// <summary>
        /// Method to convert a string into Eight Byte Chunks into an Array.  This method was provided as a means to transport 'other'
        /// types of data via a PDU that uses variable or fixed Datum.
        /// </summary>
        /// <param name="data">String data to convert</param>
        /// <returns>List of EightByteChunk data</returns>
        public List<DIS1998net.EightByteChunk> StringToEightByteChunks(string data)
        {
            //If data does not exist return null
            if (data.Length == 0)
                return null;

            //Using standard ascii encoding
            System.Text.ASCIIEncoding encoding = new ASCIIEncoding();

            //Convert string into bytes
            Array dataArray = encoding.GetBytes(data);

            return ArrayToEightByteChunks(dataArray);
        }

        /// <summary>
        /// Method to convert a string into Four Byte Chunks into an Array.  This method was provided as a means to transport 'other'
        /// types of data via a PDU that uses variable or fixed Datum.
        /// </summary>
        /// <param name="data">String data to convert</param>
        /// <returns>List of FourByteChunk data</returns>
        public List<DIS1998net.FourByteChunk> StringToFourByteChunks(string data)
        {
            if (data.Length == 0)
                return null;

            System.Text.ASCIIEncoding encoding = new ASCIIEncoding();
            Array dataArray = encoding.GetBytes(data);

            return ArrayToFourByteChunks(dataArray);
        }

        /// <summary>
        /// Method to convert a string into Two Byte Chunks into an Array.  This method was provided as a means to transport 'other'
        /// types of data via a PDU that uses variable or fixed Datum.
        /// </summary>
        /// <param name="data">String data to convert</param>
        /// <returns>List of TwoByteChunk data</returns>
        public List<DIS1998net.TwoByteChunk> StringToTwoByteChunks(string data)
        {
            if (data.Length == 0)
                return null;

            System.Text.ASCIIEncoding encoding = new ASCIIEncoding();
            Array dataArray = encoding.GetBytes(data);

            return ArrayToTwoByteChunks(dataArray);
        }


        /// <summary>
        /// Method to convert a byte Array into Eigh tByte Chunks
        /// </summary>
        /// <param name="data">Byte array that contains data to convert</param>
        /// <returns>List containing EightByteChunks</returns>
        public List<DIS1998net.EightByteChunk> ArrayToEightByteChunks(Array data)
        {
            //If no data exists return null
            if (data.Length == 0)
                return null;

            int result = 0;

            //Used to get the length of the data
            DIS1998net.EightByteChunk byteChunkData = new DIS1998net.EightByteChunk();
            int lengthByteChunkData = byteChunkData.OtherParameters.Length;

            //Calculate the size if not on the byte boundary then all 1 to make it so
            int maxSize = Math.DivRem(data.Length, lengthByteChunkData, out result);
            if (result != 0) maxSize++;

            //Create buffer to hold the data passed in from the array
            byte[] chunkBuffer = new byte[maxSize * lengthByteChunkData];

            //Copy data to the buffer created above
            Buffer.BlockCopy(data, 0, chunkBuffer, 0, data.Length);

            List<DIS1998net.EightByteChunk> byteChunkList = new List<DIS1998net.EightByteChunk>();

            //Iterate over the buffer and grab the appropriate number of bytes, store into the List
            for (int i = 0; i < maxSize; i++)
            {
                byteChunkData = new DIS1998net.EightByteChunk();
                Buffer.BlockCopy(chunkBuffer, i * lengthByteChunkData, byteChunkData.OtherParameters, 0, lengthByteChunkData);

                byteChunkList.Add(byteChunkData);
            }

            return byteChunkList;
        }

        /// <summary>
        /// Method to convert a byte Array into Four tByte Chunks
        /// </summary>
        /// <param name="data">Byte array that contains data to convert</param>
        /// <returns>List containing FourByteChunks</returns>
        public List<DIS1998net.FourByteChunk> ArrayToFourByteChunks(Array data)
        {
            if (data.Length == 0)
                return null;

            int result = 0;

            DIS1998net.FourByteChunk byteChunkData = new DIS1998net.FourByteChunk();
            int lengthByteChunkData = byteChunkData.OtherParameters.Length;

            int maxSize = Math.DivRem(data.Length, lengthByteChunkData, out result);
            if (result != 0) maxSize++;

            byte[] chunkBuffer = new byte[maxSize * lengthByteChunkData];
            Buffer.BlockCopy(data, 0, chunkBuffer, 0, data.Length);

            List<DIS1998net.FourByteChunk> byteChunkList = new List<DIS1998net.FourByteChunk>();

            for (int i = 0; i < maxSize; i++)
            {
                byteChunkData = new DIS1998net.FourByteChunk();
                Buffer.BlockCopy(chunkBuffer, i * lengthByteChunkData, byteChunkData.OtherParameters, 0, lengthByteChunkData);

                byteChunkList.Add(byteChunkData);
            }

            return byteChunkList;
        }

        /// <summary>
        /// Method to convert a byte Array into Two tByte Chunks
        /// </summary>
        /// <param name="data">Byte array that contains data to convert</param>
        /// <returns>List containing TwoByteChunks</returns>
        public List<DIS1998net.TwoByteChunk> ArrayToTwoByteChunks(Array data)
        {
            if (data.Length == 0)
                return null;

            int result = 0;

            DIS1998net.TwoByteChunk byteChunkData = new DIS1998net.TwoByteChunk();
            int lengthByteChunkData = byteChunkData.OtherParameters.Length;

            int maxSize = Math.DivRem(data.Length, lengthByteChunkData, out result);
            if (result != 0) maxSize++;

            byte[] chunkBuffer = new byte[maxSize * lengthByteChunkData];
            Buffer.BlockCopy(data, 0, chunkBuffer, 0, data.Length);

            List<DIS1998net.TwoByteChunk> byteChunkList = new List<DIS1998net.TwoByteChunk>();

            for (int i = 0; i < maxSize; i++)
            {
                byteChunkData = new DIS1998net.TwoByteChunk();
                Buffer.BlockCopy(chunkBuffer, i * lengthByteChunkData, byteChunkData.OtherParameters, 0, lengthByteChunkData);

                byteChunkList.Add(byteChunkData);
            }

            return byteChunkList;
        }

      }



    ///// <summary>
    ///// Class originally created to provide chunk data using reflection.  The method below does work, however I could not find a way to
    ///// use reflection going from an Array to the appropriate chunk type data (eg. EightByteChunk).
    ///// </summary>
    ///// <typeparam name="T">Type of Chunk data (eg. EightByteChunk)</typeparam>
    //public class ChunkConvertersUsingReflection<T> where T : class
    //{
    //    public Array ByteChunksToArrayUsingReflection(List<T> chunkList)
    //    {
    //        T[] bufferArray = new T[chunkList.Count];

    //        //Requires knowledge of the Property of the class.  In the Chunk classes each one contains the 'OtherParameters' property.  Note that
    //        //data has to exist within this otherwise an error will occur.  Try catch could be implemented.
    //        byte[] otherParameter = (byte[])chunkList[0].GetType().GetProperty("OtherParameters", System.Reflection.BindingFlags.NonPublic | BindingFlags.Instance | BindingFlags.Public | BindingFlags.Default).GetValue(chunkList[0], null);
    //        byte[] chunkBuffer = new byte[chunkList.Count * otherParameter.Length];

    //        for (int i = 0; i < bufferArray.Length; i++)
    //        {
    //            //Get the underlining data
    //            byte[] data = (byte[])chunkList[i].GetType().GetProperty("OtherParameters", System.Reflection.BindingFlags.NonPublic | BindingFlags.Instance | BindingFlags.Public | BindingFlags.Default).GetValue(chunkList[i], null);

    //            Buffer.BlockCopy(data, 0, chunkBuffer, i * otherParameter.Length, otherParameter.Length);

    //        }

    //        return chunkBuffer;
    //    }
    //}

}