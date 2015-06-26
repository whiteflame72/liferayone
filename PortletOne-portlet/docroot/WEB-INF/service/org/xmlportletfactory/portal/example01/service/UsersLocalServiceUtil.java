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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the users local service. This utility wraps {@link org.xmlportletfactory.portal.example01.service.impl.UsersLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jack A. Rider
 * @see UsersLocalService
 * @see org.xmlportletfactory.portal.example01.service.base.UsersLocalServiceBaseImpl
 * @see org.xmlportletfactory.portal.example01.service.impl.UsersLocalServiceImpl
 * @generated
 */
public class UsersLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.xmlportletfactory.portal.example01.service.impl.UsersLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the users to the database. Also notifies the appropriate model listeners.
	*
	* @param users the users
	* @return the users that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.Users addUsers(
		org.xmlportletfactory.portal.example01.model.Users users)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUsers(users);
	}

	/**
	* Creates a new users with the primary key. Does not add the users to the database.
	*
	* @param usersId the primary key for the new users
	* @return the new users
	*/
	public static org.xmlportletfactory.portal.example01.model.Users createUsers(
		long usersId) {
		return getService().createUsers(usersId);
	}

	/**
	* Deletes the users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param usersId the primary key of the users
	* @throws PortalException if a users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUsers(long usersId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUsers(usersId);
	}

	/**
	* Deletes the users from the database. Also notifies the appropriate model listeners.
	*
	* @param users the users
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUsers(
		org.xmlportletfactory.portal.example01.model.Users users)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUsers(users);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static org.xmlportletfactory.portal.example01.model.Users fetchUsers(
		long usersId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUsers(usersId);
	}

	/**
	* Returns the users with the primary key.
	*
	* @param usersId the primary key of the users
	* @return the users
	* @throws PortalException if a users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.Users getUsers(
		long usersId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUsers(usersId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.xmlportletfactory.portal.example01.model.Users> getUserses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserses(start, end);
	}

	/**
	* Returns the number of userses.
	*
	* @return the number of userses
	* @throws SystemException if a system exception occurred
	*/
	public static int getUsersesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUsersesCount();
	}

	/**
	* Updates the users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param users the users
	* @return the users that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.Users updateUsers(
		org.xmlportletfactory.portal.example01.model.Users users)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUsers(users);
	}

	/**
	* Updates the users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param users the users
	* @param merge whether to merge the users with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the users that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.Users updateUsers(
		org.xmlportletfactory.portal.example01.model.Users users, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUsers(users, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.util.List findAllInUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllInUser(userId);
	}

	public static java.util.List findAllInUser(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllInUser(userId, orderByComparator);
	}

	public static java.util.List findAllInGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllInGroup(groupId);
	}

	public static java.util.List findAllInGroup(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllInGroup(groupId, orderByComparator);
	}

	public static java.util.List findAllInUserAndGroup(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllInUserAndGroup(userId, groupId);
	}

	public static java.util.List findAllInUserAndGroup(long userId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findAllInUserAndGroup(userId, groupId, orderByComparator);
	}

	public static void remove(
		org.xmlportletfactory.portal.example01.model.Users fileobj)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().remove(fileobj);
	}

	public static void clearService() {
		_service = null;
	}

	public static UsersLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UsersLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					UsersLocalService.class.getName(), portletClassLoader);

			_service = new UsersLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(UsersLocalServiceUtil.class,
				"_service");
			MethodCache.remove(UsersLocalService.class);
		}

		return _service;
	}

	public void setService(UsersLocalService service) {
		MethodCache.remove(UsersLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(UsersLocalServiceUtil.class,
			"_service");
		MethodCache.remove(UsersLocalService.class);
	}

	private static UsersLocalService _service;
}