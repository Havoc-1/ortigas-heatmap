<%-- 
    Document   : admin
    Created on : Nov 8, 2021, 12:44:53 AM
    Author     : Sandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
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
                      <th scope="col">Last Login</th>
                      <th scope="col">Status</th>
                      <th scope="col">Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="acc" items="${accList}">
                        <tr>
                            <td><c:out value="${acc.getUid()}" /></td>
                            <td><c:out value="${acc.getUsername()}" /></td>
                            <td><c:out value="${acc.getEmail()}" /></td>
                            <td><c:out value="${acc.getAddress()}" /></td>
                            <td><c:out value="${acc.getLastLogin()}" /></td>
                            <c:choose>
                                <c:when test='${(acc.getCovidStatus() == false)}'>
                                    <td><p>Safe</p></td>
                                </c:when>
                                <c:otherwise>
                                    <td><p>Compromised</p></td>
                                </c:otherwise>
                            </c:choose>
                            <td> <%-- Implement administrator abilities here (icons are from bootstrap/fontisawesome --%> 
                              <button type="button" class="btn btn-primary"><i class="far fa-eye"></i></button>
                              <button type="button" class="btn btn-success"><i class="fas fa-edit"></i></button>
                              <button type="button" class="btn btn-danger"><i class="far fa-trash-alt" ></i></button>
                            </td>
                        </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        <a href="do.adminLogout" class="previous">Log Out</a> <br><br><br><br><br>
        <a href="do.adminApprove" class="previous">Approve Locations</a>
        </section>
    </body>
</html>
