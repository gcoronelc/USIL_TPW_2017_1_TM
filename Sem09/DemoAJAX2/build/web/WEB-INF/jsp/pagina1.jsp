<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h2>SUMA DE DOS NUMEROS</h2>
    <form id="form1">
      <div>
        <label>Número 1: </label>
        <input type="text" name="num1"/>
      </div>
      <div>
        <label>Número 2: </label>
        <input type="text" name="num2"/>
      </div>
      <div>
        <input class="boton" id="btnProcesar" type="button" value="Procesar"/>
      </div>
    </form>
    <div id="divResultado" style="display: none;">
      <h2>RESULTADO</h2>
      <p>Número 1: <span id="n1"></span></p>
      <p>Número 2: <span id="n2"></span></p>
      <p>Suma: <span id="su"></span></p>
    </div>
    <script>
      $("#btnProcesar").click(fnProcesar);
      
      function fnProcesar(){
        // Data
        var data = $("#form1").serialize();
        // Procesar
        $.post("sumar.htm",data,function(rpta){
          var obj = $.parseJSON(rpta);
          $("#n1").text(obj.n1);
          $("#n2").text(obj.n2);
          $("#su").text(obj.su);
          $("#divResultado").show(900);
        });
        
        $("input").keyup(function(){
          $("#divResultado").hide();
        });
      }
    </script>
  </body>
</html>
