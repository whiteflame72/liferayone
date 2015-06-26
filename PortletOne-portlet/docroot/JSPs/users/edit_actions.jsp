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

<%@ page import="org.xmlportletfactory.portal.example01.model.Users"%>
<%@ page import="org.xmlportletfactory.portal.example01.service.UsersLocalServiceUtil"%>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Users users = (Users)row.getObject();

long groupId = users.getGroupId();
String name = Users.class.getName();
String primKey = String.valueOf(users.getPrimaryKey());

%>
<liferay-ui:icon-menu cssClass="">

	<c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.UPDATE) %>">
		<portlet:actionURL name="editUsers" var="editUsersURL">
			<portlet:param name="resourcePrimKey" value="<%=primKey %>" />
		</portlet:actionURL>

		<liferay-ui:icon image="edit" url="<%=editUsersURL.toString() %>" />
	</c:if>

	<c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.DELETE) %>">
		<portlet:actionURL name="deleteUsers" var="deleteUsersURL">
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:actionURL>

		<liferay-ui:icon image="delete" url="<%=deleteUsersURL.toString() %>" />
	</c:if>
</liferay-ui:icon-menu>