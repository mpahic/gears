package com.cloudcog.gears.repository.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jcr.AccessDeniedException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.UnsupportedRepositoryOperationException;

import org.apache.jackrabbit.api.JackrabbitSession;
import org.apache.jackrabbit.api.security.user.Authorizable;
import org.apache.jackrabbit.api.security.user.AuthorizableExistsException;
import org.apache.jackrabbit.api.security.user.Group;
import org.apache.jackrabbit.api.security.user.User;
import org.apache.jackrabbit.api.security.user.UserManager;

public class UserDAO {

	public static GearsUser getCurrentUser(Session session) throws AccessDeniedException,
			UnsupportedRepositoryOperationException, RepositoryException {
		JackrabbitSession js = (JackrabbitSession) session;
		return new GearsUser((User) js.getUserManager().getAuthorizable(session.getUserID()));
	}

	public static List<GearsUser> getAllUsers(Session session) throws RepositoryException {
		final List<GearsUser> users = new ArrayList<GearsUser>();

		final UserManager userManager = ((JackrabbitSession) session).getUserManager();
		Iterator<Authorizable> iter = userManager.findAuthorizables("jcr:primaryType", "rep:User");

		while (iter.hasNext()) {
			Authorizable auth = iter.next();
			if (!auth.isGroup()) {
				users.add(new GearsUser((User) auth));
			}
		}

		return users;
	}
	
	public static List<Group> getAllGroups(Session session) throws RepositoryException {
		final List<Group> groups = new ArrayList<Group>();

		final UserManager userManager = ((JackrabbitSession) session).getUserManager();
		Iterator<Authorizable> iter = userManager.findAuthorizables("jcr:primaryType", "rep:User");

		while (iter.hasNext()) {
			Authorizable auth = iter.next();
			if (auth.isGroup()) {
				groups.add((Group) auth);
			}
		}

		return groups;
	}
	
	public static List<User> getAllUsersFromGroup(Session session, String groupName) throws AccessDeniedException, UnsupportedRepositoryOperationException, RepositoryException {
		final List<User> members = new ArrayList<User>();
		final UserManager userManager = ((JackrabbitSession) session).getUserManager();
		final Authorizable auth2 = userManager.getAuthorizable(groupName);
		if (auth2.isGroup()) {
			Iterator<Authorizable> iter = ((Group) auth2).getMembers();
			while (iter.hasNext()) {
				Authorizable auth = iter.next();
				if (!auth.isGroup()) {
					members.add((User) auth);
				}
			}
		}
		
		return members;
	}
	
	public static User createUser(Session session, String username, String password) throws AuthorizableExistsException, RepositoryException {
		final User user = ((JackrabbitSession) session).getUserManager().createUser(username, password);
		session.save();
		return user;
	}
	
	public static Group createGroup(Session session, String groupName) throws AuthorizableExistsException, RepositoryException {
		final Group group = ((JackrabbitSession) session).getUserManager().createGroup(groupName);
		session.save();
		return group;
	}
	
	public static void addUserToGroup(Session session, Group group, User user) throws AuthorizableExistsException, RepositoryException {
		group.addMember(user);
		session.save();
	}
	
	public static void removeUser(Session session, String username) throws AccessDeniedException, UnsupportedRepositoryOperationException, RepositoryException {
		final UserManager userManager = ((JackrabbitSession) session).getUserManager();
		final User user = (User) userManager.getAuthorizable(username);
		user.remove();
		session.save();
	}
}
