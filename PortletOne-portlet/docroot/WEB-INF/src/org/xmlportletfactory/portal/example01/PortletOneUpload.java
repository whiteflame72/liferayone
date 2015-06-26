/**
 *     Copyright (C) 2009-2012  Jack A. Rider All rights reserved.
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 */
 
 package org.xmlportletfactory.portal.example01;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import org.apache.commons.fileupload.FileItem;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;

import org.xmlportletfactory.portal.example01.model.PortletOne;

/**
 * Upload implementation class PortletOne
 */
public class PortletOneUpload {

	public static String HIDDEN = "HIDDEN";
	public static String SEPARATOR = "_";

	public static String DOCUMENT_DELETE = "DELETEDOCUMENT";
	public static String DOCUMENTFILE = "DOCUMENTFILE";
	public static String DOCUMENTLIBRARY_REQUESTFOLDER = HIDDEN+SEPARATOR+"folderDLId";
	public static String DOCUMENTLIBRARY_MAINFOLDER = "XMLPortletFactoryUploads";
	public static String DOCUMENTLIBRARY_PORTLETFOLDER = "PortletOne";
	public static String DOCUMENTLIBRARY_MAINFOLDER_DESCRIPTION = "XMLPortletFactory Portlet Document Uploads";
	public static String DOCUMENTLIBRARY_PORTLETFOLDER_DESCRIPTION = "Portlet Onecc";

	private long dlFolderId = 0L;

	private List<FileItem> files = null;
	private HashMap hiddens = null;
	private HashMap deleteds = null;

	public PortletOneUpload() {
		init();
	}

	private void init(){
		files = new ArrayList<FileItem>();
		hiddens = new HashMap();
		deleteds = new HashMap();
		dlFolderId = 0L;
	}

	public void add(FileItem item) {
		if(files==null) files = new ArrayList<FileItem>();
		files.add(item);
	}

	public void addHidden(String formField, Long value){
		if(hiddens==null) hiddens = new HashMap();
		//Check if Hidden folders
		if (formField.equalsIgnoreCase(DOCUMENTLIBRARY_REQUESTFOLDER)){
			if((value!=null)&& (value!=0L)) dlFolderId = value;
		} else {
			hiddens.put(formField, value);
		}
	}

	public void addDeleted(String formField) {
		if(deleteds==null) deleteds = new HashMap();
		deleteds.put(formField,new Boolean("true"));
	}

	public PortletOne uploadFiles(ActionRequest request,PortletOne portletOne) throws PortalException, SystemException, IOException, SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException{

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
    	long groupId = UserLocalServiceUtil.getUser(userId).getGroupId();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
    	
        String[] groupPermissions = StringUtil.split("DELETE,UPDATE,VIEW");
        String[] guestPermissions = StringUtil.split("DELETE,UPDATE,VIEW");
        serviceContext.setGroupPermissions(groupPermissions);
        serviceContext.setGuestPermissions(guestPermissions);

		for(FileItem item : files) {
			String formField = item.getFieldName();
			String strType = formField.substring(formField.lastIndexOf(SEPARATOR)+1);
			if(strType.equalsIgnoreCase(DOCUMENTFILE)) {
				formField = getFieldFromAttribute(extractSufix(DOCUMENTFILE,formField));
				if(deleteds.get(formField)!=null){
					Long prevDocument = (Long)hiddens.get(HIDDEN+SEPARATOR+formField);
					if((prevDocument!=null)&&(prevDocument!=0L)) {
						DLFileEntryLocalServiceUtil.deleteDLFileEntry(prevDocument);
					}
				} else if(!item.getName().equals("")){
					if(dlFolderId==0L) {
						createDLFolders(request,userId,groupId,serviceContext);
					}
					
					String sourceFileName = item.getName();		
					String title = sourceFileName;
					String description = sourceFileName;
					long folderId = dlFolderId;
					String changeLog = "changeLog";
					InputStream inputStream = null;
					long fileSize = item.getSize();
					String contentType = item.getContentType();

					inputStream = item.getInputStream();
					
					DLFolder dlFolder = DLFolderLocalServiceUtil.getDLFolder(folderId);
					
					FileEntry fileEntry = DLAppServiceUtil.addFileEntry(
							dlFolder.getRepositoryId(), folderId, sourceFileName, contentType, title,
							description, changeLog, inputStream, fileSize, serviceContext);
					
					callSetMethod(formField,portletOne,fileEntry.getFileEntryId());
					
					//Check possible previous values
					if(hiddens!=null){
						Long prevDocument = (Long)hiddens.get(HIDDEN+SEPARATOR+formField);
						if((prevDocument!=null)&&(prevDocument!=0L)){
							//Delete previous document
							DLFileEntryLocalServiceUtil.deleteDLFileEntry(prevDocument);
						}
					}
				} else {
					//See hidden value, possible edit
					if(hiddens!=null){
						Long prevDocument = (Long)hiddens.get(HIDDEN+SEPARATOR+formField);
						if((prevDocument!=null)&&(prevDocument!=0L)) {
							callSetMethod(formField,portletOne,(Long)hiddens.get(HIDDEN+SEPARATOR+formField));
						}
					}
				}
			}
		}
		return portletOne;
	}

	private void callSetMethod(String formField, PortletOne portletOne, Long value) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		String strMethod = "set"+StringUtil.upperCaseFirstLetter(formField);
		Method methodSet = portletOne.getClass().getMethod(strMethod,long.class);
		methodSet.invoke(portletOne, value);
	}

	/**
	 * Create folders for upload documents from our portlet to DocumentLibrary portlet
	 * @param request
	 * @param userId
	 * @param groupId
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private void createDLFolders(ActionRequest request,Long userId,Long groupId,ServiceContext serviceContext) throws PortalException, SystemException{
		//Variables for folder ids
		Long dlMainFolderId = 0L;
		Long dlPortletFolderId = 0L;
		Long dlRecordFolderId = 0L;
		//Search for folder in Document Library
        boolean dlMainFolderFound = false;
        boolean dlPortletFolderFound = false;
		long repositoryId = 0L;
		if (dlFolderId == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID ){
			repositoryId = groupId;
		} else {
			repositoryId = dlFolderId;
		}
        
        //Get main folder
        try {
        	//Get main folder
        	DLFolder dlFolderMain = DLFolderLocalServiceUtil.getFolder(groupId,0,DOCUMENTLIBRARY_MAINFOLDER);
        	dlMainFolderId = dlFolderMain.getFolderId();
        	dlMainFolderFound = true;
        	//Get portlet folder
        	DLFolder dlFolderPortlet = DLFolderLocalServiceUtil.getFolder(groupId,dlMainFolderId,DOCUMENTLIBRARY_PORTLETFOLDER);
        	dlPortletFolderId = dlFolderPortlet.getFolderId();
        	dlPortletFolderFound = true;
        } catch (Exception ex){
        	System.out.println("Needed document folders not found, will create now.");//Not found Main Folder
        }
        //Create main folder if not exist
        if(!dlMainFolderFound){
        	DLFolder newDocumentMainFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, repositoryId, false, 0, DOCUMENTLIBRARY_MAINFOLDER, DOCUMENTLIBRARY_MAINFOLDER_DESCRIPTION, serviceContext);
        	dlMainFolderId = newDocumentMainFolder.getFolderId();
        	dlMainFolderFound = true;
        }
        //Create portlet folder if not exist
        if(dlMainFolderFound && !dlPortletFolderFound){
        	DLFolder newDocumentPortletFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, repositoryId, false, dlMainFolderId , DOCUMENTLIBRARY_PORTLETFOLDER, DOCUMENTLIBRARY_PORTLETFOLDER_DESCRIPTION, serviceContext);
            dlPortletFolderId = newDocumentPortletFolder.getFolderId();
        	dlPortletFolderFound = true;
        }

        //Create this record folder
        if(dlPortletFolderFound){
        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        	Date date = new Date();
        	String dlRecordFolderName = dateFormat.format(date)+SEPARATOR+userId;
        	DLFolder newDocumentRecordFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, repositoryId, false, dlPortletFolderId, dlRecordFolderName, dlRecordFolderName, serviceContext);
        	dlRecordFolderId = newDocumentRecordFolder.getFolderId();
        }
        dlFolderId = dlRecordFolderId;
	}

	/**
	  * Extract a given sufix from a String
	  * This method loof for sufix, and then, substring the rest to the left.
	  * Posible last char = "_" deleted
	  * @param sufix
	  * @param itemName
	  * @return
	  */
	private String extractSufix (String sufix, String itemName){
		String result = itemName;
			if(itemName!=null && sufix!=null){
				int lastPos  = itemName.lastIndexOf(sufix);
				result = itemName.substring(0,lastPos);
				//Delete posible "_" char
				if(result.substring(result.length()-1,result.length()).equals("_")) {
					result = result.substring(0,result.length()-1);
				}
			}
		return result;
	}

	/**
	 * Get the field string from the attribute string
	 * @param attribute
	 * @return
	 */
	private String getFieldFromAttribute(String attribute){
		return attribute.substring(attribute.lastIndexOf(SEPARATOR)+1);
	}
}
