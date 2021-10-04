<%-- 
    Document   : add
    Created on : Oct 4, 2021, 3:55:40 PM
    Author     : Sandro
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name ="viewport" content="with=device-width, initial-scale=1.0"> <%-- to make the webpage responsive --%>        
        <link rel="stylesheet" href="./style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Signup Page</title>
    </head>
        
<body class ="bg">
  <div class="bar-bg">
    <div class="rectangle-1">
      <p class="step-1">Step 1</p>
      <h3 class="personal-information">Personal Information</h3>
    </div>
    <div class="rectangle-2">
      <p class="step-2">Step 2</p>
      <h3 class="account-details">Account Details</h3>
    </div>
    <div class="rectangle-3">
      <p class="step-3">Step 3</p>
      <h3 class="survey ">Survey</h3>
    </div>
  </div>

  <div class="highlight">
      <form action="do.register" method="POST"> 
      <div class="highlight">
        <h2 class="steps">Step 1</h2>
        <h3 class="inputs">
          What is your email address
        </h3>
        <input type="text" name="email" class="rectangle"><br><br>
        <h3 class="what-is-your-address">
          What is your address
        </h3>
        <input type="text" id="address" name="Address" class="rectangle "required><br><br>

        <hr class="solid">
        <h2 class="steps">Step 2</h2>
        <h3 class="inputs">
          Username
        </h3>
        <input type="text" name="user" class="rectangle "required><br><br>
        <h3 class="inputs">
          Password
        </h3>
        <input type="password" name="pass" class="rectangle " required><br><br>
        <label for="myFile" class="custom-file-upload">
          Upload Government Id
        </label>
        
        <input type="checkbox" id="TOS" name="terms" required>
        <label for="TOS" class="inputs">Terms of services</label>
        <hr class="solid">
        <h2 class="steps">Step 3</h2>
        <h2 class="inputs">Covid Questions </h2> <br>
        <div class="survey-1">
          <p> <strong>Kindly answer the questions truthfully </strong> </p>
          <p> <strong>Have you or anyone in your household had any of the following symptoms in the past few days? sore
              throat, cough, chills, body aches for unknown reasons, shortness of breath for unknown reasons, loss of
              smell, loss of taste, high fever</strong> </p>
          <input type="checkbox" id="Q1" name="Q1 Answer:" name="yes" value="Yes">
          <label for="Answer:"> yes </label> <br>
          <label for="Yes, Sypmtoms"> if yes, kindly check the symptoms: </label>
          <br>
          <input type="checkbox" id="If Yes kindly specify" name="symptoms" value="sore throat">
          <label for="sore throat"> sore throat </label> <br>
          <input type="checkbox" id="If Yes kindly specify" name="symptoms" value="coughs">
          <label for="coughs"> coughs </label> <br>
          <input type="checkbox" id="If Yes kindly specify" name="symptoms" value="chills">
          <label for="chills"> chills </label> <br>
          <input type="checkbox" id="If Yes kindly specify" name="symptoms" value="body aches">
          <label for="body aches"> body aches </label> <br>
          <input type="checkbox" id="If Yes kindly specify" name="symptoms"
            value="shortness of breath for unknown reasons">
          <label for="loss of breath for unknown reasons"> loss of breath for unknown reasons </label> <br>
          <input type="checkbox" id="If Yes kindly specify" name="symptoms" value="loss of smell"> <label
            for="loss of smell"> loss of smell </label> <br>

          <input type="checkbox" id="If Yes kindly specify" name="symptoms" value="loss of taste">
          <label for="sore throat"> sore throat </label> <br>

          <input type="checkbox" id="If Yes kindly specify" name="symptoms" value="high fever">
          <label for="high fever"> high fever </label>
          <br>
          <br>
          <input type="checkbox" id="Q1" name="No" value="No">
          <label for="Q1 Answer:"> No </label><br>
          <p> <strong>Q2: Have you or anyone in your household been tested for COVID-19?</strong></p>
          <input type="checkbox" id="" name="Q2 Answer:" value="Yes">
          <label for="Q2"> Yes</label><br>
          <input type="checkbox" id="Q2 Answer" name="Q2 Answer:" value="No">
          <label for="Q2"> No </label><br>
          <p> <strong>Q3: Have you or anyone in your household traveled in or outside the Philippines in the past 14
              days?</strong></p>
          <input type="checkbox" id="Q3 Answer:" name="Q3 Answer:" value="Yes">
          <label for="Q3"> Yes</label><br>
          <input type="checkbox" id="Q3 Answer" name="Q3 Answer:" value="No">
          <label for="Q3"> No </label><br>
          <p> <strong>Q4: Were you admitted to the hospital in the past 14 days? </strong></p>
          <input type="checkbox" id="Q4 Answer:" name="Q4 Answer:" value="Yes">
          <label for="Q4"> Yes</label><br>
          <input type="checkbox" id="Q4 Answer" name="Q4 Answer:" value="No">
          <label for="Q4"> No </label><br>
        </div>
        <input type="submit" value="Submit" class="arrow-rectangle">
   
  </div>
      </form>
  </div>
</html>
