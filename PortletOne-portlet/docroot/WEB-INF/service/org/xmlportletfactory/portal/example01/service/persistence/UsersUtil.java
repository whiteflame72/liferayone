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

import org.xmlportletfactory.portal.example01.model.Users;

import java.util.List;

/**
 * The persistence utility for the users service. This utility wraps {@link UsersPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jack A. Rider
 * @see UsersPersistence
 * @see UsersPersistenceImpl
 * @generated
 */
public class UsersUtil {
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
	public static void clearCache(Users users) {
		getPersistence().clearCache(users);
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
	public static List<Users> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Users> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Users> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Users update(Users users, boolean merge)
		throws SystemException {
		return getPersistence().update(users, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Users update(Users users, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(users, merge, serviceContext);
	}

	/**
	* Caches the users in the entity cache if it is enabled.
	*
	* @param users the users
	*/
	public static void cacheResult(
		org.xmlportletfactory.portal.example01.model.Users users) {
		getPersistence().cacheResult(users);
	}

	/**
	* Caches the userses in the entity cache if it is enabled.
	*
	* @param userses the userses
	*/
	public static void cacheResult(
		java.util.List<org.xmlportletfactory.portal.example01.model.Users> userses) {
		getPersistence().cacheResult(userses);
	}

	/**
	* Creates a new users with the primary key. Does not add the users to the database.
	*
	* @param usersId the primary key for the new users
	* @return the new users
	*/
	public static org.xmlportletfactory.portal.example01.model.Users create(
		long usersId) {
		return getPersistence().create(usersId);
	}

	/**
	* Removes the users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param usersId the primary key of the users
	* @return the users that was removed
	* @throws org.xmlportletfactory.portal.example01.NoSuchUsersException if a users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.Users remove(
		long usersId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException {
		return getPersistence().remove(usersId);
	}

	public static org.xmlportletfactory.portal.example01.model.Users updateImpl(
		org.xmlportletfactory.portal.example01.model.Users users, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(users, merge);
	}

	/**
	* Returns the users with the primary key or throws a {@link org.xmlportletfactory.portal.example01.NoSuchUsersException} if it could not be found.
	*
	* @param usersId the primary key of the users
	* @return the users
	* @throws org.xmlportletfactory.portal.example01.NoSuchUsersException if a users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.Users findByPrimaryKey(
		long usersId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException {
		return getPersistence().findByPrimaryKey(usersId);
	}

	/**
	* Returns the users with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param usersId the primary key of the users
	* @return the users, or <code>null</code> if a users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.Users fetchByPrimaryKey(
		long usersId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(usersId);
	}

	/**
	* Returns all the userses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.Users> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the userses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of userses
	* @param end the upper bound of the range of userses (not inclusive)
	* @return the range of matching userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.Users> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the userses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of userses
	* @param end the upper bound of the range of userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.Users> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first users in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching users
	* @throws org.xmlportletfactory.portal.example01.NoSuchUsersException if a matching users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.Users findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last users in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching users
	* @throws org.xmlportletfactory.portal.example01.NoSuchUsersException if a matching users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.Users findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the userses before and after the current users in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param usersId the primary key of the current users
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next users
	* @throws org.xmlportletfactory.portal.example01.NoSuchUsersException if a users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.Users[] findByGroupId_PrevAndNext(
		long usersId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(usersId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the userses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching userses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.Users> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the userses that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of userses
	* @param end the upper bound of the range of userses (not inclusive)
	* @return the range of matching userses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.Users> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the userses that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of userses
	* @param end the upper bound of the range of userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching userses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.Users> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the userses before and after the current users in the ordered set of userses that the user has permission to view where groupId = &#63;.
	*
	* @param usersId the primary key of the current users
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next users
	* @throws org.xmlportletfactory.portal.example01.NoSuchUsersException if a users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.Users[] filterFindByGroupId_PrevAndNext(
		long usersId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(usersId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the userses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.Users> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the userses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of userses
	* @param end the upper bound of the range of userses (not inclusive)
	* @return the range of matching userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.Users> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the userses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of userses
	* @param end the upper bound of the range of userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.Users> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first users in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching users
	* @throws org.xmlportletfactory.portal.example01.NoSuchUsersException if a matching users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.Users findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last users in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching users
	* @throws org.xmlportletfactory.portal.example01.NoSuchUsersException if a matching users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.Users findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the userses before and after the current users in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param usersId the primary key of the current users
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next users
	* @throws org.xmlportletfactory.portal.example01.NoSuchUsersException if a users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.Users[] findByUserId_PrevAndNext(
		long usersId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException {
		return getPersistence()
				   .findByUserId_PrevAndNext(usersId, userId, orderByComparator);
	}

	/**
	* Returns all the userses where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.Users> findByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns a range of all the userses where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of userses
	* @param end the upper bound of the range of userses (not inclusive)
	* @return the range of matching userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.Users> findByUserIdGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdGroupId(userId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the userses where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of userses
	* @param end the upper bound of the range of userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.Users> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdGroupId(userId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first users in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching users
	* @throws org.xmlportletfactory.portal.example01.NoSuchUsersException if a matching users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.Users findByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException {
		return getPersistence()
				   .findByUserIdGroupId_First(userId, groupId, orderByComparator);
	}

	/**
	* Returns the last users in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching users
	* @throws org.xmlportletfactory.portal.example01.NoSuchUsersException if a matching users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.Users findByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException {
		return getPersistence()
				   .findByUserIdGroupId_Last(userId, groupId, orderByComparator);
	}

	/**
	* Returns the userses before and after the current users in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param usersId the primary key of the current users
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next users
	* @throws org.xmlportletfactory.portal.example01.NoSuchUsersException if a users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.Users[] findByUserIdGroupId_PrevAndNext(
		long usersId, long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException {
		return getPersistence()
				   .findByUserIdGroupId_PrevAndNext(usersId, userId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the userses that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching userses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.Users> filterFindByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns a range of all the userses that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of userses
	* @param end the upper bound of the range of userses (not inclusive)
	* @return the range of matching userses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.Users> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUserIdGroupId(userId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the userses that the user has permissions to view where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of userses
	* @param end the upper bound of the range of userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching userses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.Users> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUserIdGroupId(userId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the userses before and after the current users in the ordered set of userses that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param usersId the primary key of the current users
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next users
	* @throws org.xmlportletfactory.portal.example01.NoSuchUsersException if a users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.portal.example01.model.Users[] filterFindByUserIdGroupId_PrevAndNext(
		long usersId, long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException {
		return getPersistence()
				   .filterFindByUserIdGroupId_PrevAndNext(usersId, userId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the userses.
	*
	* @return the userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.Users> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.xmlportletfactory.portal.example01.model.Users> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the userses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of userses
	* @param end the upper bound of the range of userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.portal.example01.model.Users> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the userses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the userses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the userses where userId = &#63; and groupId = &#63; from the database.
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
	* Removes all the userses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of userses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of userses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching userses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns the number of userses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of userses where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns the number of userses that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching userses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns the number of userses.
	*
	* @return the number of userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UsersPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UsersPersistence)PortletBeanLocatorUtil.locate(org.xmlportletfactory.portal.example01.service.ClpSerializer.getServletContextName(),
					UsersPersistence.class.getName());

			ReferenceRegistry.registerReference(UsersUtil.class, "_persistence");
		}

		return _persistence;
	}

	public void setPersistence(UsersPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(UsersUtil.class, "_persistence");
	}

	private static UsersPersistence _persistence;
}