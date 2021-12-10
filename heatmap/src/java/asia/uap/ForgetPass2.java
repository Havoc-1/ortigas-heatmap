/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package asia.uap;


import asia.uap.Classes.Accounts;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nofuente
 */
public class ForgetPass2 extends HttpServlet {
    private Accounts account;
    SQLThing db = new SQLThing();
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
        
        String ans = util.checkNull(request, "sec_ques_ans");
        String fu = util.checkNull(request, "forgotUser");
        
        if(ans.equals(util.NO_VALUE)) {
            response.sendRedirect("do.forgor");
        } else if(fu.equals(util.NO_VALUE)) {
            response.sendRedirect("do.forgor");
        } else {
            Accounts account = new Accounts();
            account.setUsername(fu);
            account.setSecQuesAns(ans);
            
            try {
                if (db.checkForgotPass(account)) {
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
                        out.println("<h1>Account authentication complete!</h1>\n" +
        "        <form action=\"do.successForget\" method=\"POST\">\n" +
        "            <input type=\"hidden\" name=\"sec_ques_ans\" value=\"" + ans + "\">" +
        "            <input type=\"hidden\" name=\"forgotUser\" value=\"" + fu + "\">");
                    out.println("<input type=\"submit\" value=\"Proceed\">");
                    out.println("</div>");
                    out.println("</section>");
                        out.println("</body>");
                        out.println("</html>");
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    response.sendRedirect("do.successForget");
                } else{
                    System.out.println("dies");
                    response.sendRedirect("index.jsp"); 
                }
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

