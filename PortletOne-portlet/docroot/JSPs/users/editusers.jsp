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
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileEntry" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>


<jsp:useBean class="java.lang.String" id="editUsersURL" scope="request" />
<jsp:useBean id="users" type="org.xmlportletfactory.portal.example01.model.Users" scope="request"/>
<jsp:useBean id="usersId" class="java.lang.String" scope="request" />
<jsp:useBean id="userName" class="java.lang.String" scope="request" />
<jsp:useBean id="userPhoto" class="java.lang.String" scope="request" />
<jsp:useBean id="folderDLId" class="java.lang.String" scope="request" />

<portlet:defineObjects />


<liferay-ui:success key="users-added-successfully" message="users-added-successfully" />
<form name="addUsers" action="<%=editUsersURL %>" method="POST" enctype='multipart/form-data'>

	<input type="hidden" name="resourcePrimKey" value="<%=users.getPrimaryKey() %>">
	<input type="hidden" name="HIDDEN_userPhoto" value="<%=users.getUserPhoto() %>">
	<input type="hidden" name="HIDDEN_folderDLId" value="<%=users.getFolderDLId() %>">

	<table border="0">
		<tr>
			<td>
				<liferay-ui:message key="Users-userName" /><br>
            </td>
            <td>
				<liferay-ui:input-field model="<%= Users.class %>" field="userName" fieldParam="userName" defaultValue="<%= userName %>" disabled="false" />

				<liferay-ui:error key="Users-userName-required" message="Users-userName-required" />
	            <br>
				<br>
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="Users-userPhoto" /><br>
            </td>
            <td>
<% if (!userPhoto.trim().equalsIgnoreCase("") && !userPhoto.trim().equalsIgnoreCase("0")){
	DLFileEntry userPhoto_doc = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.parseLong(userPhoto));
	String userPhoto_url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + userPhoto_doc.getGroupId() + StringPool.SLASH + userPhoto_doc.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(HtmlUtil.unescape(userPhoto_doc.getTitle()));
%>
<%	if (userPhoto_doc.getMimeType().toLowerCase().contains("image")) { %>			
			<a href="<%= userPhoto_url %>" target="_blank"><img alt="" src="/documents/<%= userPhoto_doc.getRepositoryId() %>/<%= userPhoto_doc.getUuid() %>" width="100"><%= userPhoto_doc.getTitle() %></a>
<% } else { 
	String url_userPhoto_doc="/documents/"+userPhoto_doc.getRepositoryId()+"/" + userPhoto_doc.getUuid();
%>
        	<liferay-ui:icon
        		cssClass="top-link"
        		image='<%= "../file_system/small/" + userPhoto_doc.getIcon() %>'
        		label="<%= true %>"
        		message="<%= userPhoto_doc.getTitle() %>"
        		url='<%= url_userPhoto_doc %>'
        		target="_blank"
        	/>
<% } %>
        	<aui:input name="userPhoto_DELETEDOCUMENT" label="delete-field" type="checkbox" inlineField="true"/>
<% } %>
	        <aui:input name="userPhoto_DOCUMENTFILE" label="" type="file" />

				<liferay-ui:error key="Users-userPhoto-required" message="Users-userPhoto-required" />
	            <br>
				<br>
			</td>
		</tr>
	</table>
	<input type="submit" value="<liferay-ui:message key="submit" />" >
	<input type="button" value="<liferay-ui:message key="cancel" />" onClick="self.location = '<portlet:renderURL></portlet:renderURL>';" />
</form>