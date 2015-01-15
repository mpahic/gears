package com.cloudcog.gears.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.vaadin.server.FileResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Image;

/**
 * Class for fetching various resources, mainly images for buttons
 * 
 * @author mpahic
 * 
 */
public class ImageResource {

	public static final String CROSS_BUTTON_16 = "img/icons/16/cross-button.png";
	public static final String CROSS_CIRCLE_FRAME_16 = "img/icons/16/cross-circle-frame.png";
	public static final String CROSS_CIRCLE_16 = "img/icons/16/cross-circle.png";
	public static final String CROSS_OCTAGON_FRAME_16 = "img/icons/16/cross-octagon-frame.png";
	public static final String CROSS_OCTAGON_16 = "img/icons/16/cross-octagon.png";
	public static final String CROSS_SCRIPT_16 = "img/icons/16/cross-scriptpng";
	public static final String CROSS_SHIELD_16 = "img/icons/16/cross-shield.png";
	public static final String CROSS_16 = "img/icons/16/cross.png";

	public static final String TICK_BUTTON_16 = "img/icons/16/tick-button.png";
	public static final String TICK_CIRCLE_FRAME_16 = "img/icons/16/tick-circle-frame.png";
	public static final String TICK_CIRCLE_16 = "img/icons/16/tick-circle.png";
	public static final String TICK_OCTAGON_FRAME_16 = "img/icons/16/tick-octagon-frame.png";
	public static final String TICK_OCTAGON_16 = "img/icons/16/tick-octagon.png";
	public static final String TICK_SCRIPT_16 = "img/icons/16/tick-scriptpng";
	public static final String TICK_SHIELD_16 = "img/icons/16/tick-shield.png";
	public static final String TICK_16 = "img/icons/16/tick.png";

	public static final String MINUS_BUTTON_16 = "img/icons/16/minus-button.png";
	public static final String CROSS = "img/icons/16/minus-circle-frame.png";
	public static final String MINUS_CIRCLE_16 = "img/icons/16/minus-circle.png";
	public static final String MINUS_OCTAGON_FRAME_16 = "img/icons/16/minus-octagon-frame.png";
	public static final String MINUS_OCTAGON_16 = "img/icons/16/minus-octagon.png";
	public static final String MINUS_SHIELD_16 = "img/icons/16/minus-shield.png";
	public static final String MINUS_16 = "img/icons/16/minus.png";

	public static final String PLUS_BUTTON_16 = "img/icons/16/plus-button.png";
	public static final String PLUS_CIRCLE_FRAME_16 = "img/icons/16/plus-circle-frame.png";
	public static final String PLUS_CIRCLE_16 = "img/icons/16/plus-circle.png";
	public static final String PLUS_OCTAGON_FRAME_16 = "img/icons/16/plus-octagon-frame.png";
	public static final String PLUS_OCTAGON_16 = "img/icons/16/plus-octagon.png";
	public static final String PLUS_SHIELD_16 = "img/icons/16/plus-shield.png";
	public static final String PLUS_16 = "img/icons/16/plus.png";

	public static final String QUESTION_BALOON16 = "img/icons/16/question-baloon.png";
	public static final String QUESTION_BUTTON_16 = "img/icons/16/question-button.png";
	public static final String QUESTION_FRAME_16 = "img/icons/16/question-frame.png";
	public static final String QUESTION_OCTAGON_FRAME_16 = "img/icons/16/question-octagon-frame.png";
	public static final String QUESTION_OCTAGON_16 = "img/icons/16/question-octagon.png";
	public static final String QUESTION_SHIELD_16 = "img/icons/16/question-shield.png";
	public static final String QUESTION_16 = "img/icons/16/question.png";

	public static final String EXCLAMATION_FRAME_16 = "img/icons/16/exclamation-frame.png";
	public static final String EXCLAMATION_BUTTON_16 = "img/icons/16/exclamation-button.png";
	public static final String EXCLAMATION_CIRCLE_FRAME_16 = "img/icons/16/exclamation-circle-frame.png";
	public static final String EXCLAMATION_CIRCLE_16 = "img/icons/16/exclamation-circle.png";
	public static final String EXCLAMATION_DIAMOND_FRAME_16 = "img/icons/16/exclamation-diamond-frame.png";
	public static final String EXCLAMATION_DIAMOND_16 = "img/icons/16/exclamation-diamond.png";
	public static final String EXCLAMATION_OCTAGON_FRAME_16 = "img/icons/16/exclamation-octagon-frame.png";
	public static final String EXCLAMATION_OCTAGON_16 = "img/icons/16/exclamation-octagon.png";
	public static final String EXCLAMATION_RED_FRAME_16 = "img/icons/16/exclamation-red-frame.png";
	public static final String EXCLAMATION_RED_16 = "img/icons/16/exclamation-red.png";
	public static final String EXCLAMATION_SHIELD_FRAME_16 = "img/icons/16/exclamation-shield-frame.png";
	public static final String EXCLAMATION_SHIELD_16 = "img/icons/16/exclamation-shield.png";
	public static final String EXCLAMATION_WHITE_16 = "img/icons/16/exclamation-white.png";
	public static final String EXCLAMATION_16 = "img/icons/16/exclamation.png";

	public static final String SEX_ICON_16 = "img/icons/16/sex-icon.png";
	public static final String MALE_ICON_16 = "img/icons/16/male-icon.png";
	public static final String FEMALE_ICON_16 = "img/icons/16/female-icon.png";

	public static final String PRINTER_16 = "img/icons/16/printer.png";

	public static final String SAFE_16 = "img/icons/16/safe.png";

	public static final String SCISSORS_16 = "img/icons/16/scissors.png";

	public static final String BLOCK_16 = "img/icons/16/block.png";

	public static final String WAND_16 = "img/icons/16/wand.png";

	public static final String CLOCK_HISTORY_16 = "img/icons/16/clock-history.png";

	public static final String WRENCH_16 = "img/icons/16/wrench.png";
	public static final String WRENCH_SCREWDRIVER_16 = "img/icons/16/wrench-screwdriver.png";

	public static final String USERS_16 = "img/icons/16/users.png";
	public static final String USER_16 = "img/icons/16/user.png";
	public static final String USER_FEMALE_16 = "img/icons/16/user-female.png";
	public static final String USER_GREEN_16 = "img/icons/16/user-green.png";
	public static final String USER_GREEN_FEMALE_16 = "img/icons/16/user-green-female.png";
	public static final String USER_RED_16 = "img/icons/16/user-red.png";
	public static final String USER_RED_FEMALE_16 = "img/icons/16/user-red-female.png";
	public static final String USER_SILHOUETTE_16 = "img/icons/16/user-silhouette.png";
	public static final String USER_SILHOUETTE_QUESTION_16 = "img/icons/16/user-silhouette-question.png";

	public static final String CALENDAR_16 = "img/icons/16/calendar.png";
	public static final String CALENDAR_BLUE_16 = "img/icons/16/calendar-blue.png";
	public static final String CALENDAR_MONTH_16 = "img/icons/16/calendar-month.png";

	public static final String CHART_16 = "img/icons/16/chart.png";
	public static final String CHART_PIE_16 = "img/icons/16/chart-pie.png";
	public static final String CHART_UP_16 = "img/icons/16/chart-up-color.png";
	public static final String CHART_DOWN_16 = "img/icons/16/chart-down-color.png";

	public static final String FOOTPRINT_16 = "img/icons/16/footprint.png";
	public static final String FOOTPRINTS_16 = "img/icons/16/footprints.png";

	public static final String PROHIBITION_16 = "img/icons/16/prohibition.png";
	public static final String PROHIBITION_BUTTON_16 = "img/icons/16/prohibition-button.png";

	public static final String LOCK_16 = "img/icons/16/lock.png";
	public static final String UNLOCK_16 = "img/icons/16/lock-unlock.png";
	public static final String LOCK_WARNING_16 = "img/icons/16/lock-warning.png";

	public static final String MAGNIFIER_LEFT_16 = "img/icons/16/magnifier-left.png";
	public static final String MAGNIFIER_ZOOM_ACTUAL_16 = "img/icons/16/magnifier-zoom-actual.png";
	public static final String MAGNIFIER_ZOOM_ACTUAL_EQUAL_16 = "img/icons/16/magnifier-zoom-actual-equal.png";
	public static final String MAGNIFIER_ZOOM_FIT_16 = "img/icons/16/magnifier-zoom-fit.png";
	public static final String MAGNIFIER_ZOOM_IN_16 = "img/icons/16/magnifier-zoom-in.png";
	public static final String MAGNIFIER_ZOOM_OUT_16 = "img/icons/16/magnifier-zoom-out.png";
	public static final String MAGNIFIER_16 = "img/icons/16/magnifier.png";

	private static Map<String, Image> images = new HashMap<String, Image>();
	private static Map<String, ThemeResource> resources = new HashMap<String, ThemeResource>();

	private ImageResource() {

	}

	public static Image getImage(String file) {
		Image image = images.get(file);

		if (image == null) {
			String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
			FileResource resource = new FileResource(new File(basepath + file));
			image = new Image("Image from file", resource);
			images.put(file, image);

		}
		return image;
	}

	/**
	 * 
	 * @param file
	 *            from ImageResource.PARAMS
	 * @return ThemeResource from image directory
	 */
	public static ThemeResource getResource(String file) {
		ThemeResource resource = resources.get(file);

		if (resource == null) {
			resource = new ThemeResource(file);
			resources.put(file, resource);
		}
		return resource;
	}
}
