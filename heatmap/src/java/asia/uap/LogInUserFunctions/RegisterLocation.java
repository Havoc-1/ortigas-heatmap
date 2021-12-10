/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asia.uap.LogInUserFunctions;

import asia.uap.Classes.Location;
import asia.uap.Classes.Accounts;
import asia.uap.Classes.SQLThing;
import asia.uap.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Float.parseFloat;
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
public class RegisterLocation extends HttpServlet {
    private Accounts account;
    private Location loc;
    SQLThing db = new SQLThing();

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Utils util = new Utils();
        Date date = new Date();
        String redir = "";
        String message = "";
       
        //user details
        String add = util.checkNull(request, "address");
        String name = util.checkNull(request, "name");
        String lat = util.checkNull(request, "lat");
        String longi = util.checkNull(request, "long");
        
        if(add.equals(util.NO_VALUE)) {
            response.sendRedirect("do.maps");
        } else if(name.equals(util.NO_VALUE)){
            response.sendRedirect("do.maps");
        } else if(lat.equals(util.NO_VALUE)){
            response.sendRedirect("do.maps");
        } else if(longi.equals(util.NO_VALUE)){
            response.sendRedirect("do.maps");
        } else {
            Location loc = new Location();
            loc.setName(name);
            loc.setAddress(add);
            loc.setLat(parseFloat(lat));
            loc.setLong(parseFloat(longi));
            loc.setStatus(false);

            db.registerLocation(loc);
            redir = "do.maps";
            message = "Location has been succesfully registered! Wait a day for administrators to confirm details.";
        }
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + message + "</h1>");
            out.println("<a href=\"" + redir + "\">Next page</a>");
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
