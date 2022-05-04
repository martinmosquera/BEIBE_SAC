/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Controller.servlets;

import api.Model.Exceptions.AppException;
import api.Model.FuncionarioFacade;
import api.Model.atendimento.Atendimento;
import api.Model.users.Cliente;
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
        
        String action = (String)request.getParameter("to");
        RequestDispatcher erro;
        switch(action){
            
            case "listar":    
                try{
                    
                    response.sendRedirect("./funcionario/TodosAtendimentosFuncionario.jsp");
                }catch(IOException e){
                        request.setAttribute("msg", "Nao foi possivel listar os atendimentos | "+e.getMessage());
                        request.setAttribute("form", "alterar");
                        erro = getServletContext().getRequestDispatcher("/error.jsp");
                        erro.forward(request, response);
                        
                }
            break;
            
            case "showResolve":
                try{
                    int id = Integer.valueOf(request.getParameter("id"));
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
                    int id = Integer.valueOf(request.getParameter("id"));
                    FuncionarioFacade.resolver(id);
                    request.setAttribute("msg", "Atendimento soluconado com sucesso | ");
                    getServletContext().getRequestDispatcher("/funcionario/TodosAtendimentosFuncionario.jsp").forward(request, response);
                }catch(AppException e){
                    request.setAttribute("msg", "Nao foi possivel resolver o atendimento | "+e.getMessage());
                        request.setAttribute("form", "alterar");
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
