/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Controller.servlets;

import api.Model.Categoria.Categoria;
import api.Model.ClienteFacade;
import api.Model.Exceptions.AppException;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import api.Model.users.Pessoa;
import api.Model.FuncionarioFacade;
import api.Model.ProdutoFacade;
import api.Model.atendimento.Atendimento;
import api.Model.atendimento.AtendimentoDao.AtendimentoDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import api.Model.produto.Produto;
import api.Model.users.Cliente;
import api.Model.users.Funcionario;
import api.Model.users.Gerente;
import api.Model.users.PessoaDao.PessoaDao;
import java.util.ArrayList;


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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String host = "http://"+ request.getServerName() + ":"+request.getServerPort();
        String home = request.getContextPath();
        String url = host+home;
        request.getSession().setAttribute("url", url);
        String login = request.getParameter("user");
        String pass = request.getParameter("pass");
        String message = "";
        try {   
            
        if(loginValido(login,pass,request,response)){
            String page = (String)request.getAttribute("page"); 
            response.sendRedirect(page);
//            getServletContext().getRequestDispatcher(page).forward(request, response);
            
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            request.setAttribute("msg", "Usuario ou senha incorretos");
            request.setAttribute("page", "login.jsp");
            rd.forward(request, response);
        }
        } catch (IOException | ServletException ex) {
            message = ex.getMessage();
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private boolean loginValido(String login, String pass,HttpServletRequest request,HttpServletResponse response) {
        
             String host = "http://"+ request.getServerName() + ":"+request.getServerPort();
        String home = request.getContextPath();
        String url = host+home;
         try{

            List<Pessoa> users =  PessoaDao.getLista();
//                List<Pessoa> users = uDao.getLista();
                if (users.isEmpty()) return false;
                
                List<Produto> lp = ProdutoFacade.getListaProdutos();
                List<Categoria> cats = FuncionarioFacade.getListaCategorias(); 
                HttpSession session = request.getSession();
                session.setAttribute("produtos", lp);
                session.setAttribute("categorias", cats);
                List<Atendimento >listaTotal = FuncionarioFacade.getListaAtendimentos();
                session.setAttribute("atendimentosTotal", listaTotal);
                for(Pessoa user : users){
                    
                    if(user.getNick().equalsIgnoreCase(login)){
                        if(pass.equalsIgnoreCase(user.getSenha())){
                            if(user.getType().equalsIgnoreCase("U")){
                                Pessoa cliente  = new Cliente(user);
                                Cliente c = (Cliente)cliente;
                                c.setType("U");
                                c.setId(user.getId());
                                session.setAttribute("user", cliente);
                                session.setAttribute("logado", cliente.getNick());
                                request.setAttribute("page","cliente/PortalUser.jsp");                          
                                return true;
                        
                            }else if (user.getType().equalsIgnoreCase("F")){
                            
                            Funcionario funcionario  = new Funcionario(user);
                            try{
                                funcionario.setId(user.getId());
                                session.setAttribute("user", funcionario);
                                session.setAttribute("logado", funcionario.getNick());
                                request.setAttribute("page", "funcionario/PortalFuncionario.jsp");
                                return true;
                            }catch(Exception e){
                                 RequestDispatcher rd = getServletContext().getRequestDispatcher("error.jsp");
                                    request.setAttribute("msg", "Erro ao iniciar sessao do Funcionario <br/>"+e.getMessage());
                                    request.setAttribute("page", "login.jsp");
                                    rd.forward(request, response);
                            }
                        }else if (user.getType().equalsIgnoreCase("G")){
                            
                            Gerente gerente  = new Gerente(user);
                            try{

                                session.setAttribute("user", gerente);
                                session.setAttribute("logado", gerente.getNick());
                                getServletContext().getRequestDispatcher("/gerente/PortalGerente.jsp").forward(request, response);
                                return true;
                            }catch(Exception e){
                                 RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
                                    request.setAttribute("msg", "Erro ao iniciar sessao do Funcionario <br/>"+e.getMessage());
                                    request.setAttribute("page", "login.jsp");
                                    rd.forward(request, response);
                            }
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
