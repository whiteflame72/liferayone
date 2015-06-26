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

import org.xmlportletfactory.portal.example01.model.PortletOne;
import org.xmlportletfactory.portal.example01.model.impl.PortletOneImpl;
import org.xmlportletfactory.portal.example01.service.PortletOneLocalServiceUtil;


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
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class PortletOne
 */
public class PortletOnePortlet extends MVCPortlet {



	public void init() throws PortletException {

		// Edit Mode Pages
		editJSP = getInitParameter("edit-jsp");

		// Help Mode Pages
		helpJSP = getInitParameter("help-jsp");

		// View Mode Pages
		viewJSP = getInitParameter("view-jsp");

		// View Mode Edit PortletOne
		editPortletOneJSP = getInitParameter("edit-PortletOne-jsp");
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
		} else if (jsp.equalsIgnoreCase("editPortletOne")) {
			try {
				showViewEditPortletOne(renderRequest, renderResponse);
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
		System.out.println("doEdit called");
	}

	public void doHelp(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		include(helpJSP, renderRequest, renderResponse);
		System.out.println("doHelp called");
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
				"org.xmlportletfactory.portal.example01.model", groupId, "ADD_PORTLETONE");

		List<PortletOne> tempResults = Collections.EMPTY_LIST;
		try {
			String orderByType = renderRequest.getParameter("orderByType");
			String orderByCol  = renderRequest.getParameter("orderByCol");
			OrderByComparator comparator = PortletOneComparator.getPortletOneOrderByComparator(orderByCol,orderByType);
			MultiVMPoolUtil.clear();

				tempResults = PortletOneLocalServiceUtil.findAllInGroup(groupId, comparator);
		
		} catch (Exception e) {
			_log.debug(e);
		}
		renderRequest.setAttribute("highlightRowWithKey", renderRequest.getParameter("highlightRowWithKey"));
		renderRequest.setAttribute("containerStart", renderRequest.getParameter("containerStart"));
		renderRequest.setAttribute("containerEnd", renderRequest.getParameter("containerEnd"));
		renderRequest.setAttribute("tempResults", tempResults);
		renderRequest.setAttribute("hasAddPermission", hasAddPermission);

		PortletURL addPortletOneURL = renderResponse.createActionURL();
		addPortletOneURL.setParameter("javax.portlet.action", "newPortletOne");
		renderRequest.setAttribute("addPortletOneURL", addPortletOneURL.toString());

		PortletURL PortletOneFilterURL = renderResponse.createRenderURL();
		PortletOneFilterURL.setParameter("javax.portlet.action", "doView");
		renderRequest.setAttribute("PortletOneFilterURL", PortletOneFilterURL.toString());

		include(viewJSP, renderRequest, renderResponse);
	}

	public void showViewEditPortletOne(RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {

		SimpleDateFormat formatDia    = new SimpleDateFormat("dd");
		SimpleDateFormat formatMes    = new SimpleDateFormat("MM");
		SimpleDateFormat formatAno    = new SimpleDateFormat("yyyy");
		SimpleDateFormat formatHora   = new SimpleDateFormat("HH");
		SimpleDateFormat formatMinuto = new SimpleDateFormat("mm");

		PortletURL editPortletOneURL = renderResponse.createActionURL();
		String editType = (String) renderRequest.getParameter("editType");
		
		
		PortletOne portletOne = null;
		if (editType.equalsIgnoreCase("edit")) {
			editPortletOneURL.setParameter("javax.portlet.action", "updatePortletOne");
			long PortletOneId = Long.parseLong(renderRequest.getParameter("PortletOneId"));
			portletOne = PortletOneLocalServiceUtil.getPortletOne(PortletOneId);
			String PortletOneDescription = portletOne.getPortletOneDescription()+"";
			renderRequest.setAttribute("PortletOneDescription", PortletOneDescription);
            renderRequest.setAttribute("portletOne", portletOne);
		} else {
			editPortletOneURL.setParameter("javax.portlet.action", "addPortletOne");
			PortletOne errorPortletOne = (PortletOne) renderRequest.getAttribute("errorPortletOne");
			if (errorPortletOne != null) {
				if (editType.equalsIgnoreCase("update")) {
					editPortletOneURL.setParameter("javax.portlet.action", "updatePortletOne");
                }
				renderRequest.setAttribute("portletOne", errorPortletOne);
			} else {
				PortletOneImpl blankPortletOne = new PortletOneImpl();
				blankPortletOne.setPortletOneId(0);
				blankPortletOne.setPortletOneDescription("");
				renderRequest.setAttribute("portletOne", blankPortletOne);
			}

		}

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		renderRequest.setAttribute("editPortletOneURL", editPortletOneURL.toString());

		include(editPortletOneJSP, renderRequest, renderResponse);
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
		SimpleDateFormat format = new SimpleDateFormat(prefs.getValue("PortletOne-date-format", "yyyy/MM/dd"));
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

	@ProcessAction(name = "newPortletOne")
	public void newPortletOne(ActionRequest request, ActionResponse response) {
		response.setRenderParameter("view", "editPortletOne");
		response.setRenderParameter("editType", "add");
	}

	@ProcessAction(name = "addPortletOne")
	public void addPortletOne(ActionRequest request, ActionResponse response) throws Exception {
            PortletOne portletOne = PortletOneFromRequest(request);
            ArrayList<String> errors = PortletOneValidator.validatePortletOne(portletOne, request); 
            
            if (errors.isEmpty()) {
				try {
					PortletOneLocalServiceUtil.addPortletOne(portletOne);
                	MultiVMPoolUtil.clear();
                	response.setRenderParameter("view", "");
                	SessionMessages.add(request, "PortletOne-added-successfully");
            	} catch (Exception cvex) {
            		SessionErrors.add(request, "please-enter-a-unique-code");
                    response.setRenderParameter("view", "editPortletOne");
                    response.setRenderParameter("editType", "add");
                    response.setRenderParameter("PortletOneId", portletOne.getPortletOneId()+"");
                    response.setRenderParameter("PortletOneDescription", portletOne.getPortletOneDescription()+"");
            	}
            } else {
                for (String error : errors) {
                        SessionErrors.add(request, error);
                }
                response.setRenderParameter("view", "editPortletOne");
                response.setRenderParameter("editType", "add");
                    response.setRenderParameter("PortletOneId", portletOne.getPortletOneId()+"");
                    response.setRenderParameter("PortletOneDescription", portletOne.getPortletOneDescription()+"");
            }
	}

	@ProcessAction(name = "eventPortletOne")
	public void eventPortletOne(ActionRequest request, ActionResponse response)
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

	@ProcessAction(name = "editPortletOne")
	public void editPortletOne(ActionRequest request, ActionResponse response)
			throws Exception {
		long key = ParamUtil.getLong(request, "resourcePrimKey");
		if (Validator.isNotNull(key)) {
			response.setRenderParameter("PortletOneId", Long.toString(key));
			response.setRenderParameter("view", "editPortletOne");
			response.setRenderParameter("editType", "edit");
		}
	}

	@ProcessAction(name = "deletePortletOne")
	public void deletePortletOne(ActionRequest request, ActionResponse response)throws Exception {
System.out.println("enter deletePortletOne");
		long id = ParamUtil.getLong(request, "resourcePrimKey");
		if (Validator.isNotNull(id)) {
			PortletOne portletOne = PortletOneLocalServiceUtil.getPortletOne(id);
			PortletOneLocalServiceUtil.deletePortletOne(portletOne);
            MultiVMPoolUtil.clear();
			SessionMessages.add(request, "PortletOne-deleted-successfully");
		} else {
			SessionErrors.add(request, "PortletOne-error-deleting");
		}
System.out.println("done deletePortletOne");
	}

	@ProcessAction(name = "updatePortletOne")
	public void updatePortletOne(ActionRequest request, ActionResponse response) throws Exception {
            PortletOne portletOne = PortletOneFromRequest(request);
            ArrayList<String> errors = PortletOneValidator.validatePortletOne(portletOne, request); 
            
            if (errors.isEmpty()) {
            	try {
                	PortletOneLocalServiceUtil.updatePortletOne(portletOne);
                	MultiVMPoolUtil.clear();
                	response.setRenderParameter("view", "");
                	SessionMessages.add(request, "PortletOne-updated-successfully");
            	} catch (Exception cvex) {
            		SessionErrors.add(request, "please-enter-a-unique-code");
                    response.setRenderParameter("view", "editPortletOne");
                    response.setRenderParameter("editType", "update");
                    response.setRenderParameter("PortletOneId", portletOne.getPortletOneId()+"");
                    response.setRenderParameter("PortletOneDescription", portletOne.getPortletOneDescription()+"");
            	}
            } else {
                for (String error : errors) {
                        SessionErrors.add(request, error);
                }
				response.setRenderParameter("PortletOneId)",Long.toString(portletOne.getPrimaryKey()));
				response.setRenderParameter("view", "editPortletOne");
				response.setRenderParameter("editType", "update");
                    response.setRenderParameter("PortletOneId", portletOne.getPortletOneId()+"");
                    response.setRenderParameter("PortletOneDescription", portletOne.getPortletOneDescription()+"");
            }
        }

	@ProcessAction(name = "setPortletOnePref")
	public void setPortletOnePref(ActionRequest request, ActionResponse response) throws Exception {

		String rowsPerPage = ParamUtil.getString(request, "PortletOne-rows-per-page");
		String dateFormat = ParamUtil.getString(request, "PortletOne-date-format");
		String datetimeFormat = ParamUtil.getString(request, "PortletOne-datetime-format");

		ArrayList<String> errors = new ArrayList();
		if (PortletOneValidator.validateEditPortletOne(rowsPerPage, dateFormat, datetimeFormat, errors)) {
			response.setRenderParameter("PortletOne-rows-per-page", "");
			response.setRenderParameter("PortletOne-date-format", "");
			response.setRenderParameter("PortletOne-datetime-format", "");

			PortletPreferences prefs = request.getPreferences();
			prefs.setValue("PortletOne-rows-per-page", rowsPerPage);
			prefs.setValue("PortletOne-date-format", dateFormat);
			prefs.setValue("PortletOne-datetime-format", datetimeFormat);
			prefs.store();

			SessionMessages.add(request, "PortletOne-prefs-success");
		}
	}

	private PortletOne PortletOneFromRequest(ActionRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletOneImpl portletOne = new PortletOneImpl();
        try {
            portletOne.setPortletOneId(ParamUtil.getLong(request, "PortletOneId"));
        } catch (Exception nfe) {
		    //Controled en Validator
        }
		portletOne.setPortletOneDescription(ParamUtil.getString(request, "PortletOneDescription"));
		try {
		    portletOne.setPrimaryKey(ParamUtil.getLong(request,"resourcePrimKey"));
		} catch (NumberFormatException nfe) {
			//Controled en Validator
        }
		portletOne.setCompanyId(themeDisplay.getCompanyId());
		portletOne.setGroupId(themeDisplay.getScopeGroupId());
		portletOne.setUserId(themeDisplay.getUserId());
		return portletOne;
	}


	protected String editPortletOneJSP;
	protected String editJSP;
	protected String helpJSP;
	protected String viewJSP;

	private static Log _log = LogFactoryUtil.getLog(PortletOnePortlet.class);

}
