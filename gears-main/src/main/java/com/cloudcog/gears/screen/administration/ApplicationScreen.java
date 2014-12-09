package com.cloudcog.gears.screen.administration;

import com.cloudcog.gears.screen.header.Header;
import com.cloudcog.gears.screen.leftMenu.LeftMenu;
import com.cloudcog.gears.screen.mainPanel.MainPanel;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.themes.ChameleonTheme;

public class ApplicationScreen extends Panel {
	private static final long serialVersionUID = 1190467540751104177L;

	Panel leftMenu;
	MainPanel mainPanel;
	public ApplicationScreen(){
		init();
	}

	private void init() {
		this.setSizeFull();
		VerticalSplitPanel vsp = new VerticalSplitPanel();
		vsp.setFirstComponent(new Header());
		leftMenu = new LeftMenu();
		mainPanel = new MainPanel();
		HorizontalSplitPanel hsp = new HorizontalSplitPanel(leftMenu, mainPanel);
		hsp.setSplitPosition(250, Unit.PIXELS);
		vsp.setSecondComponent(hsp);
		vsp.setSplitPosition(80, Unit.PIXELS);
		vsp.setLocked(true);
		vsp.setStyleName(ChameleonTheme.SPLITPANEL_SMALL);
		this.setContent(vsp);
	}

	public Panel getLeftMenu() {
		return leftMenu;
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}
	
}
