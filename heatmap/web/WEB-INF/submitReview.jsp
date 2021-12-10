<%-- 
    Document   : submitReview
    Created on : Dec 11, 2021, 12:37:39 AM
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
        <form action="do.submitReview" method="POST" id="form1" class="formarea ">
            <input type="hidden" name="locID" value="<c:out value="${loc.getUid()}" />">
            <input type="hidden" name="uid" value="<c:out value="${id}" />">
            
            <h3 class="survq">Do you recommend visiting this place?
            Keep in mind the amount of people and implementation of health 
            protocols.
            </h3>
            <!-- any radio button with same name will deselect other choice-->
            <input type="radio" name="feedback" value='1' required>  
            <label for ="feedback" class="ans">I recommend</label> <br>
            <input type="radio" name="feedback" value='0'>  
            <label for ="feedback" class="ans">I do not recommend</label> <br>
            
            <label for="user">Feedback Comments: </label> <br />
            <textarea name="comments" cols="50" rows="10" required></textarea> <br /><br />
            
            <input type="submit" class="fsubmitbtn" value="Submit Review">
        </form>
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
                            <form action="do.viewReviews" method="POST" id="form1" class="formarea ">
                                <input type="hidden" name="id" value="<c:out value="${loc.getUid()}" />">

                                <input type="submit" class="fsubmitbtn" value="View Reviews">
                            </form>
                        </td>
                        <td>
                            <form action="do.onReview" method="POST" id="form1" class="formarea ">
                                <input type="hidden" name="id" value="<c:out value="${loc.getUid()}" />">

                                <input type="submit" class="fsubmitbtn" value="Submit Review">
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
