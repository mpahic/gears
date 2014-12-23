package com.cloudcog.gears.screen.admin;

import com.cloudcog.gears.GearsContext;
import com.cloudcog.gears.controller.admin.AdminScreenController;
import com.cloudcog.gears.login.LogoutClickListener;
import com.cloudcog.gears.repository.user.GearsUser;
import com.cloudcog.gears.repository.user.UserDAO;
import com.cloudcog.gears.util.ImageResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.MenuBar;

public class AdminMenu extends MenuBar {
	private static final long serialVersionUID = -3386763713474566088L;

	public AdminMenu(AdminScreenController controller) {
		try {
			init(controller);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void init(AdminScreenController controller) throws Exception {
		this.setImmediate(false);
		this.setWidth("100%");
		this.setHeight("-1px");
		
		this.addItem("File", null);
		MenuBar.MenuItem administration = this.addItem("Administration", null);
		administration.addItem("Users", ImageResource.getResource(ImageResource.USERS_16), controller.getHeaderClickCommand("users"));
		administration.addItem("Settings", ImageResource.getResource(ImageResource.WRENCH_SCREWDRIVER_16), null);
		administration.addItem("Statuses", ImageResource.getResource(ImageResource.WRENCH_16), null);
		
		GearsUser user = UserDAO.getCurrentUser(GearsContext.getJcrSession());
		String username = user.getUsername();
		MenuBar.MenuItem userSetting = this.addItem(username, 
				ImageResource.getResource(ImageResource.USER_GREEN_16), null);
		
		userSetting.setStyleName("menuRight");
		ThemeResource userIcon;
		if(GearsUser.Gender.MALE.equals(user.getGender())) {
			userIcon = ImageResource.getResource(ImageResource.USER_16);
		} else {
			userIcon = ImageResource.getResource(ImageResource.USER_FEMALE_16);
		}
		userSetting.addItem("Profile", userIcon, null);
		userSetting.addItem("Settings", ImageResource.getResource(ImageResource.WRENCH_SCREWDRIVER_16), null);
		userSetting.addItem("Logout", ImageResource.getResource(ImageResource.PROHIBITION_16), new LogoutClickListener());
	}
}
