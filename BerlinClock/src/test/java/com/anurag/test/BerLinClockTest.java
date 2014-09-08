/**
 * 
 */
package com.anurag.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.anurag.service.BerLinClockImpl;

/**
 * @author AnuragK
 *
 */

public class BerLinClockTest extends BerLinClock {
	
	private BerLinClockImpl berLinClock;
	@Before
	public void setUp(){
		berLinClock=new BerLinClockImpl();
	}
	
	
	@Test(expected=RuntimeException.class )
	public void testConvertTime(){
		String time="WL:AS";
		berLinClock.convertTime(time);
	}
	
	@Test(expected=RuntimeException.class )
	public void testConvertTime_1(){
		String time="08:08::12";
		berLinClock.convertTime(time);
	}
	
	@Test(expected=RuntimeException.class )
	public void testConvertTimeHrOutOfRange(){
		String time="25:08:12";
		berLinClock.convertTime(time);
	}
	
	@Test(expected=RuntimeException.class )
	public void testConvertTimeOutOfRange(){
		String time="18:86:61";
		berLinClock.convertTime(time);
	}
	
	
	
	@Test
	
	public void testDisplayHours(){
		int hours=getHours("7:12:36");
		String expectedTopHourLamps="ROOO";
		String expectedBottomHourLamps="RROO";
		Assert.assertEquals(expectedTopHourLamps, berLinClock.displayTopHours(hours));
		Assert.assertEquals(expectedBottomHourLamps, berLinClock.displayBottomHours(hours));
		berLinClock.displayBottomHours(hours);
	}
	
	@Test
	public void testDisplayHoursAndMinutes(){
		String time="16:34:20";
		int hours=getHours(time);
		int minutes=getMinutes(time);
		String expectedTopHourLamps="RRRO";
		String expectedBottomHourLamps="ROOO";
		String expectedTopMinuteLamps="YYRYYROOOOO";
		String expectedBottomMinuteLamps="YYYY";
		Assert.assertEquals(expectedTopHourLamps, berLinClock.displayTopHours(hours));
		Assert.assertEquals(expectedBottomHourLamps, berLinClock.displayBottomHours(hours));
		Assert.assertEquals(expectedTopMinuteLamps, berLinClock.displayTopMinutes(minutes));
		Assert.assertEquals(expectedBottomMinuteLamps, berLinClock.displayBottomMinutes(minutes));
	}
	
	@Test
	public void testDisplayHoursAndMinutesAndSeconds(){
		String time="2:18:20";
		int hours=getHours(time);
		int minutes=getMinutes(time);
		int seconds=getSeconds(time);
		String expectedTopHourLamps="OOOO";
		String expectedBottomHourLamps="RROO";
		String expectedTopMinuteLamps="YYROOOOOOOO";
		String expectedBottomMinuteLamps="YYYO";
		String expectedSecondLamp="O";
		Assert.assertEquals(expectedTopHourLamps, berLinClock.displayTopHours(hours));
		Assert.assertEquals(expectedBottomHourLamps, berLinClock.displayBottomHours(hours));
		Assert.assertEquals(expectedTopMinuteLamps, berLinClock.displayTopMinutes(minutes));
		Assert.assertEquals(expectedBottomMinuteLamps, berLinClock.displayBottomMinutes(minutes));
		Assert.assertEquals(expectedSecondLamp, berLinClock.displaySeconds(seconds));
	}
	
	
	@Test
	public void testDisplayHoursAndMinutesAndSeconds_1(){
		String time="23:58:20";
		int hours=getHours(time);
		int minutes=getMinutes(time);
		int seconds=getSeconds(time);
		String expectedTopHourLamps="RRRR";
		String expectedBottomHourLamps="RRRO";
		String expectedTopMinuteLamps="YYRYYRYYRYY";
		String expectedBottomMinuteLamps="YYYO";
		String expectedSecondLamp="O";
		Assert.assertEquals(expectedTopHourLamps, berLinClock.displayTopHours(hours));
		Assert.assertEquals(expectedBottomHourLamps, berLinClock.displayBottomHours(hours));
		Assert.assertEquals(expectedTopMinuteLamps, berLinClock.displayTopMinutes(minutes));
		Assert.assertEquals(expectedBottomMinuteLamps, berLinClock.displayBottomMinutes(minutes));
		Assert.assertEquals(expectedSecondLamp, berLinClock.displaySeconds(seconds));
	}
	
	@Test
	public void testDisplayHoursAndMinutesAndSeconds_2(){
		String time="01:58:20";
		int hours=getHours(time);
		int minutes=getMinutes(time);
		int seconds=getSeconds(time);
		String expectedTopHourLamps="OOOO";
		String expectedBottomHourLamps="ROOO";
		String expectedTopMinuteLamps="YYRYYRYYRYY";
		String expectedBottomMinuteLamps="YYYO";
		String expectedSecondLamp="O";
		Assert.assertEquals(expectedTopHourLamps, berLinClock.displayTopHours(hours));
		Assert.assertEquals(expectedBottomHourLamps, berLinClock.displayBottomHours(hours));
		Assert.assertEquals(expectedTopMinuteLamps, berLinClock.displayTopMinutes(minutes));
		Assert.assertEquals(expectedBottomMinuteLamps, berLinClock.displayBottomMinutes(minutes));
		Assert.assertEquals(expectedSecondLamp, berLinClock.displaySeconds(seconds));
	}
	
	@Test
	public void testDisplayHoursAndMinutesAndSeconds_3(){
		String time="01:01:01";
		int hours=getHours(time);
		int minutes=getMinutes(time);
		int seconds=getSeconds(time);
		String expectedTopHourLamps="OOOO";
		String expectedBottomHourLamps="ROOO";
		String expectedTopMinuteLamps="OOOOOOOOOOO";
		String expectedBottomMinuteLamps="YOOO";
		String expectedSecondLamp="Y";
		Assert.assertEquals(expectedTopHourLamps, berLinClock.displayTopHours(hours));
		Assert.assertEquals(expectedBottomHourLamps, berLinClock.displayBottomHours(hours));
		Assert.assertEquals(expectedTopMinuteLamps, berLinClock.displayTopMinutes(minutes));
		Assert.assertEquals(expectedBottomMinuteLamps, berLinClock.displayBottomMinutes(minutes));
		Assert.assertEquals(expectedSecondLamp, berLinClock.displaySeconds(seconds));
	}
	
	
	
	
	
	
	
	
	
	

}
