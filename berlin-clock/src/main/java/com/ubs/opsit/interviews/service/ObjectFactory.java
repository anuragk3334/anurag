/**
 * 
 */
package com.ubs.opsit.interviews.service;

import com.ubs.opsit.interviews.BerLinClockImpl;
import com.ubs.opsit.interviews.TimeConverter;


/**
 * @author AnuragK
 *Factory to create Instance
 */
public class ObjectFactory {

	public static BerLinClockService getBerLinClockService() {
		return new BerLinClockServiceImpl();
	}
	
	public static TimeConverter getTimeConverter() {
		return new BerLinClockImpl();
	}


}
