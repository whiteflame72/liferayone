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

<%@ page import="org.xmlportletfactory.portal.example01.model.PortletOne" %>
<%@ page import="org.xmlportletfactory.portal.example01.service.PortletOneLocalServiceUtil" %>

<%@ page import="com.liferay.portlet.PortalPreferences" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="org.xmlportletfactory.portal.example01.PortletOneComparator" %>

<jsp:useBean id="addPortletOneURL" class="java.lang.String" scope="request" />
<jsp:useBean id="PortletOneFilterURL" class="java.lang.String" scope="request" />
<jsp:useBean id="PortletOneFilter" class="java.lang.String" scope="request" />
<link rel="stylesheet" type="text/css" href="/PortletOne-portlet/css/Portlet_PortletOne.css" />
<liferay-ui:success key="PortletOne-prefs-success" message="PortletOne-prefs-success" />
<liferay-ui:success key="PortletOne-added-successfully" message="PortletOne-added-successfully" />
<liferay-ui:success key="PortletOne-deleted-successfully" message="PortletOne-deleted-successfully" />
<liferay-ui:success key="PortletOne-updated-successfully" message="PortletOne-updated-successfully" />
<liferay-ui:error key="PortletOne-error-deleting" message="PortletOne-error-deleting" />
<liferay-ui:error key="dependent-rows-exist-error-deleting" message="dependent-rows-exist-error-deleting" />

<c:choose>
	<c:when test='<%= (Boolean)request.getAttribute("hasAddPermission") %>'>
		<input type="button" name="addPortletOneButton" value="<liferay-ui:message key="PortletOne-add" />" onClick="self.location = '<%=addPortletOneURL %>';">
	</c:when>
</c:choose>


<%
	String iconChecked = "checked";
	String iconUnchecked = "unchecked";
	int rows_per_page = new Integer(prefs.getValue("PortletOne-rows-per-page", "5"));
	if (Validator.isNotNull(PortletOneFilter) || !PortletOneFilter.equalsIgnoreCase("")) {
		rows_per_page = 100;
	}
	
	SimpleDateFormat dateFormat = new SimpleDateFormat(prefs.getValue("PortletOne-date-format", "yyyy/MM/dd"));
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat(prefs.getValue("PortletOne-datetime-format","yyyy/MM/dd HH:mm"));

	PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request);

	String orderByCol = ParamUtil.getString(request, "orderByCol");
	String orderByType = ParamUtil.getString(request, "orderByType");

	if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
		portalPrefs.setValue("PortletOne_order", "PortletOne-order-by-col", orderByCol);
		portalPrefs.setValue("PortletOne_order", "PortletOne-order-by-type", orderByType);
	} else {
		orderByCol = portalPrefs.getValue("PortletOne_order", "PortletOne-order-by-col", "PortletOneId");
		orderByType = portalPrefs.getValue("PortletOne_order", "PortletOne-order-by-type", "asc");
	}
%>
<liferay-ui:search-container  delta='<%= rows_per_page %>' emptyResultsMessage="PortletOne-empty-results-message" orderByCol="<%= orderByCol%>" orderByType="<%= orderByType%>">
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
		
		List<PortletOne> tempResults = (List<PortletOne>)request.getAttribute("tempResults");
		results = ListUtil.subList(tempResults, containerStart, containerEnd);
		total = tempResults.size();

		pageContext.setAttribute("results", results);
		pageContext.setAttribute("total", total);

		request.setAttribute("containerStart",String.valueOf(containerStart));
		request.setAttribute("containerEnd",String.valueOf(containerEnd));
		%>

	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="org.xmlportletfactory.portal.example01.model.PortletOne"
		keyProperty="portletOneId"
		modelVar="portletOne"
	>

		<liferay-ui:search-container-column-text
			name="PortletOne Description"
		    property="portletOneDescription"
			align="left"
		/>
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/JSPs/PortletOne/edit_actions.jsp"
		/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>
