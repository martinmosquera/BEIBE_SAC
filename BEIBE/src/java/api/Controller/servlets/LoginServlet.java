/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Controller.servlets;

import api.Model.Categoria.Categoria;
import api.Model.Categoria.CategoriaDao.CategoriaDao;
import api.Model.ClienteFacade;
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
import api.Model.ConnectionFactory.ConnectionFactory;
import api.Model.ProdutoFacade;
import api.Model.atendimento.Atendimento;
import api.Model.atendimento.AtendimentoDao.AtendimentoDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import api.Model.produto.Produto;
import api.Model.produto.ProdutoDao.ProdutoDao;
import api.Model.users.Cliente;
import api.Model.users.Funcionario;
import api.Model.users.Gerente;
import api.Model.users.PessoaDao.PessoaDao;
import org.jboss.weld.context.ApplicationContext;

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
            Class.forName("com.mysql.cj.jdbc.Driver");
            ConnectionFactory conn = new ConnectionFactory();
            PessoaDao uDao = new PessoaDao(conn);
            AtendimentoDao aDao = new AtendimentoDao(conn);
            CategoriaDao cDao = new CategoriaDao(conn);
            
        if(loginValido(login,pass,request,response,uDao,aDao,cDao)){
            String page = (String)request.getAttribute("page"); 
            response.sendRedirect(page);
//            getServletContext().getRequestDispatcher(page).forward(request, response);
            
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            request.setAttribute("msg", "Usuario ou senha incorretos");
            request.setAttribute("page", "login.jsp");
            rd.forward(request, response);
        }
        } catch (IOException | ClassNotFoundException | ServletException ex) {
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

    private boolean loginValido(String login, String pass,HttpServletRequest request,HttpServletResponse response,PessoaDao uDao,AtendimentoDao aDao,CategoriaDao cDao) {
        
            
         try{

            List<Pessoa> users =  ClienteFacade.getListaClientes();
             
//                List<Pessoa> users = uDao.getLista();
                if (users.isEmpty()) return false;
                
                List<Produto> lp = ProdutoFacade.getListaProdutos();
                List<Categoria> cats = cDao.Listar(); 
                HttpSession session = request.getSession();
                session.setAttribute("produtos", lp);
                session.setAttribute("categorias", cats);
                
                for(Pessoa user : users){
                    
                    if(user.getNick().equalsIgnoreCase(login)){
                        if(pass.equalsIgnoreCase(user.getSenha())){
                            if(user.getType().equalsIgnoreCase("U")){
                                Cliente cliente  = new Cliente(user);
                                List<Atendimento> lista;
                                lista = aDao.getListaCliente(cliente);
                                cliente.setLista(lista);
                                session.setAttribute("atendimentos",lista);
                                session.setAttribute("user", cliente);
                                session.setAttribute("logado", cliente.getNick());
                                request.setAttribute("page","cliente/PortalUser.jsp");                          
                                return true;
                        
                            }else if (user.getType().equalsIgnoreCase("F")){
                            
                            Funcionario funcionario  = new Funcionario(user);
                            List<Atendimento> listaTotal = null;
                            try{
                                
                                listaTotal = aDao.getListaFuncionario(funcionario);
                                List<Atendimento> listaAbertos = new ArrayList<Atendimento>();
                                for(Atendimento a : funcionario.getAtendimentos()){
                                    if(a.getStatus().equalsIgnoreCase("aberto"))
                                        listaAbertos.add(a);
                                }
                                session.setAttribute("categorias", cats);
                                session.setAttribute("atendimentosAbertos", listaAbertos);
                                session.setAttribute("atendimentosTotal", listaTotal);
                                session.setAttribute("user", funcionario);
                                session.setAttribute("logado", funcionario.getNick());
                                request.setAttribute("page","funcionario/PortalFuncionario.jsp");                          
                                return true;
                            }catch(Exception e){
                                 RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
                                    request.setAttribute("msg", "Erro ao iniciar sessao do Funcionario <br/>"+e.getMessage());
                                    request.setAttribute("page", "login.jsp");
                                    rd.forward(request, response);
                            }
                        }else if (user.getType().equalsIgnoreCase("G")){
                            
                            Gerente gerente  = new Gerente(user);
                            Funcionario funcionario = new Funcionario(user);
                            List<Atendimento> listaTotal;
                            try{

                                
                                listaTotal = aDao.getListaFuncionario(funcionario);
                                session.setAttribute("atendimentosTotal", listaTotal);
                                session.setAttribute("user", gerente);
                                session.setAttribute("logado", gerente.getNick());
                                request.setAttribute("page","gerente/PortalGerente.jsp");                          
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
