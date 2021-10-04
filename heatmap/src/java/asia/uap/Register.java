/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asia.uap;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import asia.uap.Utils;

/**
 *
 * @author Nofuente
 */
public class Register extends HttpServlet {

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
        String redir;
        
        Utils util = new Utils();
        String checkedUser = util.checkNull(request, "user");
        String checkedPass = util.checkNull(request, "pass");
        String checkedEmail = util.checkNull(request, "email");
        
        
        if (checkedUser.equals(" ")) {
            redir = "<h1>No username input has been recorded</h1>\n<a href=add.jsp>Go back to form</a>\n<a href=login.jsp>Go back to index</a>"; 
        } else if (checkedPass.equals(" ")) {
            redir = "<h1>No password input has been recorded</h1>\n<a href=add.jsp>Go back to form</a>\n<a href=login.jsp>Go back to index</a>"; 
        } else if (checkedEmail.equals(" ")) {
            redir = "<h1>No password input has been recorded</h1>\n<a href=add.jsp>Go back to form</a>\n<a href=login.jsp>Go back to index</a>"; 
        } 
        else {
            redir = "<h1>Your input has been recorded</h1>\n<a href=index.jsp>Go back to index</a>";
            HttpSession session = request.getSession();
            session.setAttribute("username", checkedUser);
            session.setAttribute("password", checkedPass);
            session.setAttribute("email", checkedEmail);

            if (session.getAttribute("passList") == null){
                ArrayList<String> pass1 = new ArrayList<>();
                session.setAttribute("passList", pass1);
            }

            ArrayList<String> user = util.getArrayList(session, "nameList");
            session.setAttribute("nameList", user);
            ArrayList<String> pass = util.getArrayList(session, "passList");
            session.setAttribute("passList", pass);
            ArrayList<String> email = util.getArrayList(session, "emailList");
            session.setAttribute("emailList", pass);

            user.add((String) session.getAttribute("username"));
            pass.add((String) session.getAttribute("password"));
            email.add((String) session.getAttribute("email"));
        }
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"./style.css\"/>\n" +"");
            out.println("<title>Heatmap Register</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Heatmap</h1>");
            out.println(redir);
            out.println(checkedUser);
            out.println(checkedPass);
            out.println("</body>");
            out.println("</html>");
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
