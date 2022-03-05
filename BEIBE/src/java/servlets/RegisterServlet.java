/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import users.Pessoa;
import users.PessoaDao.ConnectionFactory;
import users.PessoaDao.PessoaDao;

/**
 *
 * @author dell
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        if(session == null){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Erro");
            request.setAttribute("msg", "É requerido iniciar sessao!");
            request.setAttribute("page", "./");
            rd.forward(request, response);
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='utf-8'>");
            out.println("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
            out.println("<title>Login</title>");            
            out.println("<link rel=\"shortcut icon\" href=\"./asset/img/favicon.png\"/>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"./asset/css/style.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("</head>");
            out.println("<body class=\"container\">");
            out.println("<h1>Usuario Cadastrado</h1>");
            Pessoa user = new Pessoa(request.getParameter("nick"),request.getParameter("name"),request.getParameter("cpf"),request.getParameter("email"),request.getParameter("endereco"),request.getParameter("num"),request.getParameter("comple"),request.getParameter("bairro"),request.getParameter("cep"),request.getParameter("cidade"),request.getParameter("estado"),request.getParameter("tel"),request.getParameter("pass"),"U");
           try{
                Class.forName("com.mysql.jdbc.Driver");
            ConnectionFactory conn = new ConnectionFactory();
            PessoaDao uDao = new PessoaDao(conn);
            uDao.inserir(user);
            out.println("<h4>Usuario :"+user.getNick()+"</h4>");
            out.println("<h4>Nome :"+user.getNome()+"</h4>");
            out.println("<h4>Senha :"+user.getSenha()+"</h4>");
            out.println("<div class=\"row\">");
            out.println("<a href=\"PortalServlet\"><button class=\"btn-primary col-2\">Portal</button><a/>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
           }catch(Exception e){
               out.println("<p>"+e.getMessage()+"</p>");
               out.println("<div class=\"row\">");
            out.println("<a href=\"login.jsp\"><button class=\"btn-primary col-2\">Login</button><a/>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
