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

package org.xmlportletfactory.portal.example01.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.xmlportletfactory.portal.example01.service.UsersLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Jack A. Rider
 */
public class UsersClp extends BaseModelImpl<Users> implements Users {
	public UsersClp() {
	}

	public Class<?> getModelClass() {
		return Users.class;
	}

	public String getModelClassName() {
		return Users.class.getName();
	}

	public long getPrimaryKey() {
		return _usersId;
	}

	public void setPrimaryKey(long primaryKey) {
		setUsersId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_usersId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getUsersId() {
		return _usersId;
	}

	public void setUsersId(long usersId) {
		_usersId = usersId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public long getUserPhoto() {
		return _userPhoto;
	}

	public void setUserPhoto(long userPhoto) {
		_userPhoto = userPhoto;
	}

	public long getFolderDLId() {
		return _folderDLId;
	}

	public void setFolderDLId(long folderDLId) {
		_folderDLId = folderDLId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			UsersLocalServiceUtil.addUsers(this);
		}
		else {
			UsersLocalServiceUtil.updateUsers(this);
		}
	}

	@Override
	public Users toEscapedModel() {
		return (Users)Proxy.newProxyInstance(Users.class.getClassLoader(),
			new Class[] { Users.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UsersClp clone = new UsersClp();

		clone.setUsersId(getUsersId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setUserPhoto(getUserPhoto());
		clone.setFolderDLId(getFolderDLId());

		return clone;
	}

	public int compareTo(Users users) {
		long primaryKey = users.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		UsersClp users = null;

		try {
			users = (UsersClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = users.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{usersId=");
		sb.append(getUsersId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", userPhoto=");
		sb.append(getUserPhoto());
		sb.append(", folderDLId=");
		sb.append(getFolderDLId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("org.xmlportletfactory.portal.example01.model.Users");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>usersId</column-name><column-value><![CDATA[");
		sb.append(getUsersId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userPhoto</column-name><column-value><![CDATA[");
		sb.append(getUserPhoto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folderDLId</column-name><column-value><![CDATA[");
		sb.append(getFolderDLId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _usersId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private long _userPhoto;
	private long _folderDLId;
}