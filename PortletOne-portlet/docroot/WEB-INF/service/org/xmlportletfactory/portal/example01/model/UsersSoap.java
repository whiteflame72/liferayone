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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Jack A. Rider
 * @generated
 */
public class UsersSoap implements Serializable {
	public static UsersSoap toSoapModel(Users model) {
		UsersSoap soapModel = new UsersSoap();

		soapModel.setUsersId(model.getUsersId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setUserPhoto(model.getUserPhoto());
		soapModel.setFolderDLId(model.getFolderDLId());

		return soapModel;
	}

	public static UsersSoap[] toSoapModels(Users[] models) {
		UsersSoap[] soapModels = new UsersSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UsersSoap[][] toSoapModels(Users[][] models) {
		UsersSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UsersSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UsersSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UsersSoap[] toSoapModels(List<Users> models) {
		List<UsersSoap> soapModels = new ArrayList<UsersSoap>(models.size());

		for (Users model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UsersSoap[soapModels.size()]);
	}

	public UsersSoap() {
	}

	public long getPrimaryKey() {
		return _usersId;
	}

	public void setPrimaryKey(long pk) {
		setUsersId(pk);
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

	private long _usersId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private long _userPhoto;
	private long _folderDLId;
}