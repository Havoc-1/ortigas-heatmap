/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asia.uap.LogInUserFunctions;

import asia.uap.Classes.Accounts;
import asia.uap.Classes.Location;
import asia.uap.Classes.Reviews;
import asia.uap.Classes.SQLThing;
import asia.uap.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nofuente
 */
public class SubmitReview extends HttpServlet {
    private Accounts account;
    private Location loc;
    SQLThing db = new SQLThing();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Utils util = new Utils();
       
        //user details
        String locID = util.checkNull(request, "locID");
        String uID = util.checkNull(request, "uid");
        String feedback = util.checkNull(request, "feedback");
        String comments = util.checkNull(request, "comments");
        
        if(locID.equals(util.NO_VALUE)) {
            System.out.println("1");
            response.sendRedirect("RevFail.jsp");
        } else if(uID.equals(util.NO_VALUE)){
            System.out.println("2");
            response.sendRedirect("RevFail.jsp");
        } else if(feedback.equals(util.NO_VALUE)){
            System.out.println("3");
            response.sendRedirect("RevFail.jsp");
        } else if(comments.equals(util.NO_VALUE)){
            System.out.println("4");
            response.sendRedirect("RevFail.jsp");
        } else {
            Reviews rev = new Reviews();
            rev.setLocID(parseInt(locID));
            rev.setUid(parseInt(uID));
            rev.setStatus(parseBoolean(feedback));
            rev.setComment(comments);
            
            try {
                db.registerReview(rev);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SubmitReview.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("RevSuccess.jsp");
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