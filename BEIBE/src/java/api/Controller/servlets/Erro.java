/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
@WebServlet(name = "Erro", urlPatterns = {"/Erro"})
public class Erro extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
           out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='utf-8'>");
            out.println("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
            out.println("<title>Login</title>");            
            out.println("<link rel=\"shortcut icon\" href=\"./assets/img/favicon.png\"/>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"./assets/css/style.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("</head>");
            out.println("<body");
            out.println("<div><nav class=\"navbar navbar-light bg-light shadow-sm px-5 mb-4\">\n" +
"            <img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png\" height=\"30\" class=\"d-inline-block align-top\" alt=\"\">\n" +
"            <a href=\"./\" class=\"navbar-nav\">Home</a>\n" +
"            <a href=\"sobre.jsp\">Sobre</a>\n" +
"            <a href=\"login.jsp\">Login</a>\n" +
"        </nav>");
            out.println("</div><div class=\"container\">");
            out.println("<h1>" + request.getAttribute("msg") + "</h1>");
            String page = (String)request.getAttribute("page");
            out.println("<a href=\""+page+"\"><button class=\"btn-primary\">Voltar</button></a></div>");
            out.println("</body>");
            out.println("</html>");
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
