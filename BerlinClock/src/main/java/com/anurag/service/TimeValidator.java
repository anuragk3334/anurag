/**
 * 
 */
package com.anurag.service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author AnuragK Validator to validate input time. Input time must be in
 *         format of hh:mm:ss and must fall in the boundry of time limit
 */
public class TimeValidator {

	private static final String INPUT_TIME_RANGE_IS_NOT_VALID = "Input time range is not valid";
	private static final String INPUT_TIME_FORMAT_IS_NOT_VALID = "Input time format is not valid";

	public static boolean validateTime(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		boolean isValid=false;

		try {
			sdf.parse(time);
			isValid=validateTimeRange(time,isValid);
			

		} catch (java.text.ParseException e) {
			
			throw new RuntimeException(INPUT_TIME_FORMAT_IS_NOT_VALID);
		}
		return isValid;
	}
	
	public static boolean  validateTimeRange(String time,boolean isValid){
		int hour=TimeHelper.getHours(time);
		int min=TimeHelper.getMinutes(time);
		int sec=TimeHelper.getSeconds(time);
		if((0<=hour && hour<=24)&& (0<=min && min<60) && (0<=sec && sec<60)){
			isValid=true;
		}
		else{
			isValid=false;
			throw new RuntimeException(INPUT_TIME_RANGE_IS_NOT_VALID);
		}
		return isValid;
		
	}

}
