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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.xmlportletfactory.portal.example01.model.Users;
import org.xmlportletfactory.portal.example01.model.UsersModel;

import java.io.Serializable;

import java.sql.Types;

/**
 * The base model implementation for the Users service. Represents a row in the &quot;portletone_Users&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.xmlportletfactory.portal.example01.model.UsersModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UsersImpl}.
 * </p>
 *
 * @author Jack A. Rider
 * @see UsersImpl
 * @see org.xmlportletfactory.portal.example01.model.Users
 * @see org.xmlportletfactory.portal.example01.model.UsersModel
 * @generated
 */
public class UsersModelImpl extends BaseModelImpl<Users> implements UsersModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a users model instance should use the {@link org.xmlportletfactory.portal.example01.model.Users} interface instead.
	 */
	public static final String TABLE_NAME = "portletone_Users";
	public static final Object[][] TABLE_COLUMNS = {
			{ "usersId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "userPhoto", Types.BIGINT },
			{ "folderDLId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table portletone_Users (usersId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,userPhoto LONG,folderDLId LONG)";
	public static final String TABLE_SQL_DROP = "drop table portletone_Users";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.xmlportletfactory.portal.example01.model.Users"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.xmlportletfactory.portal.example01.model.Users"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.xmlportletfactory.portal.example01.model.Users"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long USERID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.xmlportletfactory.portal.example01.model.Users"));

	public UsersModelImpl() {
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

	public Class<?> getModelClass() {
		return Users.class;
	}

	public String getModelClassName() {
		return Users.class.getName();
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
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Users toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Users)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					Users.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		UsersImpl usersImpl = new UsersImpl();

		usersImpl.setUsersId(getUsersId());
		usersImpl.setCompanyId(getCompanyId());
		usersImpl.setGroupId(getGroupId());
		usersImpl.setUserId(getUserId());
		usersImpl.setUserName(getUserName());
		usersImpl.setUserPhoto(getUserPhoto());
		usersImpl.setFolderDLId(getFolderDLId());

		usersImpl.resetOriginalValues();

		return usersImpl;
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

		Users users = null;

		try {
			users = (Users)obj;
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
	public void resetOriginalValues() {
		UsersModelImpl usersModelImpl = this;

		usersModelImpl._originalGroupId = usersModelImpl._groupId;

		usersModelImpl._setOriginalGroupId = false;

		usersModelImpl._originalUserId = usersModelImpl._userId;

		usersModelImpl._setOriginalUserId = false;

		usersModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Users> toCacheModel() {
		UsersCacheModel usersCacheModel = new UsersCacheModel();

		usersCacheModel.usersId = getUsersId();

		usersCacheModel.companyId = getCompanyId();

		usersCacheModel.groupId = getGroupId();

		usersCacheModel.userId = getUserId();

		usersCacheModel.userName = getUserName();

		String userName = usersCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			usersCacheModel.userName = null;
		}

		usersCacheModel.userPhoto = getUserPhoto();

		usersCacheModel.folderDLId = getFolderDLId();

		return usersCacheModel;
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

	private static ClassLoader _classLoader = Users.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Users.class
		};
	private long _usersId;
	private long _companyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private long _userPhoto;
	private long _folderDLId;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private Users _escapedModelProxy;
}