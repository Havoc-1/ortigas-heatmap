/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package asia.uap;

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
public class ForgetPass extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Accounts account;
    SQLThing db = new SQLThing();
    
    public void init() {
        account = new Accounts();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Utils util = new Utils();
        HttpSession session = request.getSession();
        
        String checkedUser = util.checkNull(request, "forgotUser");
        
        if(checkedUser.equals(util.NO_VALUE)) {
            System.out.println(checkedUser + "wHAT");
            System.out.println(checkedUser + request.getParameter("forgotUser"));
            response.sendRedirect("forgot.jsp");
        } else {
            Accounts account = new Accounts();
            account.setUsername(checkedUser);
            
            try (PrintWriter out = response.getWriter()) {
                String st = db.getSecQues(account);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<link rel=\"stylesheet\" href=\"./style.css\"/>");
                out.println("<title>Forgot Password</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<section class=\"txt1\">");
                out.println("<div class=\"center\">");
                out.println("<h1>" + st + "</h1>\n" +
"        <form action=\"do.moreForgor\" method=\"POST\">\n" +
"            <div class=\"txt_field\">\n" +
"            <input type=\"text\" name=\"sec_ques_ans\" required>\n" +
"            <label for=\"sec_ques_ans\">Security Question Answer:</label>\n" +
"            <input type=\"hidden\" name=\"forgotUser\" value=\"" + checkedUser + "\">");
            out.println("</div>");
            out.println("<input type=\"submit\" value=\"Submit\"> ");
            out.println("<div class=\"signup_link\">\n" +
"                    <a href=\"login.jsp\">Go back</a>\n" +
"                </div>");
                out.println("</div>");
                out.println("</section>");
                out.println("</body>");
                out.println("</html>");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
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


