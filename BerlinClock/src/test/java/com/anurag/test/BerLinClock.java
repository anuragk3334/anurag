/**
 * 
 */
package com.anurag.test;

/**
 * @author AnuragK
 *
 */
public class BerLinClock {
	
	public int getHours(String time){
		return Integer.parseInt(time.split(":")[0]);
	}
	
	public int getMinutes(String time){
		return Integer.parseInt(time.split(":")[1]);
	}
	
	public int getSeconds(String time){
		return Integer.parseInt(time.split(":")[2]);
	}

}
