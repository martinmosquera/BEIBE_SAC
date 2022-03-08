/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import users.Pessoa;
import ConnectionFactory.ConnectionFactory;
import users.Cliente;
import users.Funcionario;
import users.PessoaDao.PessoaDao;

/**
 *
 * @author dell
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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

        String login = request.getParameter("user");
        String pass = request.getParameter("pass");
        String message = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnectionFactory conn = new ConnectionFactory();
            PessoaDao uDao = new PessoaDao(conn);
        if(loginValido(login,pass,request,uDao)){

            String page = (String)request.getAttribute("page"); 
            response.sendRedirect(page);
            
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Erro");
            request.setAttribute("msg", "Usuario ou senha incorretos");
            request.setAttribute("page", "login.jsp");
            rd.forward(request, response);
        }
        } catch (ClassNotFoundException ex) {
            message = ex.getMessage();
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Erro");
            request.setAttribute("msg","Erro ao tentar processar a solicitude "+message);
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

    private boolean loginValido(String login, String pass,HttpServletRequest request,PessoaDao uDao) {
        
        
         try{
                List<Pessoa> users = uDao.getLista();
                if (users.isEmpty()) return false;
             
                for(Pessoa user : users){
                    
                    if(user.getNick().equalsIgnoreCase(login)){
                        if(pass.equalsIgnoreCase(user.getSenha())){
                            if(user.getType().equalsIgnoreCase("U")){
                            Cliente cliente  = new Cliente(user);
                            HttpSession session = request.getSession();
                            session.setAttribute("user", cliente);
                            session.setAttribute("logado", cliente.getNick());
                            request.setAttribute("page","cliente/PortalUser.jsp");                          
                            return true;
                            }else if (user.getType().equalsIgnoreCase("F")){
                            Funcionario funcionario  = new Funcionario(user);
                            HttpSession session = request.getSession();
                            session.setAttribute("user", funcionario);
                            session.setAttribute("logado", funcionario.getNick());
                            request.setAttribute("page","funcionario/PortalFuncionario.jsp");                          
                            return true;
                            }
                            
                        }
                    }
                }
                return false;
                
            }catch(Exception e){
                return false;
            }
    }

}
