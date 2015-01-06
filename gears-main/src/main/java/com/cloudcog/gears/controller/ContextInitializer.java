package com.cloudcog.gears.controller;

import javax.jcr.RepositoryException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.cloudcog.gears.repository.RepositoryContext;

@WebListener
public class ContextInitializer implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		try {
			RepositoryContext.getRepository();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent event) {
		// todo
	}
}
