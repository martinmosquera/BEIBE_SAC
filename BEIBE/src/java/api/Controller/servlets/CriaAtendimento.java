/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Controller.servlets;

import api.Model.ConnectionFactory.ConnectionFactory;
import api.Model.atendimento.Atendimento;
import api.Model.atendimento.AtendimentoDao.AtendimentoDao;
import api.Model.users.Cliente;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import api.Model.produto.Produto;

/**
 *
 * @author dell
 */
@WebServlet(name = "CriaAtendimento", urlPatterns = {"/CriaAtendimento"})
public class CriaAtendimento extends HttpServlet {

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
            HttpSession session = request.getSession(false);
           try{
        
             String logado = (String)session.getAttribute("logado");
            if(logado == null){
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
                request.setAttribute("msg", "Precissa Estar Logado para usar este serviço");
                request.setAttribute("page", "login.jsp");
                rd.forward(request, response);

            }else{
                 ConnectionFactory conn = new ConnectionFactory();
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        String prod = request.getParameter("produto");
        List<Produto> lp = (List<Produto>)session.getAttribute("produtos");
        Produto produto = null;
        for(Produto p : lp){
        if(prod.equalsIgnoreCase(p.getNome())) produto = p;
        }
        String descricao = request.getParameter("descricao");
        Cliente cliente = (Cliente)session.getAttribute("user");
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
            Class.forName("com.mysql.jdbc.Driver");
            
            AtendimentoDao aDao = new AtendimentoDao(conn);
            aDao.inserir(atd);
            cliente.addAtendimento(atd);
            session.setAttribute("atendimentos",cliente.getLista());
            response.sendRedirect("cliente/PortalUser.jsp");
        }catch(Exception e){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            request.setAttribute("msg", e.getMessage());
            request.setAttribute("page", "cliente/PortalUser.jsp");
            rd.forward(request, response);
        
        }
            }
        
        }catch(IOException | ServletException e){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
                request.setAttribute("msg", "Erro ao tentar validar o usuario<br/>Response: "+e.getMessage());
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
