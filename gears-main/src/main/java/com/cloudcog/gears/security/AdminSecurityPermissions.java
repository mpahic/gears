package com.cloudcog.gears.security;

public class AdminSecurityPermissions {
	public static final String ADMIN_PERMISSIONS = "ADMIN_PERMISSIONS";
	public static final String ADMIN_USER_READ = "ADMIN_USER_READ";
	public static final String ADMIN_USER_EDIT = "ADMIN_USER_EDIT";
	public static final String ADMIN_USER_PERMISSION_VIEW = "ADMIN_USER_PERMISSION_VIEW";
	public static final String ADMIN_USER_PERMISSION_EDIT = "ADMIN_USER_PERMISSION_EDIT";

	public static final String ADMIN_GROUP_READ = "ADMIN_GROUP_READ";
	public static final String ADMIN_GROUP_EDIT = "ADMIN_GROUP_EDIT";
	public static final String ADMIN_GROUP_PERMISSION_VIEW = "ADMIN_GROUP_PERMISSION_VIEW";
	public static final String ADMIN_GROUP_PERMISSION_EDIT = "ADMIN_GROUP_PERMISSION_EDIT";

	public static final String ADMIN_MODULE_READ = "ADMIN_MODULE_READ";
	public static final String ADMIN_MODULE_EDIT = "ADMIN_MODULE_EDIT";

	public static Permission getSecurityPermission() {
		Permission adminPermissions = new Permission(ADMIN_PERMISSIONS);
		Permission readUser = adminPermissions.addChildPermission(ADMIN_USER_READ);
		readUser.addChildPermission(ADMIN_USER_EDIT);

		Permission readGroup = adminPermissions.addChildPermission(ADMIN_GROUP_READ);
		readGroup.addChildPermission(ADMIN_GROUP_EDIT);

		return adminPermissions;
	}
}
