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

import com.fl.uploadfile.service.UploadFileLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Manisha
 */
public class UploadFileClp extends BaseModelImpl<UploadFile>
	implements UploadFile {
	public UploadFileClp() {
	}

	public Class<?> getModelClass() {
		return UploadFile.class;
	}

	public String getModelClassName() {
		return UploadFile.class.getName();
	}

	public long getPrimaryKey() {
		return _fileUploadId;
	}

	public void setPrimaryKey(long primaryKey) {
		setFileUploadId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_fileUploadId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getFileUploadId() {
		return _fileUploadId;
	}

	public void setFileUploadId(long fileUploadId) {
		_fileUploadId = fileUploadId;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getSize() {
		return _size;
	}

	public void setSize(long size) {
		_size = size;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			UploadFileLocalServiceUtil.addUploadFile(this);
		}
		else {
			UploadFileLocalServiceUtil.updateUploadFile(this);
		}
	}

	@Override
	public UploadFile toEscapedModel() {
		return (UploadFile)Proxy.newProxyInstance(UploadFile.class.getClassLoader(),
			new Class[] { UploadFile.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UploadFileClp clone = new UploadFileClp();

		clone.setFileUploadId(getFileUploadId());
		clone.setFileEntryId(getFileEntryId());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setSize(getSize());

		return clone;
	}

	public int compareTo(UploadFile uploadFile) {
		int value = 0;

		value = getTitle().compareTo(uploadFile.getTitle());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		UploadFileClp uploadFile = null;

		try {
			uploadFile = (UploadFileClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = uploadFile.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{fileUploadId=");
		sb.append(getFileUploadId());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", size=");
		sb.append(getSize());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.fl.uploadfile.model.UploadFile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>fileUploadId</column-name><column-value><![CDATA[");
		sb.append(getFileUploadId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>size</column-name><column-value><![CDATA[");
		sb.append(getSize());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _fileUploadId;
	private long _fileEntryId;
	private String _title;
	private String _description;
	private long _size;
}