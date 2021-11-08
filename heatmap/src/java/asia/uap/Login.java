/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package asia.uap;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sandro
 */

import asia.uap.Accounts;
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
public class Login extends HttpServlet {
    
    private Accounts account;
    SQLThing db = new SQLThing();
    
    public void init() {
        account = new Accounts();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("userLogin");
        String password = request.getParameter("passLogin");
        
        if(username == null || username.isEmpty()) {
            response.sendRedirect("login.jsp");
        } else if (password == null || password.isEmpty()) {
            response.sendRedirect("login.jsp");
        } else {
            Accounts account = new Accounts();
            account.setUsername(username);
            account.setPassword(password);
            
            try {
                if (db.checkLogin(account)) {
                    String redir = "";
                    session.setAttribute("currentUser", username);
                    int i = db.getUID(account);
                    session.setAttribute("currentUserUID", i);
                    java.sql.Date d1 = db.getDate(i);
                    java.sql.Date d2 = new java.sql.Date(System.currentTimeMillis());  
                    long difference = d2.getTime() - d1.getTime();
                    float daysBetween = (difference / (1000*60*60*24));
                    System.out.println("daysBetween: " + daysBetween);
                    if (daysBetween > 0 ){
                        redir = "survey.jsp";
                    } else{
                        redir = "home.jsp";
                    }
                    db.updateDate(d2, i);
                    response.sendRedirect(redir);
                } else{
                    response.sendRedirect("index.jsp");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}

