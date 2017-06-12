
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SESSION ERROR</title>
  </head>
  <body>
    <h1>SESSION ERROR</h1>
    <div>
      Su sesión a finalizado, debe volver a identificarse.
    </div>
    
    <a href="index.htm">Inicio de sesión</a>
    
    <script>
      
      setTimeout(function(){ 
        window.location = "index.htm";
      }, 3000);
      
      
    </script>
    
    
  </body>
</html>
