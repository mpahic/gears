package com.cloudcog.gears.screen.admin.groups;

import java.util.List;

import javax.jcr.RepositoryException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloudcog.gears.controller.admin.AdminScreenController;
import com.cloudcog.gears.controller.filters.SimpleStringFilter;
import com.cloudcog.gears.repository.user.GearsGroup;
import com.cloudcog.gears.util.ImageResource;
import com.vaadin.data.Container;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.event.FieldEvents;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Tree;
import com.vaadin.ui.themes.ValoTheme;

public final class GroupsMenu extends CustomComponent {
	private static final long serialVersionUID = 1233140341244995086L;
	private static final Logger log = LoggerFactory.getLogger(GroupsMenu.class);

	public static final String ID = "groups-menu";
	public static final String REPORTS_BADGE_ID = "dashboard-menu-reports-badge";
	public static final String NOTIFICATIONS_BADGE_ID = "dashboard-menu-notifications-badge";

	private HierarchicalContainer container;

	public GroupsMenu(AdminScreenController adminScreenController, List<GearsGroup> groups) {
		addStyleName("valo-menu");
		setId(ID);
		this.setWidth("100%");
		this.setHeight("100%");

		try {
			setCompositionRoot(buildContent(adminScreenController, groups));
		} catch (RepositoryException e) {
			log.error(e.getMessage(), e);
		}
	}

	private Component buildContent(AdminScreenController adminScreenController, List<GearsGroup> groups) throws RepositoryException {

		container = new HierarchicalContainer();
		for (GearsGroup group : groups) {
			container.addItem(group);
			container.setChildrenAllowed(group, false);
		}
		final CssLayout menuContent = new CssLayout();
		menuContent.addStyleName("sidebar");
		menuContent.addStyleName(ValoTheme.MENU_PART);
		menuContent.addStyleName("no-vertical-drag-hints");
		menuContent.addStyleName("no-horizontal-drag-hints");
		menuContent.setWidth("100%");
		menuContent.setHeight("100%");

		menuContent.addComponent(buildTitle());
		menuContent.addComponent(buildSearchFilter());
		menuContent.addComponent(buildMenuItems(adminScreenController));

		return menuContent;
	}

	private Component buildTitle() {
		Label logo = new Label("Groups");
		logo.setSizeUndefined();
		Button addButton = new Button(ImageResource.getResource(ImageResource.PLUS_BUTTON_16));
		addButton.setStyleName("small");
		addButton.setStyleName("icon-only");
		addButton.setStyleName("borderless");
		HorizontalLayout logoWrapper = new HorizontalLayout(addButton, logo);
		logoWrapper.setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
		return logoWrapper;
	}

	private Component buildSearchFilter() {
		TextField searchFilter = new TextField();
		searchFilter.setInputPrompt("Search");
		searchFilter.setWidth("100%");
		searchFilter.setStyleName("small");
		searchFilter.addTextChangeListener(new FieldEvents.TextChangeListener() {

			@Override
			public void textChange(TextChangeEvent event) {
				container.removeAllContainerFilters();
				if (!event.getText().isEmpty()) {
					Container.Filter filter = new SimpleStringFilter(event.getText());
					container.addContainerFilter(filter);
				}
			}
		});
		return searchFilter;
	}

	private Component buildMenuItems(final AdminScreenController adminScreenController) throws RepositoryException {

		final Tree usersTree = new Tree();
		usersTree.setContainerDataSource(this.container);

		return usersTree;

	}

}
