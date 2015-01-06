package com.cloudcog.gears.screen.login;

import com.cloudcog.gears.i18n.Messages;
import com.cloudcog.gears.login.UserSessionHandler;
import com.cloudcog.gears.login.exception.LoginException;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.UserError;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginScreen extends VerticalLayout implements ClickListener {
	private static final long serialVersionUID = -9069021629836258264L;
	final FormLayout loginForm = new FormLayout();
	private Button btnLogin = new Button(Messages.getString("LoginScreen.login")); //$NON-NLS-1$
	private TextField txtUsername = new TextField(Messages.getString("LoginScreen.username")); //$NON-NLS-1$
	private PasswordField txtPassword = new PasswordField(Messages.getString("LoginScreen.password")); //$NON-NLS-1$

	public LoginScreen() {
		super();
		initUI();
	}

	private void initUI() {
		txtUsername.setRequired(true);
		txtUsername.setCaption(Messages.getString("LoginScreen.username_info")); //$NON-NLS-1$
		txtUsername.focus();
		txtPassword.setRequired(true);
		txtPassword.setCaption(Messages.getString("LoginScreen.password_info")); //$NON-NLS-1$

		final Panel loginPanel = new Panel();
		this.addComponent(loginPanel);
		this.setSizeFull();
		this.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
		loginPanel.setWidth(null);

		loginForm.setMargin(true);
		loginForm.setStyleName("loginForm"); //$NON-NLS-1$
		loginForm.addComponent(txtUsername);
		loginForm.addComponent(txtPassword);
		loginForm.addComponent(btnLogin);
		btnLogin.addClickListener(this);
		btnLogin.setClickShortcut(KeyCode.ENTER);

		loginPanel.setContent(loginForm);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		txtUsername.setComponentError(null);
		txtPassword.setComponentError(null);
		try {
			UserSessionHandler userSession = new UserSessionHandler();
			userSession.loginUser(txtUsername.getValue(), txtPassword.getValue());

		} catch (LoginException e) {
			btnLogin.setComponentError(new UserError(Messages.getString("LoginScreen.login_error"))); //$NON-NLS-1$
		} catch (Exception e) {
			btnLogin.setComponentError(new UserError(e.getMessage()));
			e.printStackTrace();
		}
	}

}