package com.cloudcog.gears.screen.admin.groups;

import java.util.List;

import javax.jcr.RepositoryException;

import com.cloudcog.gears.controller.admin.AdminScreenController;
import com.cloudcog.gears.repository.user.GearsGroup;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Tree;
import com.vaadin.ui.themes.ValoTheme;

public final class GroupsMenu extends CustomComponent {
	private static final long serialVersionUID = 1233140341244995086L;

	public static final String ID = "groups-menu";
	public static final String REPORTS_BADGE_ID = "dashboard-menu-reports-badge";
	public static final String NOTIFICATIONS_BADGE_ID = "dashboard-menu-notifications-badge";
	private static final String STYLE_VISIBLE = "valo-menu-visible";

	public GroupsMenu(AdminScreenController adminScreenController, List<GearsGroup> groups) {
		addStyleName("valo-menu");
		setId(ID);
		setSizeUndefined();

		try {
			setCompositionRoot(buildContent(adminScreenController, groups));
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}

	private Component buildContent(AdminScreenController adminScreenController, List<GearsGroup> groups) throws RepositoryException {
		final CssLayout menuContent = new CssLayout();
		menuContent.addStyleName("sidebar");
		menuContent.addStyleName(ValoTheme.MENU_PART);
		menuContent.addStyleName("no-vertical-drag-hints");
		menuContent.addStyleName("no-horizontal-drag-hints");
		menuContent.setWidth(null);
		menuContent.setHeight("100%");

		menuContent.addComponent(buildTitle());
		menuContent.addComponent(buildToggleButton());
		menuContent.addComponent(buildMenuItems(adminScreenController, groups));

		return menuContent;
	}

	private Component buildTitle() {
		Label logo = new Label("Users");
		logo.setSizeUndefined();
		HorizontalLayout logoWrapper = new HorizontalLayout(logo);
		logoWrapper.setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
		logoWrapper.addStyleName("valo-menu-title");
		return logoWrapper;
	}

	private Component buildToggleButton() {
		Button valoMenuToggleButton = new Button("Menu", new ClickListener() {
			@Override
			public void buttonClick(final ClickEvent event) {
				if (getCompositionRoot().getStyleName().contains(STYLE_VISIBLE)) {
					getCompositionRoot().removeStyleName(STYLE_VISIBLE);
				} else {
					getCompositionRoot().addStyleName(STYLE_VISIBLE);
				}
			}
		});
		valoMenuToggleButton.setIcon(FontAwesome.LIST);
		valoMenuToggleButton.addStyleName("valo-menu-toggle");
		valoMenuToggleButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		valoMenuToggleButton.addStyleName(ValoTheme.BUTTON_SMALL);
		return valoMenuToggleButton;
	}

	private Component buildMenuItems(final AdminScreenController adminScreenController, List<GearsGroup> groups) throws RepositoryException {

		Tree usersTree = new Tree();

		for (final GearsGroup group : groups) {
			usersTree.addItem(group);
			usersTree.setChildrenAllowed(group, false);
		}

		usersTree.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(final ItemClickEvent event) {
				adminScreenController.setSelectedItem(event.getItemId());
			}
		});

		return usersTree;

	}

}
