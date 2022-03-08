/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import users.Pessoa;
import ConnectionFactory.ConnectionFactory;
import users.PessoaDao.PessoaDao;

/**
 *
 * @author dell
 */
@WebServlet(name = "UpdateCliente", urlPatterns = {"/UpdateCliente"})
public class UpdateCliente extends HttpServlet {

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
         if(session == null){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Erro");
            request.setAttribute("msg", "É requerido iniciar sessao!");
            rd.forward(request, response);
        }
         
        Pessoa user = (Pessoa)session.getAttribute("user");
        
        user.setNick(request.getParameter("nick"));
        user.setNome(request.getParameter("nome"));
        user.setRua(request.getParameter("rua"));
        user.setNum(request.getParameter("num"));
        user.setComplemento(request.getParameter("complemento"));
        user.setBairro(request.getParameter("bairro"));
        user.setCep(request.getParameter("cep"));
        user.setCidade(request.getParameter("cidade"));
        user.setEstado(request.getParameter("estado"));
        user.setTelefone(request.getParameter("telefone"));
        user.setSenha(request.getParameter("senha"));
         
        try{
            Class.forName("com.mysql.jdbc.Driver");
            ConnectionFactory conn = new ConnectionFactory();
            PessoaDao uDao = new PessoaDao(conn);
            uDao.inserir(user);
            response.sendRedirect("./PortalUser.jsp");
            
           }catch(Exception e){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Erro");
            request.setAttribute("msg","Erro ao processar a solicitude "+e.getMessage());
            request.setAttribute("page","PortalUser.jsp");
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
