package com.cloudcog.gears.controller.services;

import com.vaadin.ui.Component;

public interface Module {

	public String getName();

	public Component createComponent();

}
