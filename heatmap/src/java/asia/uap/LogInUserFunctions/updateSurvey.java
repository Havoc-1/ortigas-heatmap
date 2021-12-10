/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asia.uap.LogInUserFunctions;

import asia.uap.Classes.Accounts;
import asia.uap.Register;
import asia.uap.Classes.SQLThing;
import asia.uap.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.Date;
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
public class updateSurvey extends HttpServlet {
    private Accounts account;
    SQLThing db = new SQLThing();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        Utils util = new Utils();
        Date date = new Date();
        
        String sq1 = util.checkNull(request, "sq1");
        String sq2 = util.checkNull(request, "sq2");
        String sq3 = util.checkNull(request, "sq3");
        String sq4 = util.checkNull(request, "sq4");
        String[] symptoms = new String[]{};
        symptoms = request.getParameterValues("symptoms");
        String symp = util.arrToString(symptoms);
        
        if(sq1.equals(util.NO_VALUE)){
            response.sendRedirect("add.jsp");
        } else if(sq2.equals(util.NO_VALUE)){
            response.sendRedirect("add.jsp");
        } else if(sq3.equals(util.NO_VALUE)){
            response.sendRedirect("add.jsp");
        } else if(sq4.equals(util.NO_VALUE)){
            response.sendRedirect("add.jsp");
        } else {
            if(symp.equals(util.NO_VALUE)){
                symp = "None";
            }
            
            Accounts account = new Accounts();
            account.setSQ1(parseInt(sq1));
            account.setSQ2(parseInt(sq2));
            account.setSQ3(parseInt(sq3));
            account.setSQ4(parseInt(sq4));
            account.setSymptoms(symp);

            int uid = (int) session.getAttribute("currentUserUID");

            account.setUid(uid);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
            db.updateUserSurvey(account, sqlDate);
            response.sendRedirect("do.maps");
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
