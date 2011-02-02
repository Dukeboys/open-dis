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
    /// Enumeration values for LandPlatformAppearance (es.appear.platform.land, Platforms of the Land Domain, 
    /// section 4.3.1.1)
    /// The enumeration values are generated from the SISO DIS XML EBV document (R35), which was
    /// obtained from http://discussions.sisostds.org/default.asp?action=10&amp;fd=31
    /// </summary>
    [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
    [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
    [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
    [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
    [Serializable]
    public struct LandPlatformAppearance
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
        /// Describes characteristics of mobility kills
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes characteristics of mobility kills")]
        public enum MobilityValue : uint
        {
            /// <summary>
            /// No mobility kill
            /// </summary>
            NoMobilityKill = 0,

            /// <summary>
            /// Mobility kill
            /// </summary>
            MobilityKill = 1
        }

        /// <summary>
        /// Describes characteristics of fire-power kill
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes characteristics of fire-power kill")]
        public enum FirePowerValue : uint
        {
            /// <summary>
            /// No fire-power kill
            /// </summary>
            NoFirePowerKill = 0,

            /// <summary>
            /// Fire-power kill
            /// </summary>
            FirePowerKill = 1
        }

        /// <summary>
        /// Describes the damaged appearance of an entity
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the damaged appearance of an entity")]
        public enum DamageValue : uint
        {
            /// <summary>
            /// No damage
            /// </summary>
            NoDamage = 0,

            /// <summary>
            /// Slight damage
            /// </summary>
            SlightDamage = 1,

            /// <summary>
            /// Moderate damage
            /// </summary>
            ModerateDamage = 2,

            /// <summary>
            /// Destroyed
            /// </summary>
            Destroyed = 3
        }

        /// <summary>
        /// Describes status or location of smoke emanating from an entity
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes status or location of smoke emanating from an entity")]
        public enum SmokeValue : uint
        {
            /// <summary>
            /// Not smoking
            /// </summary>
            NotSmoking = 0,

            /// <summary>
            /// Smoke plume rising from the entity
            /// </summary>
            SmokePlumeRisingFromTheEntity = 1,

            /// <summary>
            /// Entity is emitting engine smoke
            /// </summary>
            EntityIsEmittingEngineSmoke = 2,

            /// <summary>
            /// Entity is emitting engine smoke, and smoke plume is rising from the entity
            /// </summary>
            EntityIsEmittingEngineSmokeAndSmokePlumeIsRisingFromTheEntity = 3
        }

        /// <summary>
        /// Describes the size of the dust cloud trailing effect for the Effects entity
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the size of the dust cloud trailing effect for the Effects entity")]
        public enum TrailingEffectsValue : uint
        {
            /// <summary>
            /// None
            /// </summary>
            None = 0,

            /// <summary>
            /// Small
            /// </summary>
            Small = 1,

            /// <summary>
            /// Medium
            /// </summary>
            Medium = 2,

            /// <summary>
            /// Large
            /// </summary>
            Large = 3
        }

        /// <summary>
        /// Describes the state of the primary hatch
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the state of the primary hatch")]
        public enum HatchValue : uint
        {
            /// <summary>
            /// Not applicable
            /// </summary>
            NotApplicable = 0,

            /// <summary>
            /// Primary hatch is closed
            /// </summary>
            PrimaryHatchIsClosed = 1,

            /// <summary>
            /// Primary hatch is popped
            /// </summary>
            PrimaryHatchIsPopped = 2,

            /// <summary>
            /// Primary hatch is popped and a person is visible under hatch
            /// </summary>
            PrimaryHatchIsPoppedAndAPersonIsVisibleUnderHatch = 3,

            /// <summary>
            /// Primary hatch is open
            /// </summary>
            PrimaryHatchIsOpen = 4,

            /// <summary>
            /// Primary hatch is open and person is visible
            /// </summary>
            PrimaryHatchIsOpenAndPersonIsVisible = 5,

            /// <summary>
            /// null
            /// </summary>
            Unknown = 6
        }

        /// <summary>
        /// Describes whether Head Lights are on or off.
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes whether Head Lights are on or off.")]
        public enum HeadLightsValue : uint
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
        /// Describes whether Tail Lights are on or off.
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes whether Tail Lights are on or off.")]
        public enum TailLightsValue : uint
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
        /// Describes whether Brake Lights are on or off.
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes whether Brake Lights are on or off.")]
        public enum BrakeLightsValue : uint
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
        /// Describes whether flames are rising from an entity
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes whether flames are rising from an entity")]
        public enum FlamingValue : uint
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
        /// Describes the elevated status of the platform's primary launcher
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the elevated status of the platform's primary launcher")]
        public enum LauncherValue : uint
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
        /// Describes the type of concealment
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the type of concealment")]
        public enum ConcealedValue : uint
        {
            /// <summary>
            /// Not concealed
            /// </summary>
            NotConcealed = 0,

            /// <summary>
            /// Entity in a prepared concealed position (with netting, etc.)
            /// </summary>
            EntityInAPreparedConcealedPositionWithNettingEtc = 1
        }

        /// <summary>
        /// Describes the frozen status of a Land Entity
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the frozen status of a Land Entity")]
        public enum FrozenStatusValue : uint
        {
            /// <summary>
            /// Not frozen
            /// </summary>
            NotFrozen = 0,

            /// <summary>
            /// Frozen (Frozen entities should not be dead-reckoned, i.e. should be displayed as fixed at the current location even if non-zero velocity, acceleration or rotation data received from the frozen entity)
            /// </summary>
            FrozenFrozenEntitiesShouldNotBeDeadReckonedIEShouldBeDisplayedAsFixedAtTheCurrentLocationEvenIfNonZeroVelocityAccelerationOrRotationDataReceivedFromTheFrozenEntity = 1
        }

        /// <summary>
        /// Describes the power-plant status of platform
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the power-plant status of platform")]
        public enum PowerPlantStatusValue : uint
        {
            /// <summary>
            /// Power plant off
            /// </summary>
            PowerPlantOff = 0,

            /// <summary>
            /// Power plant on
            /// </summary>
            PowerPlantOn = 1
        }

        /// <summary>
        /// Describes the state of a Land Entity
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the state of a Land Entity")]
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
        /// Describes the status of a tent extension
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the status of a tent extension")]
        public enum TentValue : uint
        {
            /// <summary>
            /// Not extended
            /// </summary>
            NotExtended = 0,

            /// <summary>
            /// Extended
            /// </summary>
            Extended = 1
        }

        /// <summary>
        /// Describes the status of a ramp
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the status of a ramp")]
        public enum RampValue : uint
        {
            /// <summary>
            /// Up
            /// </summary>
            Up = 0,

            /// <summary>
            /// Down
            /// </summary>
            Down = 1
        }

        /// <summary>
        /// Describes whether Blackout Lights are on or off.
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes whether Blackout Lights are on or off.")]
        public enum BlackoutLightsValue : uint
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
        /// Describes whether Blackout Brake Lights are on or off.
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes whether Blackout Brake Lights are on or off.")]
        public enum BlackoutBrakeLightsValue : uint
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
        /// Describes whether Spot Lights are on or off.
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes whether Spot Lights are on or off.")]
        public enum SpotLightsValue : uint
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
        /// Describes whether Interior Lights are on or off.
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes whether Interior Lights are on or off.")]
        public enum InteriorLightsValue : uint
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
        /// Describes the surrender state of the vehicle occupants
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes the surrender state of the vehicle occupants")]
        public enum SurrenderStateValue : uint
        {
            /// <summary>
            /// Not surrendered
            /// </summary>
            NotSurrendered = 0,

            /// <summary>
            /// Surrender
            /// </summary>
            Surrender = 1
        }

        /// <summary>
        /// Describes if the entity is Masked / Cloaked or Not
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1707:IdentifiersShouldNotContainUnderscores", Justification = "Due to SISO standardized naming.")]
        [SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", Justification = "Due to SISO standardized naming.")]
        [Description("Describes if the entity is Masked / Cloaked or Not")]
        public enum MaskedCloakedValue : uint
        {
            /// <summary>
            /// Not Masked / Not Cloaked
            /// </summary>
            NotMaskedNotCloaked = 0,

            /// <summary>
            /// Masked / Cloaked
            /// </summary>
            MaskedCloaked = 1
        }

        private LandPlatformAppearance.PaintSchemeValue paintScheme;
        private LandPlatformAppearance.MobilityValue mobility;
        private LandPlatformAppearance.FirePowerValue firePower;
        private LandPlatformAppearance.DamageValue damage;
        private LandPlatformAppearance.SmokeValue smoke;
        private LandPlatformAppearance.TrailingEffectsValue trailingEffects;
        private LandPlatformAppearance.HatchValue hatch;
        private LandPlatformAppearance.HeadLightsValue headLights;
        private LandPlatformAppearance.TailLightsValue tailLights;
        private LandPlatformAppearance.BrakeLightsValue brakeLights;
        private LandPlatformAppearance.FlamingValue flaming;
        private LandPlatformAppearance.LauncherValue launcher;
        private LandPlatformAppearance.CamouflageTypeValue camouflageType;
        private LandPlatformAppearance.ConcealedValue concealed;
        private LandPlatformAppearance.FrozenStatusValue frozenStatus;
        private LandPlatformAppearance.PowerPlantStatusValue powerPlantStatus;
        private LandPlatformAppearance.StateValue state;
        private LandPlatformAppearance.TentValue tent;
        private LandPlatformAppearance.RampValue ramp;
        private LandPlatformAppearance.BlackoutLightsValue blackoutLights;
        private LandPlatformAppearance.BlackoutBrakeLightsValue blackoutBrakeLights;
        private LandPlatformAppearance.SpotLightsValue spotLights;
        private LandPlatformAppearance.InteriorLightsValue interiorLights;
        private LandPlatformAppearance.SurrenderStateValue surrenderState;
        private LandPlatformAppearance.MaskedCloakedValue maskedCloaked;

        /// <summary>
        /// Implements the operator !=.
        /// </summary>
        /// <param name="left">The left operand.</param>
        /// <param name="right">The right operand.</param>
        /// <returns>
        /// 	<c>true</c> if operands are not equal; otherwise, <c>false</c>.
        /// </returns>
        public static bool operator !=(LandPlatformAppearance left, LandPlatformAppearance right)
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
        public static bool operator ==(LandPlatformAppearance left, LandPlatformAppearance right)
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
        /// Performs an explicit conversion from <see cref="OpenDis.Enumerations.EntityState.Appearance.LandPlatformAppearance"/> to <see cref="System.UInt32"/>.
        /// </summary>
        /// <param name="obj">The <see cref="OpenDis.Enumerations.EntityState.Appearance.LandPlatformAppearance"/> scheme instance.</param>
        /// <returns>The result of the conversion.</returns>
        public static explicit operator uint(LandPlatformAppearance obj)
        {
            return obj.ToUInt32();
        }

        /// <summary>
        /// Performs an explicit conversion from <see cref="System.UInt32"/> to <see cref="OpenDis.Enumerations.EntityState.Appearance.LandPlatformAppearance"/>.
        /// </summary>
        /// <param name="value">The uint value.</param>
        /// <returns>The result of the conversion.</returns>
        public static explicit operator LandPlatformAppearance(uint value)
        {
            return LandPlatformAppearance.FromUInt32(value);
        }

        /// <summary>
        /// Creates the <see cref="OpenDis.Enumerations.EntityState.Appearance.LandPlatformAppearance"/> instance from the byte array.
        /// </summary>
        /// <param name="array">The array which holds the values for the <see cref="OpenDis.Enumerations.EntityState.Appearance.LandPlatformAppearance"/>.</param>
        /// <param name="index">The starting position within value.</param>
        /// <returns>The <see cref="OpenDis.Enumerations.EntityState.Appearance.LandPlatformAppearance"/> instance, represented by a byte array.</returns>
        /// <exception cref="ArgumentNullException">if the <c>array</c> is null.</exception>
        /// <exception cref="IndexOutOfRangeException">if the <c>index</c> is lower than 0 or greater or equal than number of elements in array.</exception>
        public static LandPlatformAppearance FromByteArray(byte[] array, int index)
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
        /// Creates the <see cref="OpenDis.Enumerations.EntityState.Appearance.LandPlatformAppearance"/> instance from the uint value.
        /// </summary>
        /// <param name="value">The uint value which represents the <see cref="OpenDis.Enumerations.EntityState.Appearance.LandPlatformAppearance"/> instance.</param>
        /// <returns>The <see cref="OpenDis.Enumerations.EntityState.Appearance.LandPlatformAppearance"/> instance, represented by the uint value.</returns>
        public static LandPlatformAppearance FromUInt32(uint value)
        {
            LandPlatformAppearance ps = new LandPlatformAppearance();

            uint a0Mask = 0x0001;
            byte a0Shift = 0;
            uint a0Value = value & a0Mask >> a0Shift;
            ps.PaintScheme = (LandPlatformAppearance.PaintSchemeValue)a0Value;

            uint a1Mask = 0x0002;
            byte a1Shift = 1;
            uint a1Value = value & a1Mask >> a1Shift;
            ps.Mobility = (LandPlatformAppearance.MobilityValue)a1Value;

            uint a2Mask = 0x0004;
            byte a2Shift = 2;
            uint a2Value = value & a2Mask >> a2Shift;
            ps.FirePower = (LandPlatformAppearance.FirePowerValue)a2Value;

            uint a3Mask = 0x0018;
            byte a3Shift = 3;
            uint a3Value = value & a3Mask >> a3Shift;
            ps.Damage = (LandPlatformAppearance.DamageValue)a3Value;

            uint a4Mask = 0x0060;
            byte a4Shift = 5;
            uint a4Value = value & a4Mask >> a4Shift;
            ps.Smoke = (LandPlatformAppearance.SmokeValue)a4Value;

            uint a5Mask = 0x0180;
            byte a5Shift = 7;
            uint a5Value = value & a5Mask >> a5Shift;
            ps.TrailingEffects = (LandPlatformAppearance.TrailingEffectsValue)a5Value;

            uint a6Mask = 0x0e00;
            byte a6Shift = 9;
            uint a6Value = value & a6Mask >> a6Shift;
            ps.Hatch = (LandPlatformAppearance.HatchValue)a6Value;

            uint a7Mask = 0x1000;
            byte a7Shift = 12;
            uint a7Value = value & a7Mask >> a7Shift;
            ps.HeadLights = (LandPlatformAppearance.HeadLightsValue)a7Value;

            uint a8Mask = 0x2000;
            byte a8Shift = 13;
            uint a8Value = value & a8Mask >> a8Shift;
            ps.TailLights = (LandPlatformAppearance.TailLightsValue)a8Value;

            uint a9Mask = 0x4000;
            byte a9Shift = 14;
            uint a9Value = value & a9Mask >> a9Shift;
            ps.BrakeLights = (LandPlatformAppearance.BrakeLightsValue)a9Value;

            uint a10Mask = 0x8000;
            byte a10Shift = 15;
            uint a10Value = value & a10Mask >> a10Shift;
            ps.Flaming = (LandPlatformAppearance.FlamingValue)a10Value;

            uint a11Mask = 0x10000;
            byte a11Shift = 16;
            uint a11Value = value & a11Mask >> a11Shift;
            ps.Launcher = (LandPlatformAppearance.LauncherValue)a11Value;

            uint a12Mask = 0x60000;
            byte a12Shift = 17;
            uint a12Value = value & a12Mask >> a12Shift;
            ps.CamouflageType = (LandPlatformAppearance.CamouflageTypeValue)a12Value;

            uint a13Mask = 0x80000;
            byte a13Shift = 19;
            uint a13Value = value & a13Mask >> a13Shift;
            ps.Concealed = (LandPlatformAppearance.ConcealedValue)a13Value;

            uint a15Mask = 0x200000;
            byte a15Shift = 21;
            uint a15Value = value & a15Mask >> a15Shift;
            ps.FrozenStatus = (LandPlatformAppearance.FrozenStatusValue)a15Value;

            uint a16Mask = 0x400000;
            byte a16Shift = 22;
            uint a16Value = value & a16Mask >> a16Shift;
            ps.PowerPlantStatus = (LandPlatformAppearance.PowerPlantStatusValue)a16Value;

            uint a17Mask = 0x800000;
            byte a17Shift = 23;
            uint a17Value = value & a17Mask >> a17Shift;
            ps.State = (LandPlatformAppearance.StateValue)a17Value;

            uint a18Mask = 0x1000000;
            byte a18Shift = 24;
            uint a18Value = value & a18Mask >> a18Shift;
            ps.Tent = (LandPlatformAppearance.TentValue)a18Value;

            uint a19Mask = 0x2000000;
            byte a19Shift = 25;
            uint a19Value = value & a19Mask >> a19Shift;
            ps.Ramp = (LandPlatformAppearance.RampValue)a19Value;

            uint a20Mask = 0x4000000;
            byte a20Shift = 26;
            uint a20Value = value & a20Mask >> a20Shift;
            ps.BlackoutLights = (LandPlatformAppearance.BlackoutLightsValue)a20Value;

            uint a21Mask = 0x8000000;
            byte a21Shift = 27;
            uint a21Value = value & a21Mask >> a21Shift;
            ps.BlackoutBrakeLights = (LandPlatformAppearance.BlackoutBrakeLightsValue)a21Value;

            uint a22Mask = 0x10000000;
            byte a22Shift = 28;
            uint a22Value = value & a22Mask >> a22Shift;
            ps.SpotLights = (LandPlatformAppearance.SpotLightsValue)a22Value;

            uint a23Mask = 0x20000000;
            byte a23Shift = 29;
            uint a23Value = value & a23Mask >> a23Shift;
            ps.InteriorLights = (LandPlatformAppearance.InteriorLightsValue)a23Value;

            uint a24Mask = 0x40000000;
            byte a24Shift = 30;
            uint a24Value = value & a24Mask >> a24Shift;
            ps.SurrenderState = (LandPlatformAppearance.SurrenderStateValue)a24Value;

            uint a25Mask = 0x80000000;
            byte a25Shift = 31;
            uint a25Value = value & a25Mask >> a25Shift;
            ps.MaskedCloaked = (LandPlatformAppearance.MaskedCloakedValue)a25Value;

            return ps;
        }

        /// <summary>
        /// Gets or sets the paintscheme.
        /// </summary>
        /// <value>The paintscheme.</value>
        public LandPlatformAppearance.PaintSchemeValue PaintScheme
        {
            get { return this.paintScheme; }
            set { this.paintScheme = value; }
        }

        /// <summary>
        /// Gets or sets the mobility.
        /// </summary>
        /// <value>The mobility.</value>
        public LandPlatformAppearance.MobilityValue Mobility
        {
            get { return this.mobility; }
            set { this.mobility = value; }
        }

        /// <summary>
        /// Gets or sets the firepower.
        /// </summary>
        /// <value>The firepower.</value>
        public LandPlatformAppearance.FirePowerValue FirePower
        {
            get { return this.firePower; }
            set { this.firePower = value; }
        }

        /// <summary>
        /// Gets or sets the damage.
        /// </summary>
        /// <value>The damage.</value>
        public LandPlatformAppearance.DamageValue Damage
        {
            get { return this.damage; }
            set { this.damage = value; }
        }

        /// <summary>
        /// Gets or sets the smoke.
        /// </summary>
        /// <value>The smoke.</value>
        public LandPlatformAppearance.SmokeValue Smoke
        {
            get { return this.smoke; }
            set { this.smoke = value; }
        }

        /// <summary>
        /// Gets or sets the trailingeffects.
        /// </summary>
        /// <value>The trailingeffects.</value>
        public LandPlatformAppearance.TrailingEffectsValue TrailingEffects
        {
            get { return this.trailingEffects; }
            set { this.trailingEffects = value; }
        }

        /// <summary>
        /// Gets or sets the hatch.
        /// </summary>
        /// <value>The hatch.</value>
        public LandPlatformAppearance.HatchValue Hatch
        {
            get { return this.hatch; }
            set { this.hatch = value; }
        }

        /// <summary>
        /// Gets or sets the headlights.
        /// </summary>
        /// <value>The headlights.</value>
        public LandPlatformAppearance.HeadLightsValue HeadLights
        {
            get { return this.headLights; }
            set { this.headLights = value; }
        }

        /// <summary>
        /// Gets or sets the taillights.
        /// </summary>
        /// <value>The taillights.</value>
        public LandPlatformAppearance.TailLightsValue TailLights
        {
            get { return this.tailLights; }
            set { this.tailLights = value; }
        }

        /// <summary>
        /// Gets or sets the brakelights.
        /// </summary>
        /// <value>The brakelights.</value>
        public LandPlatformAppearance.BrakeLightsValue BrakeLights
        {
            get { return this.brakeLights; }
            set { this.brakeLights = value; }
        }

        /// <summary>
        /// Gets or sets the flaming.
        /// </summary>
        /// <value>The flaming.</value>
        public LandPlatformAppearance.FlamingValue Flaming
        {
            get { return this.flaming; }
            set { this.flaming = value; }
        }

        /// <summary>
        /// Gets or sets the launcher.
        /// </summary>
        /// <value>The launcher.</value>
        public LandPlatformAppearance.LauncherValue Launcher
        {
            get { return this.launcher; }
            set { this.launcher = value; }
        }

        /// <summary>
        /// Gets or sets the camouflagetype.
        /// </summary>
        /// <value>The camouflagetype.</value>
        public LandPlatformAppearance.CamouflageTypeValue CamouflageType
        {
            get { return this.camouflageType; }
            set { this.camouflageType = value; }
        }

        /// <summary>
        /// Gets or sets the concealed.
        /// </summary>
        /// <value>The concealed.</value>
        public LandPlatformAppearance.ConcealedValue Concealed
        {
            get { return this.concealed; }
            set { this.concealed = value; }
        }

        /// <summary>
        /// Gets or sets the frozenstatus.
        /// </summary>
        /// <value>The frozenstatus.</value>
        public LandPlatformAppearance.FrozenStatusValue FrozenStatus
        {
            get { return this.frozenStatus; }
            set { this.frozenStatus = value; }
        }

        /// <summary>
        /// Gets or sets the powerplantstatus.
        /// </summary>
        /// <value>The powerplantstatus.</value>
        public LandPlatformAppearance.PowerPlantStatusValue PowerPlantStatus
        {
            get { return this.powerPlantStatus; }
            set { this.powerPlantStatus = value; }
        }

        /// <summary>
        /// Gets or sets the state.
        /// </summary>
        /// <value>The state.</value>
        public LandPlatformAppearance.StateValue State
        {
            get { return this.state; }
            set { this.state = value; }
        }

        /// <summary>
        /// Gets or sets the tent.
        /// </summary>
        /// <value>The tent.</value>
        public LandPlatformAppearance.TentValue Tent
        {
            get { return this.tent; }
            set { this.tent = value; }
        }

        /// <summary>
        /// Gets or sets the ramp.
        /// </summary>
        /// <value>The ramp.</value>
        public LandPlatformAppearance.RampValue Ramp
        {
            get { return this.ramp; }
            set { this.ramp = value; }
        }

        /// <summary>
        /// Gets or sets the blackoutlights.
        /// </summary>
        /// <value>The blackoutlights.</value>
        public LandPlatformAppearance.BlackoutLightsValue BlackoutLights
        {
            get { return this.blackoutLights; }
            set { this.blackoutLights = value; }
        }

        /// <summary>
        /// Gets or sets the blackoutbrakelights.
        /// </summary>
        /// <value>The blackoutbrakelights.</value>
        public LandPlatformAppearance.BlackoutBrakeLightsValue BlackoutBrakeLights
        {
            get { return this.blackoutBrakeLights; }
            set { this.blackoutBrakeLights = value; }
        }

        /// <summary>
        /// Gets or sets the spotlights.
        /// </summary>
        /// <value>The spotlights.</value>
        public LandPlatformAppearance.SpotLightsValue SpotLights
        {
            get { return this.spotLights; }
            set { this.spotLights = value; }
        }

        /// <summary>
        /// Gets or sets the interiorlights.
        /// </summary>
        /// <value>The interiorlights.</value>
        public LandPlatformAppearance.InteriorLightsValue InteriorLights
        {
            get { return this.interiorLights; }
            set { this.interiorLights = value; }
        }

        /// <summary>
        /// Gets or sets the surrenderstate.
        /// </summary>
        /// <value>The surrenderstate.</value>
        public LandPlatformAppearance.SurrenderStateValue SurrenderState
        {
            get { return this.surrenderState; }
            set { this.surrenderState = value; }
        }

        /// <summary>
        /// Gets or sets the maskedcloaked.
        /// </summary>
        /// <value>The maskedcloaked.</value>
        public LandPlatformAppearance.MaskedCloakedValue MaskedCloaked
        {
            get { return this.maskedCloaked; }
            set { this.maskedCloaked = value; }
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

            if (!(obj is LandPlatformAppearance))
            {
                return false;
            }

            return this.Equals((LandPlatformAppearance)obj);
        }

        /// <summary>
        /// Determines whether the specified <see cref="OpenDis.Enumerations.EntityState.Appearance.LandPlatformAppearance"/> instance is equal to this instance.
        /// </summary>
        /// <param name="other">The <see cref="OpenDis.Enumerations.EntityState.Appearance.LandPlatformAppearance"/> instance to compare with this instance.</param>
        /// <returns>
        /// 	<c>true</c> if the specified <see cref="OpenDis.Enumerations.EntityState.Appearance.LandPlatformAppearance"/> is equal to this instance; otherwise, <c>false</c>.
        /// </returns>
        public bool Equals(LandPlatformAppearance other)
        {
            // If parameter is null return false (cast to object to prevent recursive loop!)
            if ((object)other == null)
            {
                return false;
            }

            return
                this.PaintScheme == other.PaintScheme &&
                this.Mobility == other.Mobility &&
                this.FirePower == other.FirePower &&
                this.Damage == other.Damage &&
                this.Smoke == other.Smoke &&
                this.TrailingEffects == other.TrailingEffects &&
                this.Hatch == other.Hatch &&
                this.HeadLights == other.HeadLights &&
                this.TailLights == other.TailLights &&
                this.BrakeLights == other.BrakeLights &&
                this.Flaming == other.Flaming &&
                this.Launcher == other.Launcher &&
                this.CamouflageType == other.CamouflageType &&
                this.Concealed == other.Concealed &&
                this.FrozenStatus == other.FrozenStatus &&
                this.PowerPlantStatus == other.PowerPlantStatus &&
                this.State == other.State &&
                this.Tent == other.Tent &&
                this.Ramp == other.Ramp &&
                this.BlackoutLights == other.BlackoutLights &&
                this.BlackoutBrakeLights == other.BlackoutBrakeLights &&
                this.SpotLights == other.SpotLights &&
                this.InteriorLights == other.InteriorLights &&
                this.SurrenderState == other.SurrenderState &&
                this.MaskedCloaked == other.MaskedCloaked;
        }

        /// <summary>
        /// Converts the instance of <see cref="OpenDis.Enumerations.EntityState.Appearance.LandPlatformAppearance"/> to the byte array.
        /// </summary>
        /// <returns>The byte array representing the current <see cref="OpenDis.Enumerations.EntityState.Appearance.LandPlatformAppearance"/> instance.</returns>
        public byte[] ToByteArray()
        {
            return BitConverter.GetBytes(this.ToUInt32());
        }

        /// <summary>
        /// Converts the instance of <see cref="OpenDis.Enumerations.EntityState.Appearance.LandPlatformAppearance"/> to the uint value.
        /// </summary>
        /// <returns>The uint value representing the current <see cref="OpenDis.Enumerations.EntityState.Appearance.LandPlatformAppearance"/> instance.</returns>
        public uint ToUInt32()
        {
            uint val = 0;

            val |= (uint)((uint)this.PaintScheme << 0);
            val |= (uint)((uint)this.Mobility << 1);
            val |= (uint)((uint)this.FirePower << 2);
            val |= (uint)((uint)this.Damage << 3);
            val |= (uint)((uint)this.Smoke << 5);
            val |= (uint)((uint)this.TrailingEffects << 7);
            val |= (uint)((uint)this.Hatch << 9);
            val |= (uint)((uint)this.HeadLights << 12);
            val |= (uint)((uint)this.TailLights << 13);
            val |= (uint)((uint)this.BrakeLights << 14);
            val |= (uint)((uint)this.Flaming << 15);
            val |= (uint)((uint)this.Launcher << 16);
            val |= (uint)((uint)this.CamouflageType << 17);
            val |= (uint)((uint)this.Concealed << 19);
            val |= (uint)((uint)this.FrozenStatus << 21);
            val |= (uint)((uint)this.PowerPlantStatus << 22);
            val |= (uint)((uint)this.State << 23);
            val |= (uint)((uint)this.Tent << 24);
            val |= (uint)((uint)this.Ramp << 25);
            val |= (uint)((uint)this.BlackoutLights << 26);
            val |= (uint)((uint)this.BlackoutBrakeLights << 27);
            val |= (uint)((uint)this.SpotLights << 28);
            val |= (uint)((uint)this.InteriorLights << 29);
            val |= (uint)((uint)this.SurrenderState << 30);
            val |= (uint)((uint)this.MaskedCloaked << 31);

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
                hash = (hash * 29) + this.Mobility.GetHashCode();
                hash = (hash * 29) + this.FirePower.GetHashCode();
                hash = (hash * 29) + this.Damage.GetHashCode();
                hash = (hash * 29) + this.Smoke.GetHashCode();
                hash = (hash * 29) + this.TrailingEffects.GetHashCode();
                hash = (hash * 29) + this.Hatch.GetHashCode();
                hash = (hash * 29) + this.HeadLights.GetHashCode();
                hash = (hash * 29) + this.TailLights.GetHashCode();
                hash = (hash * 29) + this.BrakeLights.GetHashCode();
                hash = (hash * 29) + this.Flaming.GetHashCode();
                hash = (hash * 29) + this.Launcher.GetHashCode();
                hash = (hash * 29) + this.CamouflageType.GetHashCode();
                hash = (hash * 29) + this.Concealed.GetHashCode();
                hash = (hash * 29) + this.FrozenStatus.GetHashCode();
                hash = (hash * 29) + this.PowerPlantStatus.GetHashCode();
                hash = (hash * 29) + this.State.GetHashCode();
                hash = (hash * 29) + this.Tent.GetHashCode();
                hash = (hash * 29) + this.Ramp.GetHashCode();
                hash = (hash * 29) + this.BlackoutLights.GetHashCode();
                hash = (hash * 29) + this.BlackoutBrakeLights.GetHashCode();
                hash = (hash * 29) + this.SpotLights.GetHashCode();
                hash = (hash * 29) + this.InteriorLights.GetHashCode();
                hash = (hash * 29) + this.SurrenderState.GetHashCode();
                hash = (hash * 29) + this.MaskedCloaked.GetHashCode();
            }

            return hash;
        }
    }
}
