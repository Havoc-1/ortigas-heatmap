/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package asia.uap.LogInUserFunctions;


import asia.uap.Classes.Accounts;
import asia.uap.Classes.SQLThing;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Update Password</title>");
            out.println("<link rel=\"stylesheet\" href=\"./style.css\"/>");
            out.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\"/>");
            out.println("</head>");
            out.println("<body>");
            //navbar
            out.println("<div class=\"navbar\">");
            out.println("<a href=\"do.maps\"><img src =\"img/logo.png\"></a>");
            out.println("<div class=\"dropdown\">");
            out.println("<button class=\"dropbtn\">Options");
            out.println("<i class=\"fa fa-caret-down\"></i>");
            out.println("</button>");
            out.println("<div class=\"dropdown-content\">");
            out.println("<a href=\"profile.jsp\">Profile Settings</a>");
            out.println("<a href=\"do.logout\">Log Out</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            //main page
            out.println("<div class=\"viewprofile2\">");
            out.println("<div class=\"profilecontain\">");
            out.println("<div class=\"sqlprof\">");
            out.println("<h1>Edit Profile</h1>");
            out.println("<h3>For user details that does not want to be edited, leave the input box blank.</h3>");
            out.println("<form action =\"do.confirmEdits\" method =\"post\">\n" +
"                <label for=\"password\" class=\"q1\">New Password:</label><br>\n" +
"                <input type=\"password\" class=\"profeditp\" name=\"password\" onkeyup='check();'><br>\n" +
"                \n" +
"                <label for=\"passwordConfirm\" class=\"q1\">Confirm New Password:</label><br>\n" +
"                <input type=\"password\" class=\"profeditp\" name=\"passwordConfirm\" onkeyup='check();'><br>\n" +
"                \n" +                 
"                <label for=\"abtme\" class=\"q1\">New Email:</label><br>\n" +
"                <input type=\"text\" class=\"profedit\" name=\"email\"><br>\n" +
"                \n" +
"                <label for=\"url_photo\" class=\"q1\">New Address:</label><br>\n" +
"                <input type=\"text\" class=\"profedit\" name=\"address\"><br><br>\n");
            out.println("<input type=\"submit\" class=\"submitbtn2\" value=\"Submit\">\n" +
"            </form>");
            out.println("</div>");
            out.println("</div>");
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
