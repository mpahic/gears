package com.cloudcog.gears.controller.filters;

import com.vaadin.data.Container;
import com.vaadin.data.Item;

public class SimpleStringFilter implements Container.Filter {
	private static final long serialVersionUID = -4895967610013498074L;

	private String filter;

	public SimpleStringFilter(String filter) {
		this.filter = filter;
	}

	@Override
	public boolean passesFilter(Object itemId, Item item) throws UnsupportedOperationException {
		if (itemId.toString().contains(filter)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean appliesToProperty(Object propertyId) {
		return true;
	}
}
