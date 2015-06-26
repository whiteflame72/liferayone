/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.fl.uploadfile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link UploadFileLocalService}.
 * </p>
 *
 * @author    Manisha
 * @see       UploadFileLocalService
 * @generated
 */
public class UploadFileLocalServiceWrapper implements UploadFileLocalService,
	ServiceWrapper<UploadFileLocalService> {
	public UploadFileLocalServiceWrapper(
		UploadFileLocalService uploadFileLocalService) {
		_uploadFileLocalService = uploadFileLocalService;
	}

	/**
	* Adds the upload file to the database. Also notifies the appropriate model listeners.
	*
	* @param uploadFile the upload file
	* @return the upload file that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.fl.uploadfile.model.UploadFile addUploadFile(
		com.fl.uploadfile.model.UploadFile uploadFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uploadFileLocalService.addUploadFile(uploadFile);
	}

	/**
	* Creates a new upload file with the primary key. Does not add the upload file to the database.
	*
	* @param fileUploadId the primary key for the new upload file
	* @return the new upload file
	*/
	public com.fl.uploadfile.model.UploadFile createUploadFile(
		long fileUploadId) {
		return _uploadFileLocalService.createUploadFile(fileUploadId);
	}

	/**
	* Deletes the upload file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fileUploadId the primary key of the upload file
	* @throws PortalException if a upload file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUploadFile(long fileUploadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_uploadFileLocalService.deleteUploadFile(fileUploadId);
	}

	/**
	* Deletes the upload file from the database. Also notifies the appropriate model listeners.
	*
	* @param uploadFile the upload file
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUploadFile(com.fl.uploadfile.model.UploadFile uploadFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		_uploadFileLocalService.deleteUploadFile(uploadFile);
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
		return _uploadFileLocalService.dynamicQuery(dynamicQuery);
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
		return _uploadFileLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _uploadFileLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _uploadFileLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.fl.uploadfile.model.UploadFile fetchUploadFile(long fileUploadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uploadFileLocalService.fetchUploadFile(fileUploadId);
	}

	/**
	* Returns the upload file with the primary key.
	*
	* @param fileUploadId the primary key of the upload file
	* @return the upload file
	* @throws PortalException if a upload file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fl.uploadfile.model.UploadFile getUploadFile(long fileUploadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _uploadFileLocalService.getUploadFile(fileUploadId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _uploadFileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the upload files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of upload files
	* @param end the upper bound of the range of upload files (not inclusive)
	* @return the range of upload files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fl.uploadfile.model.UploadFile> getUploadFiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uploadFileLocalService.getUploadFiles(start, end);
	}

	/**
	* Returns the number of upload files.
	*
	* @return the number of upload files
	* @throws SystemException if a system exception occurred
	*/
	public int getUploadFilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uploadFileLocalService.getUploadFilesCount();
	}

	/**
	* Updates the upload file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param uploadFile the upload file
	* @return the upload file that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fl.uploadfile.model.UploadFile updateUploadFile(
		com.fl.uploadfile.model.UploadFile uploadFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uploadFileLocalService.updateUploadFile(uploadFile);
	}

	/**
	* Updates the upload file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param uploadFile the upload file
	* @param merge whether to merge the upload file with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the upload file that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fl.uploadfile.model.UploadFile updateUploadFile(
		com.fl.uploadfile.model.UploadFile uploadFile, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uploadFileLocalService.updateUploadFile(uploadFile, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _uploadFileLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_uploadFileLocalService.setBeanIdentifier(beanIdentifier);
	}

	public com.fl.uploadfile.model.UploadFile addFile(long fileEntryId,
		java.lang.String title, java.lang.String description, long size)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uploadFileLocalService.addFile(fileEntryId, title, description,
			size);
	}

	public java.util.List<com.fl.uploadfile.model.UploadFile> getAllFiles()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uploadFileLocalService.getAllFiles();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public UploadFileLocalService getWrappedUploadFileLocalService() {
		return _uploadFileLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedUploadFileLocalService(
		UploadFileLocalService uploadFileLocalService) {
		_uploadFileLocalService = uploadFileLocalService;
	}

	public UploadFileLocalService getWrappedService() {
		return _uploadFileLocalService;
	}

	public void setWrappedService(UploadFileLocalService uploadFileLocalService) {
		_uploadFileLocalService = uploadFileLocalService;
	}

	private UploadFileLocalService _uploadFileLocalService;
}