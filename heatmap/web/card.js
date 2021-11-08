/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

//getting modal open buttons
var modalBtns = document.querySelectorAll('.modal-open');

modalBtns.forEach(function(btn) {
    btn.onclick = function() {
        var modal = btn.getAttribute("data-modal");
        document.getElementById(modal).style.display = "block";
    };  
});

var closeBtns = document.querySelectorAll('.modal-close');

closeBtns.forEach(function(btn){
    btn.onclick = function() {
        var modal = btn.closest(".modal").style.display = "none";
    };
});

window.onclick = function(e) {
    if(e.target.className === "modal") {
        e.target.style.display = "none";
    }
};

