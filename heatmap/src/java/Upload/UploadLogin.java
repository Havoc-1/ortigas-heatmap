/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Upload;

import asia.uap.Classes.Accounts;
import asia.uap.Classes.SQLThing;
import asia.uap.Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nofuente
 */
public class UploadLogin extends HttpServlet {
    private Accounts account;
    SQLThing db = new SQLThing();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String username = request.getParameter("userLogin");
        String password = request.getParameter("passLogin");
        
        if(username == null || username.isEmpty()) {
            response.sendRedirect("uploadPortalLogin.jsp");
        } else if (password == null || password.isEmpty()) {
            response.sendRedirect("uploadPortalLogin.jsp");
        } else {
            Accounts account = new Accounts();
            account.setUsername(username);
            account.setPassword(password);
            
            try {
                if (db.checkUploadLogin(account)) {
                    session.setAttribute("currentUploadUser", username);
                    session.setAttribute("currentUploadUserID", db.getPortalUID(account));
                    response.sendRedirect("uploadCSV.jsp");
                } else{
                    response.sendRedirect("index.jsp");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
