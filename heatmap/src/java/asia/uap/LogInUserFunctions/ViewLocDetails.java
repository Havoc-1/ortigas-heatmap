/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asia.uap.LogInUserFunctions;

import asia.uap.Classes.Accounts;
import asia.uap.Classes.Location;
import asia.uap.Register;
import asia.uap.Classes.SQLThing;
import asia.uap.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nofuente
 */
public class ViewLocDetails extends HttpServlet {
    private Accounts account;
    SQLThing db = new SQLThing();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String uri = "WEB-INF/viewLocDetails.jsp";
        ArrayList<Location> list = new ArrayList<>();
        Utils util = new Utils();
        
        String id = util.checkNull(request, "id");
        String add = util.checkNull(request, "address");
        String name = util.checkNull(request, "name");
        String lat = util.checkNull(request, "lat");
        String longi = util.checkNull(request, "long");
        float avgVPH = 0, avgVL = 0;
        boolean compromised = false;
        
        if(id.equals(util.NO_VALUE)) {
            response.sendRedirect("add.jsp");
        } else if(add.equals(util.NO_VALUE)){
            response.sendRedirect("add.jsp");
        } else if(name.equals(util.NO_VALUE)){
            response.sendRedirect("add.jsp");
        } else if(lat.equals(util.NO_VALUE)){
            response.sendRedirect("add.jsp");
        } else if(longi.equals(util.NO_VALUE)){
            response.sendRedirect("add.jsp");
        } else {
            Location loc = new Location();
            loc.setUid(parseInt(id));
            loc.setAddress(add);
            loc.setName(name);
            loc.setLong(parseFloat(longi));
            loc.setLat(parseFloat(lat));

            request.setAttribute("loc", loc);
            
            try {
                avgVPH = db.getAverageVisitsPerHour(parseInt(id));
                avgVL = db.getAverageVisitLength(parseInt(id));
                compromised = db.checkIfLocationCompromised(parseInt(id));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ViewLocDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            request.setAttribute("avgVPH", avgVPH);
            request.setAttribute("avgVL", avgVL);
            request.setAttribute("compromised", compromised);
            RequestDispatcher rd = request.getRequestDispatcher(uri);
            rd.forward(request, response);
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
