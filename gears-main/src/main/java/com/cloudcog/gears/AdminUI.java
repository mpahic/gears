package com.cloudcog.gears;

import javax.jcr.RepositoryException;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebServlet;

import com.cloudcog.gears.controller.admin.AdminScreenController;
import com.cloudcog.gears.repository.RepositoryContext;
import com.cloudcog.gears.repository.user.UserDAO;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@Theme("gears")
@SuppressWarnings("serial")
public class AdminUI extends AbstractAuthorizableUI {

	@WebServlet(value = "/admin/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = AdminUI.class, widgetset = "com.cloudcog.gears.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void showAppScreen() {
		AdminScreenController adminController = new AdminScreenController();
		setContent(adminController.getMainContent());
	}

	@Override
	protected boolean hasAccessRights() {
		try {
			if (GearsContext.isAuthorized() && UserDAO.getCurrentUser(GearsContext.getJcrSession()).isAdmin()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public void contextInitialized(ServletContextEvent event) {
		try {
			RepositoryContext.getRepository();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}

}
