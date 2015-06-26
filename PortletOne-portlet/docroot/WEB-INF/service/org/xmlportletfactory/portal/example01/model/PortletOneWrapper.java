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

package org.xmlportletfactory.portal.example01.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link PortletOne}.
 * </p>
 *
 * @author    Jack A. Rider
 * @see       PortletOne
 * @generated
 */
public class PortletOneWrapper implements PortletOne, ModelWrapper<PortletOne> {
	public PortletOneWrapper(PortletOne portletOne) {
		_portletOne = portletOne;
	}

	public Class<?> getModelClass() {
		return PortletOne.class;
	}

	public String getModelClassName() {
		return PortletOne.class.getName();
	}

	/**
	* Returns the primary key of this portlet one.
	*
	* @return the primary key of this portlet one
	*/
	public long getPrimaryKey() {
		return _portletOne.getPrimaryKey();
	}

	/**
	* Sets the primary key of this portlet one.
	*
	* @param primaryKey the primary key of this portlet one
	*/
	public void setPrimaryKey(long primaryKey) {
		_portletOne.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the portlet one ID of this portlet one.
	*
	* @return the portlet one ID of this portlet one
	*/
	public long getPortletOneId() {
		return _portletOne.getPortletOneId();
	}

	/**
	* Sets the portlet one ID of this portlet one.
	*
	* @param PortletOneId the portlet one ID of this portlet one
	*/
	public void setPortletOneId(long PortletOneId) {
		_portletOne.setPortletOneId(PortletOneId);
	}

	/**
	* Returns the company ID of this portlet one.
	*
	* @return the company ID of this portlet one
	*/
	public long getCompanyId() {
		return _portletOne.getCompanyId();
	}

	/**
	* Sets the company ID of this portlet one.
	*
	* @param companyId the company ID of this portlet one
	*/
	public void setCompanyId(long companyId) {
		_portletOne.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this portlet one.
	*
	* @return the group ID of this portlet one
	*/
	public long getGroupId() {
		return _portletOne.getGroupId();
	}

	/**
	* Sets the group ID of this portlet one.
	*
	* @param groupId the group ID of this portlet one
	*/
	public void setGroupId(long groupId) {
		_portletOne.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this portlet one.
	*
	* @return the user ID of this portlet one
	*/
	public long getUserId() {
		return _portletOne.getUserId();
	}

	/**
	* Sets the user ID of this portlet one.
	*
	* @param userId the user ID of this portlet one
	*/
	public void setUserId(long userId) {
		_portletOne.setUserId(userId);
	}

	/**
	* Returns the user uuid of this portlet one.
	*
	* @return the user uuid of this portlet one
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletOne.getUserUuid();
	}

	/**
	* Sets the user uuid of this portlet one.
	*
	* @param userUuid the user uuid of this portlet one
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_portletOne.setUserUuid(userUuid);
	}

	/**
	* Returns the portlet one description of this portlet one.
	*
	* @return the portlet one description of this portlet one
	*/
	public java.lang.String getPortletOneDescription() {
		return _portletOne.getPortletOneDescription();
	}

	/**
	* Sets the portlet one description of this portlet one.
	*
	* @param PortletOneDescription the portlet one description of this portlet one
	*/
	public void setPortletOneDescription(java.lang.String PortletOneDescription) {
		_portletOne.setPortletOneDescription(PortletOneDescription);
	}

	public boolean isNew() {
		return _portletOne.isNew();
	}

	public void setNew(boolean n) {
		_portletOne.setNew(n);
	}

	public boolean isCachedModel() {
		return _portletOne.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_portletOne.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _portletOne.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _portletOne.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_portletOne.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _portletOne.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_portletOne.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PortletOneWrapper((PortletOne)_portletOne.clone());
	}

	public int compareTo(PortletOne portletOne) {
		return _portletOne.compareTo(portletOne);
	}

	@Override
	public int hashCode() {
		return _portletOne.hashCode();
	}

	public com.liferay.portal.model.CacheModel<PortletOne> toCacheModel() {
		return _portletOne.toCacheModel();
	}

	public PortletOne toEscapedModel() {
		return new PortletOneWrapper(_portletOne.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _portletOne.toString();
	}

	public java.lang.String toXmlString() {
		return _portletOne.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_portletOne.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PortletOne getWrappedPortletOne() {
		return _portletOne;
	}

	public PortletOne getWrappedModel() {
		return _portletOne;
	}

	public void resetOriginalValues() {
		_portletOne.resetOriginalValues();
	}

	private PortletOne _portletOne;
}