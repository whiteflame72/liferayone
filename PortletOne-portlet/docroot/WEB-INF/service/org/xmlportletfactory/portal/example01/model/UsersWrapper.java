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

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Users}.
 * </p>
 *
 * @author    Jack A. Rider
 * @see       Users
 * @generated
 */
public class UsersWrapper implements Users, ModelWrapper<Users> {
	public UsersWrapper(Users users) {
		_users = users;
	}

	public Class<?> getModelClass() {
		return Users.class;
	}

	public String getModelClassName() {
		return Users.class.getName();
	}

	/**
	* Returns the primary key of this users.
	*
	* @return the primary key of this users
	*/
	public long getPrimaryKey() {
		return _users.getPrimaryKey();
	}

	/**
	* Sets the primary key of this users.
	*
	* @param primaryKey the primary key of this users
	*/
	public void setPrimaryKey(long primaryKey) {
		_users.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the users ID of this users.
	*
	* @return the users ID of this users
	*/
	public long getUsersId() {
		return _users.getUsersId();
	}

	/**
	* Sets the users ID of this users.
	*
	* @param usersId the users ID of this users
	*/
	public void setUsersId(long usersId) {
		_users.setUsersId(usersId);
	}

	/**
	* Returns the company ID of this users.
	*
	* @return the company ID of this users
	*/
	public long getCompanyId() {
		return _users.getCompanyId();
	}

	/**
	* Sets the company ID of this users.
	*
	* @param companyId the company ID of this users
	*/
	public void setCompanyId(long companyId) {
		_users.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this users.
	*
	* @return the group ID of this users
	*/
	public long getGroupId() {
		return _users.getGroupId();
	}

	/**
	* Sets the group ID of this users.
	*
	* @param groupId the group ID of this users
	*/
	public void setGroupId(long groupId) {
		_users.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this users.
	*
	* @return the user ID of this users
	*/
	public long getUserId() {
		return _users.getUserId();
	}

	/**
	* Sets the user ID of this users.
	*
	* @param userId the user ID of this users
	*/
	public void setUserId(long userId) {
		_users.setUserId(userId);
	}

	/**
	* Returns the user uuid of this users.
	*
	* @return the user uuid of this users
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _users.getUserUuid();
	}

	/**
	* Sets the user uuid of this users.
	*
	* @param userUuid the user uuid of this users
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_users.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this users.
	*
	* @return the user name of this users
	*/
	public java.lang.String getUserName() {
		return _users.getUserName();
	}

	/**
	* Sets the user name of this users.
	*
	* @param userName the user name of this users
	*/
	public void setUserName(java.lang.String userName) {
		_users.setUserName(userName);
	}

	/**
	* Returns the user photo of this users.
	*
	* @return the user photo of this users
	*/
	public long getUserPhoto() {
		return _users.getUserPhoto();
	}

	/**
	* Sets the user photo of this users.
	*
	* @param userPhoto the user photo of this users
	*/
	public void setUserPhoto(long userPhoto) {
		_users.setUserPhoto(userPhoto);
	}

	/**
	* Returns the folder d l ID of this users.
	*
	* @return the folder d l ID of this users
	*/
	public long getFolderDLId() {
		return _users.getFolderDLId();
	}

	/**
	* Sets the folder d l ID of this users.
	*
	* @param folderDLId the folder d l ID of this users
	*/
	public void setFolderDLId(long folderDLId) {
		_users.setFolderDLId(folderDLId);
	}

	public boolean isNew() {
		return _users.isNew();
	}

	public void setNew(boolean n) {
		_users.setNew(n);
	}

	public boolean isCachedModel() {
		return _users.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_users.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _users.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _users.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_users.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _users.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_users.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UsersWrapper((Users)_users.clone());
	}

	public int compareTo(Users users) {
		return _users.compareTo(users);
	}

	@Override
	public int hashCode() {
		return _users.hashCode();
	}

	public com.liferay.portal.model.CacheModel<Users> toCacheModel() {
		return _users.toCacheModel();
	}

	public Users toEscapedModel() {
		return new UsersWrapper(_users.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _users.toString();
	}

	public java.lang.String toXmlString() {
		return _users.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_users.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Users getWrappedUsers() {
		return _users;
	}

	public Users getWrappedModel() {
		return _users;
	}

	public void resetOriginalValues() {
		_users.resetOriginalValues();
	}

	private Users _users;
}