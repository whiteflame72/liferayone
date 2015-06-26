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

package org.xmlportletfactory.portal.example01.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link UsersLocalService}.
 * </p>
 *
 * @author    Jack A. Rider
 * @see       UsersLocalService
 * @generated
 */
public class UsersLocalServiceWrapper implements UsersLocalService,
	ServiceWrapper<UsersLocalService> {
	public UsersLocalServiceWrapper(UsersLocalService usersLocalService) {
		_usersLocalService = usersLocalService;
	}

	/**
	* Adds the users to the database. Also notifies the appropriate model listeners.
	*
	* @param users the users
	* @return the users that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.portal.example01.model.Users addUsers(
		org.xmlportletfactory.portal.example01.model.Users users)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usersLocalService.addUsers(users);
	}

	/**
	* Creates a new users with the primary key. Does not add the users to the database.
	*
	* @param usersId the primary key for the new users
	* @return the new users
	*/
	public org.xmlportletfactory.portal.example01.model.Users createUsers(
		long usersId) {
		return _usersLocalService.createUsers(usersId);
	}

	/**
	* Deletes the users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param usersId the primary key of the users
	* @throws PortalException if a users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUsers(long usersId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_usersLocalService.deleteUsers(usersId);
	}

	/**
	* Deletes the users from the database. Also notifies the appropriate model listeners.
	*
	* @param users the users
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUsers(
		org.xmlportletfactory.portal.example01.model.Users users)
		throws com.liferay.portal.kernel.exception.SystemException {
		_usersLocalService.deleteUsers(users);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _usersLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usersLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usersLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.xmlportletfactory.portal.example01.model.Users fetchUsers(
		long usersId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usersLocalService.fetchUsers(usersId);
	}

	/**
	* Returns the users with the primary key.
	*
	* @param usersId the primary key of the users
	* @return the users
	* @throws PortalException if a users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.portal.example01.model.Users getUsers(
		long usersId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _usersLocalService.getUsers(usersId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _usersLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the userses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of userses
	* @param end the upper bound of the range of userses (not inclusive)
	* @return the range of userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.portal.example01.model.Users> getUserses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usersLocalService.getUserses(start, end);
	}

	/**
	* Returns the number of userses.
	*
	* @return the number of userses
	* @throws SystemException if a system exception occurred
	*/
	public int getUsersesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usersLocalService.getUsersesCount();
	}

	/**
	* Updates the users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param users the users
	* @return the users that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.portal.example01.model.Users updateUsers(
		org.xmlportletfactory.portal.example01.model.Users users)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usersLocalService.updateUsers(users);
	}

	/**
	* Updates the users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param users the users
	* @param merge whether to merge the users with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the users that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.portal.example01.model.Users updateUsers(
		org.xmlportletfactory.portal.example01.model.Users users, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usersLocalService.updateUsers(users, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _usersLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_usersLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.util.List findAllInUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usersLocalService.findAllInUser(userId);
	}

	public java.util.List findAllInUser(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usersLocalService.findAllInUser(userId, orderByComparator);
	}

	public java.util.List findAllInGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usersLocalService.findAllInGroup(groupId);
	}

	public java.util.List findAllInGroup(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usersLocalService.findAllInGroup(groupId, orderByComparator);
	}

	public java.util.List findAllInUserAndGroup(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usersLocalService.findAllInUserAndGroup(userId, groupId);
	}

	public java.util.List findAllInUserAndGroup(long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usersLocalService.findAllInUserAndGroup(userId, groupId,
			orderByComparator);
	}

	public void remove(
		org.xmlportletfactory.portal.example01.model.Users fileobj)
		throws com.liferay.portal.kernel.exception.SystemException {
		_usersLocalService.remove(fileobj);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public UsersLocalService getWrappedUsersLocalService() {
		return _usersLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedUsersLocalService(UsersLocalService usersLocalService) {
		_usersLocalService = usersLocalService;
	}

	public UsersLocalService getWrappedService() {
		return _usersLocalService;
	}

	public void setWrappedService(UsersLocalService usersLocalService) {
		_usersLocalService = usersLocalService;
	}

	private UsersLocalService _usersLocalService;
}