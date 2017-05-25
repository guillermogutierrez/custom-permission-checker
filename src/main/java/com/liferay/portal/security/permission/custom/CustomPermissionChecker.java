package com.liferay.portal.security.permission.custom;

import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.ProxyFactory;
import com.liferay.portal.security.permission.AdvancedPermissionChecker;

public class CustomPermissionChecker extends AdvancedPermissionChecker {

    @Override
    public CustomPermissionChecker clone() {

	System.out.println("Created a clone using my custom permission checker implementation!!!");
	return new CustomPermissionChecker();
    }

    @Override
    public boolean hasPermission(long groupId, String name, String primKey, String actionId) {

	JournalArticleLocalService osgiService = ProxyFactory
		.newServiceTrackedInstance(JournalArticleLocalService.class);

	try {

	    Group guestGroup = GroupLocalServiceUtil.getGroup(groupId);

	    osgiService.getArticlesCount(groupId);

	    System.out.println("Group with the groupId " + groupId + " cointains "
		    + osgiService.getArticlesCount(groupId) + " articles");
	    System.out.println("Using my custom permission checker implementation for the group " + groupId
		    + guestGroup.getFriendlyURL());

	} catch (PortalException e) {

	    System.out.println("Error using my custom permission checker implementation!!!" + e.getMessage());
	}

	System.out.println("Using my custom permission checker implementation!!!");

	return super.hasPermission(groupId, name, primKey, actionId);
    }

}
