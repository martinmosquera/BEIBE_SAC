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
import atendimento.Atendimento;
import atendimento.AtendimentoDao.AtendimentoDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import produto.Produto;
import produto.ProdutoDao.ProdutoDao;
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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        String login = request.getParameter("user");
        String pass = request.getParameter("pass");
        String message = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnectionFactory conn = new ConnectionFactory();
            PessoaDao uDao = new PessoaDao(conn);
            AtendimentoDao aDao = new AtendimentoDao(conn);
            ProdutoDao pDao = new ProdutoDao(conn);
            
        if(loginValido(login,pass,request,response,uDao,aDao,pDao)){
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

    private boolean loginValido(String login, String pass,HttpServletRequest request,HttpServletResponse response,PessoaDao uDao,AtendimentoDao aDao,ProdutoDao pDao) {
        
        
         try{
                List<Pessoa> users = uDao.getLista();
                if (users.isEmpty()) return false;
             
                for(Pessoa user : users){
                    
                    if(user.getNick().equalsIgnoreCase(login)){
                        if(pass.equalsIgnoreCase(user.getSenha())){
                            if(user.getType().equalsIgnoreCase("U")){
                            Cliente cliente  = new Cliente(user);
                            List<Atendimento> lista;
                            lista = aDao.getListaCliente(cliente);
                            cliente.setLista(lista);
                            List<Produto> lp = pDao.Listar();
                            HttpSession session = request.getSession();
                            session.setAttribute("produtos", lp);
                            session.setAttribute("atendimentos",lista);
                            session.setAttribute("user", cliente);
                            session.setAttribute("logado", cliente.getNick());
                            request.setAttribute("page","cliente/PortalUser.jsp");                          
                            return true;
                        }else if (user.getType().equalsIgnoreCase("F")){
                            
                            Funcionario funcionario  = new Funcionario(user);
                            List<Atendimento> listaTotal;
                            try{

                                List<Produto> lp = pDao.Listar();
                                listaTotal = aDao.getListaFuncionario(funcionario);
    //                            if(lista.size() >0)
                                funcionario.setAtendimentos(lista);
                                List<Atendimento> listaAbertos = new ArrayList<Atendimento>();
                                for(Atendimento a : listaTotal){
                                    if(a.getStatus().equalsIgnoreCase("aberto"))
                                        listaAbertos.add(a);
                                }
                                HttpSession session = request.getSession();
                                session.setAttribute("produtos", lp);
                                session.setAttribute("atendimentosAbertos", listaAbertos);
                                session.setAttribute("atendimentosTotal", listaTotal);
                                session.setAttribute("user", funcionario);
                                session.setAttribute("logado", funcionario.getNick());
                                request.setAttribute("page","funcionario/PortalFuncionario.jsp");                          
                                return true;
                            }catch(Exception e){
                                 RequestDispatcher rd = getServletContext().getRequestDispatcher("/Erro");
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
