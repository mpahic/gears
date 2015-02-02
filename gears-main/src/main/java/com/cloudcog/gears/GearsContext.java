package com.cloudcog.gears;

import java.util.Locale;

import javax.jcr.LoginException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import com.cloudcog.gears.controller.services.ModuleService;
import com.cloudcog.gears.controller.services.impl.ModuleServiceImpl;
import com.cloudcog.gears.repository.RepositoryContext;
import com.cloudcog.gears.repository.user.UserDAO;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinSession;

public class GearsContext {

	private static final String SESSION_PARAM = "jcrSession";

	private static ModuleService moduleService;

	public static void destroyJcrSession() {
		Session session = (Session) VaadinService.getCurrentRequest().getWrappedSession().getAttribute(SESSION_PARAM);
		if (session != null) {
			session.logout();
			VaadinService.getCurrentRequest().getWrappedSession().removeAttribute(SESSION_PARAM);
		}
	}

	public static Session getJcrSession() throws LoginException, RepositoryException {
		Session session = (Session) VaadinService.getCurrentRequest().getWrappedSession().getAttribute(SESSION_PARAM);
		if (session == null) {
			session = RepositoryContext.createAnonymusSession();
			VaadinService.getCurrentRequest().getWrappedSession().setAttribute(SESSION_PARAM, session);
		}
		return session;
	}

	public static Boolean isAuthorized() {
		Session session = (Session) VaadinService.getCurrentRequest().getWrappedSession().getAttribute(SESSION_PARAM);
		if (session == null || UserDAO.ANONIMOUS_USER.equals(session.getUserID())) {
			return false;
		} else {
			return true;
		}
	}

	public static void setJcrSession(Session session) {
		Session existingSession = (Session) VaadinService.getCurrentRequest().getWrappedSession().getAttribute(SESSION_PARAM);
		if (existingSession != null) {
			existingSession.logout();
		}
		VaadinService.getCurrentRequest().getWrappedSession().setAttribute(SESSION_PARAM, session);
	}

	public static Locale getSessionLocale() {
		return VaadinSession.getCurrent().getLocale();
	}

	public static ModuleService getModuleService() {
		if (moduleService == null) {
			moduleService = new ModuleServiceImpl();
		}
		return moduleService;
	}

}
