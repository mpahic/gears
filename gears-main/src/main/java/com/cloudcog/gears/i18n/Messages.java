package com.cloudcog.gears.i18n;

import java.util.MissingResourceException;

import com.cloudcog.gears.GearsContext;

/**
 * 
 * @author mpahic
 * 
 */
public class Messages {

	private Messages() {
	}

	public static String getString(String key) {
		try {
			return I18n.getBundle(GearsContext.getSessionLocale()).getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

}
