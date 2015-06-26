/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.xmlportletfactory.portal.example01.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.xmlportletfactory.portal.example01.model.Users;

import java.io.Serializable;

/**
 * The cache model class for representing Users in entity cache.
 *
 * @author Jack A. Rider
 * @see Users
 * @generated
 */
public class UsersCacheModel implements CacheModel<Users>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{usersId=");
		sb.append(usersId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", userPhoto=");
		sb.append(userPhoto);
		sb.append(", folderDLId=");
		sb.append(folderDLId);
		sb.append("}");

		return sb.toString();
	}

	public Users toEntityModel() {
		UsersImpl usersImpl = new UsersImpl();

		usersImpl.setUsersId(usersId);
		usersImpl.setCompanyId(companyId);
		usersImpl.setGroupId(groupId);
		usersImpl.setUserId(userId);

		if (userName == null) {
			usersImpl.setUserName(StringPool.BLANK);
		}
		else {
			usersImpl.setUserName(userName);
		}

		usersImpl.setUserPhoto(userPhoto);
		usersImpl.setFolderDLId(folderDLId);

		usersImpl.resetOriginalValues();

		return usersImpl;
	}

	public long usersId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long userPhoto;
	public long folderDLId;
}