/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package asia.uap;


import java.io.IOException;
import java.io.PrintWriter;
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
        processRequest(request, response);
        /*
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
        */
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Utils util = new Utils();
        Date date = new Date();
       
        //user details
        String user = util.checkNull(request, "username");
        String pass = util.checkNull(request, "password");
        String passCon = util.checkNull(request, "passwordConfirm");
        String email = util.checkNull(request, "email");
        String addr = util.checkNull(request, "address");
        String secQ = util.checkNull(request, "sec_ques_no");
        String secAns = util.checkNull(request, "sec_ques_ans");
        
        //covid form
        String sq1 = util.checkNull(request, "sq1");
        String sq2 = util.checkNull(request, "sq2");
        String sq3 = util.checkNull(request, "sq3");
        String sq4 = util.checkNull(request, "sq4");
        String[] symptoms = new String[]{};
        symptoms = request.getParameterValues("symptoms");
        String symp = util.arrToString(symptoms);
        
        if(user.equals(util.NO_VALUE)) {
            response.sendRedirect("add.jsp");
        } else if(pass.equals(util.NO_VALUE)){
            response.sendRedirect("add.jsp");
        } else if(passCon.equals(util.NO_VALUE)){
            response.sendRedirect("add.jsp");
        } else if(email.equals(util.NO_VALUE)){
            response.sendRedirect("add.jsp");
        } else if(addr.equals(util.NO_VALUE)){
            response.sendRedirect("add.jsp");
        } else if(secQ.equals(util.NO_VALUE)){
            response.sendRedirect("add.jsp");
        } else if(secAns.equals(util.NO_VALUE)){
            response.sendRedirect("add.jsp");
        } else if(sq1.equals(util.NO_VALUE)){
            response.sendRedirect("add.jsp");
        } else if(sq2.equals(util.NO_VALUE)){
            response.sendRedirect("add.jsp");
        } else if(sq3.equals(util.NO_VALUE)){
            response.sendRedirect("add.jsp");
        } else if(sq4.equals(util.NO_VALUE)){
            response.sendRedirect("add.jsp");
        } else {
            if(symp.equals(util.NO_VALUE)){
                symp = "None";
            }
            if (pass.equals(passCon)){
                Accounts account = new Accounts();
                account.setUsername(user);
                account.setPassword(pass);
                account.setEmail(email);
                account.setAddress(addr);
                account.setSecQuesNo(parseInt(secQ));
                account.setSecQuesAns(secAns);
                account.setSQ1(parseInt(sq1));
                account.setSQ2(parseInt(sq2));
                account.setSQ3(parseInt(sq3));
                account.setSQ4(parseInt(sq4));
                account.setSymptoms(symp);
                System.out.println(symp);
                
                java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
                
                db.registerUser(account, sqlDate);
                int uid;
                try {
                    uid = db.getUID(account);
                    account.setUid(uid);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
                db.registerUserSurvey(account, sqlDate);
                response.sendRedirect("login.jsp");
            } else{
                response.sendRedirect("add.jsp");
            }
        }
        
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
