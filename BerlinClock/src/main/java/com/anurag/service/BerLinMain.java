package com.anurag.service;

/**
 * @author AnuragK
 *Main class to print output on console
 */
public class BerLinMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Clock clk=new BerLinClockImpl();
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

	private static void consolePrint(Clock clk, String time) {
		System.out.println("input time is : \t" +time );
		System.out.println("************************************");
		
		String convertTime = clk.convertTime(time);
		System.out.println(convertTime);
		System.out.println("************************************");
	}

}
