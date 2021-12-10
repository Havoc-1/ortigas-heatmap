<%-- 
    Document   : userActivities
    Created on : Dec 11, 2021, 3:39:20 AM
    Author     : Nofuente
--%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <section class="admintab">
             <div class="container">
            <div class="row">
              <div class="col-12">
                <table class="table table-bordered">
                  <thead>
                    <tr>
                      <th scope="col">ID</th>
                      <th scope="col">Location</th>
                      <th scope="col">Check in Date</th>
                      <th scope="col">Check out Date</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="his" items="${hisList}">
                        <tr>
                            <td><c:out value="${his.getUid()}" /></td>
                            <td><c:out value="${his.getLoc()}" /></td>
                            <td><c:out value="${his.getCheckInDate()}" /></td>
                            <td><c:out value="${his.getCheckOutDate()}" /></td>
                        </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        <a href="do.maps" class="previous">Home</a> 
        </section>
    </body>
</html>
