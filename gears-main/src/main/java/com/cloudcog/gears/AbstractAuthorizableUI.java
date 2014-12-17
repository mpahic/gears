package com.cloudcog.gears;

import javax.jcr.LoginException;
import javax.jcr.RepositoryException;

import com.cloudcog.gears.login.ISessionListener;
import com.cloudcog.gears.screen.login.LoginScreen;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;


public abstract class AbstractAuthorizableUI extends UI implements ISessionListener {
	private static final long serialVersionUID = 4786085432570500274L;

	@Override
	protected void init(VaadinRequest request) {
		if(GearsContext.isAuthorized()) {
			showAppScreen();
		} else {
			showLoginScreen();
		}
	}

	private void showLoginScreen(){
		setContent(new LoginScreen());
	}

	protected abstract void showAppScreen();

	@Override
	public void sessionCreateHandler() {
		showAppScreen();
	}

	@Override
	public void sessionDestroyHandler() {
		GearsContext.destroyJcrSession();
		showLoginScreen();
	}
	
	public static AbstractAuthorizableUI getCurrent(){
		return (AbstractAuthorizableUI) UI.getCurrent();
	}
}
