package com.cloudcog.gears;

import javax.servlet.annotation.WebServlet;

import com.cloudcog.gears.screen.administration.ApplicationScreen;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@Theme("gears")
@SuppressWarnings("serial")
public class AdminUI extends AbstractAuthorizableUI
{

	private ApplicationScreen applicationScreen;

    @WebServlet(value = "/admin/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = AdminUI.class, widgetset = "com.cloudcog.gears.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

	@Override
	protected void showAppScreen() {
		applicationScreen = new ApplicationScreen();
		setContent(applicationScreen);
	}

}
