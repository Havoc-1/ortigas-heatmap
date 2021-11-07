/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


$(".next").click(function(){
    current_fs = $(this).parent();
    next_fs = $(this).parent().next();
    curLoad = $("#one").width();
    next_fs.hide(); // this fixes your css
    current_fs.hide("slide", { direction: "left" }, function() {
        next_fs.show("slide", { direction: "right" });
        $("#one").animate({
            width: "+=33.33%"
        });
        //alert("Width was added");
        //alert("next page"); //debug
    });
});

$(".prev").click(function(){
    current_fs = $(this).parent();
    //alert("prev page"); //debug
    previous_fs = $(this).parent().prev();
    curLoad = $("#one").width();
    current_fs.hide("slide", { direction: "right" }, function() {
        previous_fs.show("slide", { direction: "left" });
        $("#one").animate({
            width: "-=33.33%"
        });
        //alert("Width was removed");
    });
});

