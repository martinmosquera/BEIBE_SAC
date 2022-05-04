/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Controller.servlets;

import api.Model.Categoria.Categoria;
import api.Model.CategoriaFacade;
import api.Model.ClienteFacade;
import api.Model.ConnectionFactory.ConnectionFactory;
import api.Model.Exceptions.AppException;
import api.Model.ProdutoFacade;
import api.Model.atendimento.Atendimento;
import api.Model.atendimento.AtendimentoDao.AtendimentoDao;
import api.Model.produto.Produto;
import api.Model.users.Cliente;
import api.Model.users.Pessoa;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

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
        String host = "http://"+ request.getServerName() + ":"+request.getServerPort();
        String home = request.getContextPath();
        String url = host+home;
        request.getSession().setAttribute("url", url);
        
        
        String action = (String)request.getParameter("to");
        Cliente uCliente;
        RequestDispatcher error;
        
        if(action.equalsIgnoreCase("home")){
             getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }else if(action.equalsIgnoreCase("formNew")){
             getServletContext().getRequestDispatcher("/cliente/register.jsp").forward(request, response);
        }else if(action.equalsIgnoreCase("sobre")){
            getServletContext().getRequestDispatcher("/sobre.jsp").forward(request, response);
        }else if(action.equalsIgnoreCase("login")){
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
           }else if(action.equalsIgnoreCase("userNew")){
            uCliente = new Cliente(request.getParameter("nick"),request.getParameter("nome"),request.getParameter("cpf"),request.getParameter("email"),request.getParameter("rua"),request.getParameter("num"),request.getParameter("comple"),request.getParameter("bairro"),request.getParameter("cep"),request.getParameter("cidade"),request.getParameter("estado"),request.getParameter("tel"),request.getParameter("senha"),"U");
            try {
                ClienteFacade.insereUsuario(uCliente);
                HttpSession session = request.getSession();
                session.setAttribute("user", uCliente);
                session.setAttribute("logado", uCliente.getNick());
                session.setAttribute("type",uCliente.getType());
                List<Produto> lp = ProdutoFacade.getListaProdutos();
                List<Categoria> cats = CategoriaFacade.listarCategorias();
                session.setAttribute("produtos", lp);
                session.setAttribute("categorias", cats);
                getServletContext().getRequestDispatcher("/cliente/PortalUser.jsp").forward(request, response);
            } catch (AppException ex) {
                        request.setAttribute("msg", "Erro ao tentar Carregar a pagina |\n " + ex.getMessage());
                        request.setAttribute("form", "alterar");
                        error = getServletContext().getRequestDispatcher("./error.jsp");
                        error.forward(request, response);
            }
        }else{        
        
        
        HttpSession session = request.getSession(false);
        try{
             String logado = (String)session.getAttribute("logado");
            if(logado == null){
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
                request.setAttribute("msg", "Precissa Estar Logado para usar este serviço");
                request.setAttribute("page", "login.jsp");
                rd.forward(request, response);

            }
        
        }catch(IOException | ServletException e){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
                request.setAttribute("msg", "Erro ao tentar validar o usuario<br/>"+e.getMessage());
                request.setAttribute("page", "portal.jsp");
                rd.forward(request, response);
        }
      
        
        String idCliente;
        int id;
        Cliente cliente;
        RequestDispatcher erro;
        switch(action){
            
            case "update":
                
                try{
                    response.sendRedirect("./cliente/AlteracaoDadosCliente.jsp");
                }catch(IOException e){
                        request.setAttribute("msg", "Erro ao tentar atualizar o usuario | " + e.getMessage());
                        request.setAttribute("form", "alterar");
                        erro = getServletContext().getRequestDispatcher("/error.jsp");
                        erro.forward(request, response);
                        
                }
            break;

                
            case "updateUsuario":
                
                Pessoa user = new Pessoa();
                user.setId(Integer.valueOf(request.getParameter("id")));
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
                    ClienteFacade.atualizaCliente(user);
                    session = request.getSession();
                    session.setAttribute("user", user);
                    response.sendRedirect("./cliente/PortalUser.jsp");                
                }catch(AppException | IOException  e){
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
                    request.setAttribute("msg","Erro ao processar a solicitude "+e.getMessage());
                    request.setAttribute("page","./cliente/PortalUser.jsp");
                    rd.forward(request, response);
                   }
            
                
               break;
            case "listar":
                try{
                    response.sendRedirect("./cliente/ListaAtendimentosCliente.jsp");
                }catch(IOException e){
                    request.setAttribute("msg", "Erro ao tentar atualizar o usuario | " + e.getMessage());
                    request.setAttribute("form", "alterar");
                    erro = getServletContext().getRequestDispatcher("/error.jsp");
                    erro.forward(request, response);    
                }
                break;
                
            case "newForm":
                try{
                    response.sendRedirect("./cliente/CriacaoAtendimentoCliente.jsp");
                }catch(IOException e){
                        request.setAttribute("msg", "Erro ao tentar atualizar o usuario | " + e.getMessage());
                        request.setAttribute("form", "alterar");
                        erro = getServletContext().getRequestDispatcher("/error.jsp");
                        erro.forward(request, response);
                        
                }
                break;
                
            case "home":
                
                 try{
                    response.sendRedirect("./cliente/PortalUser.jsp");
                }catch(IOException e){
                        request.setAttribute("msg", "Erro ao tentar atualizar o usuario | " + e.getMessage());
                        request.setAttribute("form", "alterar");
                        erro = getServletContext().getRequestDispatcher("/error.jsp");
                        erro.forward(request, response);
                        
                }
                break;
                
            case "newAtendimento":
                
                String type = request.getParameter("type");
                String prod = request.getParameter("produto");
                List<Produto> lp = (List<Produto>)session.getAttribute("produtos");
                Produto produto = null;
                for(Produto p : lp){
                if(prod.equalsIgnoreCase(p.getNome())) produto = p;
                }
                String descricao = request.getParameter("descricao");
                cliente = (Cliente)session.getAttribute("user");
                Atendimento atd = new Atendimento(cliente,type,produto,descricao);
                Date data = Date.valueOf(LocalDate.now());
                atd.setData(data);
                Time tm = Time.valueOf(LocalTime.now());
                atd.setHora(tm);
                Timestamp tmst = Timestamp.valueOf(LocalDateTime.now());
                atd.setDatatime(tmst);
                atd.setCliente(cliente);
                atd.setStatus("Aberto");
                
                try{
                   ClienteFacade.criaAtendimento(atd);
                    cliente.addAtendimento(atd);
                    session.setAttribute("atendimentos",cliente.getLista());
                    response.sendRedirect("./cliente/ListaAtendimentosCliente.jsp");
                }catch(Exception e){
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
                    request.setAttribute("msg", e.getMessage());
                    request.setAttribute("page", "cliente/PortalUser.jsp");
                    rd.forward(request, response);

                }

                    
                break;
                
            default:
                    erro = getServletContext().getRequestDispatcher("/error.jsp");
                    request.setAttribute("msg","Erro ao processar a solicitude ");
                    
                    request.setAttribute("page","./cliente/PortalUser.jsp");
                    erro.forward(request, response);
                break;
               
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
