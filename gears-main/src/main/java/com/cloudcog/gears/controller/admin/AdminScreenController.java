package com.cloudcog.gears.controller.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloudcog.gears.GearsContext;
import com.cloudcog.gears.repository.user.GearsGroup;
import com.cloudcog.gears.repository.user.GearsUser;
import com.cloudcog.gears.repository.user.UserDAO;
import com.cloudcog.gears.screen.admin.AdminMainScreen;
import com.cloudcog.gears.screen.admin.AdminMenu;
import com.cloudcog.gears.screen.admin.groups.GroupsMenu;
import com.cloudcog.gears.screen.admin.users.UsersMenu;
import com.cloudcog.gears.screen.header.Header;
import com.vaadin.event.MouseEvents;
import com.vaadin.ui.Component;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;

public class AdminScreenController {

	private static final Logger log = LoggerFactory.getLogger(AdminScreenController.class);

	private AdminMainScreen adminMainScreen;

	public AdminScreenController() {
		init();
	}

	private void init() {
		adminMainScreen = new AdminMainScreen(this);
		adminMainScreen.setHeader(new Header(new AdminMenu(this)));
	}

	public Component getMainContent() {
		return adminMainScreen;
	}

	public Command getHeaderClickCommand(String commandId) {
		return new AdminHeaderCommand(commandId);

	}

	private class AdminHeaderCommand implements Command {
		private static final long serialVersionUID = 7388306994941716144L;
		private String commandId;

		public AdminHeaderCommand(String commandId) {
			this.commandId = commandId;
		}

		@Override
		public void menuSelected(MenuItem selectedItem) {
			AdminScreenController.this.handleCommand(this.commandId);

		}
	}

	public void handleCommand(String commandId) {
		if (commandId.equalsIgnoreCase("users")) {
			showUsersPanel();
		} else if (commandId.equalsIgnoreCase("groups")) {
			showGroupsPanel();
		}
	}

	private void showUsersPanel() {
		try {
			List<GearsUser> users = UserDAO.getAllUsers(GearsContext.getJcrSession());
			adminMainScreen.setSideScreen(new UsersMenu(this, users));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	private void showGroupsPanel() {
		try {
			List<GearsGroup> groups = UserDAO.getAllGroups(GearsContext.getJcrSession());
			adminMainScreen.setSideScreen(new GroupsMenu(this, groups));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	public void setSelectedItem(Object item) {
		try {
			adminMainScreen.addPanelScreen(this, item);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	public Object getContentClickListener() {
		return new ContentClickListener();
	}

	private class ContentClickListener implements MouseEvents.ClickListener {
		public void click(MouseEvents.ClickEvent event) {
			AdminScreenController.this.setSelectedItem(event.getSource());
		}
	}

	public void createNewPanel(Class<GearsUser> objectClass) {
		try {
			adminMainScreen.addNewPanelScreen(this, objectClass);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
}
