/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asia.uap.Admin;

import asia.uap.Classes.Location;
import asia.uap.Classes.Accounts;
import asia.uap.Classes.SQLThing;
import asia.uap.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
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
public class ApproveLocation extends HttpServlet {
    private Accounts account;
    SQLThing db = new SQLThing();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Utils util = new Utils();
        
        String id = util.checkNull(request, "id");
        String address = util.checkNull(request, "address");
        String name = util.checkNull(request, "name");
        String lat = util.checkNull(request, "lat");
        String longi = util.checkNull(request, "long");
        
        if(id.equals(util.NO_VALUE)) {
            System.out.println("1");
            response.sendRedirect("WEB-INF/adminApproveLocation.jsp");
        } else if(address.equals(util.NO_VALUE)){
            System.out.println("2");
            response.sendRedirect("WEB-INF/adminApproveLocation.jsp");
        } else if(name.equals(util.NO_VALUE)){
            System.out.println("3");
            response.sendRedirect("WEB-INF/adminApproveLocation.jsp");
        } else if(lat.equals(util.NO_VALUE)){
            System.out.println("4");
            response.sendRedirect("WEB-INF/adminApproveLocation.jsp");
        } else if(longi.equals(util.NO_VALUE)){
            System.out.println("5");
            response.sendRedirect("WEB-INF/adminApproveLocation.jsp");;
        } else {
            Location l = new Location();
            l.setUid(parseInt(id));
            System.out.println("AOPWEJPA ID: " + id);
            l.setAddress(address);
            l.setName(name);
            l.setLat(parseFloat(lat));
            l.setLong(parseFloat(longi));
            
            try {
                db.updateLocation(l);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ApproveLocation.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("do.admin");;
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
