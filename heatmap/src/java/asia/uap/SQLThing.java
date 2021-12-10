/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asia.uap;

/**
 *
 * @author Sandro
 */

import asia.uap.Classes.Location;
import asia.uap.Classes.Accounts;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SQLThing {
    private String driver;
    private String url;
    private String user;
    private String pass;
    
    // <editor-fold defaultstate="collapsed" desc="Load class and SQL">
    
    //to add a new user
    private boolean loadClass() {
        //Load whatever preloaded driver from SQL properties file.
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public void loadSQL() {
        //Retrieve from SQL.properties
        ResourceBundle sql = ResourceBundle.getBundle("asia.uap.SQL");
        this.url = sql.getString("url");
        this.user = sql.getString("user");
        this.pass = sql.getString("password");
        this.driver = sql.getString("driver");
    }   
    
    public SQLThing(String driver, String url, String user, String pass){
        this.url = url;
        this.user = user;
        this.pass = pass;
        this.driver = driver;
    }
    
    public SQLThing(){
        loadSQL();
    }// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Register Methods: User, UserSurvey">
    public int registerUser(Accounts account, Date d) {
        String insert = "INSERT INTO users" +  //sql statement
        "(username, password, email, address, sec_ques_no, sec_ques_ans, lastLogin) SELECT " +
        "?, SHA2(?, 256), ?, ?, ?, SHA2(?, 256), ?;";
        
        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        loadClass();
        
        
         try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.prepareStatement(insert);
            
            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getPassword());
            stmt.setString(3, account.getEmail());
            stmt.setString(4, account.getAddress());
            stmt.setInt(5, account.getSecQuesNo());
            stmt.setString(6, account.getSecQuesAns());
            stmt.setDate(7, d);
            
            System.out.println(stmt);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
         return result;
    }
    
    public int registerUserSurvey(Accounts account, Date d) {
        String insert = "INSERT INTO covidquestions " +  //sql statement
        "(sq1, sq2, sq3, sq4, symptoms, lastUpdated) SELECT " +
        "?, ?, ?, ?, ?, ?;";
        
        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        loadClass();
        
         try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.prepareStatement(insert);
            
            stmt.setInt(1, account.getSQ1());
            stmt.setInt(2, account.getSQ2());
            stmt.setInt(3, account.getSQ3());
            stmt.setInt(4, account.getSQ4());
            stmt.setString(5, account.getSymptoms());
            stmt.setDate(6, d);
            
            System.out.println(stmt);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
         return result;
    }
    
    public int registerLocation(Location loc) {
        String insert = "INSERT INTO location " +  //sql statement
        "(name, address, longitude, latitude, status) SELECT " +
        "?, ?, ?, ?, ?;";
        
        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        loadClass();
        
         try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.prepareStatement(insert);
            
            stmt.setString(1, loc.getName());
            stmt.setString(2, loc.getAddress());
            stmt.setFloat(3, loc.getLong());
            stmt.setFloat(4, loc.getLat());
            stmt.setBoolean(5, loc.getStatus());
            
            System.out.println(stmt);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
         return result;
    }
    
    public int registerCheckOut(int i, int locID, int uID) throws ClassNotFoundException {
        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        //sql statement
        String update = "INSERT INTO checkin_history (userID, locID, checkInTime, checkOutTime) "
                + "SELECT ?,  ?, DATE_ADD(NOW(), INTERVAL - ? HOUR), NOW()";

        loadClass();
        
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.prepareStatement(update);
            stmt.setInt(1, uID);
            stmt.setInt(2, locID);
            stmt.setInt(3, i);
            
            System.out.println(stmt);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Update Methods: UserSurvey, Profile, Date, Pass, Location">
    public int updateUserSurvey(Accounts account, Date d) {
        String insert = "UPDATE covidquestions " +  //sql statement
        "(sq1, sq2, sq3, sq4, symptoms, lastUpdated) SELECT " +
        "?, ?, ?, ?, ?, ? " +
        "WHERE uid = ?";
        
        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        loadClass();
        
         try {
            conn = DriverManager.getConnection(url, user, pass); 
            stmt = conn.prepareStatement(insert);
            
            stmt.setInt(1, account.getSQ1());
            stmt.setInt(2, account.getSQ2());
            stmt.setInt(3, account.getSQ3());
            stmt.setInt(4, account.getSQ4());
            stmt.setString(5, account.getSymptoms());
            stmt.setDate(6, d);
            stmt.setInt(7, account.getUid());
            
            System.out.println(stmt);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
         return result;
    }
    
    public int updateProfile(Accounts account, int uid) {
        String insert = "UPDATE users " +
                        "SET password = SHA2(?, 256), email = ?, address = ? " +
                        "WHERE uid = ?;";
        String insert2 = "UPDATE users " +
                        "SET email = ?, address = ? " +
                        "WHERE uid = ?;";
        
        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        loadClass();
        
         try {
            conn = DriverManager.getConnection(url, user, pass); 
            String s = account.getPassword();
            if(s == null || s.isEmpty()) {
                stmt = conn.prepareStatement(insert2);
                stmt.setString(1, account.getEmail());
                stmt.setString(2, account.getAddress());
                stmt.setInt(3, uid);
            }else{
                stmt = conn.prepareStatement(insert);
                stmt.setString(1, s);
                stmt.setString(2, account.getEmail());
                stmt.setString(3, account.getAddress());
                stmt.setInt(4, uid);
            } 

            System.out.println(stmt);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
         return result;
    }
    
    public int updateDate(Date d, int uid) throws ClassNotFoundException {
        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        //sql statement
        String update = "UPDATE users SET lastLogin = ? WHERE uid = ?";
        
        loadClass();
        
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.prepareStatement(update);
            stmt.setDate(1, d);
            stmt.setInt(2, uid);
            
            System.out.println(stmt);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }
    
    public int updatePass(Accounts account) throws ClassNotFoundException {
        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        //sql statement
        String update = "UPDATE users SET password = SHA2(?, 256) WHERE username = ? and sec_ques_ans = SHA2(?, 256)";
        
        loadClass();
        
        try {
            conn = DriverManager.getConnection(url, user, pass);
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
    
    public int updateLocation(Location l) throws ClassNotFoundException {
        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        //sql statement
        String update = "UPDATE location SET address = ?, name = ?, latitude = ?, longitude = ?, status = 1 WHERE uid = ?";
        
        loadClass();
        
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.prepareStatement(update);
            stmt.setString(1, l.getAddress());
            stmt.setString(2, l.getName());
            stmt.setFloat(3, l.getLat());
            stmt.setFloat(4, l.getLong());
            stmt.setInt(5, l.getUid());
            
            System.out.println(stmt);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Get Methods: Account, All Accounts, Pending Locations, Date, UID, AdminUID, SecQues">
    public Accounts getAccount(int uid) {
        String getAcc = "SELECT u.username, u.email, u.address, u.lastLogin, cq.sq1, cq.sq2, cq.sq3, cq.sq4, cq.symptoms " +
                        "FROM users u " +
                        "INNER JOIN covidquestions cq " +
                        "ON u.uid = cq.userUID " +
                        "WHERE u.uid = ?;";
        
        Accounts account = new Accounts();
        Connection conn = null;
        PreparedStatement stmt = null;
        
        loadClass();
        
         try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.prepareStatement(getAcc);
            
            stmt.setInt(1, uid);
            
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                account.setUsername(rs.getString("u.username"));
                account.setEmail(rs.getString("u.email"));
                account.setAddress(rs.getString("u.address"));
                account.setLastLogin(rs.getDate("u.lastLogin"));
                account.setSQ1(rs.getInt("cq.sq1"));
                account.setSQ2(rs.getInt("cq.sq2"));
                account.setSQ3(rs.getInt("cq.sq3"));
                account.setSQ4(rs.getInt("cq.sq4"));
                account.setSymptoms(rs.getString("cq.symptoms"));
                return account;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
         return account;
    }
    
    public ArrayList<Accounts> getAllAccounts() {
        String getAcc = "SELECT u.uid, u.username, u.email, u.address, u.lastLogin, cq.sq1, cq.sq2, cq.sq3, cq.sq4, cq.symptoms " +
                        "FROM users u " +
                        "INNER JOIN covidquestions cq " +
                        "ON u.uid = cq.userUID ";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<Accounts> list = new ArrayList<>();
        
        loadClass();
        
         try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.prepareStatement(getAcc);
            
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Accounts account = new Accounts();
                account.setUid(rs.getInt("u.uid"));
                account.setUsername(rs.getString("u.username"));
                account.setEmail(rs.getString("u.email"));
                account.setAddress(rs.getString("u.address"));
                account.setLastLogin(rs.getDate("u.lastLogin"));
                account.setSQ1(rs.getInt("cq.sq1"));
                account.setSQ2(rs.getInt("cq.sq2"));
                account.setSQ3(rs.getInt("cq.sq3"));
                account.setSQ4(rs.getInt("cq.sq4"));
                account.setSymptoms(rs.getString("cq.symptoms"));
                account.setCovidStatus();
                list.add(account);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
         return list;
    }
    
    public ArrayList<Location> getPendingLocations() {
        String getAcc = "SELECT * " +
                        "FROM location " +
                        "WHERE status = 0";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<Location> list = new ArrayList<>();
        
        loadClass();
        
         try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.prepareStatement(getAcc);
            
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Location loc = new Location();
                loc.setUid(rs.getInt("uid"));
                loc.setName(rs.getString("name"));
                loc.setAddress(rs.getString("address"));
                loc.setLong(rs.getFloat("longitude"));
                loc.setLat(rs.getFloat("latitude"));
                loc.setStatus(rs.getBoolean("status"));
                list.add(loc);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
         return list;
    }
    
    public ArrayList<Location> getApprovedLocations() {
        String getAcc = "SELECT * " +
                        "FROM location " +
                        "WHERE status = 1";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<Location> list = new ArrayList<>();
        
        loadClass();
        
         try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.prepareStatement(getAcc);
            
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Location loc = new Location();
                loc.setUid(rs.getInt("uid"));
                loc.setName(rs.getString("name"));
                loc.setAddress(rs.getString("address"));
                loc.setLong(rs.getFloat("longitude"));
                loc.setLat(rs.getFloat("latitude"));
                loc.setStatus(rs.getBoolean("status"));
                list.add(loc);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
         return list;
    }
    
    public Date getDate(int uid) {
        String getDate = "SELECT lastLogin FROM users where uid = ?";
        
        Date d = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        loadClass();
        
         try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.prepareStatement(getDate);
            
            stmt.setInt(1, uid);
            
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDate("lastLogin");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
         return d;
    }

    public int getUID(Accounts account) throws ClassNotFoundException {
        int uid = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        //sql statement
        String check = "select uid from users where username = ? and password = SHA2(?, 256)";
        
        loadClass();
        
        try {
            conn = DriverManager.getConnection(url, user, pass);
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
    
    public int getAdminUID(Accounts account) throws ClassNotFoundException {
        int uid = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        //sql statement
        String check = "select uid from admins where username = ? and password = SHA2(?, 256)";
        
        loadClass();
        
        try {
            conn = DriverManager.getConnection(url, user, pass);
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
    
    public String getSecQues(Accounts account) throws ClassNotFoundException {
        String secQues = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        //sql statement
        String forgor = "select sq.question from securityQuestions sq inner join users u on u.sec_ques_no = sq.id where u.username = ?";
        
        loadClass();
        
        try {
            conn = DriverManager.getConnection(url, user, pass);
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
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Check Methods: Pass, ForgotPass, Login, AdminLogin">
    public boolean checkPass(int i, String p) throws ClassNotFoundException {
        boolean status = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        //sql statement
        String check = "select username from users where uid = ? and password = SHA2(?, 256)";
        
        loadClass();
        
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.prepareStatement(check);
            stmt.setInt(1, i);
            stmt.setString(2, p);
            
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            status = rs.next();
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        return status;
    }
    
    public boolean checkForgotPass(Accounts account) throws ClassNotFoundException {
        boolean status = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        //sql statement
        String check = "select uid from users where username = ? and sec_ques_ans = SHA2(?, 256)";
        
        loadClass();
        
        try {
            conn = DriverManager.getConnection(url, user, pass);
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
    
    public boolean checkLogin(Accounts account) throws ClassNotFoundException {
        boolean status = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        //sql statement
        String check = "select * from users where username = ? and password = SHA2(?, 256)";
        
        loadClass();
        
        try {
            conn = DriverManager.getConnection(url, user, pass);
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
    
    public boolean checkAdminLogin(Accounts account) throws ClassNotFoundException {
        boolean status = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        //sql statement
        String check = "select * from admins where username = ? and password = SHA2(?, 256)";
        
        loadClass();
        
        try {
            conn = DriverManager.getConnection(url, user, pass);
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
    
    public boolean checkLocation(Accounts account) throws ClassNotFoundException { // to be revised
        boolean status = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        //sql statement
        String check = "select * from admins where username = ? and password = SHA2(?, 256)";
        
        loadClass();
        
        try {
            conn = DriverManager.getConnection(url, user, pass);
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
    
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Check In Methods">
    public int checkIn(Accounts account, Date d) { // TO BE REVISED
        String insert = "INSERT INTO users" +  //sql statement
        "(username, password, email, address, sec_ques_no, sec_ques_ans, lastLogin) SELECT " +
        "?, SHA2(?, 256), ?, ?, ?, SHA2(?, 256), ?;";
        
        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        loadClass();
        
        
         try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.prepareStatement(insert);
            
            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getPassword());
            stmt.setString(3, account.getEmail());
            stmt.setString(4, account.getAddress());
            stmt.setInt(5, account.getSecQuesNo());
            stmt.setString(6, account.getSecQuesAns());
            stmt.setDate(7, d);
            
            System.out.println(stmt);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
         return result;
    }
    
    public int checkOut(Accounts account, Date d) { // TO BE REVISED
        String insert = "INSERT INTO users" +  //sql statement
        "(username, password, email, address, sec_ques_no, sec_ques_ans, lastLogin) SELECT " +
        "?, SHA2(?, 256), ?, ?, ?, SHA2(?, 256), ?;";
        
        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        loadClass();
        
        
         try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.prepareStatement(insert);
            
            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getPassword());
            stmt.setString(3, account.getEmail());
            stmt.setString(4, account.getAddress());
            stmt.setInt(5, account.getSecQuesNo());
            stmt.setString(6, account.getSecQuesAns());
            stmt.setDate(7, d);
            
            System.out.println(stmt);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
         return result;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Delete Methods">
    public int deleteLoc(Location l) throws ClassNotFoundException {
        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        //sql statement
        String update = "DELETE from location WHERE uid = ?";
        
        loadClass();
        
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.prepareStatement(update);
            stmt.setInt(1, l.getUid());
            
            System.out.println(stmt);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }
    // </editor-fold>
    
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

