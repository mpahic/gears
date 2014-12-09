package com.cloudcog.gears;

import javax.jcr.LoginException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import com.cloudcog.gears.repository.RepositoryContext;
import com.vaadin.server.VaadinService;

public class GearsContext {
	
	private static final String SESSION_PARAM = "jcrSession";

	public static Session getJcrSession() throws LoginException, RepositoryException {
		Session session = (Session) VaadinService.getCurrentRequest().getWrappedSession().getAttribute(SESSION_PARAM);
		if(session == null) {
			session = RepositoryContext.createAnonymusSession();
			VaadinService.getCurrentRequest().getWrappedSession().setAttribute(SESSION_PARAM, session);
		}
		return session;
	}
	
	public static void setJcrSession(Session session) {
		Session existingSession = (Session) VaadinService.getCurrentRequest().getWrappedSession().getAttribute(SESSION_PARAM);
		if(existingSession != null) {
			existingSession.logout();
		}
		VaadinService.getCurrentRequest().getWrappedSession().setAttribute(SESSION_PARAM, session);
		
	}
	
}
