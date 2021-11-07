<%-- 
    Document   : add
    Created on : Oct 4, 2021, 3:55:40 PM
    Author     : Sandro
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name ="viewport" content="width=device-width, initial-scale=1.0"> <%-- to make the webpage responsive --%>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./style.css"/>
        <title>Signup Page</title>
    </head>
    <body>
        <!-- top bar -->
        <div class="bar-bg">
            <div class="rect-1">
                <p class ="step-1">Step 1</p>
                <h3 class ="acd">Account Details</h3>
            </div>
            <div class="rect-2">
                <p class="step-2">Step 2</p>
                <h3 class="secu">Security Questions</h3>
            </div>
            <div class="rect-3">
                <p class="step-3">Step 3</p>
                <h3 class="surv">Survey</h3>
            </div>
        </div>
    <!-- form area -->
    <section class="regarea">
        <div id="one"></div>
        <form action="do.register" id="form1" class="formarea">
            <fieldset>
                <label for="username" class="q">Username</label> <br> <br>
                <input type="text" class="reg" name="username" required> <br> 
                
                <label for="password" class="q">Password</label>  <br> <br>
                <input type="password" class="regp" name="password" id="password" onkeyup='check();' required> <br>
                
                <label for="passwordConfirm" class="q">Confirm Password</label>  <br> <br>
                <input type="password" class="regp" name="passwordConfirm" onkeyup='check();' required> <br>
                
                <label for="email" class="q">Email</label> <br> <br>
                <input type="text" class="reg2" name="email" required> <br>
                
                <label for="addr" class="q">Address</label> <br> <br>
                <input type="text" class="reg" name="address" required> <br> <br> 
                
                <input type="checkbox" required="">
                <label for="tos" class="ans">I agree to the <a href="tos.jsp">Terms
                        and Service</a></label> <br> <br>
                <a class="next">next</a>
            </fieldset>
            <fieldset>
               <label for="sec_ques_no" class="q">Choose a security question:</label> <br>
                <div class="select">
                    <select name="sec_ques_no" id="sec_ques_no">
                        <option value="1">Question 1</option>
                        <option value="2">Question 2</option>
                        <option value="3">Question 3</option>
                        <option value="4">Question 4</option>
                    </select> <br>
                    <label for="sec_ques_ans" class="q">Answer:</label><br>
                    <input type="password" class="regp" name="sec_ques_ans" required><br><br>
                </div>
                <br /><br /><br />
                <a class="prev">prev</a>
                <a class="next">next</a>    
            </fieldset>
            <fieldset>
                <div class="survey">
                    <label for="username" class="q">Answer the questions truthfully.</label>
                    <!-- survey question 1 / sq1-->
                    <h3 class="survq">Have you or anyone in your household had any of the 
                    following symptoms in the past few days?<br> sore throat, cough, 
                    chills, body aches for unknown reasons, shortness of breath 
                    for unknown<br> reasons, loss of smell, loss of taste, high fever?</h3>
                    <!-- any radio button with same name will deselect other choice-->
                    <input type="radio" name="sq1" value='Yes' required>  
                    <label for ="sq1" class="ans">Yes</label> <br>
                    <input type="radio" name="sq1" value='No'>  
                    <label for ="sq1" class="ans">No</label> <br>
                    <h3 class="survq">If yes, kindly check the symptoms:</h3>
                    <input type="checkbox" name='symptoms' value='Sore throat'>
                    <label for="st" class="ans">Sore throat</label> <br>
                    <input type="checkbox" name='symptoms' value='Cough'>
                    <label for="ch" class="ans">Cough</label> <br>
                    <input type="checkbox" name='symptoms' value='Chills'>
                    <label for="cs" class="ans">Chills</label> <br>
                    <input type="checkbox" name='symptoms' value='Body Aches'>
                    <label for="bs" class="ans">Body aches</label> <br>
                    <input type="checkbox" name='symptoms' value='Loss of breath'>
                    <label for="ls" class="ans">loss of breath for unknown reasons</label>
                    <!-- survey question 2 / sq2-->
                    <h3 class="survq">Have you or anyone in your household been 
                    tested for COVID-19?</h3>
                    <input type="radio" name="sq2" value='Yes' required>  
                    <label for ="sq2" class="ans">Yes</label> <br>
                    <input type="radio" name="sq2" value='No'>  
                    <label for ="sq2" class="ans">No</label> <br>
                    <!-- survey question 3 / sq3-->
                    <h3 class="survq">Have you or anyone in your household 
                    traveled in or outside the Philippines in the 
                    past 14 days</h3>
                    <input type="radio" name="sq3" value='Yes' required>  
                    <label for ="sq3" class="ans">Yes</label> <br>
                    <input type="radio" name="sq3" value='No'>  
                    <label for ="sq3" class="ans">No</label> <br>
                    <!-- survey question 4 / sq4-->
                    <h3 class="survq">Were you admitted to the hospital in the
                    past 14 days?</h3>
                    <input type="radio" name="sq4" value='Yes' required>  
                    <label for ="sq4" class="ans">Yes</label> <br>
                    <input type="radio" name="sq4" value='No'>  
                    <label for ="sq4" class="ans">No</label> <br>
                </div>
            <br> <br> <br>
            <input type="submit" class="fsubmitbtn" value="Submit">
            <br> <br> <br>
            <a class="prev">prev</a>
            </fieldset>
        </form>
    </section>
    
    <!-- CDNs -->
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30=" crossorigin="anonymous"></script>
    <script src='./hideForm.js'></script>
    <script src='./onKeyUp.js'></script>
    
    </body>
</html>
