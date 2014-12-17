package com.cloudcog.gears.login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.jackrabbit.commons.cnd.ParseException;

import com.cloudcog.gears.AbstractAuthorizableUI;
import com.cloudcog.gears.GearsContext;
import com.cloudcog.gears.login.exception.LoginException;
import com.cloudcog.gears.repository.RepositoryContext;

public class UserSessionHandler {
	private List<ISessionListener> listeners = new ArrayList<ISessionListener>();
	
	public UserSessionHandler() {
		this.addListener((AbstractAuthorizableUI) AbstractAuthorizableUI.getCurrent());
	}
	
	public void loginUser(String username, String password) throws LoginException {
		
		try {
			Session session = RepositoryContext.login(username, password);
			GearsContext.setJcrSession(session);
			this.fireSessionCreatedEvent();
		} catch (javax.jcr.LoginException e) {
			throw new LoginException();
		} catch (RepositoryException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String hash(String s) {
        try {
            MessageDigest m;
            m = MessageDigest.getInstance("MD5");
            m.update(s.getBytes(), 0, s.length());
            return new BigInteger(1, m.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void fireSessionCreatedEvent(){
		for(ISessionListener listener : listeners){
			listener.sessionCreateHandler();
		}
	}
	
	public void fireSessionDeletedEvent(){
		for(ISessionListener listener : listeners){
			listener.sessionDestroyHandler();
		}
	}
	
	public void addListener(ISessionListener listener) {
		this.listeners.add(listener);
	}
}
