package com.cloudcog.gears.util;


import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;

public class DataResources {
//	private static Logger log = Logger.getLogger(DataResources.class);
	
	private static JDBCConnectionPool pool;

	public static JDBCConnectionPool getConnectionPool() throws Exception {

		if(pool == null) {
		String connectionInfo = "jdbc:mysql://"+ConfigurationResource.getDatabaseHost()+":"+ConfigurationResource.getDatabasePort()+"/" + ConfigurationResource.getDatabaseName();
//		log.debug("Trying to connect to: " + connectionInfo + " with username: " 
//		+ ConfigurationResource.getDatabaseUsername() + " and password: " + ConfigurationResource.getDatabasePassword());
		
			pool = new SimpleJDBCConnectionPool(
		        "com.mysql.jdbc.Driver",
		        connectionInfo, ConfigurationResource.getDatabaseUsername(), ConfigurationResource.getDatabasePassword(), 2, 5);
		}
		return pool;
	}
	
}
