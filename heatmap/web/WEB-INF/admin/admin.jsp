<%-- 
    Document   : admin
    Created on : Nov 8, 2021, 12:44:53 AM
    Author     : Sandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name ="viewport" content="width=device-width, initial-scale=1.0"> <%-- to make the webpage responsive --%>        
        <link rel="stylesheet" href="./style.css"/>
        <%-- CDN to call bootstrap --%>        
        
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <div class="adminbg">
        <div class="tbl-header">
            <table cellpadding="0" cellspacing="0" border="0">
            <thead>
                <tr>
                    <th>UID</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Last Login</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            </table>
        </div>
        <div class="tbl-content">
            <table cellpadding="0" cellspacing="0" border="0">
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
                    <td> 
                        <form action="do.deleteUser" id="form1" class="formarea">
                            <input type="hidden" name="id" value="<c:out value="${acc.getUid()}" />">

                            <input type="submit" class="" value="Delete User">
                        </form>
                    </td>
                    <td> 
                        <form action="do.markPositive" id="form1" class="formarea">
                            <input type="hidden" name="id" value="<c:out value="${acc.getUid()}" />">

                            <input type="submit" class="" value="Mark as Positive">
                        </form>
                    </td>
                    <td> 
                        <form action="do.markNegative" id="form1" class="formarea">
                            <input type="hidden" name="id" value="<c:out value="${acc.getUid()}" />">

                            <input type="submit" class="" value="Mark as Negative">
                        </form>
                    </td>   
                </tr>
                </c:forEach>
            </tbody>   
            </table>
        </div>
        </div>
        <a href="do.adminLogout" class="previous">Log Out</a> <br><br><br><br><br>
        <a href="do.adminApprove" class="previous">Approve Locations</a> <br><br><br><br><br>
        <a href="do.adminReviews" class="previous">Manage Reviews</a> <br><br><br><br><br>
        <a href="do.checkCSV" class="previous">Check CSV</a>
    </body>
</html>
