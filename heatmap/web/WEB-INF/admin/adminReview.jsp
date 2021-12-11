<%-- 
    Document   : adminReview
    Created on : Dec 11, 2021, 6:20:17 PM
    Author     : Nofuente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Review</title>
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
                      <th scope="col">Location</th>
                      <th scope="col">User</th>
                      <th scope="col">Feedback</th>
                      <th scope="col">Comments</th>
                      <th scope="col">Delete</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="rev" items="${reviews}">
                        <tr>
                            <td><c:out value="${rev.getUid()}" /></td>
                            <td><c:out value="${rev.getLocName()}" /></td>
                            <td><c:out value="${rev.getUserName()}" /></td>
                            <c:choose>
                                <c:when test='${(rev.getStatus() == false)}'>
                                    <td><p>Recommended</p></td>
                                </c:when>
                                <c:otherwise>
                                    <td><p>Not Recommended</p></td>
                                </c:otherwise>
                            </c:choose>
                            <td><c:out value="${rev.getComment()}" /></td>
                            <td> 
                                <form action="do.adminDeleteReview" id="form1" class="formarea">
                                    <input type="hidden" name="id" value="<c:out value="${rev.getUid()}" />">

                                    <input type="submit" class="adminbtn" value="Delete Review">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        <a href="do.admin" class="previous">Home</a> <br><br><br><br><br>
        </section>
    </body>
</html>
