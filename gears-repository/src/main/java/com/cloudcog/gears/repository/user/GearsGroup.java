package com.cloudcog.gears.repository.user;

import java.util.ArrayList;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.Value;

import org.apache.jackrabbit.api.security.user.Group;
import org.apache.jackrabbit.value.StringValue;

public class GearsGroup {

	private static final String PERMISSIONS_PROP = "permissions";
	private Group group;

	public GearsGroup(Session session, String groupName) throws RepositoryException {
		this.group = UserDAO.createGroup(session, groupName);
	}

	public GearsGroup(Group group) throws RepositoryException {
		this.group = group;
	}

	public void setPermissions(String... permissions) throws RepositoryException {

		ArrayList<StringValue> values = new ArrayList<StringValue>();
		for (String permission : permissions) {
			values.add(new StringValue(permission));
		}
		this.group.setProperty(PERMISSIONS_PROP, (Value[]) values.toArray());
	}

	public ArrayList<String> getPermissions() throws RepositoryException {

		StringValue[] values = (StringValue[]) this.group.getProperty(PERMISSIONS_PROP);
		ArrayList<String> permissions = new ArrayList<String>();
		for (int i = 0; i < values.length; i++) {
			permissions.add(values[i].getString());
		}
		return permissions;
	}

	public boolean hasPermissions(String... permissions) throws RepositoryException {
		StringValue[] values = (StringValue[]) this.group.getProperty(PERMISSIONS_PROP);
		System.out.println(values.toString());
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < permissions.length; j++) {
				if (values[i].getString().equalsIgnoreCase(permissions[j])) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		try {
			return this.group.getID();
		} catch (RepositoryException e) {
			return super.toString();
		}
	}

	public Group getGroup() {
		return group;
	}
}
