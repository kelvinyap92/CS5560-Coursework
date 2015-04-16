<%-- 
    Document   : index
    Created on : May 16, 2014, 1:08:56 AM
    Author     : KelvinYap
--%>


<jsp:useBean id="game" scope="session" class="edu.wmich.tictactoe.Game" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tic-Tac-Toe</title>
    </head>
    <body>
        <h1>CS5560 HW 2 - Q1 (Tic Tac Toe)</h1>
        
        <form action="formServlet" method="post">
            <input type="submit" name="User" value="User start"></br>
            <input type="submit" name="Computer" value="Computer start">
        </form>
    </body>
</html>
