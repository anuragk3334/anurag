package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.helper.TimeHelper;
import com.ubs.opsit.interviews.service.BerLinClockService;
import com.ubs.opsit.interviews.service.ObjectFactory;
import com.ubs.opsit.interviews.validator.TimeValidator;

/**
 * @author AnuragK
 *BerLin Clock display user interface
 */
public class BerLinClockImpl extends AbstractBerLinClock {

	private static final String BLANK_STRING = "";
	BerLinClockService berLinClockService = ObjectFactory.getBerLinClockService();

	@Override
	public String convertTime(String time) {
       
		String displayBerLinClockFormatDate =BLANK_STRING;
		if (TimeValidator.validateTime(time)) {
			
			displayBerLinClockFormatDate= getBerLinClockDate(
					TimeHelper.getHours(time), TimeHelper.getMinutes(time),
					TimeHelper.getSeconds(time));
			
		}
		return displayBerLinClockFormatDate;
	}

	@Override
	public String displaySeconds(int seconds) {
		String displaySecond = berLinClockService
				.getDisPlaySeconds(seconds);
		return displaySecond;
	}

	@Override
	public String displayTopHours(int hours) {
		int numberOfTopLampsON = berLinClockService
				.getNumberOfLampsONForTopHrsOrMin(hours);
		String topHours = berLinClockService
				.getDisplayHours(numberOfTopLampsON);
		return topHours;
	}

	@Override
	public String displayBottomHours(int hours) {
		int numberofBottomLampsON = berLinClockService
				.getNumberOfLampsONForBottomHrsOrMin(hours);
		String bottomHours = berLinClockService
				.getDisplayHours(numberofBottomLampsON);
		return bottomHours;
	}

	@Override
	public String displayTopMinutes(int minutes) {
		int numberOfTopLampsON = berLinClockService
				.getNumberOfLampsONForTopHrsOrMin(minutes);
		String topMinutes = berLinClockService
				.getDisPlayTopMinutes(numberOfTopLampsON);
		return topMinutes.toString();
	}

	@Override
	public String displayBottomMinutes(int minutes) {
		int numberofBottomLampsON = berLinClockService
				.getNumberOfLampsONForBottomHrsOrMin(minutes);
		String bottomMinutes = berLinClockService
				.getDisplayBottomMinutes(numberofBottomLampsON);
		return bottomMinutes.toString();
	}

}
