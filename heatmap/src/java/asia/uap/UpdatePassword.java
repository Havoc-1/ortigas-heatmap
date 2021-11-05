/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package asia.uap;

import asia.uap.Accounts;
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
public class UpdatePassword extends HttpServlet {
    private Accounts account;
    SQLThing db = new SQLThing();
    
    public void init() {
        account = new Accounts();
    }
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
        
        Utils util = new Utils();
        HttpSession session = request.getSession();
        
        String ans = util.checkNull(request, "sec_ques_ans");
        String fu = util.checkNull(request, "forgotUser");
        String p = util.checkNull(request, "password");
        String pc = util.checkNull(request, "passwordConfirm");
        
        if(ans.equals(util.NO_VALUE)) {
            response.sendRedirect("do.successForgot");
        } else if(fu.equals(util.NO_VALUE)) {
            response.sendRedirect("do.successForgot");
        } else if (p.equals(util.NO_VALUE)) {
            response.sendRedirect("do.successForgot");
        } else if (pc.equals(util.NO_VALUE)) {
            response.sendRedirect("do.successForgot");
        } else if (p.equals(pc)) {
            account.setUsername(fu);
            account.setSecQuesAns(ans);
            account.setPassword(p);
            
            try {
                db.updatePass(account);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UpdatePassword.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("index.jsp");
        } else{
            response.sendRedirect("do.successForgot");
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdatePassword</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdatePassword at " + request.getContextPath() + "</h1>");
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
