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

import org.xmlportletfactory.portal.example01.service.PortletOneLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Jack A. Rider
 */
public class PortletOneClp extends BaseModelImpl<PortletOne>
	implements PortletOne {
	public PortletOneClp() {
	}

	public Class<?> getModelClass() {
		return PortletOne.class;
	}

	public String getModelClassName() {
		return PortletOne.class.getName();
	}

	public long getPrimaryKey() {
		return _PortletOneId;
	}

	public void setPrimaryKey(long primaryKey) {
		setPortletOneId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_PortletOneId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getPortletOneDescription() {
		return _PortletOneDescription;
	}

	public void setPortletOneDescription(String PortletOneDescription) {
		_PortletOneDescription = PortletOneDescription;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PortletOneLocalServiceUtil.addPortletOne(this);
		}
		else {
			PortletOneLocalServiceUtil.updatePortletOne(this);
		}
	}

	@Override
	public PortletOne toEscapedModel() {
		return (PortletOne)Proxy.newProxyInstance(PortletOne.class.getClassLoader(),
			new Class[] { PortletOne.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PortletOneClp clone = new PortletOneClp();

		clone.setPortletOneId(getPortletOneId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setPortletOneDescription(getPortletOneDescription());

		return clone;
	}

	public int compareTo(PortletOne portletOne) {
		long primaryKey = portletOne.getPrimaryKey();

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

		PortletOneClp portletOne = null;

		try {
			portletOne = (PortletOneClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = portletOne.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{PortletOneId=");
		sb.append(getPortletOneId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", PortletOneDescription=");
		sb.append(getPortletOneDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("org.xmlportletfactory.portal.example01.model.PortletOne");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>PortletOneId</column-name><column-value><![CDATA[");
		sb.append(getPortletOneId());
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
			"<column><column-name>PortletOneDescription</column-name><column-value><![CDATA[");
		sb.append(getPortletOneDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _PortletOneId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _PortletOneDescription;
}