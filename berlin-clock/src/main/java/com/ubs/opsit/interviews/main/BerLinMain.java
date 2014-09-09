package com.ubs.opsit.interviews.main;

import com.ubs.opsit.interviews.BerLinClockImpl;
import com.ubs.opsit.interviews.TimeConverter;

/**
 * @author AnuragK
 *Main class to print output on console(it is for testing purpose)
 */
public class BerLinMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TimeConverter clk=new BerLinClockImpl();
		System.out.println("************************************");
		System.out.println("Y" + "-->" +"Yellow");
		System.out.println("R" + "-->" +"Red");
		System.out.println("O" + "-->" +"OFF");
		System.out.println("************************************");
		consolePrint(clk, "11:47:6");
		consolePrint(clk, "23:49:5");
		consolePrint(clk, "00:04:6");
		consolePrint(clk, "18:00:6");
		consolePrint(clk, "20:59:6");
		
		
		
		
		

	}

	private static void consolePrint(TimeConverter clk, String time) {
		System.out.println("input time is : \t" +time );
		System.out.println("************************************");
		
		String convertTime = clk.convertTime(time);
		System.out.println(convertTime);
		System.out.println("************************************");
	}

}
