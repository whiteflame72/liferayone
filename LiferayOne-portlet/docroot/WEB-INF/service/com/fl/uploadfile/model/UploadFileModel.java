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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the UploadFile service. Represents a row in the &quot;TK_UploadFile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.fl.uploadfile.model.impl.UploadFileModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.fl.uploadfile.model.impl.UploadFileImpl}.
 * </p>
 *
 * @author Manisha
 * @see UploadFile
 * @see com.fl.uploadfile.model.impl.UploadFileImpl
 * @see com.fl.uploadfile.model.impl.UploadFileModelImpl
 * @generated
 */
public interface UploadFileModel extends BaseModel<UploadFile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a upload file model instance should use the {@link UploadFile} interface instead.
	 */

	/**
	 * Returns the primary key of this upload file.
	 *
	 * @return the primary key of this upload file
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this upload file.
	 *
	 * @param primaryKey the primary key of this upload file
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the file upload ID of this upload file.
	 *
	 * @return the file upload ID of this upload file
	 */
	public long getFileUploadId();

	/**
	 * Sets the file upload ID of this upload file.
	 *
	 * @param fileUploadId the file upload ID of this upload file
	 */
	public void setFileUploadId(long fileUploadId);

	/**
	 * Returns the file entry ID of this upload file.
	 *
	 * @return the file entry ID of this upload file
	 */
	public long getFileEntryId();

	/**
	 * Sets the file entry ID of this upload file.
	 *
	 * @param fileEntryId the file entry ID of this upload file
	 */
	public void setFileEntryId(long fileEntryId);

	/**
	 * Returns the title of this upload file.
	 *
	 * @return the title of this upload file
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this upload file.
	 *
	 * @param title the title of this upload file
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this upload file.
	 *
	 * @return the description of this upload file
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this upload file.
	 *
	 * @param description the description of this upload file
	 */
	public void setDescription(String description);

	/**
	 * Returns the size of this upload file.
	 *
	 * @return the size of this upload file
	 */
	public long getSize();

	/**
	 * Sets the size of this upload file.
	 *
	 * @param size the size of this upload file
	 */
	public void setSize(long size);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(UploadFile uploadFile);

	public int hashCode();

	public CacheModel<UploadFile> toCacheModel();

	public UploadFile toEscapedModel();

	public String toString();

	public String toXmlString();
}