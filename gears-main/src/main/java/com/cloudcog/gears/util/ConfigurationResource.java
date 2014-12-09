package com.cloudcog.gears.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.PropertyResourceBundle;


import com.vaadin.server.VaadinServlet;

/**
 * Singleton class that instanciates itself when retrieving any of its values
 * @author mpahic
 *
 */
public class ConfigurationResource {
//	private static Logger log = Logger.getLogger(ConfigurationResource.class);
	
	private static ConfigurationResource instance;
	
	private String databaseName;
	private String databaseHost;
	private String databasePort;
	private String databaseUsername;
	private String databasePassword;
	
	private ConfigurationResource() {
		File confFile = new File(System.getProperty("catalina.base") + "\\conf\\" + VaadinServlet.getCurrent().getServletContext().getServletContextName() + ".properties");
//		log.info("Finding conf file in " + confFile.getAbsolutePath());
		
		if(!confFile.exists()) {
//			log.info("Conf file does not exist, creating one");
			createConfFile(confFile);
		}
		
		try {
			populateValues(new PropertyResourceBundle(new FileInputStream(confFile)));
		} catch (FileNotFoundException e) {
//			log.error(e.getMessage(), e);
		} catch (IOException e) {
//			log.error(e.getMessage(), e);
		}
		
	}
	
	private void populateValues(PropertyResourceBundle bundle) {
		Enumeration<String> bundleEnumeration = bundle.getKeys();
		while(bundleEnumeration.hasMoreElements()){
			String key = bundleEnumeration.nextElement();
			String value = (String) bundle.getObject(key);
			if(key.equals("database.name")) {
				databaseName = value;
			} else if(key.equals("database.host")) {
				databaseHost = value;
			} else if(key.equals("database.port")) {
				databasePort = value;
			} else if(key.equals("database.username")) {
				databaseUsername = value;
			} else if(key.equals("database.password")) {
				databasePassword = value;
			}
		}
	}
	
	private void createConfFile(File confFile){
		InputStream fileStream = VaadinServlet.getCurrent().getServletContext().getResourceAsStream("gear.properties");
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(confFile);
			int read = 0;
			byte[] bytes = new byte[1024];
	 
			while ((read = fileStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			outputStream.close();
		} catch(Exception e) {
//			log.error("Unable to copy configuration file.", e);
		}
	}
	
	private static void checkInstance(){
		if(instance == null) {
//			log.info("Creating new configuration instance");
			instance = new ConfigurationResource();
		}
	}
	
	public static String getDatabaseName(){
		checkInstance();
		return instance.databaseName;
	}
	
	public static String getDatabaseHost(){
		checkInstance();
		return instance.databaseHost;
	}
	
	public static String getDatabasePort(){
		checkInstance();
		return instance.databasePort;
	}
	
	public static String getDatabaseUsername(){
		checkInstance();
		return instance.databaseUsername;
	}
	
	public static String getDatabasePassword(){
		checkInstance();
		return instance.databasePassword;
	}
}
