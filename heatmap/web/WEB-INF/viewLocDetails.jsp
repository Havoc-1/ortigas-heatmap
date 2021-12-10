<%-- 
    Document   : viewLocDetails
    Created on : Dec 10, 2021, 9:59:16 PM
    Author     : Nofuente
--%>

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
                      <th scope="col">Details</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="loc" items="${locList}">
                        <tr>
                            <td><c:out value="${loc.getName()}" /></td>
                            <td><c:out value="${loc.getAddress()}" /></td>
                            <td>
                                <form action="do.viewLocDetails" method="POST" id="form1" class="formarea ">
                                    <input type="hidden" name="id" value="<c:out value="${loc.getUid()}" />">
                                    <input type="hidden" name="address" value="<c:out value="${loc.getAddress()}" />">
                                    <input type="hidden" name="name" value="<c:out value="${loc.getName()}" />">
                                    <input type="hidden" name="lat" value="<c:out value="${loc.getLat()}" />">
                                    <input type="hidden" name="long" value="<c:out value="${loc.getLong()}" />">
                                
                                    <input type="submit" class="fsubmitbtn" value="Details">
                                </form>
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
