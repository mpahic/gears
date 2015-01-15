package com.cloudcog.gears.controller;

import javax.jcr.RepositoryException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloudcog.gears.repository.RepositoryContext;
import com.cloudcog.gears.repository.user.GearsGroup;
import com.cloudcog.gears.repository.user.GearsUser;
import com.cloudcog.gears.screen.admin.groups.GroupsPanel;
import com.cloudcog.gears.screen.admin.users.UsersPanel;

@WebListener
public class ContextInitializer implements ServletContextListener {

	private static final Logger log = LoggerFactory.getLogger(ContextInitializer.class);

	public void contextInitialized(ServletContextEvent event) {
		try {
			ObjectWindowMatcher.putWindowMatcher(GearsUser.class, UsersPanel.class);
			ObjectWindowMatcher.putWindowMatcher(GearsGroup.class, GroupsPanel.class);
			RepositoryContext.getRepository();
		} catch (RepositoryException e) {
			log.error(e.getMessage(), e);
		}
	}

	public void contextDestroyed(ServletContextEvent event) {
		// todo
	}
}
