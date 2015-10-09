package org.cloudcog.gears;

import javax.servlet.annotation.WebServlet;

import org.cloudcog.gears.html.WebAccessServlet;

@WebServlet(urlPatterns = "/examples/*", name = "ExamplesUIServlet", asyncSupported = true)
public class ExamplesUI extends WebAccessServlet{
	private static final long serialVersionUID = -5809770891943389496L;

	private static final String FILES_PATH= "/org/cloudcog/gears/html";
	
	@Override
	protected String getFilesPath() {
		return FILES_PATH;
	}

}
