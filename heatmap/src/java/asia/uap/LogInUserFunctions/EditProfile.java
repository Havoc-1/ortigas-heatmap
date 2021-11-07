/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package asia.uap.LogInUserFunctions;


import asia.uap.Accounts;
import asia.uap.SQLThing;
import asia.uap.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nofuente
 */
public class EditProfile extends HttpServlet {
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
        HttpSession session = request.getSession();

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdatePassword</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Edit Profile</h1>");
            out.println("<h3>For user details that does not want to be edited, leave the input box blank.</h3>");
            out.println("<form action =\"do.confirmEdits\" method =\"post\">\n" +
"                <label for=\"username\">New Username:</label><br>\n" +
"                <input type=\"text\" name=\"username\"><br>\n" +
"                \n" +
"                <label for=\"password\">New Password:</label><br>\n" +
"                <input type=\"password\" name=\"password\" onkeyup='check();'><br>\n" +
"                \n" +
"                <label for=\"passwordConfirm\">Confirm New Password:</label><br>\n" +
"                <input type=\"password\" name=\"passwordConfirm\" onkeyup='check();'><br>\n" +
"                \n" +                 
"                <label for=\"abtme\">New Email:</label><br>\n" +
"                <input type=\"text\" name=\"email\"><br>\n" +
"                \n" +
"                <label for=\"url_photo\">New Address:</label><br>\n" +
"                <input type=\"text\" name=\"address\"><br><br>\n" +
"\n" +
"                <input type=\"submit\" value=\"Submit\">\n" +
"            </form>");
            out.println("<script src='onKeyUp.js'></script>");
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
