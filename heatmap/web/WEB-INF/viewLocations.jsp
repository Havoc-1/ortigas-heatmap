<%-- 
    Document   : viewLocations
    Created on : Dec 10, 2021, 8:15:33 PM
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
                      <th scope="col">Name</th>
                      <th scope="col">Address</th>
                      <th scope="col">Average Number of People Per Hour</th>
                      <th scope="col">Average Length of Visits</th>
                      <th scope="col">Compromised? (Within a week)</th>
                      <th scope="col">Reviews</th>
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
                            <form action="do.viewReviews" method="POST" id="form1" class="formarea ">
                                <input type="hidden" name="id" value="<c:out value="${loc.getUid()}" />">

                                <input type="submit" class="fsubmitbtn" value="View Reviews">
                            </form>
                        </td>
                    </tr>
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
