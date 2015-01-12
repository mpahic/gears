package com.cloudcog.gears.controller;

import java.util.HashMap;
import java.util.Map;

import com.cloudcog.gears.screen.GearsWindow;

public class ObjectWindowMatcher {

	public static Map<Class<?>, Class<? extends GearsWindow>> windowMatch = null;

	public static void putWindowMatcher(Class<?> objectClass, Class<? extends GearsWindow> panelClass) {
		if (windowMatch == null) {
			windowMatch = new HashMap<Class<?>, Class<? extends GearsWindow>>();
		}
		windowMatch.put(objectClass, panelClass);
	}

	public static Class<? extends GearsWindow> getObjectWindow(Class<?> object) {
		return windowMatch.get(object);
	}
}
