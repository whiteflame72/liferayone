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

<%@ page import="org.xmlportletfactory.portal.example01.model.PortletOne"%>
<%@ page import="org.xmlportletfactory.portal.example01.service.PortletOneLocalServiceUtil"%>

<%
String containerStart = (String) request.getAttribute("containerStart");
String containerEnd =  (String) request.getAttribute("containerEnd");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
PortletOne portletOne = (PortletOne)row.getObject();

long groupId = portletOne.getGroupId();
String name = PortletOne.class.getName();
String primKey = String.valueOf(portletOne.getPrimaryKey());

%>
<c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.UPDATE) %>">
    <portlet:actionURL name="eventPortletOne" var="eventPortletOneURL">
        <portlet:param name="resourcePrimKey" value="<%=primKey %>" />
        <portlet:param name="containerStart" value="<%= containerStart %>" />
        <portlet:param name="containerEnd" value="<%= containerEnd %>" />
    </portlet:actionURL>
<%
	if (primKey.equalsIgnoreCase((String)request.getAttribute("highlightRowWithKey"))) {
%>
    <liferay-ui:icon image="forward" url="<%=eventPortletOneURL.toString() %>" />
<%
	} else {
%>    
    <liferay-ui:icon image="view" url="<%=eventPortletOneURL.toString() %>" />
<%
	}
%>     
</c:if>
