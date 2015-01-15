package com.cloudcog.gears.screen.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

public class SmallLoginScreen extends VerticalLayout implements ClickListener {
	private static final long serialVersionUID = -9069021629836258264L;
	private static final Logger log = LoggerFactory.getLogger(SmallLoginScreen.class);

	final FormLayout loginForm = new FormLayout();
	private Button btnLogin = new Button("Login");
	private TextField txtUsername = new TextField("Username");
	private PasswordField txtPassword = new PasswordField("Password");

	public SmallLoginScreen() {
		super();
		initUI();
	}

	private void initUI() {
		txtUsername.setRequired(true);
		txtUsername.setCaption("Enter username");
		txtUsername.focus();
		txtPassword.setRequired(true);
		txtPassword.setCaption("Enter your password");

		final Panel loginPanel = new Panel();
		this.addComponent(loginPanel);
		this.setSizeFull();
		this.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
		loginPanel.setWidth(null);

		loginForm.setMargin(true);
		loginForm.setStyleName("loginForm");
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
			btnLogin.setComponentError(new UserError("Wrong username or password."));
		} catch (Exception e) {
			btnLogin.setComponentError(new UserError(e.getMessage()));
			log.error(e.getMessage(), e);
		}
	}

}