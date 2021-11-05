/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asia.uap;

/**
 *
 * @author Sandro
 */

import java.io.IOException;
import asia.uap.Accounts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLThing {
    
    //to add a new user
    public int registerUser(Accounts account) {
        String insert = "INSERT INTO users" +  //sql statement
        "(username, pass, about_me, url_photo, sec_ques_no, sec_ques_ans) SELECT " +
        "?, SHA2(?, 256), ?, ?, ?, ?;";
        
        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        
         try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginreg_db","root","root");
            stmt = conn.prepareStatement(insert);
            
            //stmt.setInt(1,1); //IMPLEMENT AUTO INCREMENT LOGIC HERE
            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getPassword());
            stmt.setString(3, account.getAbout_Me());
            stmt.setString(4, account.getUrl_Photo());
            stmt.setInt(5, account.getSecQuesNo());
            stmt.setString(6, account.getSecQuesAns());
            
            System.out.println(stmt);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
         return result;
    }
    
    public int updateProfile(Accounts account) {
        String insert = "INSERT INTO users" +  //sql statement
        "(username, pass, about_me, url_photo, sec_ques_no, sec_ques_ans) SELECT " +
        "?, SHA2(?, 256), ?, ?, ?, ?;";
        
        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        
         try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginreg_db","root","root");
            stmt = conn.prepareStatement(insert);
            
            //stmt.setInt(1,1); //IMPLEMENT AUTO INCREMENT LOGIC HERE
            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getPassword());
            stmt.setString(3, account.getAbout_Me());
            stmt.setString(4, account.getUrl_Photo());
            stmt.setInt(5, account.getSecQuesNo());
            stmt.setString(6, account.getSecQuesAns());
            
            System.out.println(stmt);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
         return result;
    }
    
    public boolean checkLogin(Accounts account) throws ClassNotFoundException {
        boolean status = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        //sql statement
        String check = "select * from users where username = ? and pass = SHA2(?, 256)";
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginreg_db","root","root");
            stmt = conn.prepareStatement(check);
            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getPassword());
            
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            status = rs.next();
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        return status;
    }
    
    public int getUID(Accounts account) throws ClassNotFoundException {
        int uid = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        //sql statement
        String check = "select uid from users where username = ? and pass = SHA2(?, 256)";
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginreg_db","root","root");
            stmt = conn.prepareStatement(check);
            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getPassword());
            
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                uid = rs.getInt("uid");
                System.out.println(uid);
                return uid;
            }
            System.out.println("oh no it passed through");
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        return uid;
    }
    
    public boolean checkForgotPass(Accounts account) throws ClassNotFoundException {
        boolean status = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        //sql statement
        String check = "select uid from users where username = ? and sec_ques_ans = ?";
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginreg_db","root","root");
            stmt = conn.prepareStatement(check);
            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getSecQuesAns());
            
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            status = rs.next();
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        return status;
    }
    
    public int updatePass(Accounts account) throws ClassNotFoundException {
        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        //sql statement
        String update = "UPDATE users SET pass = SHA2(?, 256) WHERE username = ? and sec_ques_ans = ?;";
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginreg_db","root","root");
            stmt = conn.prepareStatement(update);
            stmt.setString(1, account.getPassword());
            stmt.setString(2, account.getUsername());
            stmt.setString(3, account.getSecQuesAns());
            
            System.out.println(stmt);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }
    
    public String getSecQues(Accounts account) throws ClassNotFoundException {
        String secQues = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        //sql statement
        String forgor = "select sq.question from securityQuestions sq inner join users u on u.sec_ques_no = sq.id where u.username = ?";
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginreg_db","root","root");
            stmt = conn.prepareStatement(forgor);
            stmt.setString(1, account.getUsername());
            
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                secQues = rs.getString("question");
                System.out.println(secQues);
                return secQues;
            }
            System.out.println("oh no it passed through");
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        return secQues;
    }
    
    //gives us info on database errors - see https://docs.oracle.com/javase/7/docs/api/java/sql/SQLException.html
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                //magic superclass of all errors and exceptions, needed because SQLEx is inherited from throwable??
                Throwable a = ex.getCause(); //returns the cause from the exception
                while (a != null) {
                    System.out.println("Cause was : " + a);
                    a = a.getCause();
                    }
            }
        }
    }
}

