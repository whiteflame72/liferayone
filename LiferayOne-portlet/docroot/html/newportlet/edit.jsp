<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="javax.portlet.PortletPreferences" %>

<portlet:defineObjects />

<%
PortletPreferences prefs = renderRequest.getPreferences();

String greeting = renderRequest.getParameter("greeting");

if (greeting != null) {
	prefs.setValue("greeting", greeting);
	prefs.store();
%>
	<p>Greeting saved successfully!</p>
<%
}
%>

<%
greeting = (String)prefs.getValue("greeting", "Hello! Welcome to our portal.");
String viewJSP = (String) renderRequest.getPortletSession().getAttribute("viewJSP");
String editJSP = (String) renderRequest.getPortletSession().getAttribute("editJSP");
%>
<portlet:renderURL var="editGreetingURL">
	<portlet:param name="jspPage" value='<%= editJSP %>' />
</portlet:renderURL>

<aui:form action="<%= editGreetingURL %>" method="post">
	<aui:input label="greeting" name="greeting" type="text" value="<%= greeting %>" />
	<aui:button type="submit" />
</aui:form>

<portlet:renderURL var="viewGreetingURL">
	<portlet:param name="jspPage" value="<%= viewJSP %>" />
</portlet:renderURL>
<p>
<p><a href="<%= viewGreetingURL %>">Back</a></p>