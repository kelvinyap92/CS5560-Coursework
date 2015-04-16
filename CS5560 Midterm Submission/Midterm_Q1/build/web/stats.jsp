<%-- 
    Document   : stats
    Created on : May 30, 2014, 3:37:52 PM
    Author     : KelvinYap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Webpage number of hits</title>
    </head>
    <body>
       
      
         <%
            
            int count1 = Integer.parseInt(request.getSession().getAttribute("Page1").toString());
            int count2 = Integer.parseInt(request.getSession().getAttribute("Page2").toString());
            int count3 = Integer.parseInt(request.getSession().getAttribute("Page3").toString());
        %>
        
        The number of hits to page1.html is <%=count1%><br/>
        The number of hits to page2.html is <%=count2%><br/>
        The number of hits to page3.html is <%=count3%><br/>
            
        <p><a href="./index.html">Back</a></p>
    </body>
</html>
