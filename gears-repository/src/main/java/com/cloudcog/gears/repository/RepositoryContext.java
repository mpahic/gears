package com.cloudcog.gears.repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.jcr.GuestCredentials;
import javax.jcr.LoginException;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.apache.jackrabbit.commons.cnd.CndImporter;
import org.apache.jackrabbit.commons.cnd.ParseException;
import org.apache.jackrabbit.core.TransientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RepositoryContext {
	
	private static final Logger log = LoggerFactory.getLogger(RepositoryContext.class);

	private static Repository repository;
	private static Session anonymousSession;

	public static Session login(String username, String password) throws LoginException, RepositoryException, FileNotFoundException, ParseException, IOException {
		log.info("Logging user: " + username);
		
		Session session = RepositoryContext.getRepository().login(new SimpleCredentials(username, password.toCharArray()));
		CndImporter.registerNodeTypes(new FileReader("src/main/java/com/cloudcog/gears/repository/data/nodeTypes.cnd"),session);
		
		return session; 
	}
	
	public static Repository getRepository() throws RepositoryException {
		if(repository == null) {
			repository = new TransientRepository();
		}
		return repository;
	}

	public static Session createAnonymusSession() throws LoginException, RepositoryException {
		log.info("Using guest credentials");
		if(anonymousSession == null) {
			anonymousSession = repository.login(new GuestCredentials());
		}
		return anonymousSession;
	}
	
}
