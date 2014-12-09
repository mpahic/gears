package com.cloudcog.gears;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("gears")
@SuppressWarnings("serial")
public class AdminUI extends UI
{

    @WebServlet(value = "/admin/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = AdminUI.class, widgetset = "com.cloudcog.gears.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        
        Button button = new Button("Admin Me");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Welcome to admin"));
                System.out.println("lalalal");
            }
        });
        layout.addComponent(button);
    }

}
