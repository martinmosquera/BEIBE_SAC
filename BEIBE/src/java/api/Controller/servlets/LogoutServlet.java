/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dell
 */
@WebServlet(name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        
        try{
            String logado = (String)session.getAttribute("logado");
            if(logado != null){
                session.invalidate();
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
                request.setAttribute("msg", "Logout Efetuado com Sucesso!");
                request.setAttribute("page","login.jsp");
                String host = "http://"+ request.getServerName() + ":"+request.getServerPort();
                String home = request.getContextPath();
                String url = host+home;
                request.getSession().setAttribute("url", url);
                rd.forward(request, response);
            }else{
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
                request.setAttribute("msg", "Você não inicio nenhuma sessão ainda");
                request.setAttribute("page","login.jsp");
                rd.forward(request, response);
            }
        }catch(Exception e){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
                request.setAttribute("msg", "Erro ao tentar delogar a sessão<br/>Resposta: "+e.getMessage());
                request.setAttribute("page","login.jsp");
                rd.forward(request, response);
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
