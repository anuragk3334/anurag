package com.ubs.opsit.interviews.service;

/**
 * @author AnuragK
 * depicts the state of lamps
 */
public enum BerLinClockState {
	RED("R"),YELLOW("Y"),OFF("O");
	
	private String value;
	
	

	private BerLinClockState(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}
