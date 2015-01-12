package com.cloudcog.gears.screen.mainPanel;

import com.cloudcog.gears.controller.admin.AdminScreenController;
import com.vaadin.ui.Component;
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

	public void addTab(Component panel) {
		Tab tab = tabSheet.addTab(panel, panel.getCaption(), panel.getIcon());
		tab.setClosable(true);
		tabSheet.setSelectedTab(tab);
	}

}
