$(document).ready(function(){
    $.ajax({
        url: "Servlet_mensajes",
        data:{
            accion : "iniciarServicio"
        },
        success: function(result){
            console.log(result);
            $(".articles").append(result);
        }
    });
    
});

var myVar = setInterval(publicar, 1000);

function publicar() {
  $.ajax({
        url: "Servlet_mensajes",
        data:{
            accion : "imprimirRecetas"
        },
        success: function(result){
            console.log(result);
            $(".articles").append(result);
        }
    });
}