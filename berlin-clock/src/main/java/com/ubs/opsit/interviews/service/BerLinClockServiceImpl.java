/**
 * 
 */
package com.ubs.opsit.interviews.service;

/**
 * @author AnuragK
 * Business logic to convert time to BerLinClock specific time
 */
public class BerLinClockServiceImpl implements BerLinClockService {

	private static final int ZERO = 0;
	private static final int ONE = 1;
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
	public String getDisPlaySeconds(int seconds) {
		StringBuilder builder=new StringBuilder();
		if(seconds % TWO==ZERO){
			builder.append(BerLinClockState.YELLOW.getValue());
		}
		else{
			builder.append(BerLinClockState.OFF.getValue());
		}
		return builder.toString();
	}
    
    @Override
	public String getDisplayHours(int numberofLampsON) {

		return getDisplayPattern(numberofLampsON, BerLinClockState.RED).toString();
	}
    
    @Override
	public String getDisplayBottomMinutes(int numberOfLampsON) {

		return getDisplayPattern(numberOfLampsON, BerLinClockState.YELLOW).toString();
	}
    
    
	@Override
	public String getDisPlayTopMinutes(int numberofLampsON) {
		StringBuilder topMinutes = new StringBuilder();
		for (int i = ONE; i <= ELEVEN; i++) {
			if (i <= numberofLampsON) {
				getDisplayTopMinutesON(topMinutes, i);

			} else {
				getDisplayOFF(topMinutes);
			}

		}
		return topMinutes.toString();
	}

	

	private StringBuilder getDisplayPattern(int numberofLampsON,
			BerLinClockState illuminatedLampState) {
		StringBuilder hrsOrBottomMinutes = new StringBuilder();
		for (int i = 0; i < FOUR; i++) {
			if (i < numberofLampsON) {
				hrsOrBottomMinutes.append(illuminatedLampState.getValue());
			
			} else {
				getDisplayOFF(hrsOrBottomMinutes);
			}

		}
		return hrsOrBottomMinutes;
	}

	

	private void getDisplayOFF(StringBuilder offLamps) {
		offLamps.append(BerLinClockState.OFF.getValue());
		
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
		
	}
	
}
