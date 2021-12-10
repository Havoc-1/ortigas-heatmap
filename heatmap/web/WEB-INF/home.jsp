<%-- 
    Document   : home
    Created on : Oct 4, 2021, 4:05:37 PM
    Author     : Sandro
--%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name ="viewport" content="width=device-width, initial-scale=1.0"> <%-- to make the webpage responsive --%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Heatmap</title>
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css"
        integrity="sha512-xodZBNTC5n17Xt2atTPuE1HxjVMSvLVW9ocqUKLsCC5CXdbqCmblAshOMAS6/keqq/sMZMZ19scR4PsZChSR7A=="
        crossorigin=""/>
        <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"
        integrity="sha512-XQoYMqMTK8LvdxXYG3nZ448hOEQiglfqkJs1NOQV44cWnUrBc8PkAOcXy20w0vlaXaVUearIOBhiXZ5V3ynxwA=="
        crossorigin=""></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
        <link rel="stylesheet" href="./style.css"/>
        <script defer src="./card.js"></script>
        <script defer src="./leafmaps.js"></script>
    </head>
    <body>
        <%-- MAVBAR --%>
        <div class="navbar">
            <a href="do.maps"><img src="img/logo.png"></a> 
            <div class="dropdown">
             <button class="dropbtn">Dropdown <%-- this needs to fetch username --%>
            <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
                <a href="profile.jsp">Edit Profile</a>
                <a href="do.onCheckOut">Checkout</a>
                <a href="do.logout">Logout</a>
            </div>
            </div>
        </div>
        <%-- MAVBAR END --%>
        <%-- LEAFLETJS --%>
        <div id="map"></div>        
        <%-- LEAFLETJS END --%>
        <%-- MODALS --%>
        <button class="modal-open" data-modal="modal1">Check In / Check out</button> 
        <div class="modal" id="modal1">
            <div class="modal-content">
                <div class="modal-header">Modal 1
                    <button class="icon modal-close"><i class="material-icons">close</i></button>
                </div>
                <div class="modal-body"></div>Put in form here
                <div class="modal-footer"><button class="link modal-close">Close</button></div>
            </div>
        </div>
        <%-- MODALS END --%>
        
    </body>
</html>