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

package org.xmlportletfactory.portal.example01.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.xmlportletfactory.portal.example01.model.PortletOne;

import java.util.List;

/**
 * The persistence utility for the portlet one service. This utility wraps {@link PortletOnePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jack A. Rider
 * @see PortletOnePersistence
 * @see PortletOnePersistenceImpl
 * @generated
 */
public class PortletOneUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(PortletOne portletOne) {
		getPersistence().clearCache(portletOne);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PortletOne> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PortletOne> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PortletOne> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PortletOne update(PortletOne portletOne, boolean merge)
		throws SystemException {
		return getPersistence().update(portletOne, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PortletOne update(PortletOne portletOne, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(portletOne, merge, serviceContext);
	}

	/**
	* Caches the portlet one in the entity cache if it is enabled.
	*
	* @param portletOne the portlet one
	*/
	public static void cacheResult(
		org.xmlportletfactory.portal.example01.model.PortletOne portletOne) {
		getPersistence().cacheResult(portletOne);
	}

	/**
	* Caches the portlet ones in the entity cache if it is enabled.
	*
	* @param portletOnes the portlet ones
	*/
	public static void cacheResult(
		java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> portletOnes) {
		getPersistence().cacheResult(portletOnes);
	}

	/**
	* Creates a new portlet one with the primary key. Does not add the portlet one to the database.
	*
	* @param PortletOneId the primary key for the new portlet one
	* @return the new portlet one
	*/
	public static org.xmlportletfactory.portal.example01.model.PortletOne create(
		long PortletOneId) {
		return getPersistence().create(PortletOneId);
	}

	/**
	* Removes the portlet one with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PortletOneId the primary key of the portlet one
	* @return the portlet one that was removed
	* @throws org.xmlportletfactory.portal.example01.NoSuchPortletOneException if a portlet one with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.PortletOne remove(
		long PortletOneId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchPortletOneException {
		return getPersistence().remove(PortletOneId);
	}

	public static org.xmlportletfactory.portal.example01.model.PortletOne updateImpl(
		org.xmlportletfactory.portal.example01.model.PortletOne portletOne,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(portletOne, merge);
	}

	/**
	* Returns the portlet one with the primary key or throws a {@link org.xmlportletfactory.portal.example01.NoSuchPortletOneException} if it could not be found.
	*
	* @param PortletOneId the primary key of the portlet one
	* @return the portlet one
	* @throws org.xmlportletfactory.portal.example01.NoSuchPortletOneException if a portlet one with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.PortletOne findByPrimaryKey(
		long PortletOneId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchPortletOneException {
		return getPersistence().findByPrimaryKey(PortletOneId);
	}

	/**
	* Returns the portlet one with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PortletOneId the primary key of the portlet one
	* @return the portlet one, or <code>null</code> if a portlet one with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.PortletOne fetchByPrimaryKey(
		long PortletOneId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(PortletOneId);
	}

	/**
	* Returns all the portlet ones where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching portlet ones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the portlet ones where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of portlet ones
	* @param end the upper bound of the range of portlet ones (not inclusive)
	* @return the range of matching portlet ones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the portlet ones where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of portlet ones
	* @param end the upper bound of the range of portlet ones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching portlet ones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first portlet one in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet one
	* @throws org.xmlportletfactory.portal.example01.NoSuchPortletOneException if a matching portlet one could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.PortletOne findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchPortletOneException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last portlet one in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet one
	* @throws org.xmlportletfactory.portal.example01.NoSuchPortletOneException if a matching portlet one could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.PortletOne findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchPortletOneException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the portlet ones before and after the current portlet one in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param PortletOneId the primary key of the current portlet one
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next portlet one
	* @throws org.xmlportletfactory.portal.example01.NoSuchPortletOneException if a portlet one with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.PortletOne[] findByGroupId_PrevAndNext(
		long PortletOneId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchPortletOneException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(PortletOneId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the portlet ones that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching portlet ones that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the portlet ones that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of portlet ones
	* @param end the upper bound of the range of portlet ones (not inclusive)
	* @return the range of matching portlet ones that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the portlet ones that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of portlet ones
	* @param end the upper bound of the range of portlet ones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching portlet ones that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the portlet ones before and after the current portlet one in the ordered set of portlet ones that the user has permission to view where groupId = &#63;.
	*
	* @param PortletOneId the primary key of the current portlet one
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next portlet one
	* @throws org.xmlportletfactory.portal.example01.NoSuchPortletOneException if a portlet one with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.PortletOne[] filterFindByGroupId_PrevAndNext(
		long PortletOneId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchPortletOneException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(PortletOneId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the portlet ones where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching portlet ones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the portlet ones where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of portlet ones
	* @param end the upper bound of the range of portlet ones (not inclusive)
	* @return the range of matching portlet ones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the portlet ones where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of portlet ones
	* @param end the upper bound of the range of portlet ones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching portlet ones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first portlet one in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet one
	* @throws org.xmlportletfactory.portal.example01.NoSuchPortletOneException if a matching portlet one could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.PortletOne findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchPortletOneException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last portlet one in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet one
	* @throws org.xmlportletfactory.portal.example01.NoSuchPortletOneException if a matching portlet one could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.PortletOne findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchPortletOneException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the portlet ones before and after the current portlet one in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param PortletOneId the primary key of the current portlet one
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next portlet one
	* @throws org.xmlportletfactory.portal.example01.NoSuchPortletOneException if a portlet one with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.PortletOne[] findByUserId_PrevAndNext(
		long PortletOneId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchPortletOneException {
		return getPersistence()
				   .findByUserId_PrevAndNext(PortletOneId, userId,
			orderByComparator);
	}

	/**
	* Returns all the portlet ones where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching portlet ones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> findByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns a range of all the portlet ones where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of portlet ones
	* @param end the upper bound of the range of portlet ones (not inclusive)
	* @return the range of matching portlet ones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> findByUserIdGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdGroupId(userId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the portlet ones where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of portlet ones
	* @param end the upper bound of the range of portlet ones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching portlet ones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdGroupId(userId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first portlet one in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet one
	* @throws org.xmlportletfactory.portal.example01.NoSuchPortletOneException if a matching portlet one could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.PortletOne findByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchPortletOneException {
		return getPersistence()
				   .findByUserIdGroupId_First(userId, groupId, orderByComparator);
	}

	/**
	* Returns the last portlet one in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet one
	* @throws org.xmlportletfactory.portal.example01.NoSuchPortletOneException if a matching portlet one could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.PortletOne findByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchPortletOneException {
		return getPersistence()
				   .findByUserIdGroupId_Last(userId, groupId, orderByComparator);
	}

	/**
	* Returns the portlet ones before and after the current portlet one in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param PortletOneId the primary key of the current portlet one
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next portlet one
	* @throws org.xmlportletfactory.portal.example01.NoSuchPortletOneException if a portlet one with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.PortletOne[] findByUserIdGroupId_PrevAndNext(
		long PortletOneId, long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchPortletOneException {
		return getPersistence()
				   .findByUserIdGroupId_PrevAndNext(PortletOneId, userId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the portlet ones that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching portlet ones that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> filterFindByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns a range of all the portlet ones that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of portlet ones
	* @param end the upper bound of the range of portlet ones (not inclusive)
	* @return the range of matching portlet ones that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUserIdGroupId(userId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the portlet ones that the user has permissions to view where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of portlet ones
	* @param end the upper bound of the range of portlet ones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching portlet ones that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUserIdGroupId(userId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the portlet ones before and after the current portlet one in the ordered set of portlet ones that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param PortletOneId the primary key of the current portlet one
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next portlet one
	* @throws org.xmlportletfactory.portal.example01.NoSuchPortletOneException if a portlet one with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.PortletOne[] filterFindByUserIdGroupId_PrevAndNext(
		long PortletOneId, long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchPortletOneException {
		return getPersistence()
				   .filterFindByUserIdGroupId_PrevAndNext(PortletOneId, userId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the portlet ones.
	*
	* @return the portlet ones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the portlet ones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of portlet ones
	* @param end the upper bound of the range of portlet ones (not inclusive)
	* @return the range of portlet ones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the portlet ones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of portlet ones
	* @param end the upper bound of the range of portlet ones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of portlet ones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the portlet ones where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the portlet ones where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the portlet ones where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserIdGroupId(userId, groupId);
	}

	/**
	* Removes all the portlet ones from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of portlet ones where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching portlet ones
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of portlet ones that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching portlet ones that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns the number of portlet ones where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching portlet ones
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of portlet ones where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching portlet ones
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns the number of portlet ones that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching portlet ones that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns the number of portlet ones.
	*
	* @return the number of portlet ones
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PortletOnePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PortletOnePersistence)PortletBeanLocatorUtil.locate(org.xmlportletfactory.portal.example01.service.ClpSerializer.getServletContextName(),
					PortletOnePersistence.class.getName());

			ReferenceRegistry.registerReference(PortletOneUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(PortletOnePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(PortletOneUtil.class, "_persistence");
	}

	private static PortletOnePersistence _persistence;
}