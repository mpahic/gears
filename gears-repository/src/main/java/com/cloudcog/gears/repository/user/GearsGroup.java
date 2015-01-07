package com.cloudcog.gears.repository.user;

import java.security.Permission;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.jackrabbit.api.security.user.Group;

public class GearsGroup {

	private Group group;

	public GearsGroup(Session session, String groupName) throws RepositoryException {
		this.group = UserDAO.createGroup(session, groupName);
	}

	public GearsGroup(Group group) throws RepositoryException {
		this.group = group;
	}

	private void addPermission(Permission... permission) {

	}

	@Override
	public String toString() {
		try {
			return this.group.getID();
		} catch (RepositoryException e) {
			return super.toString();
		}
	}
}
