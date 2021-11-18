<%-- 
    Document   : admin
    Created on : Nov 8, 2021, 12:44:53 AM
    Author     : Sandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.cj.jdbc.Driver"); %>
<html>
    <head>
        <meta name ="viewport" content="width=device-width, initial-scale=1.0"> <%-- to make the webpage responsive --%>        
        <link rel="stylesheet" href="./style.css"/>
        <%-- CDN to call bootstrap --%>        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <%
            String sql = "SELECT u.uid, u.username, u.email, u.address, sq.question, cq.sq1, cq.sq2, cq.sq3, cq.sq4, cq.symptoms "
                  + "FROM users u "
                  + "INNER JOIN securityquestions sq "
                  + "ON u.sec_ques_no = sq.id "
                  + "INNER JOIN covidquestions cq "
                  + "ON u.uid = cq.userUID;";
            Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/loginreg_db","root","root");
            PreparedStatement stmt = connection.prepareStatement(sql);
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
       %>
        <section class="admintab">
             <div class="container">
            <div class="row">
              <div class="col-12">
                <table class="table table-bordered">
                  <thead>
                    <tr>
                      <th scope="col">UID</th>
                      <th scope="col">Username</th>
                      <th scope="col">Email</th>
                      <th scope="col">Address</th>
                      <th scope="col">Security Question</th>
                      <th scope="col">Status</th>
                      <th scope="col">Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    <% while(rs.next()){ %>
                    <tr>
                      <% String uid = rs.getString(1); %>
                        <td><%= uid %></td>
                      <td><%= rs.getString(2) %></td>
                      <td><%= rs.getString(3) %></td>
                      <td><%= rs.getString(4) %></td>
                      <td><%= rs.getString(5) %></td>
                      <%
                          boolean sq1 = rs.getBoolean(6);
                          boolean sq2 = rs.getBoolean(7);
                          boolean sq3 = rs.getBoolean(8);
                          boolean sq4 = rs.getBoolean(9);
                          String symp = rs.getString(10);
                          boolean qStatus = false;
                          
                          String print = "";
                          if (sq1 && sq2 && sq3 && sq4){
                              qStatus = false;
                          }else{
                              qStatus = true;
                          }
                          if (qStatus && symp.equals("None")){
                              print = "Safe";
                          }else{
                              print = "Compromised";
                          }
                      %>
                      <td><%= print %></td>
                      <td> <%-- Implement administrator abilities here (icons are from bootstrap/fontisawesome --%> 
                        <button type="button" class="btn btn-primary"><i class="far fa-eye"></i></button>
                        <button type="button" class="btn btn-success"><i class="fas fa-edit"></i></button>
                        <button type="button" class="btn btn-danger"><i class="far fa-trash-alt" ></i></button>
                      </td>
                    </tr>
                    <% } %>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        <a href="home.jsp" class="previous">Go back</a>
        </section>
    </body>
</html>
