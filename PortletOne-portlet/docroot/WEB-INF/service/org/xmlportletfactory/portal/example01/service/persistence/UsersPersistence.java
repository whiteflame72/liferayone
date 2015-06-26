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

import com.liferay.portal.service.persistence.BasePersistence;

import org.xmlportletfactory.portal.example01.model.Users;

/**
 * The persistence interface for the users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jack A. Rider
 * @see UsersPersistenceImpl
 * @see UsersUtil
 * @generated
 */
public interface UsersPersistence extends BasePersistence<Users> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UsersUtil} to access the users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the users in the entity cache if it is enabled.
	*
	* @param users the users
	*/
	public void cacheResult(
		org.xmlportletfactory.portal.example01.model.Users users);

	/**
	* Caches the userses in the entity cache if it is enabled.
	*
	* @param userses the userses
	*/
	public void cacheResult(
		java.util.List<org.xmlportletfactory.portal.example01.model.Users> userses);

	/**
	* Creates a new users with the primary key. Does not add the users to the database.
	*
	* @param usersId the primary key for the new users
	* @return the new users
	*/
	public org.xmlportletfactory.portal.example01.model.Users create(
		long usersId);

	/**
	* Removes the users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param usersId the primary key of the users
	* @return the users that was removed
	* @throws org.xmlportletfactory.portal.example01.NoSuchUsersException if a users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.portal.example01.model.Users remove(
		long usersId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException;

	public org.xmlportletfactory.portal.example01.model.Users updateImpl(
		org.xmlportletfactory.portal.example01.model.Users users, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the users with the primary key or throws a {@link org.xmlportletfactory.portal.example01.NoSuchUsersException} if it could not be found.
	*
	* @param usersId the primary key of the users
	* @return the users
	* @throws org.xmlportletfactory.portal.example01.NoSuchUsersException if a users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.portal.example01.model.Users findByPrimaryKey(
		long usersId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException;

	/**
	* Returns the users with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param usersId the primary key of the users
	* @return the users, or <code>null</code> if a users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.portal.example01.model.Users fetchByPrimaryKey(
		long usersId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the userses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.portal.example01.model.Users> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.portal.example01.model.Users> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.portal.example01.model.Users> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.xmlportletfactory.portal.example01.model.Users findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException;

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
	public org.xmlportletfactory.portal.example01.model.Users findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException;

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
	public org.xmlportletfactory.portal.example01.model.Users[] findByGroupId_PrevAndNext(
		long usersId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException;

	/**
	* Returns all the userses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching userses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.portal.example01.model.Users> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.portal.example01.model.Users> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.portal.example01.model.Users> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.xmlportletfactory.portal.example01.model.Users[] filterFindByGroupId_PrevAndNext(
		long usersId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException;

	/**
	* Returns all the userses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.portal.example01.model.Users> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.portal.example01.model.Users> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.portal.example01.model.Users> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.xmlportletfactory.portal.example01.model.Users findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException;

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
	public org.xmlportletfactory.portal.example01.model.Users findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException;

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
	public org.xmlportletfactory.portal.example01.model.Users[] findByUserId_PrevAndNext(
		long usersId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException;

	/**
	* Returns all the userses where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.portal.example01.model.Users> findByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.portal.example01.model.Users> findByUserIdGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.portal.example01.model.Users> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.xmlportletfactory.portal.example01.model.Users findByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException;

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
	public org.xmlportletfactory.portal.example01.model.Users findByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException;

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
	public org.xmlportletfactory.portal.example01.model.Users[] findByUserIdGroupId_PrevAndNext(
		long usersId, long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException;

	/**
	* Returns all the userses that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching userses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.portal.example01.model.Users> filterFindByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.portal.example01.model.Users> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.portal.example01.model.Users> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.xmlportletfactory.portal.example01.model.Users[] filterFindByUserIdGroupId_PrevAndNext(
		long usersId, long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.portal.example01.NoSuchUsersException;

	/**
	* Returns all the userses.
	*
	* @return the userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.portal.example01.model.Users> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.portal.example01.model.Users> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.portal.example01.model.Users> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the userses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the userses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the userses where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the userses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of userses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching userses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of userses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching userses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of userses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching userses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of userses where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching userses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of userses that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching userses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of userses.
	*
	* @return the number of userses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}