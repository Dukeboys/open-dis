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

namespace OpenDis.Enumerations.EntityState.Appearance
{
    /// <summary>
    /// Enumeration values for LifeFormAppearance (es.appear.lifeform, Life Forms Kind, 
    /// section 4.3.3)
    /// The enumeration values are generated from the SISO DIS XML EBV document (R35), which was
    /// obtained from http://discussions.sisostds.org/default.asp?action=10&amp;fd=31
    /// </summary>
    [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
    [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
    [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
    [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
    [Serializable]
    public struct LifeFormAppearance
    {
        /// <summary>
        /// Describes the paint scheme of an entity
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the paint scheme of an entity")]
        public enum PaintSchemeValue : uint
        {
            /// <summary>
            /// Uniform color
            /// </summary>
            UniformColor = 0,

            /// <summary>
            /// Camouflage
            /// </summary>
            Camouflage = 1
        }

        /// <summary>
        /// Describes the damaged visual appearance of an entity
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the damaged visual appearance of an entity")]
        public enum HealthValue : uint
        {
            /// <summary>
            /// No injury
            /// </summary>
            NoInjury = 0,

            /// <summary>
            /// Slight injury
            /// </summary>
            SlightInjury = 1,

            /// <summary>
            /// Moderate injury
            /// </summary>
            ModerateInjury = 2,

            /// <summary>
            /// Fatal injury
            /// </summary>
            FatalInjury = 3
        }

        /// <summary>
        /// Describes compliance of life form
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes compliance of life form")]
        public enum ComplianceValue : uint
        {
            /// <summary>
            /// null
            /// </summary>
            Unknown = 0,

            /// <summary>
            /// Detained
            /// </summary>
            Detained = 1,

            /// <summary>
            /// Surrender
            /// </summary>
            Surrender = 2,

            /// <summary>
            /// Using fists
            /// </summary>
            UsingFists = 3,

            /// <summary>
            /// Verbal abuse level 1
            /// </summary>
            VerbalAbuseLevel1 = 4,

            /// <summary>
            /// Verbal abuse level 2
            /// </summary>
            VerbalAbuseLevel2 = 5,

            /// <summary>
            /// Verbal abuse level 3
            /// </summary>
            VerbalAbuseLevel3 = 6,

            /// <summary>
            /// Passive resistance level 1
            /// </summary>
            PassiveResistanceLevel1 = 7,

            /// <summary>
            /// Passive resistance level 2
            /// </summary>
            PassiveResistanceLevel2 = 8,

            /// <summary>
            /// Passive resistance level 3
            /// </summary>
            PassiveResistanceLevel3 = 9,

            /// <summary>
            /// Using non-lethal weapon 1
            /// </summary>
            UsingNonLethalWeapon1 = 10,

            /// <summary>
            /// Using non-lethal weapon 2
            /// </summary>
            UsingNonLethalWeapon2 = 11,

            /// <summary>
            /// Using non-lethal weapon 3
            /// </summary>
            UsingNonLethalWeapon3 = 12,

            /// <summary>
            /// Using non-lethal weapon 4
            /// </summary>
            UsingNonLethalWeapon4 = 13,

            /// <summary>
            /// Using non-lethal weapon 5
            /// </summary>
            UsingNonLethalWeapon5 = 14,

            /// <summary>
            /// Using non-lethal weapon 6
            /// </summary>
            UsingNonLethalWeapon6 = 15
        }

        /// <summary>
        /// Describes whether Flash Lights are on or off.
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes whether Flash Lights are on or off.")]
        public enum FlashLightsValue : uint
        {
            /// <summary>
            /// Off
            /// </summary>
            Off = 0,

            /// <summary>
            /// On
            /// </summary>
            On = 1
        }

        /// <summary>
        /// Describes the state of the life form
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the state of the life form")]
        public enum LifeFormStateValue : uint
        {
            /// <summary>
            /// null
            /// </summary>
            Unknown = 0,

            /// <summary>
            /// Upright, standing still
            /// </summary>
            UprightStandingStill = 1,

            /// <summary>
            /// Upright, walking
            /// </summary>
            UprightWalking = 2,

            /// <summary>
            /// Upright, running
            /// </summary>
            UprightRunning = 3,

            /// <summary>
            /// Kneeling
            /// </summary>
            Kneeling = 4,

            /// <summary>
            /// Prone
            /// </summary>
            Prone = 5,

            /// <summary>
            /// Crawling
            /// </summary>
            Crawling = 6,

            /// <summary>
            /// Swimming
            /// </summary>
            Swimming = 7,

            /// <summary>
            /// Parachuting
            /// </summary>
            Parachuting = 8,

            /// <summary>
            /// Jumping
            /// </summary>
            Jumping = 9,

            /// <summary>
            /// Sitting
            /// </summary>
            Sitting = 10,

            /// <summary>
            /// Squatting
            /// </summary>
            Squatting = 11,

            /// <summary>
            /// Crouching
            /// </summary>
            Crouching = 12,

            /// <summary>
            /// Wading
            /// </summary>
            Wading = 13,

            /// <summary>
            /// Surrender
            /// </summary>
            Surrender = 14,

            /// <summary>
            /// Detained
            /// </summary>
            Detained = 15
        }

        /// <summary>
        /// Describes the frozen status of a life form
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the frozen status of a life form")]
        public enum FrozenStatusValue : uint
        {
            /// <summary>
            /// Not frozen
            /// </summary>
            NotFrozen = 0,

            /// <summary>
            /// Frozen (Frozen entities should not be dead-reckoned, i.e. they should be displayed as fixed at the current location even if nonzero velocity, acceleration or rotation data is received from the frozen entity)
            /// </summary>
            FrozenFrozenEntitiesShouldNotBeDeadReckonedIETheyShouldBeDisplayedAsFixedAtTheCurrentLocationEvenIfNonzeroVelocityAccelerationOrRotationDataIsReceivedFromTheFrozenEntity = 1
        }

        /// <summary>
        /// Describes the state of a life form
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the state of a life form")]
        public enum StateValue : uint
        {
            /// <summary>
            /// Active
            /// </summary>
            Active = 0,

            /// <summary>
            /// Deactivated
            /// </summary>
            Deactivated = 1
        }

        /// <summary>
        /// Describes the position of the life form's primary weapon
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the position of the life form's primary weapon")]
        public enum Weapon1Value : uint
        {
            /// <summary>
            /// No primary weapon present
            /// </summary>
            NoPrimaryWeaponPresent = 0,

            /// <summary>
            /// Primary weapon is stowed
            /// </summary>
            PrimaryWeaponIsStowed = 1,

            /// <summary>
            /// Primary weapon is deployed
            /// </summary>
            PrimaryWeaponIsDeployed = 2,

            /// <summary>
            /// Primary weapon is in firing position
            /// </summary>
            PrimaryWeaponIsInFiringPosition = 3
        }

        /// <summary>
        /// Describes the position of the life form's secondary weapon
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the position of the life form's secondary weapon")]
        public enum Weapon2Value : uint
        {
            /// <summary>
            /// No secondary weapon present
            /// </summary>
            NoSecondaryWeaponPresent = 0,

            /// <summary>
            /// Secondary weapon is stowed
            /// </summary>
            SecondaryWeaponIsStowed = 1,

            /// <summary>
            /// Secondary weapon is deployed
            /// </summary>
            SecondaryWeaponIsDeployed = 2,

            /// <summary>
            /// Secondary weapon is in firing position
            /// </summary>
            SecondaryWeaponIsInFiringPosition = 3
        }

        /// <summary>
        /// Describes the type of camouflage
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the type of camouflage")]
        public enum CamouflageTypeValue : uint
        {
            /// <summary>
            /// Desert camouflage
            /// </summary>
            DesertCamouflage = 0,

            /// <summary>
            /// Winter camouflage
            /// </summary>
            WinterCamouflage = 1,

            /// <summary>
            /// Forest camouflage
            /// </summary>
            ForestCamouflage = 2,

            /// <summary>
            /// null
            /// </summary>
            Unknown = 3
        }

        /// <summary>
        /// Describes the type of stationary concealment
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the type of stationary concealment")]
        public enum ConcealedStationaryValue : uint
        {
            /// <summary>
            /// Not concealed
            /// </summary>
            NotConcealed = 0,

            /// <summary>
            /// Entity in a prepared concealed position
            /// </summary>
            EntityInAPreparedConcealedPosition = 1
        }

        /// <summary>
        /// Describes the type of concealed movement
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the type of concealed movement")]
        public enum ConcealedMovementValue : uint
        {
            /// <summary>
            /// Open movement
            /// </summary>
            OpenMovement = 0,

            /// <summary>
            /// Rushes between covered positions
            /// </summary>
            RushesBetweenCoveredPositions = 1
        }

        private LifeFormAppearance.PaintSchemeValue paintScheme;
        private LifeFormAppearance.HealthValue health;
        private LifeFormAppearance.ComplianceValue compliance;
        private LifeFormAppearance.FlashLightsValue flashLights;
        private LifeFormAppearance.LifeFormStateValue lifeFormState;
        private LifeFormAppearance.FrozenStatusValue frozenStatus;
        private LifeFormAppearance.StateValue state;
        private LifeFormAppearance.Weapon1Value weapon1;
        private LifeFormAppearance.Weapon2Value weapon2;
        private LifeFormAppearance.CamouflageTypeValue camouflageType;
        private LifeFormAppearance.ConcealedStationaryValue concealedStationary;
        private LifeFormAppearance.ConcealedMovementValue concealedMovement;

        /// <summary>
        /// Implements the operator !=.
        /// </summary>
        /// <param name="left">The left operand.</param>
        /// <param name="right">The right operand.</param>
        /// <returns>
        /// 	<c>true</c> if operands are not equal; otherwise, <c>false</c>.
        /// </returns>
        public static bool operator !=(LifeFormAppearance left, LifeFormAppearance right)
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
        public static bool operator ==(LifeFormAppearance left, LifeFormAppearance right)
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
        /// Performs an explicit conversion from <see cref="OpenDis.Enumerations.EntityState.Appearance.LifeFormAppearance"/> to <see cref="System.UInt32"/>.
        /// </summary>
        /// <param name="obj">The <see cref="OpenDis.Enumerations.EntityState.Appearance.LifeFormAppearance"/> scheme instance.</param>
        /// <returns>The result of the conversion.</returns>
        public static explicit operator uint(LifeFormAppearance obj)
        {
            return obj.ToUInt32();
        }

        /// <summary>
        /// Performs an explicit conversion from <see cref="System.UInt32"/> to <see cref="OpenDis.Enumerations.EntityState.Appearance.LifeFormAppearance"/>.
        /// </summary>
        /// <param name="value">The uint value.</param>
        /// <returns>The result of the conversion.</returns>
        public static explicit operator LifeFormAppearance(uint value)
        {
            return LifeFormAppearance.FromUInt32(value);
        }

        /// <summary>
        /// Creates the <see cref="OpenDis.Enumerations.EntityState.Appearance.LifeFormAppearance"/> instance from the byte array.
        /// </summary>
        /// <param name="array">The array which holds the values for the <see cref="OpenDis.Enumerations.EntityState.Appearance.LifeFormAppearance"/>.</param>
        /// <param name="index">The starting position within value.</param>
        /// <returns>The <see cref="OpenDis.Enumerations.EntityState.Appearance.LifeFormAppearance"/> instance, represented by a byte array.</returns>
        /// <exception cref="ArgumentNullException">if the <c>array</c> is null.</exception>
        /// <exception cref="IndexOutOfRangeException">if the <c>index</c> is lower than 0 or greater or equal than number of elements in array.</exception>
        public static LifeFormAppearance FromByteArray(byte[] array, int index)
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
        /// Creates the <see cref="OpenDis.Enumerations.EntityState.Appearance.LifeFormAppearance"/> instance from the uint value.
        /// </summary>
        /// <param name="value">The uint value which represents the <see cref="OpenDis.Enumerations.EntityState.Appearance.LifeFormAppearance"/> instance.</param>
        /// <returns>The <see cref="OpenDis.Enumerations.EntityState.Appearance.LifeFormAppearance"/> instance, represented by the uint value.</returns>
        public static LifeFormAppearance FromUInt32(uint value)
        {
            LifeFormAppearance ps = new LifeFormAppearance();

            uint a0Mask = 0x0001;
            byte a0Shift = 0;
            uint a0Value = value & a0Mask >> a0Shift;
            ps.PaintScheme = (LifeFormAppearance.PaintSchemeValue)a0Value;

            uint a2Mask = 0x0018;
            byte a2Shift = 3;
            uint a2Value = value & a2Mask >> a2Shift;
            ps.Health = (LifeFormAppearance.HealthValue)a2Value;

            uint a3Mask = 0x01e0;
            byte a3Shift = 5;
            uint a3Value = value & a3Mask >> a3Shift;
            ps.Compliance = (LifeFormAppearance.ComplianceValue)a3Value;

            uint a5Mask = 0x1000;
            byte a5Shift = 12;
            uint a5Value = value & a5Mask >> a5Shift;
            ps.FlashLights = (LifeFormAppearance.FlashLightsValue)a5Value;

            uint a7Mask = 0xf0000;
            byte a7Shift = 16;
            uint a7Value = value & a7Mask >> a7Shift;
            ps.LifeFormState = (LifeFormAppearance.LifeFormStateValue)a7Value;

            uint a9Mask = 0x200000;
            byte a9Shift = 21;
            uint a9Value = value & a9Mask >> a9Shift;
            ps.FrozenStatus = (LifeFormAppearance.FrozenStatusValue)a9Value;

            uint a11Mask = 0x800000;
            byte a11Shift = 23;
            uint a11Value = value & a11Mask >> a11Shift;
            ps.State = (LifeFormAppearance.StateValue)a11Value;

            uint a12Mask = 0x3000000;
            byte a12Shift = 24;
            uint a12Value = value & a12Mask >> a12Shift;
            ps.Weapon1 = (LifeFormAppearance.Weapon1Value)a12Value;

            uint a13Mask = 0xc000000;
            byte a13Shift = 26;
            uint a13Value = value & a13Mask >> a13Shift;
            ps.Weapon2 = (LifeFormAppearance.Weapon2Value)a13Value;

            uint a14Mask = 0x30000000;
            byte a14Shift = 28;
            uint a14Value = value & a14Mask >> a14Shift;
            ps.CamouflageType = (LifeFormAppearance.CamouflageTypeValue)a14Value;

            uint a15Mask = 0x40000000;
            byte a15Shift = 30;
            uint a15Value = value & a15Mask >> a15Shift;
            ps.ConcealedStationary = (LifeFormAppearance.ConcealedStationaryValue)a15Value;

            uint a16Mask = 0x80000000;
            byte a16Shift = 31;
            uint a16Value = value & a16Mask >> a16Shift;
            ps.ConcealedMovement = (LifeFormAppearance.ConcealedMovementValue)a16Value;

            return ps;
        }

        /// <summary>
        /// Gets or sets the paintscheme.
        /// </summary>
        /// <value>The paintscheme.</value>
        public LifeFormAppearance.PaintSchemeValue PaintScheme
        {
            get { return this.paintScheme; }
            set { this.paintScheme = value; }
        }

        /// <summary>
        /// Gets or sets the health.
        /// </summary>
        /// <value>The health.</value>
        public LifeFormAppearance.HealthValue Health
        {
            get { return this.health; }
            set { this.health = value; }
        }

        /// <summary>
        /// Gets or sets the compliance.
        /// </summary>
        /// <value>The compliance.</value>
        public LifeFormAppearance.ComplianceValue Compliance
        {
            get { return this.compliance; }
            set { this.compliance = value; }
        }

        /// <summary>
        /// Gets or sets the flashlights.
        /// </summary>
        /// <value>The flashlights.</value>
        public LifeFormAppearance.FlashLightsValue FlashLights
        {
            get { return this.flashLights; }
            set { this.flashLights = value; }
        }

        /// <summary>
        /// Gets or sets the lifeformstate.
        /// </summary>
        /// <value>The lifeformstate.</value>
        public LifeFormAppearance.LifeFormStateValue LifeFormState
        {
            get { return this.lifeFormState; }
            set { this.lifeFormState = value; }
        }

        /// <summary>
        /// Gets or sets the frozenstatus.
        /// </summary>
        /// <value>The frozenstatus.</value>
        public LifeFormAppearance.FrozenStatusValue FrozenStatus
        {
            get { return this.frozenStatus; }
            set { this.frozenStatus = value; }
        }

        /// <summary>
        /// Gets or sets the state.
        /// </summary>
        /// <value>The state.</value>
        public LifeFormAppearance.StateValue State
        {
            get { return this.state; }
            set { this.state = value; }
        }

        /// <summary>
        /// Gets or sets the weapon1.
        /// </summary>
        /// <value>The weapon1.</value>
        public LifeFormAppearance.Weapon1Value Weapon1
        {
            get { return this.weapon1; }
            set { this.weapon1 = value; }
        }

        /// <summary>
        /// Gets or sets the weapon2.
        /// </summary>
        /// <value>The weapon2.</value>
        public LifeFormAppearance.Weapon2Value Weapon2
        {
            get { return this.weapon2; }
            set { this.weapon2 = value; }
        }

        /// <summary>
        /// Gets or sets the camouflagetype.
        /// </summary>
        /// <value>The camouflagetype.</value>
        public LifeFormAppearance.CamouflageTypeValue CamouflageType
        {
            get { return this.camouflageType; }
            set { this.camouflageType = value; }
        }

        /// <summary>
        /// Gets or sets the concealedstationary.
        /// </summary>
        /// <value>The concealedstationary.</value>
        public LifeFormAppearance.ConcealedStationaryValue ConcealedStationary
        {
            get { return this.concealedStationary; }
            set { this.concealedStationary = value; }
        }

        /// <summary>
        /// Gets or sets the concealedmovement.
        /// </summary>
        /// <value>The concealedmovement.</value>
        public LifeFormAppearance.ConcealedMovementValue ConcealedMovement
        {
            get { return this.concealedMovement; }
            set { this.concealedMovement = value; }
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

            if (!(obj is LifeFormAppearance))
            {
                return false;
            }

            return this.Equals((LifeFormAppearance)obj);
        }

        /// <summary>
        /// Determines whether the specified <see cref="OpenDis.Enumerations.EntityState.Appearance.LifeFormAppearance"/> instance is equal to this instance.
        /// </summary>
        /// <param name="other">The <see cref="OpenDis.Enumerations.EntityState.Appearance.LifeFormAppearance"/> instance to compare with this instance.</param>
        /// <returns>
        /// 	<c>true</c> if the specified <see cref="OpenDis.Enumerations.EntityState.Appearance.LifeFormAppearance"/> is equal to this instance; otherwise, <c>false</c>.
        /// </returns>
        public bool Equals(LifeFormAppearance other)
        {
            // If parameter is null return false (cast to object to prevent recursive loop!)
            if ((object)other == null)
            {
                return false;
            }

            return
                this.PaintScheme == other.PaintScheme &&
                this.Health == other.Health &&
                this.Compliance == other.Compliance &&
                this.FlashLights == other.FlashLights &&
                this.LifeFormState == other.LifeFormState &&
                this.FrozenStatus == other.FrozenStatus &&
                this.State == other.State &&
                this.Weapon1 == other.Weapon1 &&
                this.Weapon2 == other.Weapon2 &&
                this.CamouflageType == other.CamouflageType &&
                this.ConcealedStationary == other.ConcealedStationary &&
                this.ConcealedMovement == other.ConcealedMovement;
        }

        /// <summary>
        /// Converts the instance of <see cref="OpenDis.Enumerations.EntityState.Appearance.LifeFormAppearance"/> to the byte array.
        /// </summary>
        /// <returns>The byte array representing the current <see cref="OpenDis.Enumerations.EntityState.Appearance.LifeFormAppearance"/> instance.</returns>
        public byte[] ToByteArray()
        {
            return BitConverter.GetBytes(this.ToUInt32());
        }

        /// <summary>
        /// Converts the instance of <see cref="OpenDis.Enumerations.EntityState.Appearance.LifeFormAppearance"/> to the uint value.
        /// </summary>
        /// <returns>The uint value representing the current <see cref="OpenDis.Enumerations.EntityState.Appearance.LifeFormAppearance"/> instance.</returns>
        public uint ToUInt32()
        {
            uint val = 0;

            val |= (uint)((uint)this.PaintScheme << 0);
            val |= (uint)((uint)this.Health << 3);
            val |= (uint)((uint)this.Compliance << 5);
            val |= (uint)((uint)this.FlashLights << 12);
            val |= (uint)((uint)this.LifeFormState << 16);
            val |= (uint)((uint)this.FrozenStatus << 21);
            val |= (uint)((uint)this.State << 23);
            val |= (uint)((uint)this.Weapon1 << 24);
            val |= (uint)((uint)this.Weapon2 << 26);
            val |= (uint)((uint)this.CamouflageType << 28);
            val |= (uint)((uint)this.ConcealedStationary << 30);
            val |= (uint)((uint)this.ConcealedMovement << 31);

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
                hash = (hash * 29) + this.PaintScheme.GetHashCode();
                hash = (hash * 29) + this.Health.GetHashCode();
                hash = (hash * 29) + this.Compliance.GetHashCode();
                hash = (hash * 29) + this.FlashLights.GetHashCode();
                hash = (hash * 29) + this.LifeFormState.GetHashCode();
                hash = (hash * 29) + this.FrozenStatus.GetHashCode();
                hash = (hash * 29) + this.State.GetHashCode();
                hash = (hash * 29) + this.Weapon1.GetHashCode();
                hash = (hash * 29) + this.Weapon2.GetHashCode();
                hash = (hash * 29) + this.CamouflageType.GetHashCode();
                hash = (hash * 29) + this.ConcealedStationary.GetHashCode();
                hash = (hash * 29) + this.ConcealedMovement.GetHashCode();
            }

            return hash;
        }
    }
}
