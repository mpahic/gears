package com.cloudcog.gears.controller;

import javax.jcr.RepositoryException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.cloudcog.gears.repository.RepositoryContext;
import com.cloudcog.gears.repository.user.GearsGroup;
import com.cloudcog.gears.repository.user.GearsUser;
import com.cloudcog.gears.screen.admin.groups.GroupsPanel;
import com.cloudcog.gears.screen.admin.users.UsersPanel;

@WebListener
public class ContextInitializer implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		try {
			ObjectWindowMatcher.putWindowMatcher(GearsUser.class, UsersPanel.class);
			ObjectWindowMatcher.putWindowMatcher(GearsGroup.class, GroupsPanel.class);
			RepositoryContext.getRepository();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent event) {
		// todo
	}
}
