<%-- 
    Document   : game
    Created on : May 16, 2014, 1:35:18 AM
    Author     : KelvinYap
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="edu.wmich.tictactoe.Game.State" %>
<%@page import="edu.wmich.tictactoe.Cells" %>
<%@page import="edu.wmich.tictactoe.Lines" %>

<jsp:useBean id="game" scope="session" class="edu.wmich.tictactoe.Game" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tic-Tac-Toe</title>
    </head>
    <body>
        <h1>Let's Play!</h1>
        <table border="1">
            <c:forEach var="lines" items="${game.gridLines}">
             <tr>
                 <c:forEach var="cells" items="${game.getGridStatus(lines)}" >
                  <td>
                      <c:choose>
                          <c:when test="${cells.state == 'X'}" >
                             <img src="img/x.png" alt="X" />
                          </c:when>
                          <c:when test="${cells.state == 'O'}" >
                              <img src="img/o.png" alt="O" />
                          </c:when>
                          <c:otherwise>
                              <c:if test="${winner == null}" >
                                  <a href="gameServlet?Lines=${cells.lines}&Cols=${cells.cols}">
                            </c:if>  
                                 <img src="img/null.png" alt="null" />
                                 <c:if test="${winner == null} " >
                                     </a>
                                 </c:if>
                              
                          </c:otherwise>
                      </c:choose>
                              </td>
                 </c:forEach>
               </tr>               
            </c:forEach>
        </table>
        
        <c:if test="${winner != null}">
            <h2>${winner}</h2>
            <form action="index.jsp" method="POST">
                <input type="submit" name="Restart" value="Restart"><br/>
            </form>
            </c:if>
    </body>
</html>
