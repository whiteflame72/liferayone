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
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>


<jsp:useBean class="java.lang.String" id="editPortletOneURL" scope="request" />
<jsp:useBean id="portletOne" type="org.xmlportletfactory.portal.example01.model.PortletOne" scope="request"/>
<jsp:useBean id="PortletOneId" class="java.lang.String" scope="request" />
<jsp:useBean id="PortletOneDescription" class="java.lang.String" scope="request" />

<portlet:defineObjects />


<liferay-ui:success key="portletOne-added-successfully" message="portletOne-added-successfully" />
<form name="addPortletOne" action="<%=editPortletOneURL %>" method="POST">

	<input type="hidden" name="resourcePrimKey" value="<%=portletOne.getPrimaryKey() %>">

	<table border="0">
		<tr>
			<td>
				<liferay-ui:message key="PortletOne-PortletOneDescription" /><br>
            </td>
            <td>
				<liferay-ui:input-field model="<%= PortletOne.class %>" field="PortletOneDescription" fieldParam="PortletOneDescription" defaultValue="<%= PortletOneDescription %>" disabled="false" />
		        *

				<liferay-ui:error key="PortletOne-PortletOneDescription-required" message="PortletOne-PortletOneDescription-required" />
	            <br>
				<br>
			</td>
		</tr>
	</table>
	<input type="submit" value="<liferay-ui:message key="submit" />" >
	<input type="button" value="<liferay-ui:message key="cancel" />" onClick="self.location = '<portlet:renderURL></portlet:renderURL>';" />
</form>