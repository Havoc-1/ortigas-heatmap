/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package asia.uap.LogInUserFunctions;

import asia.uap.Classes.Location;
import asia.uap.Classes.Reviews;
import asia.uap.Classes.SQLThing;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Sandro
 */
public class Maps extends HttpServlet {
    SQLThing db = new SQLThing();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        
        URL url = this.getClass().getResource("heatmap.txt");
        File file = new File(url.getPath());
        
        
        ArrayList<String> heatmap = new ArrayList<String>();
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            heatmap.add(data);
        }
        myReader.close();
        
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Location> list = new ArrayList<>();
        
       
        HashMap<Integer,Float> hour = new HashMap<Integer,Float>();
        HashMap<Integer,Float> length = new HashMap<Integer,Float>();
        HashMap<Integer, ArrayList<Reviews>> reviews = new HashMap<Integer, ArrayList<Reviews>>();
        String uri = "WEB-INF/home.jsp";
        
        list = db.getApprovedLocations();
        for(Location location : list ) {
            int fuid = location.getUid();
            hour.put(fuid, db.getAverageVisitsPerHour(fuid));
            length.put(fuid, db.getAverageVisitLength(fuid));   
            reviews.put(fuid, db.getReviews(fuid));
        }
        
        request.setAttribute("heatmap", heatmap);
        request.setAttribute("reviews", reviews);
        request.setAttribute("lengthr", length);
        request.setAttribute("avghr", hour);
        request.setAttribute("contList", list);
        RequestDispatcher rd = request.getRequestDispatcher(uri);
        rd.forward(request,response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Maps.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Maps.class.getName()).log(Level.SEVERE, null, ex);
        }
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
