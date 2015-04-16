/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wmich;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KelvinYap
 */
@WebServlet(name = "CountServlet", urlPatterns = {"/CountServlet"})
public class CountServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
              String page = request.getParameter("page");
            int count = 0;

            if (page.equals("page1")) {
               
                if(request.getSession(true) != null){
                Object o = request.getSession(true).getAttribute("Page1");
                if (o != null) {
                    count = Integer.parseInt(o.toString());
                } 
                count++;
                request.getSession(true).setAttribute("Page1", count);
                request.getRequestDispatcher("page1.html").forward(request, response);
                }
                else{
                 request.getSession().invalidate();
                //by default it is set to 30 mins
                request.getSession().getLastAccessedTime();
                }
                
            } else if (page.equals("page2")) {
                
                if(request.getSession(true) != null) {
                Object o = request.getSession(true).getAttribute("Page2");
                if (o != null) {
                    count = Integer.parseInt(o.toString());
                }
                
                   
                count++;
                request.getSession(true).setAttribute("Page2", count);
                request.getRequestDispatcher("page2.html").forward(request, response);
                } else {
                       request.getSession().invalidate();
                //by default it is set to 30 mins
                request.getSession().getLastAccessedTime();
                }
                
            } else if (page.equals("page3")) {
                
                if(request.getSession(true) != null) {
                Object o = request.getSession(true).getAttribute("Page3");
                if (o != null) {
                    count = Integer.parseInt(o.toString());
                }
                count++;
                request.getSession(true).setAttribute("Page3", count);
                request.getRequestDispatcher("page3.html").forward(request, response);
                } else{
                 request.getSession().invalidate();
                //by default it is set to 30 mins
                request.getSession().getLastAccessedTime();
                }
                
                
            } else if (page.equals("stats")) {
                if (request.getSession(false)== null) {
                   // out.println("test");
                  //If session is null, it will return to index.html 
                    out.println("View page1-page3 to get stats");
                    request.getRequestDispatcher("index.html").forward(request, response);
                }
                else
                {
                 request.getRequestDispatcher("stats.jsp").forward(request, response);

                }
                }
                
            }
        }
    
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
