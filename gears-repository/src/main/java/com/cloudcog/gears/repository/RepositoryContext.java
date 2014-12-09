package com.cloudcog.gears.repository;

import javax.jcr.GuestCredentials;
import javax.jcr.LoginException;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.apache.jackrabbit.commons.JcrUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RepositoryContext {
	
	private static final Logger log = LoggerFactory.getLogger(RepositoryContext.class);

	private static Repository repository;

	public static Session login(String username, String password) throws LoginException, RepositoryException {
		log.info("Logging user: " + username);
		return RepositoryContext.getRepository().login(new SimpleCredentials(username, password.toCharArray())); 
	}
	
	public static Repository getRepository() throws RepositoryException {
		if(repository == null) {
			repository = JcrUtils.getRepository();
		}
		return repository;
	}

	public static Session createAnonymusSession() throws LoginException, RepositoryException {
		log.info("Using guest credentials");
		return repository.login(new GuestCredentials());
	}
	
}
