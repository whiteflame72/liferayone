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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.xmlportletfactory.portal.example01.NoSuchPortletOneException;
import org.xmlportletfactory.portal.example01.model.PortletOne;
import org.xmlportletfactory.portal.example01.model.impl.PortletOneImpl;
import org.xmlportletfactory.portal.example01.model.impl.PortletOneModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the portlet one service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jack A. Rider
 * @see PortletOnePersistence
 * @see PortletOneUtil
 * @generated
 */
public class PortletOnePersistenceImpl extends BasePersistenceImpl<PortletOne>
	implements PortletOnePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PortletOneUtil} to access the portlet one persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PortletOneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(PortletOneModelImpl.ENTITY_CACHE_ENABLED,
			PortletOneModelImpl.FINDER_CACHE_ENABLED, PortletOneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(PortletOneModelImpl.ENTITY_CACHE_ENABLED,
			PortletOneModelImpl.FINDER_CACHE_ENABLED, PortletOneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			PortletOneModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(PortletOneModelImpl.ENTITY_CACHE_ENABLED,
			PortletOneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(PortletOneModelImpl.ENTITY_CACHE_ENABLED,
			PortletOneModelImpl.FINDER_CACHE_ENABLED, PortletOneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(PortletOneModelImpl.ENTITY_CACHE_ENABLED,
			PortletOneModelImpl.FINDER_CACHE_ENABLED, PortletOneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			PortletOneModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(PortletOneModelImpl.ENTITY_CACHE_ENABLED,
			PortletOneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDGROUPID =
		new FinderPath(PortletOneModelImpl.ENTITY_CACHE_ENABLED,
			PortletOneModelImpl.FINDER_CACHE_ENABLED, PortletOneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID =
		new FinderPath(PortletOneModelImpl.ENTITY_CACHE_ENABLED,
			PortletOneModelImpl.FINDER_CACHE_ENABLED, PortletOneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIdGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			PortletOneModelImpl.USERID_COLUMN_BITMASK |
			PortletOneModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDGROUPID = new FinderPath(PortletOneModelImpl.ENTITY_CACHE_ENABLED,
			PortletOneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIdGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PortletOneModelImpl.ENTITY_CACHE_ENABLED,
			PortletOneModelImpl.FINDER_CACHE_ENABLED, PortletOneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PortletOneModelImpl.ENTITY_CACHE_ENABLED,
			PortletOneModelImpl.FINDER_CACHE_ENABLED, PortletOneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PortletOneModelImpl.ENTITY_CACHE_ENABLED,
			PortletOneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the portlet one in the entity cache if it is enabled.
	 *
	 * @param portletOne the portlet one
	 */
	public void cacheResult(PortletOne portletOne) {
		EntityCacheUtil.putResult(PortletOneModelImpl.ENTITY_CACHE_ENABLED,
			PortletOneImpl.class, portletOne.getPrimaryKey(), portletOne);

		portletOne.resetOriginalValues();
	}

	/**
	 * Caches the portlet ones in the entity cache if it is enabled.
	 *
	 * @param portletOnes the portlet ones
	 */
	public void cacheResult(List<PortletOne> portletOnes) {
		for (PortletOne portletOne : portletOnes) {
			if (EntityCacheUtil.getResult(
						PortletOneModelImpl.ENTITY_CACHE_ENABLED,
						PortletOneImpl.class, portletOne.getPrimaryKey()) == null) {
				cacheResult(portletOne);
			}
			else {
				portletOne.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all portlet ones.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PortletOneImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PortletOneImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the portlet one.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PortletOne portletOne) {
		EntityCacheUtil.removeResult(PortletOneModelImpl.ENTITY_CACHE_ENABLED,
			PortletOneImpl.class, portletOne.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PortletOne> portletOnes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PortletOne portletOne : portletOnes) {
			EntityCacheUtil.removeResult(PortletOneModelImpl.ENTITY_CACHE_ENABLED,
				PortletOneImpl.class, portletOne.getPrimaryKey());
		}
	}

	/**
	 * Creates a new portlet one with the primary key. Does not add the portlet one to the database.
	 *
	 * @param PortletOneId the primary key for the new portlet one
	 * @return the new portlet one
	 */
	public PortletOne create(long PortletOneId) {
		PortletOne portletOne = new PortletOneImpl();

		portletOne.setNew(true);
		portletOne.setPrimaryKey(PortletOneId);

		return portletOne;
	}

	/**
	 * Removes the portlet one with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PortletOneId the primary key of the portlet one
	 * @return the portlet one that was removed
	 * @throws org.xmlportletfactory.portal.example01.NoSuchPortletOneException if a portlet one with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletOne remove(long PortletOneId)
		throws NoSuchPortletOneException, SystemException {
		return remove(Long.valueOf(PortletOneId));
	}

	/**
	 * Removes the portlet one with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the portlet one
	 * @return the portlet one that was removed
	 * @throws org.xmlportletfactory.portal.example01.NoSuchPortletOneException if a portlet one with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletOne remove(Serializable primaryKey)
		throws NoSuchPortletOneException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PortletOne portletOne = (PortletOne)session.get(PortletOneImpl.class,
					primaryKey);

			if (portletOne == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPortletOneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(portletOne);
		}
		catch (NoSuchPortletOneException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PortletOne removeImpl(PortletOne portletOne)
		throws SystemException {
		portletOne = toUnwrappedModel(portletOne);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, portletOne);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(portletOne);

		return portletOne;
	}

	@Override
	public PortletOne updateImpl(
		org.xmlportletfactory.portal.example01.model.PortletOne portletOne,
		boolean merge) throws SystemException {
		portletOne = toUnwrappedModel(portletOne);

		boolean isNew = portletOne.isNew();

		PortletOneModelImpl portletOneModelImpl = (PortletOneModelImpl)portletOne;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, portletOne, merge);

			portletOne.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PortletOneModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((portletOneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(portletOneModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						Long.valueOf(portletOneModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((portletOneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(portletOneModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						Long.valueOf(portletOneModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((portletOneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(portletOneModelImpl.getOriginalUserId()),
						Long.valueOf(portletOneModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID,
					args);

				args = new Object[] {
						Long.valueOf(portletOneModelImpl.getUserId()),
						Long.valueOf(portletOneModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(PortletOneModelImpl.ENTITY_CACHE_ENABLED,
			PortletOneImpl.class, portletOne.getPrimaryKey(), portletOne);

		return portletOne;
	}

	protected PortletOne toUnwrappedModel(PortletOne portletOne) {
		if (portletOne instanceof PortletOneImpl) {
			return portletOne;
		}

		PortletOneImpl portletOneImpl = new PortletOneImpl();

		portletOneImpl.setNew(portletOne.isNew());
		portletOneImpl.setPrimaryKey(portletOne.getPrimaryKey());

		portletOneImpl.setPortletOneId(portletOne.getPortletOneId());
		portletOneImpl.setCompanyId(portletOne.getCompanyId());
		portletOneImpl.setGroupId(portletOne.getGroupId());
		portletOneImpl.setUserId(portletOne.getUserId());
		portletOneImpl.setPortletOneDescription(portletOne.getPortletOneDescription());

		return portletOneImpl;
	}

	/**
	 * Returns the portlet one with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the portlet one
	 * @return the portlet one
	 * @throws com.liferay.portal.NoSuchModelException if a portlet one with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletOne findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the portlet one with the primary key or throws a {@link org.xmlportletfactory.portal.example01.NoSuchPortletOneException} if it could not be found.
	 *
	 * @param PortletOneId the primary key of the portlet one
	 * @return the portlet one
	 * @throws org.xmlportletfactory.portal.example01.NoSuchPortletOneException if a portlet one with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletOne findByPrimaryKey(long PortletOneId)
		throws NoSuchPortletOneException, SystemException {
		PortletOne portletOne = fetchByPrimaryKey(PortletOneId);

		if (portletOne == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + PortletOneId);
			}

			throw new NoSuchPortletOneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				PortletOneId);
		}

		return portletOne;
	}

	/**
	 * Returns the portlet one with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the portlet one
	 * @return the portlet one, or <code>null</code> if a portlet one with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletOne fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the portlet one with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PortletOneId the primary key of the portlet one
	 * @return the portlet one, or <code>null</code> if a portlet one with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletOne fetchByPrimaryKey(long PortletOneId)
		throws SystemException {
		PortletOne portletOne = (PortletOne)EntityCacheUtil.getResult(PortletOneModelImpl.ENTITY_CACHE_ENABLED,
				PortletOneImpl.class, PortletOneId);

		if (portletOne == _nullPortletOne) {
			return null;
		}

		if (portletOne == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				portletOne = (PortletOne)session.get(PortletOneImpl.class,
						Long.valueOf(PortletOneId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (portletOne != null) {
					cacheResult(portletOne);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PortletOneModelImpl.ENTITY_CACHE_ENABLED,
						PortletOneImpl.class, PortletOneId, _nullPortletOne);
				}

				closeSession(session);
			}
		}

		return portletOne;
	}

	/**
	 * Returns all the portlet ones where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching portlet ones
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletOne> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<PortletOne> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
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
	public List<PortletOne> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<PortletOne> list = (List<PortletOne>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_PORTLETONE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<PortletOne>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public PortletOne findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPortletOneException, SystemException {
		List<PortletOne> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPortletOneException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public PortletOne findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPortletOneException, SystemException {
		int count = countByGroupId(groupId);

		List<PortletOne> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPortletOneException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public PortletOne[] findByGroupId_PrevAndNext(long PortletOneId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchPortletOneException, SystemException {
		PortletOne portletOne = findByPrimaryKey(PortletOneId);

		Session session = null;

		try {
			session = openSession();

			PortletOne[] array = new PortletOneImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, portletOne, groupId,
					orderByComparator, true);

			array[1] = portletOne;

			array[2] = getByGroupId_PrevAndNext(session, portletOne, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PortletOne getByGroupId_PrevAndNext(Session session,
		PortletOne portletOne, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTLETONE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portletOne);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortletOne> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the portlet ones that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching portlet ones that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletOne> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<PortletOne> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
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
	public List<PortletOne> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(2);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PORTLETONE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PORTLETONE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PORTLETONE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PortletOne.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PortletOneImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PortletOneImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<PortletOne>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	public PortletOne[] filterFindByGroupId_PrevAndNext(long PortletOneId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchPortletOneException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(PortletOneId, groupId,
				orderByComparator);
		}

		PortletOne portletOne = findByPrimaryKey(PortletOneId);

		Session session = null;

		try {
			session = openSession();

			PortletOne[] array = new PortletOneImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, portletOne,
					groupId, orderByComparator, true);

			array[1] = portletOne;

			array[2] = filterGetByGroupId_PrevAndNext(session, portletOne,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PortletOne filterGetByGroupId_PrevAndNext(Session session,
		PortletOne portletOne, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PORTLETONE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PORTLETONE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PORTLETONE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PortletOne.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, PortletOneImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, PortletOneImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portletOne);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortletOne> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the portlet ones where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching portlet ones
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletOne> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<PortletOne> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
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
	public List<PortletOne> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<PortletOne> list = (List<PortletOne>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_PORTLETONE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<PortletOne>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public PortletOne findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchPortletOneException, SystemException {
		List<PortletOne> list = findByUserId(userId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPortletOneException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public PortletOne findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchPortletOneException, SystemException {
		int count = countByUserId(userId);

		List<PortletOne> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPortletOneException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public PortletOne[] findByUserId_PrevAndNext(long PortletOneId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchPortletOneException, SystemException {
		PortletOne portletOne = findByPrimaryKey(PortletOneId);

		Session session = null;

		try {
			session = openSession();

			PortletOne[] array = new PortletOneImpl[3];

			array[0] = getByUserId_PrevAndNext(session, portletOne, userId,
					orderByComparator, true);

			array[1] = portletOne;

			array[2] = getByUserId_PrevAndNext(session, portletOne, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PortletOne getByUserId_PrevAndNext(Session session,
		PortletOne portletOne, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTLETONE_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portletOne);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortletOne> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the portlet ones where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching portlet ones
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletOne> findByUserIdGroupId(long userId, long groupId)
		throws SystemException {
		return findByUserIdGroupId(userId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<PortletOne> findByUserIdGroupId(long userId, long groupId,
		int start, int end) throws SystemException {
		return findByUserIdGroupId(userId, groupId, start, end, null);
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
	public List<PortletOne> findByUserIdGroupId(long userId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID;
			finderArgs = new Object[] { userId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDGROUPID;
			finderArgs = new Object[] {
					userId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<PortletOne> list = (List<PortletOne>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PORTLETONE_WHERE);

			query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

				list = (List<PortletOne>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public PortletOne findByUserIdGroupId_First(long userId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPortletOneException, SystemException {
		List<PortletOne> list = findByUserIdGroupId(userId, groupId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPortletOneException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public PortletOne findByUserIdGroupId_Last(long userId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPortletOneException, SystemException {
		int count = countByUserIdGroupId(userId, groupId);

		List<PortletOne> list = findByUserIdGroupId(userId, groupId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPortletOneException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public PortletOne[] findByUserIdGroupId_PrevAndNext(long PortletOneId,
		long userId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchPortletOneException, SystemException {
		PortletOne portletOne = findByPrimaryKey(PortletOneId);

		Session session = null;

		try {
			session = openSession();

			PortletOne[] array = new PortletOneImpl[3];

			array[0] = getByUserIdGroupId_PrevAndNext(session, portletOne,
					userId, groupId, orderByComparator, true);

			array[1] = portletOne;

			array[2] = getByUserIdGroupId_PrevAndNext(session, portletOne,
					userId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PortletOne getByUserIdGroupId_PrevAndNext(Session session,
		PortletOne portletOne, long userId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTLETONE_WHERE);

		query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portletOne);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortletOne> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the portlet ones that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching portlet ones that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletOne> filterFindByUserIdGroupId(long userId, long groupId)
		throws SystemException {
		return filterFindByUserIdGroupId(userId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<PortletOne> filterFindByUserIdGroupId(long userId,
		long groupId, int start, int end) throws SystemException {
		return filterFindByUserIdGroupId(userId, groupId, start, end, null);
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
	public List<PortletOne> filterFindByUserIdGroupId(long userId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByUserIdGroupId(userId, groupId, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PORTLETONE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PORTLETONE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PORTLETONE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PortletOne.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PortletOneImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PortletOneImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			qPos.add(groupId);

			return (List<PortletOne>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	public PortletOne[] filterFindByUserIdGroupId_PrevAndNext(
		long PortletOneId, long userId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPortletOneException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByUserIdGroupId_PrevAndNext(PortletOneId, userId,
				groupId, orderByComparator);
		}

		PortletOne portletOne = findByPrimaryKey(PortletOneId);

		Session session = null;

		try {
			session = openSession();

			PortletOne[] array = new PortletOneImpl[3];

			array[0] = filterGetByUserIdGroupId_PrevAndNext(session,
					portletOne, userId, groupId, orderByComparator, true);

			array[1] = portletOne;

			array[2] = filterGetByUserIdGroupId_PrevAndNext(session,
					portletOne, userId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PortletOne filterGetByUserIdGroupId_PrevAndNext(Session session,
		PortletOne portletOne, long userId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PORTLETONE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PORTLETONE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PORTLETONE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PortletOne.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, PortletOneImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, PortletOneImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portletOne);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortletOne> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the portlet ones.
	 *
	 * @return the portlet ones
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletOne> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<PortletOne> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<PortletOne> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<PortletOne> list = (List<PortletOne>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PORTLETONE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PORTLETONE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PortletOne>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PortletOne>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the portlet ones where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (PortletOne portletOne : findByGroupId(groupId)) {
			remove(portletOne);
		}
	}

	/**
	 * Removes all the portlet ones where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (PortletOne portletOne : findByUserId(userId)) {
			remove(portletOne);
		}
	}

	/**
	 * Removes all the portlet ones where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserIdGroupId(long userId, long groupId)
		throws SystemException {
		for (PortletOne portletOne : findByUserIdGroupId(userId, groupId)) {
			remove(portletOne);
		}
	}

	/**
	 * Removes all the portlet ones from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PortletOne portletOne : findAll()) {
			remove(portletOne);
		}
	}

	/**
	 * Returns the number of portlet ones where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching portlet ones
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PORTLETONE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of portlet ones that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching portlet ones that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_PORTLETONE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PortletOne.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of portlet ones where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching portlet ones
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PORTLETONE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of portlet ones where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching portlet ones
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserIdGroupId(long userId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERIDGROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PORTLETONE_WHERE);

			query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDGROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of portlet ones that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching portlet ones that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByUserIdGroupId(long userId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByUserIdGroupId(userId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_PORTLETONE_WHERE);

		query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PortletOne.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of portlet ones.
	 *
	 * @return the number of portlet ones
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PORTLETONE);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the portlet one persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.xmlportletfactory.portal.example01.model.PortletOne")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PortletOne>> listenersList = new ArrayList<ModelListener<PortletOne>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PortletOne>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(PortletOneImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = PortletOnePersistence.class)
	protected PortletOnePersistence portletOnePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_PORTLETONE = "SELECT portletOne FROM PortletOne portletOne";
	private static final String _SQL_SELECT_PORTLETONE_WHERE = "SELECT portletOne FROM PortletOne portletOne WHERE ";
	private static final String _SQL_COUNT_PORTLETONE = "SELECT COUNT(portletOne) FROM PortletOne portletOne";
	private static final String _SQL_COUNT_PORTLETONE_WHERE = "SELECT COUNT(portletOne) FROM PortletOne portletOne WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "portletOne.groupId = ?";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "portletOne.userId = ?";
	private static final String _FINDER_COLUMN_USERIDGROUPID_USERID_2 = "portletOne.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDGROUPID_GROUPID_2 = "portletOne.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "portletOne.PortletOneId";
	private static final String _FILTER_SQL_SELECT_PORTLETONE_WHERE = "SELECT DISTINCT {portletOne.*} FROM portletone_PortletOne portletOne WHERE ";
	private static final String _FILTER_SQL_SELECT_PORTLETONE_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {portletone_PortletOne.*} FROM (SELECT DISTINCT portletOne.PortletOneId FROM portletone_PortletOne portletOne WHERE ";
	private static final String _FILTER_SQL_SELECT_PORTLETONE_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN portletone_PortletOne ON TEMP_TABLE.PortletOneId = portletone_PortletOne.PortletOneId";
	private static final String _FILTER_SQL_COUNT_PORTLETONE_WHERE = "SELECT COUNT(DISTINCT portletOne.PortletOneId) AS COUNT_VALUE FROM portletone_PortletOne portletOne WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "portletOne";
	private static final String _FILTER_ENTITY_TABLE = "portletone_PortletOne";
	private static final String _ORDER_BY_ENTITY_ALIAS = "portletOne.";
	private static final String _ORDER_BY_ENTITY_TABLE = "portletone_PortletOne.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PortletOne exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PortletOne exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PortletOnePersistenceImpl.class);
	private static PortletOne _nullPortletOne = new PortletOneImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PortletOne> toCacheModel() {
				return _nullPortletOneCacheModel;
			}
		};

	private static CacheModel<PortletOne> _nullPortletOneCacheModel = new CacheModel<PortletOne>() {
			public PortletOne toEntityModel() {
				return _nullPortletOne;
			}
		};
}