<%-- 
    Document   : index
    Created on : May 17, 2014, 8:31:08 PM
    Author     : KelvinYap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>CS5560 H2Q2 - Temperature Conversion</title>
    </head>
    <body>
 <div id="page">  
 <div id="title">    
<label>Temperature Converter </label> </div>
        
 <form  align="center" action="index.jsp" method="POST">
     <jsp:useBean id="jb" class="edu.wmich.convert.Javabean" scope="session"></jsp:useBean>
     <jsp:setProperty name="jb" property="from" param="fromCh"></jsp:setProperty>
     <jsp:setProperty name="jb" property="to" param="toCh"></jsp:setProperty>
     <jsp:setProperty name="jb" property="temperature" param="convert"></jsp:setProperty>
     
     <div class="row"> 
 <div class="col-xs-4" align="left">
     <label>Convert: </label>
    <input type="text" id="convert" name="convert" class="form-control" placeholder="Enter input.. ">
  </div>
    </div>
        
  <div align="left">
  <table border="0">
      
  <tr>
      
      
  <td> <label> From: </label><br>
      
           <input type="radio" name="fromCh" value="FrCelsius" id="FrCelsius">Celsius<br>
            <input type="radio" name="fromCh" value="FrFahrenheit" id="FrFahrenheit">Fahrenheit<br>
             <input type="radio" name="fromCh" value="FrKelvin" id="FrKelvin">Kelvin<br>
              <input type="radio" name="fromCh" value="FrRankine" id="FrRankine">Rankine<br>

          </td>
      
        <td> <b>To: </b> <br>
 
            <input type="radio" name="toCh" value="ToCelsius" id="ToCelsius">Celsius<br>
            <input type="radio" name="toCh" value="ToFahrenheit" id="ToFahrenheit">Fahrenheit<br>
             <input type="radio" name="toCh" value="ToKelvin" id="ToKelvin">Kelvin<br>
              <input type="radio" name="toCh" value="ToRankine" id="ToRankine">Rankine<br>
         </td>
     
  </tr>
  
      <!-- submit form -->
      <tr>
       <td colspan="20"align="left">   
           <input type="submit" id ="convert" value="Convert" name="Go"></td> 
         
      </tr>
      
      <!-- Answer form -->
      <tr>
         
    <!--  <td align="left" colspan="2" height="5"><input type="text" class="border" name ="answer"  size="60"></td> -->
    <td align="center" colspan="1" height="5"> 
        <br>
    <% if(request.getParameter("convert") != null) 
        {%>
                <%=jb.getNewTemperature() %>
                <%=jb.getFunction() %>
                <%}
                %>
                </td>
    
      </tr>
      
   </table>
                
  </div>
     
   
  </form>

        
        <footer>CS5560 - Homework 2 (Q2), Done By Kelvin Yap </footer>
 </div>  
 
 </body>
</html>
