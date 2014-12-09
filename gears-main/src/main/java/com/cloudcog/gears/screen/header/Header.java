package com.cloudcog.gears.screen.header;

import javax.jcr.LoginException;
import javax.jcr.RepositoryException;

import com.cloudcog.gears.GearsContext;
import com.cloudcog.gears.login.LogoutClickListener;
import com.cloudcog.gears.model.user.User;
import com.cloudcog.gears.util.ImageResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;

public class Header extends Panel{
	private static final long serialVersionUID = 5826047616924652432L;

	private AbsoluteLayout mainLayout;
	private TextField txtSearch;
	private Button btnSearchHistory;
	private MenuBar mnuUser;

	public Header() {
		this.setContent(buildPanel());
		init();
	}

	private void init() {

		try {
			mnuUser.addItem("File", null);
			MenuBar.MenuItem administration = mnuUser.addItem("Administration", null);
			administration.addItem("Users", ImageResource.getResource(ImageResource.USERS_16), null);
			administration.addItem("Settings", ImageResource.getResource(ImageResource.WRENCH_SCREWDRIVER_16), null);
			administration.addItem("Statuses", ImageResource.getResource(ImageResource.WRENCH_16), null);
			
//			User user = (User) VaadinSession.getCurrent().getAttribute("user");
			String username = GearsContext.getJcrSession().getUserID();
			MenuBar.MenuItem userSetting = mnuUser.addItem(username, 
					ImageResource.getResource(ImageResource.USER_GREEN_16), null);
			
			userSetting.setStyleName("menuRight");
			ThemeResource userIcon;
//			if(user.isMale()) {
//				userIcon = ImageResource.getResource(ImageResource.USER_16);
//			} else {
//				userIcon = ImageResource.getResource(ImageResource.USER_FEMALE_16);
//			}
//			userSetting.addItem("Profile", userIcon, null);
			userSetting.addItem("Settings", ImageResource.getResource(ImageResource.WRENCH_SCREWDRIVER_16), null);
			userSetting.addItem("Logout", ImageResource.getResource(ImageResource.PROHIBITION_16), new LogoutClickListener());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbsoluteLayout buildPanel() {
		
		mainLayout = new AbsoluteLayout();
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");

		setWidth("100.0%");
		setHeight("100.0%");
		
		mnuUser = new MenuBar();
		mnuUser.setImmediate(false);
		mnuUser.setWidth("100%");
		mnuUser.setHeight("-1px");
		mainLayout.addComponent(mnuUser, "bottom:0px;left:0px;");
		
		// txtSearch
		txtSearch = new TextField();
		txtSearch.setStyleName("search");
		txtSearch.setImmediate(false);
		txtSearch.setWidth("-1px");
		txtSearch.setHeight("-1px");
		txtSearch.setInvalidAllowed(false);
		txtSearch.setInvalidCommitted(true);
		mainLayout.addComponent(txtSearch, "top:20.0px;right:40.0px;");
		
		// txtSearch
		txtSearch = new TextField();
		txtSearch.setStyleName("search");
		txtSearch.setImmediate(false);
		txtSearch.setWidth("-1px");
		txtSearch.setHeight("-1px");
		txtSearch.setInvalidAllowed(false);
		txtSearch.setInvalidCommitted(true);
		mainLayout.addComponent(txtSearch, "top:20.0px;right:40.0px;");
		
		btnSearchHistory = new Button();
		btnSearchHistory.setIcon(ImageResource.getResource(ImageResource.CLOCK_HISTORY_16));
		btnSearchHistory.setStyleName("icon-only small");
		mainLayout.addComponent(btnSearchHistory, "top:20.0px;right:20.0px;");

		return mainLayout;
	}
	
}
