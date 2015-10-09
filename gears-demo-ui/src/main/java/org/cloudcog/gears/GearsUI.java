package org.cloudcog.gears;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.cloudcog.gears.admin.AdminUI;
import org.cloudcog.gears.admin.modules.AdminModule;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinServlet;

/**
 *
 */
@Theme("gearsTheme")
@Widgetset("org.cloudcog.gears.GearsWidgetset")
public class GearsUI extends AdminUI {
	private static final long serialVersionUID = 3120983349184954095L;

	@WebServlet(urlPatterns = "/*", name = "GearsUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = GearsUI.class, productionMode = false)
    public static class GearsUIServlet extends VaadinServlet {
		private static final long serialVersionUID = -5161965584720683482L;
		
    }

	@Override
	public List<Class<? extends AdminModule>> getModules() {
		// TODO Auto-generated method stub
		return null;
	}
}
