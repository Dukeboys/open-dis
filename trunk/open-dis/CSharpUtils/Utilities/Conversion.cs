using System;
using System.Collections.Generic;
using System.Text;


namespace DISnet.Utilities
{
  /* Author Peter Smith (Naval Air Warfare Center - Training Systems Division) 01/23/2009
  * Modifications: none
  * Notes:
  */
   
    public static class Conversion
    {

         /// the mask that will leave only the typemetric
         /// from an integer representing the Articulation Parameter's parameter type.
         /// this mask is based on the IEEE Std 1278.1-1995
        const int ARTICULATION_PARAMETER_TYPE_METRIC_MASK = 0x001F;

        /// the number of bits used to store the type metric value
        /// within the Articulation Parameter's parameter type value.
        /// this mask is based on the IEEE Std 1278.1-1995
        const byte ARTICULATION_PARAMETER_TYPE_METRIC_NUMBER_OF_BITS = 5;

        /// make the value needed for the ArticulationParameter's Parameter Type.
        /// @param typeclass the enumeration for the articulated part.
        /// This must have less precision than ARTICULATION_PARAMETER_TYPE_METRIC_NUMBER_OF_BITS.
        /// @param typemetric the enumeration for the motion description.
        /// this must have less precision than 32 - ARTICULATION_PARAMETER_TYPE_METRIC_NUMBER_OF_BITS.
        /// @return the value to be used as the Parameter Type, with 32 bits precision.

        public static uint MakeArticulationParameterType(uint typeclass, uint typemetric)
        {
            // enforce a ceiling on typemetric
            typemetric = typemetric & ARTICULATION_PARAMETER_TYPE_METRIC_MASK;

            // shift the typeclass bits to the left by the precision amount of typemetric
            // and then add the typemetric bits
            return ((typeclass << ARTICULATION_PARAMETER_TYPE_METRIC_NUMBER_OF_BITS)
                   + typemetric);
        }

        /// extract the data for the type metric value stored within the parameter type value.
        /// this an inverse to the function, MakeArticulationParameterType.
        /// @param parametertype the value storing the type metric and type class values.
        /// @return the type metric value, with ARTICULATION_PARAMETER_TYPE_METRIC_NUMBER_OF_BITS bits precision.
        public static int GetArticulationTypeMetric(int parametertype)
        {
            // wipe off the typeclass bits and return the typemetric bits
            return (parametertype & ARTICULATION_PARAMETER_TYPE_METRIC_MASK);
        }

        /// extract the data for the type class value stored within the parameter type value.
        /// this an inverse to the function, MakeArticulationParameterType.
        /// @param parametertype the value storing the type metric and type class values.
        /// @return the type class value, with ARTICULATION_PARAMETER_TYPE_METRIC_NUMBER_OF_BITS bits precision
        public static int GetArticulationTypeClass(int parametertype)
        {
            // wipe off the typemetric bits and return the typeclass bits
            return (parametertype >> ARTICULATION_PARAMETER_TYPE_METRIC_NUMBER_OF_BITS);
        }
    }
}
