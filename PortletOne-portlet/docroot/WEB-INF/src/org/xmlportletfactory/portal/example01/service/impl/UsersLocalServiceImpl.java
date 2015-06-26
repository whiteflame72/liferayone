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

import org.xmlportletfactory.portal.example01.NoSuchUsersException;
import org.xmlportletfactory.portal.example01.model.Users;
import org.xmlportletfactory.portal.example01.service.base.UsersLocalServiceBaseImpl;
import org.xmlportletfactory.portal.example01.service.persistence.UsersUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.dao.orm.QueryUtil;

import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Jack A. Rider
 * @author Juan Gonzalez P.
 */
public class UsersLocalServiceImpl extends UsersLocalServiceBaseImpl {

	@SuppressWarnings("unchecked")
	public List findAllInUser(long userId)throws SystemException {
		List<Users> list = (List<Users>) UsersUtil.findByUserId(userId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUser(long userId, OrderByComparator orderByComparator) throws SystemException {
		List<Users> list = (List<Users>) UsersUtil.findByUserId(userId, QueryUtil.ALL_POS,QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInGroup(long groupId) throws SystemException {
		List<Users> list = (List<Users>) UsersUtil.findByGroupId(groupId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInGroup(long groupId, OrderByComparator orderByComparator) throws SystemException{
		List <Users> list = (List<Users>) UsersUtil.findByGroupId(groupId,QueryUtil.ALL_POS,QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUserAndGroup(long userId, long groupId) throws SystemException {
		List<Users> list = (List<Users>) UsersUtil.findByUserIdGroupId(userId, groupId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUserAndGroup(long userId, long groupId, OrderByComparator orderByComparator) throws SystemException {
		List<Users> list = (List<Users>) UsersUtil.findByUserIdGroupId(userId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
		return list;
	}
	




	public Users addUsers (Users validUsers) throws SystemException {
	    Users fileobj = usersPersistence.create(CounterLocalServiceUtil.increment(Users.class.getName()));

	    fileobj.setCompanyId(validUsers.getCompanyId());
	    fileobj.setGroupId(validUsers.getGroupId());
	    fileobj.setUserId(validUsers.getUserId());

	    fileobj.setUserName(validUsers.getUserName());
		fileobj.setUserPhoto(validUsers.getUserPhoto());
		fileobj.setFolderDLId(validUsers.getFolderDLId());
		return usersPersistence.update(fileobj, false);
	}

	public void deleteUsers (Users fileobj) throws SystemException {
		//Remove DocumentFile dir
		Long dlFolder = fileobj.getFolderDLId();
		if(dlFolder!=null && dlFolder!=0L) {
			try{
				DLFolderLocalServiceUtil.deleteDLFolder(dlFolder);
			} catch (PortalException e) {
				throw new SystemException(e.getMessage(),e.getCause());
			}
		}
		try {
			UsersUtil.remove(fileobj.getPrimaryKey());
		} catch (NoSuchUsersException e) {
			e.printStackTrace();
		}
	}

	public void remove(Users fileobj) throws SystemException {

		usersPersistence.remove(fileobj);
	}
	
}