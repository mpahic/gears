package com.cloudcog.gears.screen.leftMenu;

import com.cloudcog.gears.GearsUI;
import com.vaadin.data.Item;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.shared.MouseEventDetails.MouseButton;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.TreeTable;
import com.vaadin.ui.VerticalLayout;

public class LeftMenu extends Panel{
	private static final long serialVersionUID = -6039366750202717846L;

	public LeftMenu(){
		this.setSizeFull();
		VerticalLayout vl = new VerticalLayout();
		this.setContent(vl);
		CssLayout toolbar = new CssLayout();
		toolbar.setStyleName("toolbar");
		toolbar.addComponent(new Button("Add"));
		vl.addComponent(toolbar);
		
		Tree tree = new Tree();
		vl.addComponent(tree);
		
		
		// Create the tree nodes
		tree.addItem("UI");
		tree.addItem("Branch 1");
		tree.addItem("Branch 2");
		tree.addItem("Leaf 1");
		tree.addItem("Leaf 2");
		tree.addItem("Leaf 3");
		tree.addItem("Leaf 4");
		        
		// Set the hierarchy
		tree.setParent("Branch 1", "UI");
		tree.setParent("Branch 2", "UI");
		tree.setParent("Leaf 1", "Branch 1");
		tree.setParent("Leaf 2", "Branch 1");
		tree.setParent("Leaf 3", "Branch 2");
		tree.setParent("Leaf 4", "Branch 2");
		
		tree.addItemClickListener(new ItemClickEvent.ItemClickListener() {
		    public void itemClick(ItemClickEvent event) {
		        // Pick only left mouse clicks
		        if (event.getButton() == MouseButton.RIGHT) {
		        	Notification.show("Left click", Notification.Type.HUMANIZED_MESSAGE);
		        } else if(event.isDoubleClick()) {
		        	Panel tab = new Panel(event.getItem().toString());
//		        	GearsUI.getCurrent().getMainPanel().addTab(tab);
		        }
		    }
		});
		
	}
}
