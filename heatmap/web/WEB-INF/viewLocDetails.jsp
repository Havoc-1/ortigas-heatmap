<%-- 
    Document   : viewLocDetails
    Created on : Dec 10, 2021, 9:59:16 PM
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
                      <th scope="col">Name</th>
                      <th scope="col">Address</th>
                      <th scope="col">Average Number of People Per Hour</th>
                      <th scope="col">Average Length of Visits</th>
                      <th scope="col">Compromised? (Within a week)</th>
                      <th scope="col">View Reviews</th>
                      <th scope="col">Submit Reviews</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                        <td><c:out value="${loc.getName()}" /></td>
                        <td><c:out value="${loc.getAddress()}" /></td>
                        <td><c:out value="${avgVPH}" /></td>
                        <td><c:out value="${avgVL}" /></td>
                        <td><c:out value="${compromised}" /></td>
                        <td>
                            <form action="do.onReview" method="POST" id="form1" class="formarea ">
                                <input type="hidden" name="id" value="<c:out value="${loc.getUid()}" />">

                                <input type="submit" class="fsubmitbtn" value="View Reviews">
                            </form>
                        </td>
                        <td>
                            <form action="do.onSubmitReview" method="POST" id="form1" class="formarea ">
                                <input type="hidden" name="id" value="<c:out value="${loc.getUid()}" />">

                                <input type="submit" class="fsubmitbtn" value="Submit Reviews">
                            </form>
                        </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        <a href="do.maps" class="previous">Home</a> 
        <a href="do.viewLocations" class="previous">Previous</a> 
        </section>
    </body>
</html>