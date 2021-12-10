<%-- 
    Document   : viewReviews
    Created on : Dec 11, 2021, 12:24:03 AM
    Author     : Nofuente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
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
                      <th scope="col">Number</th>
                      <th scope="col">Feedback</th>
                      <th scope="col">Comments</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="rev" items="${reviews}">
                        <tr>
                            <td><c:out value="${rev.getUid()}" /></td>
                            <c:choose>
                                <c:when test='${(rev.getStatus() == false)}'>
                                    <td><p>Recommended</p></td>
                                </c:when>
                                <c:otherwise>
                                    <td><p>Not Recommended</p></td>
                                </c:otherwise>
                            </c:choose>
                            <td><c:out value="${rev.getComment()}" /></td>
                            
                        </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        <a href="do.maps" class="previous">Home</a> <br><br><br><br><br>
        <a href="do.viewLocations" class="previous">Back</a>
        </section>
    </body>
</html>
