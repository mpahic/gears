package com.cloudcog.gears.security;

import java.util.ArrayList;
import java.util.List;

public class Permission {

	private String permission;
	private List<Permission> children;

	public Permission(String permission) {
		this.permission = permission;
	}

	public Permission addChildPermission(String permission) {
		Permission newPermission = new Permission(permission);
		if (children == null) {
			children = new ArrayList<Permission>();
		}
		children.add(newPermission);
		return newPermission;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof String || obj instanceof Permission) {
			return this.permission.equals(obj.toString());
		}
		return false;
	}

	@Override
	public String toString() {
		return this.permission;
	}
}
