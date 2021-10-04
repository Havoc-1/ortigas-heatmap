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

/**
 *
 * @author Nofuente
 */
public class Auth extends HttpServlet {

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
        
        String u = request.getParameter("userLogin");
        String p = request.getParameter("passLogin");
        String redir = null;
        
        if(u == null || u.isEmpty()) {
            redir = "<h1>No username input has been recorded</h1>\n<a href=add.jsp>Go back to form</a>"; 
        } else if (p == null || p.isEmpty()) {
            redir = "<h1>No password input has been recorded</h1>\n<a href=add.jsp>Go back to form</a>"; 
        } else {
            HttpSession session = request.getSession();
            
            ArrayList<String> existingUserList = (ArrayList<String>) session.getAttribute("nameList");
            ArrayList<String> existingPassList = (ArrayList<String>) session.getAttribute("passList");
            if (existingUserList == null){
                    redir = "<h1>No existing registered users yet.</h1>\n<a href=add.jsp>Sign Up</a>";
            }else{
                for(int i = 0; i < existingUserList.size(); i++) {  
                    if (existingUserList.get(i).equals(u)){
                        if(existingPassList.get(i).equals(p)){
                            redir = "<h1>You are verified in the eyes of God</h1>\n<a href=home.jsp>Go Home</a>";
                            response.sendRedirect("home.jsp");
                            session.setAttribute("currentUser", existingUserList.get(i));
                        }else{
                            redir = "<h1>Wrong Password</h1>\n<a href=login.jsp>Go back to index</a>";
                        }
                    } else{
                        redir = "<h1>Username does not exist</h1>\n<a href=login.jsp>Go back to index</a>";
                    }
                } 
            }
        }
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet savedata</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet savedata at " + request.getContextPath() + "</h1>");
            out.println(redir);
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
