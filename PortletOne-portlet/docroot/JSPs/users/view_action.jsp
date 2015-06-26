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
String containerStart = (String) request.getAttribute("containerStart");
String containerEnd =  (String) request.getAttribute("containerEnd");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Users users = (Users)row.getObject();

long groupId = users.getGroupId();
String name = Users.class.getName();
String primKey = String.valueOf(users.getPrimaryKey());

%>
<c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.UPDATE) %>">
    <portlet:actionURL name="eventUsers" var="eventUsersURL">
        <portlet:param name="resourcePrimKey" value="<%=primKey %>" />
        <portlet:param name="containerStart" value="<%= containerStart %>" />
        <portlet:param name="containerEnd" value="<%= containerEnd %>" />
    </portlet:actionURL>
<%
	if (primKey.equalsIgnoreCase((String)request.getAttribute("highlightRowWithKey"))) {
%>
    <liferay-ui:icon image="forward" url="<%=eventUsersURL.toString() %>" />
<%
	} else {
%>    
    <liferay-ui:icon image="view" url="<%=eventUsersURL.toString() %>" />
<%
	}
%>     
</c:if>
