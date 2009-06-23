using System;
using System.Collections.Generic;
using System.Text;

namespace DISnet.DataStreamUtilities
{
    /* Author Peter Smith (Naval Air Warfare Center - Training Systems Division) 01/23/2009
* Modifications: none
* Notes:
*/

    /// <summary>
    /// Represents the underlining represetation of value types
    /// </summary>
    public class EndianTypes
    {
        /// <summary>
        /// Known endian types
        /// </summary>
        public enum Endian
        {
            LITTLE = 1,
            BIG = 0,
        };
    }
}
