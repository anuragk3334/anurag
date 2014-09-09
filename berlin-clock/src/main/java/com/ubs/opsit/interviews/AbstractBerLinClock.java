/**
 * 
 */
package com.ubs.opsit.interviews;

/**
 * @author AnuragK
 * 
 */
public abstract class AbstractBerLinClock implements TimeConverter {

	private static final String NEWLINE = "\r\n";
	/**
	 * @return On  top of clock there is a yellow lamp which blinks on/off every two
	 *         seconds. At 0th second it remains Yellow,in 1st second turns OFF
	 *         ,in another 1 second it turns yellow
	 */
	abstract String displaySeconds(int second);

	/**
	 * @return 1st row contains 4 Red lamps .Every lamp correspond to 5 hours.
	 *         10 hr~ 2 Red Lamps, 15 hrs ~3 red lamps and so on.
	 */
	abstract String displayTopHours(int hours);

	/**
	 * @return 2nd row contains 4 Red lamps. Every lamp corresponds to 1 hr.
	 *         1hr~1 bottom red lamp 22hr~4 top Red lamps + 2 bottom red lamps
	 *         and so on
	 */
	abstract String displayBottomHours(int hours);

	/**
	 * @return
	 * 3rd row contains 11 lamps.Every lamp corrresponds to 5 mins. All lamps are yellow 
	 * except 3rd,6th and 9th (which are red).
	 * 5 minutes ~1 lamp
	 * 10 minutes~2 lamp and so on
	 */
   abstract String displayTopMinutes(int minutes);

	/**
	 * @return
	 * 4th row contains 4 Yellow lamps .Every lamp corresponds to 1 minute.
	 * 1 min~ 1 lamp
	 * 57 mins~11 top (3rd row lamps) + 2 lamps from(4th row)
	 */
	abstract String displayBottomMinutes(int minutes);
	
	
	/**
	 * @param hours
	 * @param minutes
	 * @param second
	 * @return
	 * template converting input time to BerLinClockTimeFormat.Every new line corresponds  row in BerLin clock
	 */
	public String getBerLinClockDate(int hours,int minutes,int second){
		String seconds = displaySeconds(second);
		String topHours = displayTopHours(hours);
		String bottomHours = displayBottomHours(hours);
		String topMinutes = displayTopMinutes(minutes);
		String bottomMinutes = displayBottomMinutes(minutes);
		String timeInBerLinClockFormat=seconds.concat(NEWLINE).concat(topHours).concat(NEWLINE).concat(bottomHours)
				.concat(NEWLINE).concat(topMinutes).concat(NEWLINE)
				.concat(bottomMinutes);
		return timeInBerLinClockFormat;

	}
	
	


	
}
