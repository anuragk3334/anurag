/**
 * 
 */
package com.ubs.opsit.interviews.helper;

/**
 * @author AnuragK
 *This class is used to split time in hh:mm:ss format to provide hours,minutes and seconds
 */
public class TimeHelper {

	private static final String SEMICOLON = ":";
	private static final int TWO = 2;
	private static final int ONE= 1;
	private static final int ZERO = 0;

	/**
	 * @param time
	 * @return hours
	 */
	public static int getHours(String time){
		return Integer.parseInt(time.split(SEMICOLON)[ZERO]);
	}
	
	/**
	 * @param time
	 * @return Minutes
	 */
	public static int getMinutes(String time){
		return Integer.parseInt(time.split(SEMICOLON)[ONE]);
	}
	
	/**
	 * @param time
	 * @return seconds
	 */
	public static int getSeconds(String time){
		return Integer.parseInt(time.split(SEMICOLON)[TWO]);
	}

}
