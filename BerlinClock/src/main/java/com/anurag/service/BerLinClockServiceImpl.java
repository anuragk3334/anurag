/**
 * 
 */
package com.anurag.service;

/**
 * @author AnuragK
 * Business logic to convert time to BerLinClock specific time
 */
public class BerLinClockServiceImpl implements BerLinClockService {

	private static final int TWO = 2;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int ELEVEN = 11;

	@Override
	public int getNumberOfLampsONForTopHrsOrMin(int hourOrMinute) {
		
		return (hourOrMinute / FIVE);

	}
    @Override
	public int getNumberOfLampsONForBottomHrsOrMin(int hourOrMinute) {
		
		return (hourOrMinute % FIVE);
	}
    @Override
	public StringBuilder getDisplayHours(int numberofLampsON) {

		return getDisplay(numberofLampsON, BerLinClockState.RED);
	}
	@Override
	public StringBuilder getDisPlayTopMinutes(int numberofLampsON) {
		StringBuilder topMinutes = new StringBuilder();
		for (int i = 1; i <= ELEVEN; i++) {
			if (i <= numberofLampsON) {
				getDisplayTopMinutesON(topMinutes, i);

			} else {
				getDisplayOFF(topMinutes);
			}

		}
		return topMinutes;
	}

	@Override
	public StringBuilder getDisplayBottomMinutes(int numberOfLampsON) {

		return getDisplay(numberOfLampsON, BerLinClockState.YELLOW);
	}
	
	@Override
	public StringBuilder getDisPlaySeconds(int seconds) {
		StringBuilder builder=new StringBuilder();
		if(seconds % TWO==0){
			builder.append(BerLinClockState.OFF.getValue());
		}
		else{
			builder.append(BerLinClockState.YELLOW.getValue());
		}
		return builder;
	}


	private StringBuilder getDisplay(int numberofLampsON,
			BerLinClockState illuminatedLampState) {
		StringBuilder hrsOrBottomMinutes = new StringBuilder();
		for (int i = 0; i < FOUR; i++) {
			if (i < numberofLampsON) {
				hrsOrBottomMinutes.append(illuminatedLampState.getValue());
				//hrsOrBottomMinutes.append("\t");
			} else {
				getDisplayOFF(hrsOrBottomMinutes);
			}

		}
		return hrsOrBottomMinutes;
	}

	

	private void getDisplayOFF(StringBuilder offLamps) {
		offLamps.append(BerLinClockState.OFF.getValue());
		//upperLampsPattern.append("\t");
	}

	/**
	 * @param builder
	 * @param i
	 *            Every third consecutive illuminated Upper Minute Lamp will be
	 *            Red
	 */
	private void getDisplayTopMinutesON(StringBuilder builder, int i) {
		if (i % 3 == 0) {
			builder.append(BerLinClockState.RED.getValue());
		} else {
			builder.append(BerLinClockState.YELLOW.getValue());
		}
		//builder.append("\t");
	}
	
}
