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
 * This class is a wrapper for {@link PortletOneLocalService}.
 * </p>
 *
 * @author    Jack A. Rider
 * @see       PortletOneLocalService
 * @generated
 */
public class PortletOneLocalServiceWrapper implements PortletOneLocalService,
	ServiceWrapper<PortletOneLocalService> {
	public PortletOneLocalServiceWrapper(
		PortletOneLocalService portletOneLocalService) {
		_portletOneLocalService = portletOneLocalService;
	}

	/**
	* Adds the portlet one to the database. Also notifies the appropriate model listeners.
	*
	* @param portletOne the portlet one
	* @return the portlet one that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.portal.example01.model.PortletOne addPortletOne(
		org.xmlportletfactory.portal.example01.model.PortletOne portletOne)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletOneLocalService.addPortletOne(portletOne);
	}

	/**
	* Creates a new portlet one with the primary key. Does not add the portlet one to the database.
	*
	* @param PortletOneId the primary key for the new portlet one
	* @return the new portlet one
	*/
	public org.xmlportletfactory.portal.example01.model.PortletOne createPortletOne(
		long PortletOneId) {
		return _portletOneLocalService.createPortletOne(PortletOneId);
	}

	/**
	* Deletes the portlet one with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PortletOneId the primary key of the portlet one
	* @throws PortalException if a portlet one with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deletePortletOne(long PortletOneId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_portletOneLocalService.deletePortletOne(PortletOneId);
	}

	/**
	* Deletes the portlet one from the database. Also notifies the appropriate model listeners.
	*
	* @param portletOne the portlet one
	* @throws SystemException if a system exception occurred
	*/
	public void deletePortletOne(
		org.xmlportletfactory.portal.example01.model.PortletOne portletOne)
		throws com.liferay.portal.kernel.exception.SystemException {
		_portletOneLocalService.deletePortletOne(portletOne);
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
		return _portletOneLocalService.dynamicQuery(dynamicQuery);
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
		return _portletOneLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _portletOneLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _portletOneLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.xmlportletfactory.portal.example01.model.PortletOne fetchPortletOne(
		long PortletOneId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletOneLocalService.fetchPortletOne(PortletOneId);
	}

	/**
	* Returns the portlet one with the primary key.
	*
	* @param PortletOneId the primary key of the portlet one
	* @return the portlet one
	* @throws PortalException if a portlet one with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.portal.example01.model.PortletOne getPortletOne(
		long PortletOneId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portletOneLocalService.getPortletOne(PortletOneId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portletOneLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<org.xmlportletfactory.portal.example01.model.PortletOne> getPortletOnes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletOneLocalService.getPortletOnes(start, end);
	}

	/**
	* Returns the number of portlet ones.
	*
	* @return the number of portlet ones
	* @throws SystemException if a system exception occurred
	*/
	public int getPortletOnesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletOneLocalService.getPortletOnesCount();
	}

	/**
	* Updates the portlet one in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portletOne the portlet one
	* @return the portlet one that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.portal.example01.model.PortletOne updatePortletOne(
		org.xmlportletfactory.portal.example01.model.PortletOne portletOne)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletOneLocalService.updatePortletOne(portletOne);
	}

	/**
	* Updates the portlet one in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portletOne the portlet one
	* @param merge whether to merge the portlet one with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the portlet one that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.portal.example01.model.PortletOne updatePortletOne(
		org.xmlportletfactory.portal.example01.model.PortletOne portletOne,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletOneLocalService.updatePortletOne(portletOne, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _portletOneLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_portletOneLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.util.List findAllInUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletOneLocalService.findAllInUser(userId);
	}

	public java.util.List findAllInUser(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletOneLocalService.findAllInUser(userId, orderByComparator);
	}

	public java.util.List findAllInGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletOneLocalService.findAllInGroup(groupId);
	}

	public java.util.List findAllInGroup(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletOneLocalService.findAllInGroup(groupId, orderByComparator);
	}

	public java.util.List findAllInUserAndGroup(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletOneLocalService.findAllInUserAndGroup(userId, groupId);
	}

	public java.util.List findAllInUserAndGroup(long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletOneLocalService.findAllInUserAndGroup(userId, groupId,
			orderByComparator);
	}

	public void remove(
		org.xmlportletfactory.portal.example01.model.PortletOne fileobj)
		throws com.liferay.portal.kernel.exception.SystemException {
		_portletOneLocalService.remove(fileobj);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PortletOneLocalService getWrappedPortletOneLocalService() {
		return _portletOneLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPortletOneLocalService(
		PortletOneLocalService portletOneLocalService) {
		_portletOneLocalService = portletOneLocalService;
	}

	public PortletOneLocalService getWrappedService() {
		return _portletOneLocalService;
	}

	public void setWrappedService(PortletOneLocalService portletOneLocalService) {
		_portletOneLocalService = portletOneLocalService;
	}

	private PortletOneLocalService _portletOneLocalService;
}