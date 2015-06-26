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

<liferay-ui:success key="users-prefs-success" message="users-prefs-success" />

<form name="setUsersPref" action="<portlet:actionURL name="setUsersPref" />" method="POST">
<table border="0">
	<tbody>
		<tr>
			<td>
				<liferay-ui:message key="users-rows-per-page" />*<br>
				<input type="text" name="users-rows-per-page" value="<%=prefs.getValue("users-rows-per-page","") %>" size="5" />
				<liferay-ui:error key="users-rows-per-page-required" message="users-rows-per-page-required" />
				<liferay-ui:error key="users-rows-per-page-invalid" message="users-rows-per-page-invalid" />
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="users-date-format" />*<br>
				<input type="text" name="users-date-format" value="<%=prefs.getValue("users-date-format","")%>" size="45" />
				<liferay-ui:error key="users-date-format-required" message="users-date-format-required" />
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="users-datetime-format" />*<br>
				<input type="text" name="users-datetime-format" value="<%=prefs.getValue("users-datetime-format","")%>" size="45" />
				<liferay-ui:error key="users-datetime-format-required" message="users-datetime-format-required" />
			</td>
		</tr>
	</tbody>
</table>
<input type="submit" value="Submit" />
</form>
