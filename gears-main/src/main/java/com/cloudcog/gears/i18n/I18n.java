package com.cloudcog.gears.i18n;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * 
 * @author mpahic
 * 
 */
public class I18n {
	private static Map<Locale, ResourceBundle> resourceMap = new HashMap<Locale, ResourceBundle>();

	private static final String BUNDLE_NAME = "com.cloudcog.gears.i18n.messages"; //$NON-NLS-1$

	public static ResourceBundle getBundle(Locale locale) {
		ResourceBundle bundle = resourceMap.get(locale);
		if (bundle == null) {
			try {
				bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
			} catch (MissingResourceException e) {
				bundle = ResourceBundle.getBundle(BUNDLE_NAME);
			}
			resourceMap.put(locale, bundle);
		}
		return bundle;
	}
}
