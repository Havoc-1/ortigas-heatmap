/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package asia.uap;


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
 * @author Sandro
 */
public class Register extends HttpServlet {

    private Accounts account;
    SQLThing db = new SQLThing();

    
    public void init() {
        account = new Accounts();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException { 
        Utils util = new Utils();
        
        String checkedUser = util.checkNull(request, "username");
        String checkedPass = util.checkNull(request, "password");
        String checkedAboutMe = util.checkNull(request, "abtme");
        String checkedPhoto = util.checkNull(request, "url_photo");
        String checkedSecQuesAns = util.checkNull(request, "sec_ques_ans");
        
        if (checkedUser.equals(util.NO_VALUE)) {
            response.sendRedirect("login.jsp");
        } else if (checkedPass.equals(util.NO_VALUE)) {
            response.sendRedirect("login.jsp");
        } else if (checkedAboutMe.equals(util.NO_VALUE)) {
            response.sendRedirect("login.jsp");
        } else if (checkedPhoto.equals(util.NO_VALUE)) {
            response.sendRedirect("login.jsp");
        } else if (checkedSecQuesAns.equals(util.NO_VALUE)) {
            response.sendRedirect("login.jsp");
        } else {
            Accounts account = new Accounts();
            account.setUsername(checkedUser);
            account.setPassword(checkedPass);
            account.setAboutMe(checkedAboutMe);
            account.setUrlPhoto(checkedPhoto);
            int i = Integer.parseInt(request.getParameter("sec_ques_no"));
            account.setSecQuesNo(i);
            account.setSecQuesAns(checkedSecQuesAns);


            db.registerUser(account);

            response.sendRedirect("home.jsp");
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String sq = (String) session.getAttribute("secques");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Register at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
