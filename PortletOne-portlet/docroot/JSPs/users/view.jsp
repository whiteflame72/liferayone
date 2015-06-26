<%
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
%> 
<%@include file="../init.jsp" %>

<%@ page import="org.xmlportletfactory.portal.example01.model.Users" %>
<%@ page import="org.xmlportletfactory.portal.example01.service.UsersLocalServiceUtil" %>

<%@ page import="com.liferay.portlet.PortalPreferences" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="org.xmlportletfactory.portal.example01.UsersComparator" %>

<jsp:useBean id="addUsersURL" class="java.lang.String" scope="request" />
<jsp:useBean id="usersFilterURL" class="java.lang.String" scope="request" />
<jsp:useBean id="usersFilter" class="java.lang.String" scope="request" />
<link rel="stylesheet" type="text/css" href="/PortletOne-portlet/css/Portlet_users.css" />
<liferay-ui:success key="users-prefs-success" message="users-prefs-success" />
<liferay-ui:success key="users-added-successfully" message="users-added-successfully" />
<liferay-ui:success key="users-deleted-successfully" message="users-deleted-successfully" />
<liferay-ui:success key="users-updated-successfully" message="users-updated-successfully" />
<liferay-ui:error key="users-error-deleting" message="users-error-deleting" />
<liferay-ui:error key="dependent-rows-exist-error-deleting" message="dependent-rows-exist-error-deleting" />

<c:choose>
	<c:when test='<%= (Boolean)request.getAttribute("hasAddPermission") %>'>
		<input type="button" name="addusersButton" value="<liferay-ui:message key="users-add" />" onClick="self.location = '<%=addUsersURL %>';">
	</c:when>
</c:choose>


<form id="usersFilterForm" name="usersFilterForm" action="<%=usersFilterURL %>" method="POST">
	<input type="text" name="usersFilter" value="<%= usersFilter %>" />
	<input type="submit" value="<liferay-ui:message key="filter" />">
</form>
<%
	String iconChecked = "checked";
	String iconUnchecked = "unchecked";
	int rows_per_page = new Integer(prefs.getValue("users-rows-per-page", "5"));
	if (Validator.isNotNull(usersFilter) || !usersFilter.equalsIgnoreCase("")) {
		rows_per_page = 100;
	}
	
	SimpleDateFormat dateFormat = new SimpleDateFormat(prefs.getValue("users-date-format", "yyyy/MM/dd"));
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat(prefs.getValue("users-datetime-format","yyyy/MM/dd HH:mm"));

	PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request);

	String orderByCol = ParamUtil.getString(request, "orderByCol");
	String orderByType = ParamUtil.getString(request, "orderByType");

	if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
		portalPrefs.setValue("users_order", "users-order-by-col", orderByCol);
		portalPrefs.setValue("users_order", "users-order-by-type", orderByType);
	} else {
		orderByCol = portalPrefs.getValue("users_order", "users-order-by-col", "usersId");
		orderByType = portalPrefs.getValue("users_order", "users-order-by-type", "asc");
	}
%>
<liferay-ui:search-container  delta='<%= rows_per_page %>' emptyResultsMessage="users-empty-results-message" orderByCol="<%= orderByCol%>" orderByType="<%= orderByType%>">
	<liferay-ui:search-container-results>

		<%
		int containerStart;
		int containerEnd;
		try {
			containerStart = ParamUtil.getInteger(request, "containerStart");
			containerEnd = ParamUtil.getInteger(request, "containerEnd");
		} catch (Exception e) {
			containerStart = searchContainer.getStart();
			containerEnd = searchContainer.getEnd();
		}
		if (containerStart <=0) {
			containerStart = searchContainer.getStart();
			containerEnd = searchContainer.getEnd();
		}
		
		List<Users> tempResults = (List<Users>)request.getAttribute("tempResults");
		results = ListUtil.subList(tempResults, containerStart, containerEnd);
		total = tempResults.size();

		pageContext.setAttribute("results", results);
		pageContext.setAttribute("total", total);

		request.setAttribute("containerStart",String.valueOf(containerStart));
		request.setAttribute("containerEnd",String.valueOf(containerEnd));
		%>

	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="org.xmlportletfactory.portal.example01.model.Users"
		keyProperty="usersId"
		modelVar="users"
	>

		<liferay-ui:search-container-column-text
			name="Id"
		    property="usersId"
			orderable="true"
			orderableProperty="usersId"
			align="right"
		/>
		<liferay-ui:search-container-column-text
			name="Name"
		    property="userName"
			orderable="true"
			orderableProperty="userName"
			align="left"
		/>
		<liferay-ui:search-container-column-text name="Photo" align="center">
			<%
 				String userPhotoIcon = iconUnchecked;
				Long userPhoto = users.getUserPhoto();
				if (userPhoto.compareTo(new Long(0))>0) {
 					userPhotoIcon= iconChecked;
 				}
 			  %>
 			  <liferay-ui:icon image="<%=userPhotoIcon %>"/>
 		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/JSPs/users/edit_actions.jsp"
		/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>
