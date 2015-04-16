<%@page import="com.google.appengine.api.datastore.FetchOptions"%>
<%@page import="com.google.appengine.api.datastore.Entity"%>
<%@page import="com.google.appengine.api.datastore.Query"%>
<%@page import="com.google.appengine.api.datastore.KeyFactory"%>
<%@page import="com.google.appengine.api.datastore.Key"%>
<%@page import="com.google.appengine.api.datastore.DatastoreServiceFactory"%>
<%@page import="com.google.appengine.api.datastore.DatastoreService"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>

</head>

<body>

        <%
            UserService userService = UserServiceFactory.getUserService();
            User user = userService.getCurrentUser();

            if (user == null) {
        %>
        <a href="<%=userService.createLoginURL(request.getRequestURI())%>">Sign in</a>
        <%
        } else {
            pageContext.setAttribute("user", user);
        %>
        <a href="<%=userService.createLogoutURL(request.getRequestURI())%>">Sign out</a>
<%-- //[START datastore]--%>
<%
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    
    // Run an ancestor query to ensure we see the most up-to-date
    // view of the Greetings belonging to the selected Guestbook.
    Query query = new Query("Greeting");
    List<Entity> greetings = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(100));
    
   
%>
<form action="/sign" method="get">
<table>
    <thead><tr><td>Username</td><td>URL</td><td>Password</td></tr></thead>
    
   
<%
    
    for (Entity greeting : greetings) {
        pageContext.setAttribute("greeting_username",
                greeting.getProperty("username"));
         pageContext.setAttribute("greeting_url",
                greeting.getProperty("url"));
          pageContext.setAttribute("greeting_password",
                greeting.getProperty("password"));
          
          String key = KeyFactory.keyToString(greeting.getKey());
          
          
          
       
%>

<tr>

<td>${fn:escapeXml(greeting_username)}</td>
<td>${fn:escapeXml(greeting_url)}</td>
<td>${fn:escapeXml(greeting_password)}</td>
<td><input type="hidden" name="key" value='<%=key%>'/></td>
<td><input type="submit" value="Delete"></td>
</tr>
  


<%
        
    }
    
%>
</table>
</form>

<form action="/sign" method="post">
    Username<input type="text" name="username" >
    URL     <input type="text" name="url" >
    Password<input type="text" name="password" >
    <input type="submit" value="Enter Vault"/>
 
</form>
<%-- //[END datastore]--%>
<%
            }%>
</body>
</html>