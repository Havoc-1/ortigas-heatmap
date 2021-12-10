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
                <div class="regcontain">
                    <div class="row1">
                        <div class="input-group">
                            <label for="username" class="q">Username</label>
                            <input type="text" class="reg" name="username" required>  
                        </div>
                        <div class="input-group">
                            <label for="email" class="q">Email</label> <br>
                            <input type="text" class="reg2" name="email" required> 
                        </div>
                        <div class="input-group">
                            <label for="password" class="q">Password</label>  
                            <input type="password" class="regp" name="password" id="password" onkeyup='check();' required>
                        </div>
                        <div class="input-group">
                            <label for="passwordConfirm" class="q">Confirm Password</label>  
                            <input type="password" class="regp" name="passwordConfirm" onkeyup='check();' required>
                        </div>
                        <div class="input-group">
                            <label for="addr" class="q">Address</label> <br>
                            <input type="text" class="reg3" name="address" required>
                        </div> <div class="break"></div>
                        <div class="input-group">
                            <input type="checkbox" required="">
                            <label for="tos" class="ans">I agree to the <a href="tos.jsp" class="link1">Terms
                            and Service</a></label> 
                        </div>
                    </div> 
                </div> <div class="space"></div>
                    <a class="getout" href="index.jsp">Cancel</a>
                    <a class="next">Next</a>
            </fieldset>
            <fieldset>
                <div class="regcontain1">
                    <div class="space1"></div>
                    <label for="sec_ques_no" class="secq">Choose a security question:</label> <br> <br>
                    <div class="selectdiv">
                        <select name="sec_ques_no" id="sec_ques_no">
                            <option value="1">1. What was the name of your favorite pet?</option>
                            <option value="2">2. What was your favorite subject in high school?</option>
                            <option value="3">3. What is the name of a college you applied to but didn't?</option>
                            <option value="4">5. Where did you have your most memorable school field trip?</option>
                        </select> <br> <br>
                        <label for="sec_ques_ans" class="secq">Answer:</label> <br> <br>
                        <input type="password" class="secans" name="sec_ques_ans" required>
                    </div>
                </div>
                <div class="space"></div>
                <a class="getout" href="index.jsp">Cancel</a> 
                <a class="prev">Back</a>
                <a class="next">Next</a>    
            </fieldset>
            <fieldset>
                <div class="regcontain2">
                    <div class="survey">
                        <label for="username" class="q">Answer the questions truthfully.</label>
                        <!-- survey question 1 / sq1-->
                        <h3 class="survq">Have you or anyone in your household had any of the 
                        following symptoms in the past few days?<br> sore throat, cough, 
                        chills, body aches for unknown reasons, shortness of breath 
                        for unknown<br> reasons, loss of smell, loss of taste, high fever?</h3>
                        <!-- any radio button with same name will deselect other choice-->
                        <input type="radio" name="sq1" value='1' required>  
                        <label for ="sq1" class="ans">Yes</label> <br>
                        <input type="radio" name="sq1" value='0'>  
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
                        <input type="radio" name="sq2" value='1' required>  
                        <label for ="sq2" class="ans">Yes</label> <br>
                        <input type="radio" name="sq2" value='0'>  
                        <label for ="sq2" class="ans">No</label> <br>
                        <!-- survey question 3 / sq3-->
                        <h3 class="survq">Have you or anyone in your household 
                        traveled in or outside the Philippines in the 
                        past 14 days</h3>
                        <input type="radio" name="sq3" value='1' required>  
                        <label for ="sq3" class="ans">Yes</label> <br>
                        <input type="radio" name="sq3" value='0'>  
                        <label for ="sq3" class="ans">No</label> <br>
                        <!-- survey question 4 / sq4-->
                        <h3 class="survq">Were you admitted to the hospital in the
                        past 14 days?</h3>
                        <input type="radio" name="sq4" value='1' required>  
                        <label for ="sq4" class="ans">Yes</label> <br>
                        <input type="radio" name="sq4" value='0'>  
                        <label for ="sq4" class="ans">No</label> 
                    </div>
                </div>
            <div class="space"></div>
            <input type="submit" class="fsubmitbtn" value="Submit"> <br> <br> <br>
            <a class="getout" href="index.jsp">Cancel</a>
            <a class="prev">Back</a>
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
