/**
 * 
 */
package com.anurag.service;

/**
 * @author AnuragK
 *This class is used to split time in hh:mm:ss format to provide hours,minutes and seconds
 */
public class TimeHelper {

	/**
	 * @param time
	 * @return hours
	 */
	public static int getHours(String time){
		return Integer.parseInt(time.split(":")[0]);
	}
	
	/**
	 * @param time
	 * @return Minutes
	 */
	public static int getMinutes(String time){
		return Integer.parseInt(time.split(":")[1]);
	}
	
	/**
	 * @param time
	 * @return seconds
	 */
	public static int getSeconds(String time){
		return Integer.parseInt(time.split(":")[2]);
	}

}
