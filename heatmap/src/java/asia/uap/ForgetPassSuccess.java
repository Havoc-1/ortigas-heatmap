/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package asia.uap;


import asia.uap.Classes.Accounts;
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
public class ForgetPassSuccess extends HttpServlet {
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
        
        if(ans.equals(util.NO_VALUE)) {
            response.sendRedirect("do.moreForgor");
        } else if(fu.equals(util.NO_VALUE)) {
            response.sendRedirect("do.moreForgor");
        } else {
            Accounts account = new Accounts();
            account.setUsername(fu);
            account.setSecQuesAns(fu);
            
            try (PrintWriter out = response.getWriter()) {
                try {
                    String st = db.getSecQues(account);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ForgetPassSuccess.class.getName()).log(Level.SEVERE, null, ex);
                }
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Forgot Password</title>");            
                out.println("<link rel=\"stylesheet\" href=\"./style.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<section class=\"txt1\">");
                out.println("<div class=\"center\">");
                out.println("<h1>Update password</h1>\n" +
"               <form action=\"do.updatePass\" method=\"POST\">\n" +
"                   <div class=\"txt_field\">\n" +
"                   <input type=\"password\" name=\"password\" required>" +
                    "<span></span>\n" +
"                   <label for=\"password\">New Password:</label>\n" +
                    "</div>\n" +    
"                   <div class=\"txt_field\">\n" +
"                   <input type=\"password\" name=\"passwordConfirm\" required>" +
                    "<span></span>\n" +
"                   <label for=\"passwordConfirm\">Confirm New Password:</label>\n" +
                    "</div>\n" +        

"                   <input type=\"hidden\" name=\"sec_ques_ans\" value=\"" + ans + "\">" +
"                   <input type=\"hidden\" name=\"forgotUser\" value=\"" + fu + "\">" +
"            \n" + "<input type=\"submit\" value=\"Submit\"><br>");
                out.println("</div>");
                out.println("</section>");
                out.println("</body>");
                out.println("</html>");
            }        }
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


