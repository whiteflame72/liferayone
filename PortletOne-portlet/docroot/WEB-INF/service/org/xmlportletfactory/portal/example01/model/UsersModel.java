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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Users service. Represents a row in the &quot;portletone_Users&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.xmlportletfactory.portal.example01.model.impl.UsersModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.xmlportletfactory.portal.example01.model.impl.UsersImpl}.
 * </p>
 *
 * @author Jack A. Rider
 * @see Users
 * @see org.xmlportletfactory.portal.example01.model.impl.UsersImpl
 * @see org.xmlportletfactory.portal.example01.model.impl.UsersModelImpl
 * @generated
 */
public interface UsersModel extends BaseModel<Users> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a users model instance should use the {@link Users} interface instead.
	 */

	/**
	 * Returns the primary key of this users.
	 *
	 * @return the primary key of this users
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this users.
	 *
	 * @param primaryKey the primary key of this users
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the users ID of this users.
	 *
	 * @return the users ID of this users
	 */
	public long getUsersId();

	/**
	 * Sets the users ID of this users.
	 *
	 * @param usersId the users ID of this users
	 */
	public void setUsersId(long usersId);

	/**
	 * Returns the company ID of this users.
	 *
	 * @return the company ID of this users
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this users.
	 *
	 * @param companyId the company ID of this users
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this users.
	 *
	 * @return the group ID of this users
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this users.
	 *
	 * @param groupId the group ID of this users
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this users.
	 *
	 * @return the user ID of this users
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this users.
	 *
	 * @param userId the user ID of this users
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this users.
	 *
	 * @return the user uuid of this users
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this users.
	 *
	 * @param userUuid the user uuid of this users
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this users.
	 *
	 * @return the user name of this users
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this users.
	 *
	 * @param userName the user name of this users
	 */
	public void setUserName(String userName);

	/**
	 * Returns the user photo of this users.
	 *
	 * @return the user photo of this users
	 */
	public long getUserPhoto();

	/**
	 * Sets the user photo of this users.
	 *
	 * @param userPhoto the user photo of this users
	 */
	public void setUserPhoto(long userPhoto);

	/**
	 * Returns the folder d l ID of this users.
	 *
	 * @return the folder d l ID of this users
	 */
	public long getFolderDLId();

	/**
	 * Sets the folder d l ID of this users.
	 *
	 * @param folderDLId the folder d l ID of this users
	 */
	public void setFolderDLId(long folderDLId);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Users users);

	public int hashCode();

	public CacheModel<Users> toCacheModel();

	public Users toEscapedModel();

	public String toString();

	public String toXmlString();
}