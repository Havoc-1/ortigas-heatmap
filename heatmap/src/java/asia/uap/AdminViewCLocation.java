/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asia.uap;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
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
public class AdminViewCLocation extends HttpServlet {
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
        String uri = "WEB-INF/adminConfirmLoc.jsp";
        
        String id = util.checkNull(request, "id");
        String address = util.checkNull(request, "address");
        String name = util.checkNull(request, "name");
        String lat = util.checkNull(request, "lat");
        String longi = util.checkNull(request, "long");
        
        if(id.equals(util.NO_VALUE)) {
            response.sendRedirect("WEB-INF/adminApproveLoc.jsp");
        } else if(address.equals(util.NO_VALUE)){
            response.sendRedirect("WEB-INF/adminApproveLoc.jsp");
        } else if(name.equals(util.NO_VALUE)){
            response.sendRedirect("WEB-INF/adminApproveLoc.jsp");
        } else if(lat.equals(util.NO_VALUE)){
            response.sendRedirect("WEB-INF/adminApproveLoc.jsp");
        } else if(longi.equals(util.NO_VALUE)){
            response.sendRedirect("WEB-INF/adminApproveLoc.jsp");
        } else {
            Location l = new Location();
            l.setUid(parseInt(id));
            l.setAddress(address);
            l.setName(name);
            l.setLat(parseFloat(lat));
            l.setLong(parseFloat(longi));
            
            request.setAttribute("loc", l);
            RequestDispatcher rd = request.getRequestDispatcher(uri);
            rd.forward(request,response);
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
