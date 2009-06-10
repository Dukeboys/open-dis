#ifndef HIGHDENSITYTRACKJAM__H
#define HIGHDENSITYTRACKJAM__H

#include <string>
#include <disenum/Enumeration.h>

namespace DIS {

class HighDensityTrackJam : public Enumeration {
  public:
    static HighDensityTrackJam NOT_SELECTED;
    static HighDensityTrackJam SELECTED;
    

    /** Returns the string description associated with the enumerated instance with this value.
     * If there is no enumerated instance for this value, the string Invalid enumeration: <val> is returned.     */
    static std::string getDescriptionForValue(int aVal);

    /** Returns the enumerated instance with this value.
     * If there is no enumerated instance for this value, the exception is thrown.     */
    static HighDensityTrackJam getEnumerationForValue(int aVal) throw(EnumException);

    /** Returns true if there is an enumerated instance for this value, false otherwise. */
    static bool enumerationForValueExists(int aVal);

    typedef hashMap<int,HighDensityTrackJam*> enumContainer;
    static enumContainer getEnumerations();

    HighDensityTrackJam& operator=(const int& aVal) throw(EnumException);

  private:
    /** Constructor */
	  HighDensityTrackJam(int value, std::string description);

	  static HighDensityTrackJam* findEnumeration(int aVal);
    static enumContainer enumerations;

};  /* HighDensityTrackJam */


}  /* namespace DIS */

#endif /* HIGHDENSITYTRACKJAM__H */

