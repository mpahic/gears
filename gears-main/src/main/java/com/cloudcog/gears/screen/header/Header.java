package com.cloudcog.gears.screen.header;

import com.cloudcog.gears.util.ImageResource;
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

	public Header(MenuBar menu) {
		this.mnuUser = menu;
		this.setContent(buildPanel());
	}
	
	private AbsoluteLayout buildPanel() {
		
		mainLayout = new AbsoluteLayout();
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");

		setWidth("100.0%");
		setHeight("100.0%");

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
