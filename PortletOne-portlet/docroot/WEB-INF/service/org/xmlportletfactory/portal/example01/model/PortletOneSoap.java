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
public class PortletOneSoap implements Serializable {
	public static PortletOneSoap toSoapModel(PortletOne model) {
		PortletOneSoap soapModel = new PortletOneSoap();

		soapModel.setPortletOneId(model.getPortletOneId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setPortletOneDescription(model.getPortletOneDescription());

		return soapModel;
	}

	public static PortletOneSoap[] toSoapModels(PortletOne[] models) {
		PortletOneSoap[] soapModels = new PortletOneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PortletOneSoap[][] toSoapModels(PortletOne[][] models) {
		PortletOneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PortletOneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PortletOneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PortletOneSoap[] toSoapModels(List<PortletOne> models) {
		List<PortletOneSoap> soapModels = new ArrayList<PortletOneSoap>(models.size());

		for (PortletOne model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PortletOneSoap[soapModels.size()]);
	}

	public PortletOneSoap() {
	}

	public long getPrimaryKey() {
		return _PortletOneId;
	}

	public void setPrimaryKey(long pk) {
		setPortletOneId(pk);
	}

	public long getPortletOneId() {
		return _PortletOneId;
	}

	public void setPortletOneId(long PortletOneId) {
		_PortletOneId = PortletOneId;
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

	public String getPortletOneDescription() {
		return _PortletOneDescription;
	}

	public void setPortletOneDescription(String PortletOneDescription) {
		_PortletOneDescription = PortletOneDescription;
	}

	private long _PortletOneId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _PortletOneDescription;
}