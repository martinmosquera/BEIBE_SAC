/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package api.Controller.servlets;

import api.Model.Exceptions.AppException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import api.Model.FuncionarioFacade;
import api.Model.atendimento.Atendimento;
import api.Model.users.Funcionario;
import java.util.logging.Level;
import java.util.logging.Logger;

import api.Model.GerenteFacade;

/**
 *
 * @author lucas
 */
@WebServlet(name = "GerenteServlet", urlPatterns = {"/GerenteServlet"})
public class GerenteServlet extends HttpServlet {

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
            throws ServletException, IOException, AppException {
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher portal = getServletContext().getRequestDispatcher("/gerente/PortalGerente.jsp");
        
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
                request.setAttribute("page", "/gerente/PortalGerente.jsp");
                rd.forward(request, response);
        }
        
        String action = (String)request.getParameter("to");
        RequestDispatcher erro;
        switch(action){
            case "manageFuncionarios":
                java.util.ArrayList<Funcionario> funcionarios = FuncionarioFacade.listFuncionarios();
                request.setAttribute("funcionarios", funcionarios);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/gerente/CadastroFuncionarios.jsp");
                rd.forward(request, response);
                break;
            case "atendimentosAberto":
                java.util.ArrayList<Atendimento> atendimentos = GerenteFacade.getAtendimentosEmAberto();
                request.setAttribute("atendimentos", atendimentos);
                
                portal.forward(request, response);
                break;
            case "deleteFunc":
                String string_id = request.getParameter("id");
                if(string_id == null) break;
                FuncionarioFacade.deletaFuncionario(Integer.parseInt(string_id));
                
                portal.forward(request, response);
                break;
            case "editFunc":
                String func_id = request.getParameter("id");
                if(func_id == null) break;
                Funcionario f = FuncionarioFacade.getFuncionario(Integer.parseInt(func_id));
                
                request.setAttribute("funcionario", f);
                RequestDispatcher editFunc = getServletContext().getRequestDispatcher("/gerente/NovoFuncionario.jsp");
                editFunc.forward(request, response);
                break;
            default:
                java.util.ArrayList<Atendimento> a = GerenteFacade.getAtendimentos();
                request.setAttribute("atendimentos", a);
                portal.forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (AppException ex) {
            Logger.getLogger(GerenteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (AppException ex) {
            Logger.getLogger(GerenteServlet.class.getName()).log(Level.SEVERE, null, ex);
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

}
