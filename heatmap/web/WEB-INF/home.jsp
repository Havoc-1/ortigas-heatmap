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
        <script src="leaflet-heat.js"></script>
    </head>
    <body>
        <%-- MAVBAR --%>
        <div class="navbar">
            <a href="do.maps"><img src="img/logo.png"></a> 
            <div class="dropdown">
             <button class="dropbtn">Options <%-- this needs to fetch username --%>
            <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
                <a href="do.onProfile">Profile Settings</a>
                <a href="do.onActivities">User Activities</a>
                <a href="do.onCheckOut">Checkout</a>
                <a href="do.viewLocations">View Locations</a>
                <a href="do.logout">Logout</a>
            </div>
            </div>
        </div>
        <%-- MAVBAR END --%>
        <script defer>
        var contents = [
            <c:forEach var="cont" items = "${contList}">
                {
                    "uid": <c:out value="${cont.getUid()}" />,
                    "name": '<c:out value="${cont.getName()}" />',         
                    "long": <c:out value="${cont.getLong()}" />,
                    "lat":<c:out value="${cont.getLat()}" />,
                    "rating": <c:out value="${cont.getRating()}" />,
                },
            </c:forEach>
        ];
        
        var reviews = new Map([
            <c:forEach var="revs" items="${reviews}">
                [<c:out value="${revs.key}" />,
                [
                <c:forEach var="rev" items="${revs.value}">
                    {
                        "userId":<c:out value="${rev.getUserID()}" />,
                        "comment":"<c:out value="${rev.getComment()}" />",
                        "status":"<c:out value="${rev.getStatus()}" />"
                    },
                </c:forEach>
                ]
                ],
        </c:forEach>])
        var hours = new Map([
            <c:forEach var="hr" items = "${avghr}">
                [<c:out value="${hr.key}"/>,<c:out value="${hr.value}"/>],
            </c:forEach>])
        var lengths = new Map([
            <c:forEach var="length" items = "${lengthr}">
                [<c:out value="${length.key}"/>,<c:out value="${length.value}"/>],
            </c:forEach>])
        
        var heatmap = [
            <c:forEach var="input" items = "${heatmap}">
            [<c:out value="${input}"/>],
            </c:forEach>
        ]
        
        for (var content of contents) {
            content.reviews = reviews.get(content.uid)
            content.hour = hours.get(content.uid)
            content.length = lengths.get(content.uid)
        }
        </script>
        <%-- LEAFLETJS --%>
        <div id="map"></div>                
        <%-- LEAFLETJS END --%>
        
        <%-- EMERGENCY NUMBERS --%>
        <div class="emergency">
            <p>DOH LAUNCHES COVID-19 HOTLINES 1555, 02-894-COVID</p>
        </div>
    </body>
</html>