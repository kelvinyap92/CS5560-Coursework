package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>CS5560 H2Q2 - Temperature Conversion</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write(" <div id=\"page\">  \n");
      out.write(" <div id=\"title\">    \n");
      out.write("<label>Temperature Converter </label> </div>\n");
      out.write("        \n");
      out.write(" <form name=\"MainForm\" align=\"center\" action=\"index.jsp\" method=\"POST\">\n");
      out.write("     ");
      edu.wmich.convert.JavaBean javaBean = null;
      synchronized (session) {
        javaBean = (edu.wmich.convert.JavaBean) _jspx_page_context.getAttribute("javaBean", PageContext.SESSION_SCOPE);
        if (javaBean == null){
          javaBean = new edu.wmich.convert.JavaBean();
          _jspx_page_context.setAttribute("javaBean", javaBean, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("javaBean"), "temp", request.getParameter("what"), request, "what", false);
      out.write("\n");
      out.write("     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("javaBean"), "from", request.getParameter("fromCh"), request, "fromCh", false);
      out.write("\n");
      out.write("     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("javaBean"), "to", request.getParameter("toCh"), request, "toCh", false);
      out.write("\n");
      out.write("     \n");
      out.write("     <div class=\"row\"> \n");
      out.write(" <div class=\"col-xs-4\" align=\"left\">\n");
      out.write("     <label>Convert: </label>\n");
      out.write("    <input type=\"text\" id=\"what\" name=\"what\" class=\"form-control\" placeholder=\"Enter input.. \">\n");
      out.write("  </div>\n");
      out.write("    </div>\n");
      out.write("        \n");
      out.write("  <div align=\"left\">\n");
      out.write("  <table border=\"0\">\n");
      out.write("      \n");
      out.write("  <tr>\n");
      out.write("      \n");
      out.write("      \n");
      out.write("  <td> <label> From: </label><br>\n");
      out.write("      \n");
      out.write("           <input type=\"radio\" name=\"fromCh\" value=\"FrCelsius\" id=\"FrCelsius\">Celsius<br>\n");
      out.write("            <input type=\"radio\" name=\"fromCh\" value=\"FrFahrenheit\" id=\"FrFahrenheit\">Fahrenheit<br>\n");
      out.write("             <input type=\"radio\" name=\"fromCh\" value=\"FrKelvin\" id=\"FrKelvin\">Kelvin<br>\n");
      out.write("              <input type=\"radio\" name=\"fromCh\" value=\"FrRankine\" id=\"FrRankine\">Rankine<br>\n");
      out.write("\n");
      out.write("          </td>\n");
      out.write("      \n");
      out.write("        <td> <b>To: </b> <br>\n");
      out.write(" \n");
      out.write("            <input type=\"radio\" name=\"toCh\" value=\"ToCelsius\" id=\"ToCelsius\">Celsius<br>\n");
      out.write("            <input type=\"radio\" name=\"toCh\" value=\"ToFahrenheit\" id=\"ToFahrenheit\">Fahrenheit<br>\n");
      out.write("             <input type=\"radio\" name=\"toCh\" value=\"ToKelvin\" id=\"ToKelvin\">Kelvin<br>\n");
      out.write("              <input type=\"radio\" name=\"toCh\" value=\"ToRankine\" id=\"ToRankine\">Rankine<br>\n");
      out.write("         </td>\n");
      out.write("     \n");
      out.write("  </tr>\n");
      out.write("  \n");
      out.write("      <!-- submit form -->\n");
      out.write("      <tr>\n");
      out.write("       <td colspan=\"20\"align=\"left\">   \n");
      out.write("           <input type=\"button\" id =\"convert\" value=\"Convert\" name=\"Go\" onClick=\"myCon()\"></td> \n");
      out.write("         \n");
      out.write("      </tr>\n");
      out.write("      \n");
      out.write("      <!-- Answer form -->\n");
      out.write("      <tr>\n");
      out.write("         \n");
      out.write("      <td align=\"left\" colspan=\"2\" height=\"5\"><input type=\"text\" class=\"border\" name =\"answer\"  size=\"60\"></td>\n");
      out.write("         ");
 if(request.getParameter("convert") != null) 
        {
      out.write("\n");
      out.write("                ");
      out.print(javaBean.getNewTemperature());
      out.write("\n");
      out.write("                ");
      out.print(javaBean.getFunction());
      out.write("\n");
      out.write("                ");
}
                
      out.write("\n");
      out.write("      \n");
      out.write("      </tr>\n");
      out.write("      \n");
      out.write("   </table>\n");
      out.write("                \n");
      out.write("  </div>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <footer>CS5560 - Homework 2 (Q2), Done By Kelvin Yap </footer>\n");
      out.write(" </div>   \n");
      out.write(" </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
