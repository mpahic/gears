package com.cloudcog.gears.screen.login;

import com.cloudcog.gears.i18n.Messages;
import com.cloudcog.gears.login.UserSessionHandler;
import com.cloudcog.gears.login.exception.LoginException;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
public class LoginView extends VerticalLayout {

	public LoginView() {
		setSizeFull();

		Component loginForm = buildLoginForm();
		addComponent(loginForm);
		setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);

	}

	private Component buildLoginForm() {
		final VerticalLayout loginPanel = new VerticalLayout();
		loginPanel.setSizeUndefined();
		loginPanel.setSpacing(true);
		Responsive.makeResponsive(loginPanel);
		loginPanel.addStyleName("login-panel"); //$NON-NLS-1$

		loginPanel.addComponent(buildLabels());
		loginPanel.addComponent(buildFields());
		// loginPanel.addComponent(new CheckBox("Remember me", true));
		return loginPanel;
	}

	private Component buildFields() {
		HorizontalLayout fields = new HorizontalLayout();
		fields.setSpacing(true);
		fields.addStyleName("fields"); //$NON-NLS-1$

		final TextField username = new TextField(Messages.getString("LoginScreen.username")); //$NON-NLS-1$
		username.setIcon(FontAwesome.USER);
		username.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

		final PasswordField password = new PasswordField(Messages.getString("LoginScreen.password")); //$NON-NLS-1$
		password.setIcon(FontAwesome.LOCK);
		password.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

		final Button signin = new Button(Messages.getString("LoginScreen.sign_in")); //$NON-NLS-1$
		signin.addStyleName(ValoTheme.BUTTON_PRIMARY);
		signin.setClickShortcut(KeyCode.ENTER);
		signin.focus();

		fields.addComponents(username, password, signin);
		fields.setComponentAlignment(signin, Alignment.BOTTOM_LEFT);

		signin.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(final ClickEvent event) {
				UserSessionHandler userSession = new UserSessionHandler();
				try {
					userSession.loginUser(username.getValue(), password.getValue());
				} catch (LoginException e) {
					e.printStackTrace();
				}
			}
		});
		return fields;
	}

	private Component buildLabels() {
		CssLayout labels = new CssLayout();
		labels.addStyleName("labels"); //$NON-NLS-1$

		Label welcome = new Label(Messages.getString("LoginScreen.welcome")); //$NON-NLS-1$
		welcome.setSizeUndefined();
		welcome.addStyleName(ValoTheme.LABEL_H4);
		welcome.addStyleName(ValoTheme.LABEL_COLORED);
		labels.addComponent(welcome);

		Label title = new Label(Messages.getString("LoginScreen.gears_admin_interface_title")); //$NON-NLS-1$
		title.setSizeUndefined();
		title.addStyleName(ValoTheme.LABEL_H3);
		title.addStyleName(ValoTheme.LABEL_LIGHT);
		labels.addComponent(title);
		return labels;
	}

}
