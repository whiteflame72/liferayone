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
 
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.xml.namespace.QName;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.portlet.PortletFileUpload;
import org.apache.commons.beanutils.BeanComparator;

import org.xmlportletfactory.portal.example01.model.Users;
import org.xmlportletfactory.portal.example01.model.impl.UsersImpl;
import org.xmlportletfactory.portal.example01.service.UsersLocalServiceUtil;


import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Users
 */
public class UsersPortlet extends MVCPortlet {


	private UsersUpload uploadManager;

	public void init() throws PortletException {

		// Edit Mode Pages
		editJSP = getInitParameter("edit-jsp");

		// Help Mode Pages
		helpJSP = getInitParameter("help-jsp");

		// View Mode Pages
		viewJSP = getInitParameter("view-jsp");

		// View Mode Edit Users
		editusersJSP = getInitParameter("edit-users-jsp");
	}

	protected void include(String path, RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext()
				.getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			// do nothing
			// _log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		String jsp = (String) renderRequest.getParameter("view");
		if (jsp == null || jsp.equals("")) {
			showViewDefault(renderRequest, renderResponse);
		} else if (jsp.equalsIgnoreCase("editUsers")) {
			try {
				showViewEditUsers(renderRequest, renderResponse);
			} catch (Exception ex) {
				_log.debug(ex);
				try {
					showViewDefault(renderRequest, renderResponse);
				} catch (Exception ex1) {
					_log.debug(ex1);
				}
			}
		}
	}

	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		showEditDefault(renderRequest, renderResponse);
	}

	public void doHelp(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		include(helpJSP, renderRequest, renderResponse);
	}

	@SuppressWarnings("unchecked")
	public void showViewDefault(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = themeDisplay.getScopeGroupId();

		PermissionChecker permissionChecker = themeDisplay
				.getPermissionChecker();

		boolean hasAddPermission = permissionChecker.hasPermission(groupId,
				"org.xmlportletfactory.portal.example01.model", groupId, "ADD_USERS");

		List<Users> tempResults = Collections.EMPTY_LIST;
		try {
			String orderByType = renderRequest.getParameter("orderByType");
			String orderByCol  = renderRequest.getParameter("orderByCol");
			OrderByComparator comparator = UsersComparator.getUsersOrderByComparator(orderByCol,orderByType);
			MultiVMPoolUtil.clear();

			String usersFilter = ParamUtil.getString(renderRequest, "usersFilter");
			if (usersFilter.equalsIgnoreCase("")) {
				tempResults = UsersLocalServiceUtil.findAllInGroup(groupId, comparator);
			} else {
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(Users.class)
				.add(
					PropertyFactoryUtil.forName("userName").like("%"+ParamUtil.getString(renderRequest, "usersFilter")+"%")
				);
				tempResults = UsersLocalServiceUtil.dynamicQuery(query, -1, -1, comparator);
			}
		
		} catch (Exception e) {
			_log.debug(e);
		}
		renderRequest.setAttribute("highlightRowWithKey", renderRequest.getParameter("highlightRowWithKey"));
		renderRequest.setAttribute("containerStart", renderRequest.getParameter("containerStart"));
		renderRequest.setAttribute("containerEnd", renderRequest.getParameter("containerEnd"));
		renderRequest.setAttribute("tempResults", tempResults);
		renderRequest.setAttribute("hasAddPermission", hasAddPermission);

		PortletURL addUsersURL = renderResponse.createActionURL();
		addUsersURL.setParameter("javax.portlet.action", "newUsers");
		renderRequest.setAttribute("addUsersURL", addUsersURL.toString());

		PortletURL usersFilterURL = renderResponse.createRenderURL();
		usersFilterURL.setParameter("javax.portlet.action", "doView");
		renderRequest.setAttribute("usersFilterURL", usersFilterURL.toString());

		include(viewJSP, renderRequest, renderResponse);
	}

	public void showViewEditUsers(RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {

		SimpleDateFormat formatDia    = new SimpleDateFormat("dd");
		SimpleDateFormat formatMes    = new SimpleDateFormat("MM");
		SimpleDateFormat formatAno    = new SimpleDateFormat("yyyy");
		SimpleDateFormat formatHora   = new SimpleDateFormat("HH");
		SimpleDateFormat formatMinuto = new SimpleDateFormat("mm");

		PortletURL editUsersURL = renderResponse.createActionURL();
		String editType = (String) renderRequest.getParameter("editType");
		
		
		Users users = null;
		if (editType.equalsIgnoreCase("edit")) {
			editUsersURL.setParameter("javax.portlet.action", "updateUsers");
			long usersId = Long.parseLong(renderRequest.getParameter("usersId"));
			users = UsersLocalServiceUtil.getUsers(usersId);
			String userName = users.getUserName()+"";
			renderRequest.setAttribute("userName", userName);
			String userPhoto = users.getUserPhoto()+"";
			renderRequest.setAttribute("userPhoto", userPhoto);
		    String folderDLId = users.getFolderDLId()+"";
			renderRequest.setAttribute("folderDLId", folderDLId);
            renderRequest.setAttribute("users", users);
		} else {
			editUsersURL.setParameter("javax.portlet.action", "addUsers");
			Users errorUsers = (Users) renderRequest.getAttribute("errorUsers");
			if (errorUsers != null) {
				if (editType.equalsIgnoreCase("update")) {
					editUsersURL.setParameter("javax.portlet.action", "updateUsers");
                }
				renderRequest.setAttribute("users", errorUsers);
	            String userPhoto = errorUsers.getUserPhoto()+"";
				renderRequest.setAttribute("userPhoto",userPhoto);
		        String folderDLId = errorUsers.getUserPhoto()+"";
				renderRequest.setAttribute("folderDLId",folderDLId);
			} else {
				UsersImpl blankUsers = new UsersImpl();
				blankUsers.setUsersId(0);
				blankUsers.setUserName("");
				renderRequest.setAttribute("users", blankUsers);
			}

		}

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		renderRequest.setAttribute("editUsersURL", editUsersURL.toString());

		include(editusersJSP, renderRequest, renderResponse);
	}

	private String dateToJsp(ActionRequest request, Date date) {
		PortletPreferences prefs = request.getPreferences();
		return dateToJsp(prefs, date);
	}
	private String dateToJsp(RenderRequest request, Date date) {
		PortletPreferences prefs = request.getPreferences();
		return dateToJsp(prefs, date);
	}
	private String dateToJsp(PortletPreferences prefs, Date date) {
		SimpleDateFormat format = new SimpleDateFormat(prefs.getValue("users-date-format", "yyyy/MM/dd"));
		String stringDate = format.format(date);
		return stringDate;
	}
	private String dateTimeToJsp(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String stringDate = format.format(date);
		return stringDate;
	}

	public void showEditDefault(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		include(editJSP, renderRequest, renderResponse);
	}

	/* Portlet Actions */

	@ProcessAction(name = "newUsers")
	public void newUsers(ActionRequest request, ActionResponse response) {
		response.setRenderParameter("view", "editUsers");
		response.setRenderParameter("editType", "add");
	}

	@ProcessAction(name = "addUsers")
	public void addUsers(ActionRequest request, ActionResponse response) throws Exception {
            boolean isMultipart = PortletFileUpload.isMultipartContent(request);
            if (isMultipart) {
            	uploadManager = new UsersUpload();
				request = extractFields(request,false);
            }
            Users users = UsersFromRequest(request);
            ArrayList<String> errors = UsersValidator.validateUsers(users, request); 
            
            if (errors.isEmpty()) {
	            users = uploadManager.uploadFiles(request,users);
				try {
					UsersLocalServiceUtil.addUsers(users);
                	MultiVMPoolUtil.clear();
                	response.setRenderParameter("view", "");
                	SessionMessages.add(request, "users-added-successfully");
            	} catch (Exception cvex) {
            		SessionErrors.add(request, "please-enter-a-unique-code");
                    response.setRenderParameter("view", "editUsers");
                    response.setRenderParameter("editType", "add");
                    response.setRenderParameter("usersId", users.getUsersId()+"");
                    response.setRenderParameter("userName", users.getUserName()+"");
                    response.setRenderParameter("userPhoto", users.getUserPhoto()+"");
            	}
            } else {
                for (String error : errors) {
                        SessionErrors.add(request, error);
                }
                response.setRenderParameter("view", "editUsers");
                response.setRenderParameter("editType", "add");
                    response.setRenderParameter("usersId", users.getUsersId()+"");
                    response.setRenderParameter("userName", users.getUserName()+"");
                    response.setRenderParameter("userPhoto", users.getUserPhoto()+"");
            }
	}

	@ProcessAction(name = "eventUsers")
	public void eventUsers(ActionRequest request, ActionResponse response)
			throws Exception {
		long key = ParamUtil.getLong(request, "resourcePrimKey");
		int containerStart = ParamUtil.getInteger(request, "containerStart");
		int containerEnd = ParamUtil.getInteger(request, "containerEnd");
		if (Validator.isNotNull(key)) {
            response.setRenderParameter("highlightRowWithKey", Long.toString(key));
            response.setRenderParameter("containerStart", Integer.toString(containerStart));
            response.setRenderParameter("containerEnd", Integer.toString(containerEnd));
		}
	}

	@ProcessAction(name = "editUsers")
	public void editUsers(ActionRequest request, ActionResponse response)
			throws Exception {
		long key = ParamUtil.getLong(request, "resourcePrimKey");
		if (Validator.isNotNull(key)) {
			response.setRenderParameter("usersId", Long.toString(key));
			response.setRenderParameter("view", "editUsers");
			response.setRenderParameter("editType", "edit");
		}
	}

	@ProcessAction(name = "deleteUsers")
	public void deleteUsers(ActionRequest request, ActionResponse response)throws Exception {
		long id = ParamUtil.getLong(request, "resourcePrimKey");
		if (Validator.isNotNull(id)) {
			Users users = UsersLocalServiceUtil.getUsers(id);
			UsersLocalServiceUtil.deleteUsers(users);
            MultiVMPoolUtil.clear();
			SessionMessages.add(request, "users-deleted-successfully");
		} else {
			SessionErrors.add(request, "users-error-deleting");
		}
	}

	@ProcessAction(name = "updateUsers")
	public void updateUsers(ActionRequest request, ActionResponse response) throws Exception {
            boolean isMultipart = PortletFileUpload.isMultipartContent(request);
            if (isMultipart) {
				uploadManager = new UsersUpload();
				request = extractFields(request,true);
            }
            Users users = UsersFromRequest(request);
            ArrayList<String> errors = UsersValidator.validateUsers(users, request); 
            
		    users = uploadManager.uploadFiles(request, users);
            if (errors.isEmpty()) {
            	try {
                	UsersLocalServiceUtil.updateUsers(users);
                	MultiVMPoolUtil.clear();
                	response.setRenderParameter("view", "");
                	SessionMessages.add(request, "users-updated-successfully");
            	} catch (Exception cvex) {
            		SessionErrors.add(request, "please-enter-a-unique-code");
                    response.setRenderParameter("view", "editUsers");
                    response.setRenderParameter("editType", "update");
                    response.setRenderParameter("usersId", users.getUsersId()+"");
                    response.setRenderParameter("userName", users.getUserName()+"");
                    response.setRenderParameter("userPhoto", users.getUserPhoto()+"");
            	}
            } else {
                for (String error : errors) {
                        SessionErrors.add(request, error);
                }
				response.setRenderParameter("usersId)",Long.toString(users.getPrimaryKey()));
				response.setRenderParameter("view", "editUsers");
				response.setRenderParameter("editType", "update");
                    response.setRenderParameter("usersId", users.getUsersId()+"");
                    response.setRenderParameter("userName", users.getUserName()+"");
                    response.setRenderParameter("userPhoto", users.getUserPhoto()+"");
            }
        }

	@ProcessAction(name = "setUsersPref")
	public void setUsersPref(ActionRequest request, ActionResponse response) throws Exception {

		String rowsPerPage = ParamUtil.getString(request, "users-rows-per-page");
		String dateFormat = ParamUtil.getString(request, "users-date-format");
		String datetimeFormat = ParamUtil.getString(request, "users-datetime-format");

		ArrayList<String> errors = new ArrayList();
		if (UsersValidator.validateEditUsers(rowsPerPage, dateFormat, datetimeFormat, errors)) {
			response.setRenderParameter("users-rows-per-page", "");
			response.setRenderParameter("users-date-format", "");
			response.setRenderParameter("users-datetime-format", "");

			PortletPreferences prefs = request.getPreferences();
			prefs.setValue("users-rows-per-page", rowsPerPage);
			prefs.setValue("users-date-format", dateFormat);
			prefs.setValue("users-datetime-format", datetimeFormat);
			prefs.store();

			SessionMessages.add(request, "users-prefs-success");
		}
	}

	private Users UsersFromRequest(ActionRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		UsersImpl users = new UsersImpl();
        try {
		    users.setUsersId(Long.valueOf(request.getAttribute("usersId").toString()));
        } catch (Exception nfe) {
		    //Controled en Validator
        }
		users.setUserName(request.getAttribute("userName").toString());
		try {
			users.setPrimaryKey(Long.valueOf(request.getAttribute("resourcePrimKey").toString()));
		} catch (NumberFormatException nfe) {
			//Controled en Validator
        }
		users.setCompanyId(themeDisplay.getCompanyId());
		users.setGroupId(themeDisplay.getScopeGroupId());
		users.setUserId(themeDisplay.getUserId());
		return users;
	}

	private ActionRequest extractFields(ActionRequest request,boolean edit) throws FileUploadException{

		FileItemFactory factory = new DiskFileItemFactory();
        PortletFileUpload uploadItems = new PortletFileUpload(factory);
        List <FileItem>allItems = uploadItems.parseRequest(request);
         //Separate formFields <-> fileItems
         for(FileItem item : allItems){
         	String formField = item.getFieldName();
         	if (item.isFormField()) {
         		//Non-file items
         		//Push all to request object
				if(formField.startsWith(UsersUpload.HIDDEN)) {
					uploadManager.addHidden(formField,Long.parseLong(item.getString()));
				} else if (formField.endsWith(UsersUpload.DOCUMENT_DELETE)) {
					int pos = formField.indexOf(UsersUpload.DOCUMENT_DELETE);
					formField = formField.substring(0,pos-1);
					int pos2 = formField.lastIndexOf(UsersUpload.SEPARATOR);
					formField = formField.substring(pos2+1);
					if(item.getString().equals("true")) uploadManager.addDeleted(formField);
				} else {
					int pos = formField.lastIndexOf(UsersUpload.SEPARATOR);
					formField = formField.substring(pos+1);
					try {
					    request.setAttribute(formField,item.getString("UTF-8").trim());
					} catch (Exception e) {
					}
				}
         	} else {
         		uploadManager.add(item);
         	}
         }
		return request;
	}

	protected String editusersJSP;
	protected String editJSP;
	protected String helpJSP;
	protected String viewJSP;

	private static Log _log = LogFactoryUtil.getLog(UsersPortlet.class);

}
