package com.cloudcog.gears.screen.admin.users;

import java.util.List;

import com.cloudcog.gears.controller.admin.AdminScreenController;
import com.cloudcog.gears.repository.user.GearsUser;
import com.vaadin.event.MouseEvents;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Panel;

public class UsersPanel extends Panel {
	private static final long serialVersionUID = 3631604330518401255L;

	public UsersPanel(AdminScreenController adminScreenController, List<GearsUser> users) {

		try {
			ListSelect userList = new ListSelect();
			userList.addItems(users);
			userList.setImmediate(true);
			userList.addListener(MouseEvents.ClickEvent.class, adminScreenController.getContentClickListener(), MouseEvents.ClickListener.clickMethod);
			this.setContent(userList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
