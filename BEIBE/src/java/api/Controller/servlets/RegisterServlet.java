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
import api.Model.ConnectionFactory.ConnectionFactory;
import api.Model.users.Cliente;
import api.Model.users.PessoaDao.PessoaDao;

/**
 *
 * @author dell
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
            /* TODO output your page here. You may use following sample code. */
            
            Cliente user = new Cliente(request.getParameter("nick"),request.getParameter("nome"),request.getParameter("cpf"),request.getParameter("email"),request.getParameter("rua"),request.getParameter("num"),request.getParameter("comple"),request.getParameter("bairro"),request.getParameter("cep"),request.getParameter("cidade"),request.getParameter("estado"),request.getParameter("tel"),request.getParameter("senha"),"U");
           try{
                Class.forName("com.mysql.jdbc.Driver");
            ConnectionFactory conn = new ConnectionFactory();
            PessoaDao uDao = new PessoaDao(conn);
            uDao.inserir(user);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("logado", user.getNick());
            session.setAttribute("type",user.getType());
            response.sendRedirect("cliente/PortalUser.jsp");
            
           }catch(Exception e){
             RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            request.setAttribute("msg", "Usuario ou senha incorretos");
            request.setAttribute("page", "login.jsp");
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
