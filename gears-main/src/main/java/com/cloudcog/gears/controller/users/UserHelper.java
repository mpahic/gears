package com.cloudcog.gears.controller.users;

import javax.jcr.RepositoryException;

import com.cloudcog.gears.repository.user.GearsUser;
import com.cloudcog.gears.util.ImageResource;
import com.vaadin.server.ThemeResource;

public class UserHelper {

    public static ThemeResource getUserIcon(GearsUser user) throws RepositoryException {
	if (GearsUser.Gender.MALE.equals(user.getGender())) {
	    return ImageResource.getResource(ImageResource.USER_16);
	} else if (GearsUser.Gender.FEMALE.equals(user.getGender())) {
	    return ImageResource.getResource(ImageResource.USER_FEMALE_16);
	} else {
	    return ImageResource.getResource(ImageResource.USER_GREEN_16);
	}
    }
}
