/**
 *     Copyright (C) 2009-2012  Jack A. Rider All rights reserved.
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 */
 
 package org.xmlportletfactory.portal.example01.service.impl;

import java.util.List;

import org.xmlportletfactory.portal.example01.NoSuchPortletOneException;
import org.xmlportletfactory.portal.example01.model.PortletOne;
import org.xmlportletfactory.portal.example01.service.base.PortletOneLocalServiceBaseImpl;
import org.xmlportletfactory.portal.example01.service.persistence.PortletOneUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.dao.orm.QueryUtil;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Jack A. Rider
 * @author Juan Gonzalez P.
 */
public class PortletOneLocalServiceImpl extends PortletOneLocalServiceBaseImpl {

	@SuppressWarnings("unchecked")
	public List findAllInUser(long userId)throws SystemException {
		List<PortletOne> list = (List<PortletOne>) PortletOneUtil.findByUserId(userId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUser(long userId, OrderByComparator orderByComparator) throws SystemException {
		List<PortletOne> list = (List<PortletOne>) PortletOneUtil.findByUserId(userId, QueryUtil.ALL_POS,QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInGroup(long groupId) throws SystemException {
		List<PortletOne> list = (List<PortletOne>) PortletOneUtil.findByGroupId(groupId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInGroup(long groupId, OrderByComparator orderByComparator) throws SystemException{
		List <PortletOne> list = (List<PortletOne>) PortletOneUtil.findByGroupId(groupId,QueryUtil.ALL_POS,QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUserAndGroup(long userId, long groupId) throws SystemException {
		List<PortletOne> list = (List<PortletOne>) PortletOneUtil.findByUserIdGroupId(userId, groupId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUserAndGroup(long userId, long groupId, OrderByComparator orderByComparator) throws SystemException {
		List<PortletOne> list = (List<PortletOne>) PortletOneUtil.findByUserIdGroupId(userId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
		return list;
	}
	




	public PortletOne addPortletOne (PortletOne validPortletOne) throws SystemException {
	    PortletOne fileobj = portletOnePersistence.create(CounterLocalServiceUtil.increment(PortletOne.class.getName()));

	    fileobj.setCompanyId(validPortletOne.getCompanyId());
	    fileobj.setGroupId(validPortletOne.getGroupId());
	    fileobj.setUserId(validPortletOne.getUserId());

	    fileobj.setPortletOneDescription(validPortletOne.getPortletOneDescription());
		return portletOnePersistence.update(fileobj, false);
	}

	public void remove(PortletOne fileobj) throws SystemException {

		portletOnePersistence.remove(fileobj);
	}
	
}