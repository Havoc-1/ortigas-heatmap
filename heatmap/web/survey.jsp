<%-- 
    Document   : survey
    Created on : Nov 8, 2021, 6:01:36 PM
    Author     : Nofuente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name ="viewport" content="width=device-width, initial-scale=1.0"> <%-- to make the webpage responsive --%>    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./style.css"/>
        <title>Survey of the Day</title>
    </head>
    <body>
        <section class="regarea2">
            <h1>Survey of the day</h1>
            <form action="do.updateSurvey" id="form1" class="formarea">
                <fieldset>
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
                            <label for ="sq4" class="ans">No</label> <br>
                            <input type="hidden" name="username" value=>
                        </div>
                    <br> <br> <br>
                    <input type="submit" class="fsubmitbtn" value="Submit">
                    <br> <br> <br>
                    </fieldset>
                </form>
            </section>
    </body>
</html>
