package com.cloudcog.gears.screen.mainPanel;

import com.cloudcog.gears.controller.ObjectWindowMatcher;
import com.cloudcog.gears.controller.admin.AdminScreenController;
import com.cloudcog.gears.screen.GearsWindow;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;

public class MainPanel extends Panel {
	private static final long serialVersionUID = -5755975822484717108L;

	TabSheet tabSheet = new TabSheet();

	public MainPanel(AdminScreenController adminScreenController) {
		tabSheet.setSizeFull();
		this.setContent(tabSheet);
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
			e.printStackTrace();
		}
	}

}
