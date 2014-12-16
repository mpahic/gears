package com.cloudcog.gears.repository.user;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.jcr.LoginException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.jackrabbit.commons.cnd.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cloudcog.gears.repository.RepositoryContext;
import com.cloudcog.gears.repository.user.GearsUser.Gender;

public class UserTest {

	private Session session;
	
	@Before
	public void before() throws LoginException, RepositoryException, FileNotFoundException, ParseException, IOException {
		session = RepositoryContext.login("admin", "admin");
	}
	
	@Test
	public void creationTest() throws RepositoryException {

		GearsUser user = new GearsUser(session, "mpahic", "mpahic");
		user.setFirstName("Marko");
		user.setLastName("Pahić");
		user.setGender(Gender.MALE);
		
		Assert.assertEquals("Marko", user.getFirstName());
		Assert.assertEquals("Pahić", user.getLastName());
		Assert.assertEquals(Gender.MALE, user.getGender());
		UserDAO.removeUser(session, user.getUsername());
	}
	
	@Test
	public void creationNullValuesTest() throws RepositoryException {
		
		GearsUser user = new GearsUser(session, "mpahic", "mpahic");
		
		Assert.assertEquals("", user.getFirstName());
		Assert.assertEquals("", user.getLastName());
		Assert.assertEquals(null, user.getGender());
		UserDAO.removeUser(session, user.getUsername());
	}

}
