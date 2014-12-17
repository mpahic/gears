package com.cloudcog.gears.login;

import com.cloudcog.gears.AbstractAuthorizableUI;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;

public class LogoutClickListener implements Command{
	private static final long serialVersionUID = 2977909483773449912L;
	
	@Override
	public void menuSelected(MenuItem selectedItem) {
		fireLogoutAction();
	}

	private void fireLogoutAction() {
		((AbstractAuthorizableUI) AbstractAuthorizableUI.getCurrent()).sessionDestroyHandler();
		
	}

}
