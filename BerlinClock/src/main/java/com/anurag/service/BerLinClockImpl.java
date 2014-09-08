package com.anurag.service;

/**
 * @author AnuragK
 *BerLin Clock display user interface
 */
public class BerLinClockImpl extends AbstractBerLinClock {

	private static final String BLANK_STRING = "";
	BerLinClockService berLinClockService = new BerLinClockServiceImpl();

	@Override
	public String convertTime(String time) {

		if (TimeValidator.validateTime(time)) {
			
			String displayBerLinClockFormatDate = displayBerLinClockFormatDate(
					TimeHelper.getHours(time), TimeHelper.getMinutes(time),
					TimeHelper.getMinutes(time));
			return displayBerLinClockFormatDate;
		}
		return BLANK_STRING;
	}

	@Override
	public String displaySeconds(int seconds) {
		StringBuilder displaySecond = berLinClockService
				.getDisPlaySeconds(seconds);
		return displaySecond.toString();
	}

	@Override
	public String displayTopHours(int hours) {
		int numberOfTopLampsON = berLinClockService
				.getNumberOfLampsONForTopHrsOrMin(hours);
		StringBuilder topHours = berLinClockService
				.getDisplayHours(numberOfTopLampsON);
		return topHours.toString();
	}

	@Override
	public String displayBottomHours(int hours) {
		int numberofBottomLampsON = berLinClockService
				.getNumberOfLampsONForBottomHrsOrMin(hours);
		StringBuilder bottomHours = berLinClockService
				.getDisplayHours(numberofBottomLampsON);
		return bottomHours.toString();
	}

	@Override
	public String displayTopMinutes(int minutes) {
		int numberOfTopLampsON = berLinClockService
				.getNumberOfLampsONForTopHrsOrMin(minutes);
		StringBuilder topMinutes = berLinClockService
				.getDisPlayTopMinutes(numberOfTopLampsON);
		return topMinutes.toString();
	}

	@Override
	public String displayBottomMinutes(int minutes) {
		int numberofBottomLampsON = berLinClockService
				.getNumberOfLampsONForBottomHrsOrMin(minutes);
		StringBuilder bottomMinutes = berLinClockService
				.getDisplayBottomMinutes(numberofBottomLampsON);
		return bottomMinutes.toString();
	}

}
