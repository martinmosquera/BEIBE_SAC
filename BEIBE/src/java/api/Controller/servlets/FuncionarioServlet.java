/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Controller.servlets;

import api.Model.Categoria.Categoria;
import api.Model.Exceptions.AppException;
import api.Model.Exceptions.GetAtendimentoException;
import api.Model.FuncionarioFacade;
import api.Model.atendimento.Atendimento;
import api.Model.atendimento.AtendimentoDao.AtendimentoDao;
import api.Model.users.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/FuncionarioServlet"})
public class FuncionarioServlet extends HttpServlet {

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
        
         response.setContentType("text/html;charset=UTF-8");
        String host = "http://"+ request.getServerName() + ":"+request.getServerPort();
        String home = request.getContextPath();
        String url = host+home;
        request.getSession().setAttribute("url", url);
        String nome;
        int id;
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
                request.setAttribute("page", "PortalFuncionario.jsp");
                rd.forward(request, response);
        }
        
        String action = (String)request.getParameter("to");
        RequestDispatcher erro;
        switch(action){
            
            case "homeF":
                request.getRequestDispatcher("funcionario/portalFuncionario.jsp").forward(request, response);
                
                break;
            
            case "listar":    
                try{
                    List<Atendimento> la = AtendimentoDao.getAtendimentos();
                    request.getSession().setAttribute("atendimentos", la);
                    response.sendRedirect("funcionario/TodosAtendimentosFuncionario.jsp");
                }catch(IOException | GetAtendimentoException e){
                        request.setAttribute("msg", "Nao foi possivel listar os atendimentos | "+e.getMessage());
                        request.setAttribute("form", "alterar");
                        erro = getServletContext().getRequestDispatcher("/error.jsp");
                        erro.forward(request, response);
                        
                }
            break;
            
            case "showResolve":
                try{
                    id = Integer.valueOf(request.getParameter("id"));
                    Atendimento a = FuncionarioFacade.getAtendimento(id);
                    request.getSession().setAttribute("atendimento", a);
                    response.sendRedirect("funcionario/ResolucaoAtendimento.jsp");
                    
                }catch(AppException | IllegalArgumentException | NullPointerException e){
                    request.setAttribute("msg", "Nao foi possivel resolver o atendimento | "+e.getMessage());
                        request.setAttribute("form", "alterar");
                        erro = getServletContext().getRequestDispatcher("/error.jsp");
                        erro.forward(request, response);
                }
                break;
   
            case "resolve":
                
                try{
                    id = Integer.valueOf(request.getParameter("id"));
                    String msg = request.getParameter("mensagem");
                    FuncionarioFacade.resolver(id,msg);
                    request.setAttribute("msg", "Atendimento solucionado com sucesso | ");
                    getServletContext().getRequestDispatcher("/funcionario/TodosAtendimentosFuncionario.jsp").forward(request, response);
                }catch(AppException e){
                    request.setAttribute("msg", "Nao foi possivel resolver o atendimento | "+e.getMessage());
                    request.setAttribute("form", "alterar");
                    erro = getServletContext().getRequestDispatcher("/error.jsp");
                    erro.forward(request, response);
                }
                break;
                
            case "gCategoria":
                response.sendRedirect("./funcionario/CadastroCategorias.jsp");
                break;
                
            case "showNewCat":
                response.sendRedirect("./funcionario/NovaCategoria.jsp");
                break;
                
            case "createCat":
                nome = request.getParameter("nome");
                try{
                    Categoria c = FuncionarioFacade.criaCategoria(nome);
                    List<Categoria> lc = (List<Categoria>)request.getSession().getAttribute("categorias");
                    lc.add(c);
                    request.getSession().setAttribute("categorias", lc);
                    getServletContext().getRequestDispatcher("/funcionario/CadastroCategorias.jsp").forward(request, response);
                }catch(AppException e){
                    request.setAttribute("msg", "Nao foi possivel Cadastrar a Categoria | "+e.getMessage());
                    erro = getServletContext().getRequestDispatcher("/error.jsp");
                    erro.forward(request, response);
                }
                
                break;
            case "showFormUC":
                
                id = Integer.valueOf(request.getParameter("id"));
                Categoria c;
            try {
                c = FuncionarioFacade.getCategoria(id);
                request.setAttribute("categoria", c);
                getServletContext().getRequestDispatcher("/funcionario/AlteraCategoria.jsp").forward(request, response);
            } catch (AppException ex) {
                request.setAttribute("msg", "Nao foi possivel obetr a Categoria | "+ex.getMessage());
                erro = getServletContext().getRequestDispatcher("/error.jsp");
                erro.forward(request, response);
                
            }
                
                break;
                
            case "updateCat":
                
                try{
                    id = Integer.valueOf(request.getParameter("id"));
                    nome = request.getParameter("nome");
                    Categoria cat = new Categoria(id,nome);
                    FuncionarioFacade.atualizaCategoria(cat);
                    List<Categoria> lista = FuncionarioFacade.getListaCategorias();
                    for(Categoria cate : lista){
                        if(cate.getId()==id) cate.setNome(nome);
                    }
                    request.getSession().setAttribute("categorias", lista);
                    getServletContext().getRequestDispatcher("/funcionario/CadastroCategorias.jsp").forward(request, response);
                }catch(AppException | IOException | NumberFormatException | ServletException e){
                    request.setAttribute("msg", "Nao foi possivel atualizar a Categoria | "+e.getMessage());
                    erro = getServletContext().getRequestDispatcher("/error.jsp");
                    erro.forward(request, response);
                }
                
                break;
                
             case "deleteCat":
                
                
                try{
                    id = Integer.valueOf(request.getParameter("id"));
                    FuncionarioFacade.apagaCategoria(id);
//                    List<Categoria> lista = FuncionarioFacade.getListaCategorias();
//                    for(Categoria a : lista){
//                        if(a.getId()==id){
//                        lista.remove(a);
//                        break;
//                        } 
                    List<Categoria> lista = FuncionarioFacade.getListaCategorias();
                    for(Categoria ce: lista)
                        if(ce.getId() == id) lista.remove(ce);
                    request.getSession().setAttribute("categorias", lista);
                    getServletContext().getRequestDispatcher("/funcionario/CadastroCategorias.jsp").forward(request, response);
                }catch(AppException | NullPointerException e){
                    request.setAttribute("msg", "Nao foi possivel atualizar a Categoria | "+e.getMessage());
                    erro = getServletContext().getRequestDispatcher("/error.jsp");
                    erro.forward(request, response);
                }
                break;
            
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
