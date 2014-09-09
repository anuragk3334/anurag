/**
 * 
 */
package com.ubs.opsit.interviews.service;

/**
 * @author AnuragK
 * 
 */
public interface BerLinClockService {

	/**
	 * @param seconds
	 * @return display pattern for Seconds Lamps
	 */
	String getDisPlaySeconds(int seconds);

	/**
	 * @param numberOfLampsON
	 * @return display pattern for Minutes lamp(Bottom)
	 */
	String getDisplayBottomMinutes(int numberOfLampsON);

	/**
	 * @param numberofLampsON
	 * @return display pattern for Minutes lamp(Top)
	 */
	String getDisPlayTopMinutes(int numberofLampsON);

	/**
	 * @param numberofLampsON
	 * @return display pattern for Hours lamp(top and bottom)
	 */
	String getDisplayHours(int numberofLampsON);

	/**
	 * @param hourOrMinute
	 * @return number of lamps ON in bottom segment (Bottom Hours or Bottom
	 *         Minutes)
	 */
	int getNumberOfLampsONForBottomHrsOrMin(int hourOrMinute);

	/**
	 * @param hourOrMinute
	 * @return returns the total number of lamps in ON state (1)(Top Hours
	 *         segment or Top Minutes Segment)
	 */
	int getNumberOfLampsONForTopHrsOrMin(int hourOrMinute);

}
