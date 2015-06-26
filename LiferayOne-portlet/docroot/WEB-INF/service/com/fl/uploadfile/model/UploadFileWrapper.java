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

package com.fl.uploadfile.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link UploadFile}.
 * </p>
 *
 * @author    Manisha
 * @see       UploadFile
 * @generated
 */
public class UploadFileWrapper implements UploadFile, ModelWrapper<UploadFile> {
	public UploadFileWrapper(UploadFile uploadFile) {
		_uploadFile = uploadFile;
	}

	public Class<?> getModelClass() {
		return UploadFile.class;
	}

	public String getModelClassName() {
		return UploadFile.class.getName();
	}

	/**
	* Returns the primary key of this upload file.
	*
	* @return the primary key of this upload file
	*/
	public long getPrimaryKey() {
		return _uploadFile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this upload file.
	*
	* @param primaryKey the primary key of this upload file
	*/
	public void setPrimaryKey(long primaryKey) {
		_uploadFile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the file upload ID of this upload file.
	*
	* @return the file upload ID of this upload file
	*/
	public long getFileUploadId() {
		return _uploadFile.getFileUploadId();
	}

	/**
	* Sets the file upload ID of this upload file.
	*
	* @param fileUploadId the file upload ID of this upload file
	*/
	public void setFileUploadId(long fileUploadId) {
		_uploadFile.setFileUploadId(fileUploadId);
	}

	/**
	* Returns the file entry ID of this upload file.
	*
	* @return the file entry ID of this upload file
	*/
	public long getFileEntryId() {
		return _uploadFile.getFileEntryId();
	}

	/**
	* Sets the file entry ID of this upload file.
	*
	* @param fileEntryId the file entry ID of this upload file
	*/
	public void setFileEntryId(long fileEntryId) {
		_uploadFile.setFileEntryId(fileEntryId);
	}

	/**
	* Returns the title of this upload file.
	*
	* @return the title of this upload file
	*/
	public java.lang.String getTitle() {
		return _uploadFile.getTitle();
	}

	/**
	* Sets the title of this upload file.
	*
	* @param title the title of this upload file
	*/
	public void setTitle(java.lang.String title) {
		_uploadFile.setTitle(title);
	}

	/**
	* Returns the description of this upload file.
	*
	* @return the description of this upload file
	*/
	public java.lang.String getDescription() {
		return _uploadFile.getDescription();
	}

	/**
	* Sets the description of this upload file.
	*
	* @param description the description of this upload file
	*/
	public void setDescription(java.lang.String description) {
		_uploadFile.setDescription(description);
	}

	/**
	* Returns the size of this upload file.
	*
	* @return the size of this upload file
	*/
	public long getSize() {
		return _uploadFile.getSize();
	}

	/**
	* Sets the size of this upload file.
	*
	* @param size the size of this upload file
	*/
	public void setSize(long size) {
		_uploadFile.setSize(size);
	}

	public boolean isNew() {
		return _uploadFile.isNew();
	}

	public void setNew(boolean n) {
		_uploadFile.setNew(n);
	}

	public boolean isCachedModel() {
		return _uploadFile.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_uploadFile.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _uploadFile.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _uploadFile.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_uploadFile.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _uploadFile.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_uploadFile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UploadFileWrapper((UploadFile)_uploadFile.clone());
	}

	public int compareTo(com.fl.uploadfile.model.UploadFile uploadFile) {
		return _uploadFile.compareTo(uploadFile);
	}

	@Override
	public int hashCode() {
		return _uploadFile.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fl.uploadfile.model.UploadFile> toCacheModel() {
		return _uploadFile.toCacheModel();
	}

	public com.fl.uploadfile.model.UploadFile toEscapedModel() {
		return new UploadFileWrapper(_uploadFile.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _uploadFile.toString();
	}

	public java.lang.String toXmlString() {
		return _uploadFile.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_uploadFile.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public UploadFile getWrappedUploadFile() {
		return _uploadFile;
	}

	public UploadFile getWrappedModel() {
		return _uploadFile;
	}

	public void resetOriginalValues() {
		_uploadFile.resetOriginalValues();
	}

	private UploadFile _uploadFile;
}