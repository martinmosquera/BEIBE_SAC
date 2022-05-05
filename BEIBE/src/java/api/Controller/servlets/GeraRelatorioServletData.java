/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Controller.servlets;

import api.Model.ConnectionFactory.ConnectionFactory;
import api.Model.Exceptions.ConnectionException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author dell
 */
@WebServlet(name = "GeraRelatorioServlet", urlPatterns = {"/GeraRelatorioServlet"})
public class GeraRelatorioServletData extends HttpServlet {

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
        try(Connection conn = new ConnectionFactory().getConnection()){
                    
                    String host = "http://"+ request.getServerName() + ":"+request.getServerPort();
                    String jasper = request.getContextPath() + "/relatorios/RelatóriodeAtendimentosemAbertoPorData.jasper";
                    URL jasperURL = new URL(host+ jasper);
                    HashMap params = new HashMap();
                    
                    byte[] bytes = JasperRunManager.runReportToPdf(jasperURL.openStream(), params, conn);
                    if(bytes != null){
                        
                        response.setContentType("application/pdf");
                        OutputStream ops = response.getOutputStream();
                        ops.write(bytes);
                    }
                }catch (ConnectionException | SQLException | IOException | RuntimeException | JRException ex) {
                    
                    request.setAttribute("msg", "Erro Na conexao com o banco"+ex.getMessage());
                    request.setAttribute("page", "./portal.jsp");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
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
