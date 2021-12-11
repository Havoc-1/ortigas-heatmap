/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

//center and instansiating map object
var mymap = L.map('map').setView([14.5838, 121.0597], 15); 

//to run the map
document.addEventListener("DOMContentLoaded", function runMaps() {
    L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 18,
    id: 'mapbox/streets-v11',
    tileSize: 512,
    zoomOffset: -1,
    accessToken: 'pk.eyJ1Ijoic3lndWljbyIsImEiOiJja3c0a3UzYXEweHU4MzJwZGszMXJnazRiIn0.ASuhvy3d0d4_oyvmQOfunw'
    }).addTo(mymap);
});

//heatmap logic
var heat = L.heatLayer(heatmap, {radius: 100}).addTo(mymap);

//appearance of popup
var popupOptions = {
    'maxWidth': '400',
    'minWidth': '350',
    'maxHeight': '400',
    'closeButton': 'true'
};

//create the popup object
var popup = L.popup();

//function to propogate the popupcontent
function populateContents() {
    
    for(var content of contents) {
        var revcollection = "";
        for (var review of content.reviews) {
            revcollection += `<p>Review: ${review.comment}</p>` ; //conver to a counter // include userID 
        }
        var popupContents = `<h1>${content.name}</h1><h3>Average Visits Per Hour</h3> <p>${content.hour}</p><h3>Average Visit Length</h3> <p>${content.length}</p><h3>Reviews</h3>${revcollection}`;
        console.log(content);
        L.marker([content.lat,content.long])
            .addTo(mymap)
            .bindPopup(popupContents, popupOptions);
    }
}
populateContents();