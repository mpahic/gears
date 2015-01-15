package com.cloudcog.gears.screen.mainPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloudcog.gears.controller.ObjectWindowMatcher;
import com.cloudcog.gears.controller.admin.AdminScreenController;
import com.cloudcog.gears.screen.GearsWindow;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;

public class MainPanel extends Panel {
	private static final long serialVersionUID = -5755975822484717108L;
	private static final Logger log = LoggerFactory.getLogger(MainPanel.class);

	TabSheet tabSheet = new TabSheet();

	public MainPanel(AdminScreenController adminScreenController) {
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.addComponent(new MenuBar());
		tabSheet.setSizeFull();
		tabSheet.setStyleName("small");
		verticalLayout.addComponent(tabSheet);
		this.setContent(verticalLayout);
		this.setSizeFull();
	}

	public void addTab(AdminScreenController adminScreenController, Object data) {
		boolean found = false;
		for (int i = 0; i < tabSheet.getComponentCount(); i++) {
			Tab tab = tabSheet.getTab(i);
			if (((GearsWindow) tab.getComponent()).getData().equals(data)) {
				tabSheet.setSelectedTab(tab);
				found = true;
			}
		}
		if (!found) {
			generateNewTab(adminScreenController, data);
		}
	}

	private void generateNewTab(AdminScreenController adminScreenController, Object data) {
		try {
			Class<? extends GearsWindow> windowClass = ObjectWindowMatcher.getObjectWindow(data.getClass());
			GearsWindow panel = windowClass.newInstance();
			panel.initialize(adminScreenController, data);
			Tab tab = tabSheet.addTab(panel, panel.getCaption(), panel.getIcon());
			tab.setClosable(true);
			tabSheet.setSelectedTab(tab);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

}
