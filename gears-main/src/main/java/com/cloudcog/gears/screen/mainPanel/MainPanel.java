package com.cloudcog.gears.screen.mainPanel;

import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;

public class MainPanel extends Panel {
	private static final long serialVersionUID = -5755975822484717108L;

	TabSheet tabSheet = new TabSheet();

	public MainPanel() {
		tabSheet.setSizeFull();
		this.setContent(tabSheet);
		this.setSizeFull();
	}
	
	public void addTab(Panel panel) {
		Tab tab = tabSheet.addTab(panel);
		tab.setClosable(true);
	}

}
