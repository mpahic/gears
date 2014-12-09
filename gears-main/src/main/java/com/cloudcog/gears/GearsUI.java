package com.cloudcog.gears;

import javax.servlet.annotation.WebServlet;

import com.cloudcog.gears.login.ISessionListener;
import com.cloudcog.gears.login.LoginScreen;
import com.cloudcog.gears.screen.administration.ApplicationScreen;
import com.cloudcog.gears.screen.mainPanel.MainPanel;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("gears")
public class GearsUI extends UI implements ISessionListener {

	ApplicationScreen applicationScreen;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = GearsUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		if(VaadinSession.getCurrent().getAttribute("user") != null) {
//			log.info("Showing app screen");
			showAppScreen();
		} else {
//			log.info("Showing login screen");
			showLoginScreen();
		}
	}
	

	private void showLoginScreen(){
		setContent(new LoginScreen());
	}

	private void showAppScreen() {
		applicationScreen = new ApplicationScreen();
		setContent(applicationScreen);
	}

	@Override
	public void sessionCreateHandler() {
		showAppScreen();
	}

	@Override
	public void sessionDestroyHandler() {
		showLoginScreen();
	}

	public Panel getLeftMenu() {
		if(applicationScreen != null){
			return applicationScreen.getLeftMenu();
		}
		return null;
	}

	public MainPanel getMainPanel() {
		if(applicationScreen != null){
			return applicationScreen.getMainPanel();
		}
		return null;
	}
	
	public static GearsUI getCurrent(){
		return (GearsUI) UI.getCurrent();
	}

}