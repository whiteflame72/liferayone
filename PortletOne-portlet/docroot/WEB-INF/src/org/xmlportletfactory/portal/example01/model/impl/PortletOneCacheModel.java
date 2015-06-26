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

import org.xmlportletfactory.portal.example01.model.PortletOne;

import java.io.Serializable;

/**
 * The cache model class for representing PortletOne in entity cache.
 *
 * @author Jack A. Rider
 * @see PortletOne
 * @generated
 */
public class PortletOneCacheModel implements CacheModel<PortletOne>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{PortletOneId=");
		sb.append(PortletOneId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", PortletOneDescription=");
		sb.append(PortletOneDescription);
		sb.append("}");

		return sb.toString();
	}

	public PortletOne toEntityModel() {
		PortletOneImpl portletOneImpl = new PortletOneImpl();

		portletOneImpl.setPortletOneId(PortletOneId);
		portletOneImpl.setCompanyId(companyId);
		portletOneImpl.setGroupId(groupId);
		portletOneImpl.setUserId(userId);

		if (PortletOneDescription == null) {
			portletOneImpl.setPortletOneDescription(StringPool.BLANK);
		}
		else {
			portletOneImpl.setPortletOneDescription(PortletOneDescription);
		}

		portletOneImpl.resetOriginalValues();

		return portletOneImpl;
	}

	public long PortletOneId;
	public long companyId;
	public long groupId;
	public long userId;
	public String PortletOneDescription;
}