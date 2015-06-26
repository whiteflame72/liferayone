<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="com.liferay.portal.kernel.util.*"%>
<%@ page import="com.liferay.portal.kernel.portlet.*"%>
<%@ page import="com.liferay.portal.theme.*"%>
<%@ page import="com.liferay.portal.model.*"%>
<%@ page import="com.liferay.portal.kernel.bean.*"%>
<%@ page import="com.liferay.portal.kernel.repository.model.*"%>
<%@ page import="com.liferay.portlet.documentlibrary.model.*"%>
<%@ page import="com.liferay.portlet.documentlibrary.service.*"%>
<%@ page import="com.liferay.portlet.documentlibrary.util.*"%>

<%@ include file="/init.jsp" %>

<!--
<portlet:defineObjects />
This is the <b>NewPortlet</b> portlet in View mode.
-->

<%
//PortletPreferences prefs = renderRequest.getPreferences();
String greeting = (String)prefs.getValue("greeting", "Hello! Welcome to our portal.");
String editJSP = (String)renderRequest.getPortletSession().getAttribute("editJSP");
%>


<%
//http://www.jarvana.com/jarvana/view/com/liferay/portal/portal-web/6.1.0/portal-web-6.1.0.war!/html/portlet/document_library/file_entry_action.jsp?format=ok
/* long defaultFolderId = GetterUtil.getLong(prefs.getValue("rootFolderId", StringPool.BLANK), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0,"SCI Upload Folder");
long folderId = BeanParamUtil.getLong(dlFolder, request, "folderId", defaultFolderId);;
 */
PortletURL multiselectUrl = renderResponse.createActionURL();
%>

<html>
<body>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<!--
<portlet:actionURL name="uploadMultipleFile" var="uploadMultipleFileURL"/>                                      
<form action="<%= uploadMultipleFileURL.toString() %>" method="post" id="UploadForm" name="UploadForm" >
	<label for=""><liferay-ui:message key="signature" /></label>
   	<input type="file" name="<portlet:namespace />signature" id="<portlet:namespace />signature">
</form>
-->
 
<p><%= greeting %></p>

<portlet:renderURL var="editGreetingURL">
    <portlet:param name="jspPage" value="<%= editJSP %>" />
</portlet:renderURL>

<div class="lfr-upload-container" id="<portlet:namespace />testaui_holder"></div>

<div id="<portlet:namespace />testaui_fallback"></div>

<p><a href="<%= editGreetingURL %>">Edit greeting</a></p>
</body>
</html>