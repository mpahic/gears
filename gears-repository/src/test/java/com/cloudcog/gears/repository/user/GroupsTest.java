package com.cloudcog.gears.repository.user;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.jcr.LoginException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.jackrabbit.commons.cnd.ParseException;
import org.junit.After;
import org.junit.Before;

import com.cloudcog.gears.repository.RepositoryContext;
import com.cloudcog.gears.repository.user.GearsUser.Gender;

public class GroupsTest {

	private Session session;
	private GearsUser user;

	@Before
	public void before() throws LoginException, RepositoryException, FileNotFoundException, ParseException, IOException {
		session = RepositoryContext.login("admin", "admin");

		user = new GearsUser(session, "TestCreationUser3", "TestCreationUser3");
		user.setFirstName("TestUser");
		user.setLastName("TestUserLastName");
		user.setGender(Gender.MALE);
	}

	// @Test
	// public void creationTest() throws RepositoryException {
	//
	// GearsGroup group = new GearsGroup(session, "testGroup2");
	// UserDAO.addUserToGroup(session, group, user);
	//
	// group.setPermissions("PERMISSION 1", "Permission 2", "Permission 3");
	// session.save();
	//
	// Assert.assertTrue(UserDAO.userHasPermission(session, user,
	// "Permission 2"));
	//
	// UserDAO.removeGroup(session, group.getGroup().getID());
	//
	// }

	@After
	public void after() throws LoginException, RepositoryException, FileNotFoundException, ParseException, IOException {

		UserDAO.removeUser(session, user.getUsername());
	}

}
