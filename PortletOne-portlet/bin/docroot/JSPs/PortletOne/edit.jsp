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

<liferay-ui:success key="PortletOne-prefs-success" message="PortletOne-prefs-success" />

<form name="setPortletOnePref" action="<portlet:actionURL name="setPortletOnePref" />" method="POST">
<table border="0">
	<tbody>
		<tr>
			<td>
				<liferay-ui:message key="PortletOne-rows-per-page" />*<br>
				<input type="text" name="PortletOne-rows-per-page" value="<%=prefs.getValue("PortletOne-rows-per-page","") %>" size="5" />
				<liferay-ui:error key="PortletOne-rows-per-page-required" message="PortletOne-rows-per-page-required" />
				<liferay-ui:error key="PortletOne-rows-per-page-invalid" message="PortletOne-rows-per-page-invalid" />
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="PortletOne-date-format" />*<br>
				<input type="text" name="PortletOne-date-format" value="<%=prefs.getValue("PortletOne-date-format","")%>" size="45" />
				<liferay-ui:error key="PortletOne-date-format-required" message="PortletOne-date-format-required" />
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="PortletOne-datetime-format" />*<br>
				<input type="text" name="PortletOne-datetime-format" value="<%=prefs.getValue("PortletOne-datetime-format","")%>" size="45" />
				<liferay-ui:error key="PortletOne-datetime-format-required" message="PortletOne-datetime-format-required" />
			</td>
		</tr>
	</tbody>
</table>
<input type="submit" value="Submit" />
</form>
