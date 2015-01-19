package com.cloudcog.gears.screen.mainPanel;

import com.cloudcog.gears.i18n.Messages;
import com.cloudcog.gears.screen.mainPanel.handlers.EditObjectInterface;
import com.cloudcog.gears.screen.mainPanel.handlers.PrintObjectInterface;
import com.cloudcog.gears.screen.mainPanel.handlers.SaveObjectInterface;
import com.vaadin.ui.MenuBar;

public class ObjectMenuBar extends MenuBar {
	private static final long serialVersionUID = -984207809661507768L;

	public ObjectMenuBar(final Object itemHandler) {
		if (itemHandler instanceof SaveObjectInterface) {
			MenuBar.MenuItem saveMenu = this.addItem(Messages.getString("ObjectMenuBar.save"), new MenuBar.Command() {

				@Override
				public void menuSelected(MenuItem selectedItem) {
					saveItem((SaveObjectInterface) itemHandler);
				}

			});
		}

		if (itemHandler instanceof EditObjectInterface) {
			MenuBar.MenuItem editMenu = this.addItem(Messages.getString("ObjectMenuBar.edit"), new MenuBar.Command() {

				@Override
				public void menuSelected(MenuItem selectedItem) {
					editItem((EditObjectInterface) itemHandler);
				}

			});

			MenuBar.MenuItem cancelMenu = this.addItem(Messages.getString("ObjectMenuBar.cancel"), new MenuBar.Command() {

				@Override
				public void menuSelected(MenuItem selectedItem) {
					cancelItem((EditObjectInterface) itemHandler);
				}

			});
			cancelMenu.setVisible(false);
		}

		if (itemHandler instanceof PrintObjectInterface) {
			MenuBar.MenuItem printMenu = this.addItem(Messages.getString("ObjectMenuBar.save"), new MenuBar.Command() {

				@Override
				public void menuSelected(MenuItem selectedItem) {
					printItem((PrintObjectInterface) itemHandler);
				}

			});
		}
	}

	private void saveItem(SaveObjectInterface itemHandler) {
		itemHandler.save();
		if (itemHandler instanceof EditObjectInterface) {
			// TODO show edit
		}
	}

	private void editItem(EditObjectInterface itemHandler) {
		itemHandler.edit();
		if (itemHandler instanceof SaveObjectInterface) {
			// TODO show save and cancel
		}
	}

	private void cancelItem(EditObjectInterface itemHandler) {
		itemHandler.cancel();
		if (itemHandler instanceof SaveObjectInterface) {
			// TODO show edit
		}
	}

	private void printItem(PrintObjectInterface itemHandler) {
		itemHandler.print();

	}
}
