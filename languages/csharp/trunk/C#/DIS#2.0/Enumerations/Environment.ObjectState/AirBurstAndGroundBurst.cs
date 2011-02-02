// Copyright 2008-2011. This work is licensed under the BSD license, available at
// http://www.movesinstitute.org/licenses
//
// Orignal authors: DMcG, Jason Nelson
// Modified for use with C#:
// - Peter Smith (Naval Air Warfare Center - Training Systems Division)
// - Zvonko Bostjancic (Blubit d.o.o. - zvonko.bostjancic@blubit.si)

using System;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Reflection;

namespace OpenDis.Enumerations.Environment.ObjectState
{
    /// <summary>
    /// Enumeration values for AirBurstAndGroundBurst (env.obj.appear.point.burst, Air burst, Ground burst, 
    /// section 12.1.2.2.3)
    /// The enumeration values are generated from the SISO DIS XML EBV document (R35), which was
    /// obtained from http://discussions.sisostds.org/default.asp?action=10&amp;fd=31
    /// </summary>
    [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
    [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
    [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
    [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
    [Serializable]
    public struct AirBurstAndGroundBurst
    {
        /// <summary>
        /// Describes the chemical content of the smoke
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the chemical content of the smoke")]
        public enum ChemicalValue : uint
        {
            /// <summary>
            /// Other
            /// </summary>
            Other = 0,

            /// <summary>
            /// Hydrochloric
            /// </summary>
            Hydrochloric = 1,

            /// <summary>
            /// White phosphorous
            /// </summary>
            WhitePhosphorous = 2,

            /// <summary>
            /// Red phosphorous
            /// </summary>
            RedPhosphorous = 3
        }

        private byte opacity;
        private byte size;
        private byte height;
        private byte numOfBursts;
        private AirBurstAndGroundBurst.ChemicalValue chemical;

        /// <summary>
        /// Implements the operator !=.
        /// </summary>
        /// <param name="left">The left operand.</param>
        /// <param name="right">The right operand.</param>
        /// <returns>
        /// 	<c>true</c> if operands are not equal; otherwise, <c>false</c>.
        /// </returns>
        public static bool operator !=(AirBurstAndGroundBurst left, AirBurstAndGroundBurst right)
        {
            return !(left == right);
        }

        /// <summary>
        /// Implements the operator ==.
        /// </summary>
        /// <param name="left">The left operand.</param>
        /// <param name="right">The right operand.</param>
        /// <returns>
        /// 	<c>true</c> if operands are not equal; otherwise, <c>false</c>.
        /// </returns>
        public static bool operator ==(AirBurstAndGroundBurst left, AirBurstAndGroundBurst right)
        {
            if (object.ReferenceEquals(left, right))
            {
                return true;
            }

            // If parameters are null return false (cast to object to prevent recursive loop!)
            if (((object)left == null) || ((object)right == null))
            {
                return false;
            }

            return left.Equals(right);
        }

        /// <summary>
        /// Performs an explicit conversion from <see cref="OpenDis.Enumerations.Environment.ObjectState.AirBurstAndGroundBurst"/> to <see cref="System.UInt32"/>.
        /// </summary>
        /// <param name="obj">The <see cref="OpenDis.Enumerations.Environment.ObjectState.AirBurstAndGroundBurst"/> scheme instance.</param>
        /// <returns>The result of the conversion.</returns>
        public static explicit operator uint(AirBurstAndGroundBurst obj)
        {
            return obj.ToUInt32();
        }

        /// <summary>
        /// Performs an explicit conversion from <see cref="System.UInt32"/> to <see cref="OpenDis.Enumerations.Environment.ObjectState.AirBurstAndGroundBurst"/>.
        /// </summary>
        /// <param name="value">The uint value.</param>
        /// <returns>The result of the conversion.</returns>
        public static explicit operator AirBurstAndGroundBurst(uint value)
        {
            return AirBurstAndGroundBurst.FromUInt32(value);
        }

        /// <summary>
        /// Creates the <see cref="OpenDis.Enumerations.Environment.ObjectState.AirBurstAndGroundBurst"/> instance from the byte array.
        /// </summary>
        /// <param name="array">The array which holds the values for the <see cref="OpenDis.Enumerations.Environment.ObjectState.AirBurstAndGroundBurst"/>.</param>
        /// <param name="index">The starting position within value.</param>
        /// <returns>The <see cref="OpenDis.Enumerations.Environment.ObjectState.AirBurstAndGroundBurst"/> instance, represented by a byte array.</returns>
        /// <exception cref="ArgumentNullException">if the <c>array</c> is null.</exception>
        /// <exception cref="IndexOutOfRangeException">if the <c>index</c> is lower than 0 or greater or equal than number of elements in array.</exception>
        public static AirBurstAndGroundBurst FromByteArray(byte[] array, int index)
        {
            if (array == null)
            {
                throw new ArgumentNullException("array");
            }

            if (index < 0 ||
                index > array.Length - 1 ||
                index + 4 > array.Length - 1)
            {
                throw new IndexOutOfRangeException();
            }

            return FromUInt32(BitConverter.ToUInt32(array, index));
        }

        /// <summary>
        /// Creates the <see cref="OpenDis.Enumerations.Environment.ObjectState.AirBurstAndGroundBurst"/> instance from the uint value.
        /// </summary>
        /// <param name="value">The uint value which represents the <see cref="OpenDis.Enumerations.Environment.ObjectState.AirBurstAndGroundBurst"/> instance.</param>
        /// <returns>The <see cref="OpenDis.Enumerations.Environment.ObjectState.AirBurstAndGroundBurst"/> instance, represented by the uint value.</returns>
        public static AirBurstAndGroundBurst FromUInt32(uint value)
        {
            AirBurstAndGroundBurst ps = new AirBurstAndGroundBurst();

            uint a0Mask = 0xff0000;
            byte a0Shift = 16;
            uint a0Value = value & a0Mask >> a0Shift;
            ps.Opacity = (byte)a0Value;

            uint a1Mask = 0xff000000;
            byte a1Shift = 24;
            uint a1Value = value & a1Mask >> a1Shift;
            ps.Size = (byte)a1Value;

            uint a2Mask = 0x00ff;
            byte a2Shift = 32;
            uint a2Value = value & a2Mask >> a2Shift;
            ps.Height = (byte)a2Value;

            uint a3Mask = 0x3f00;
            byte a3Shift = 40;
            uint a3Value = value & a3Mask >> a3Shift;
            ps.NumOfBursts = (byte)a3Value;

            uint a4Mask = 0xc000;
            byte a4Shift = 46;
            uint a4Value = value & a4Mask >> a4Shift;
            ps.Chemical = (AirBurstAndGroundBurst.ChemicalValue)a4Value;

            return ps;
        }

        /// <summary>
        /// Gets or sets the opacity.
        /// </summary>
        /// <value>The opacity.</value>
        public byte Opacity
        {
            get { return this.opacity; }
            set { this.opacity = value; }
        }

        /// <summary>
        /// Gets or sets the size.
        /// </summary>
        /// <value>The size.</value>
        public byte Size
        {
            get { return this.size; }
            set { this.size = value; }
        }

        /// <summary>
        /// Gets or sets the height.
        /// </summary>
        /// <value>The height.</value>
        public byte Height
        {
            get { return this.height; }
            set { this.height = value; }
        }

        /// <summary>
        /// Gets or sets the numofbursts.
        /// </summary>
        /// <value>The numofbursts.</value>
        public byte NumOfBursts
        {
            get { return this.numOfBursts; }
            set { this.numOfBursts = value; }
        }

        /// <summary>
        /// Gets or sets the chemical.
        /// </summary>
        /// <value>The chemical.</value>
        public AirBurstAndGroundBurst.ChemicalValue Chemical
        {
            get { return this.chemical; }
            set { this.chemical = value; }
        }

        /// <summary>
        /// Determines whether the specified <see cref="System.Object"/> is equal to this instance.
        /// </summary>
        /// <param name="obj">The <see cref="System.Object"/> to compare with this instance.</param>
        /// <returns>
        /// 	<c>true</c> if the specified <see cref="System.Object"/> is equal to this instance; otherwise, <c>false</c>.
        /// </returns>
        public override bool Equals(object obj)
        {
            if (obj == null)
            {
                return false;
            }

            if (!(obj is AirBurstAndGroundBurst))
            {
                return false;
            }

            return this.Equals((AirBurstAndGroundBurst)obj);
        }

        /// <summary>
        /// Determines whether the specified <see cref="OpenDis.Enumerations.Environment.ObjectState.AirBurstAndGroundBurst"/> instance is equal to this instance.
        /// </summary>
        /// <param name="other">The <see cref="OpenDis.Enumerations.Environment.ObjectState.AirBurstAndGroundBurst"/> instance to compare with this instance.</param>
        /// <returns>
        /// 	<c>true</c> if the specified <see cref="OpenDis.Enumerations.Environment.ObjectState.AirBurstAndGroundBurst"/> is equal to this instance; otherwise, <c>false</c>.
        /// </returns>
        public bool Equals(AirBurstAndGroundBurst other)
        {
            // If parameter is null return false (cast to object to prevent recursive loop!)
            if ((object)other == null)
            {
                return false;
            }

            return
                this.Opacity == other.Opacity &&
                this.Size == other.Size &&
                this.Height == other.Height &&
                this.NumOfBursts == other.NumOfBursts &&
                this.Chemical == other.Chemical;
        }

        /// <summary>
        /// Converts the instance of <see cref="OpenDis.Enumerations.Environment.ObjectState.AirBurstAndGroundBurst"/> to the byte array.
        /// </summary>
        /// <returns>The byte array representing the current <see cref="OpenDis.Enumerations.Environment.ObjectState.AirBurstAndGroundBurst"/> instance.</returns>
        public byte[] ToByteArray()
        {
            return BitConverter.GetBytes(this.ToUInt32());
        }

        /// <summary>
        /// Converts the instance of <see cref="OpenDis.Enumerations.Environment.ObjectState.AirBurstAndGroundBurst"/> to the uint value.
        /// </summary>
        /// <returns>The uint value representing the current <see cref="OpenDis.Enumerations.Environment.ObjectState.AirBurstAndGroundBurst"/> instance.</returns>
        public uint ToUInt32()
        {
            uint val = 0;

            val |= (uint)((uint)this.Opacity << 16);
            val |= (uint)((uint)this.Size << 24);
            val |= (uint)((uint)this.Height << 32);
            val |= (uint)((uint)this.NumOfBursts << 40);
            val |= (uint)((uint)this.Chemical << 46);

            return val;
        }

        /// <summary>
        /// Returns a hash code for this instance.
        /// </summary>
        /// <returns>
        /// 	A hash code for this instance, suitable for use in hashing algorithms and data structures like a hash table.
        /// </returns>
        public override int GetHashCode()
        {
            int hash = 17;

            // Overflow is fine, just wrap
            unchecked
            {
                hash = (hash * 29) + this.Opacity.GetHashCode();
                hash = (hash * 29) + this.Size.GetHashCode();
                hash = (hash * 29) + this.Height.GetHashCode();
                hash = (hash * 29) + this.NumOfBursts.GetHashCode();
                hash = (hash * 29) + this.Chemical.GetHashCode();
            }

            return hash;
        }
    }
}
