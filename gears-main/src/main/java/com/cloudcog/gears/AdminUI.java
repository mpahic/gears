package com.cloudcog.gears;

import javax.servlet.annotation.WebServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloudcog.gears.controller.admin.AdminScreenController;
import com.cloudcog.gears.repository.user.UserDAO;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@Theme("gears")
public class AdminUI extends AbstractAuthorizableUI {
	private static final long serialVersionUID = 6395024095088840736L;
	private static final Logger log = LoggerFactory.getLogger(AdminUI.class);

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
			log.error(e.getMessage(), e);
			return false;
		}
	}

}
