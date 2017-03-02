package com.liferay.portal.security.permission.custom;

import com.liferay.portal.security.permission.AdvancedPermissionChecker;

public class CustomPermissionChecker extends AdvancedPermissionChecker {

	@Override
	public CustomPermissionChecker clone() {
		System.out.println("Created a clone using my custom permission checker implementation!!!");
		return new CustomPermissionChecker();
	}
	
	@Override
	public boolean hasPermission(long groupId, String name, String primKey, String actionId) {
		System.out.println("Using my custom permission checker implementation!!!");
		return super.hasPermission(groupId, name, primKey, actionId);
	}
}
