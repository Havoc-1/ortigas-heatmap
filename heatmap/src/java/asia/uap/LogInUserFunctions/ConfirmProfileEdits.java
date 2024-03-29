/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asia.uap.LogInUserFunctions;

import asia.uap.Classes.Accounts;
import asia.uap.Classes.SQLThing;
import asia.uap.Utils;
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
public class ConfirmProfileEdits extends HttpServlet {
    private Accounts account;
    SQLThing db = new SQLThing();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Utils util = new Utils();
        int uid = (int) session.getAttribute("currentUserUID");
        Accounts account = db.getAccount(uid);
        
        String checkedPass = util.checkNull(request, "password");
        String checkedConfPass = util.checkNull(request, "passwordConfirm");
        String checkedEmail = util.checkNull(request, "email");
        String checkedAddress = util.checkNull(request, "address");
        
        try {
            if (!db.checkPass(uid, checkedPass) && !checkedPass.equals(util.NO_VALUE) && checkedPass.equals(checkedConfPass)){
                account.setPassword(checkedPass);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfirmProfileEdits.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!checkedEmail.equals(util.NO_VALUE) && !checkedEmail.equals(account.getEmail())) {
            account.setEmail(checkedEmail);
        }
        if (!checkedAddress.equals(util.NO_VALUE) && !checkedAddress.equals(account.getAddress())) {
            account.setAddress(checkedAddress);
        }

        db.updateProfile(account, uid);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConfirmProfileEdits</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Edit Succesful!</h1>");
            out.println("<a href=\"do.maps\">Back to Home</a>");
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
