<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome to Spring Web MVC project</title>
    <link href="<c:url  value='/css/estilos.css' />" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <h1>DEMO DE AJAX</h1>
    <div>
      <a class="boton" href="javascript: fnCargaPagina('pagina1.htm');">Pagina 1</a>
      <a class="boton" href="javascript: fnCargaPagina('pagina2.htm');">Pagina 2</a>
    </div>
    <div id="panel"></div>
    <script src="<c:url  value='/jquery/jquery.min.js' />"></script>
    <script>
      
      function fnCargaPagina(pagina){
        $("#panel").load(pagina);
      }
      
    </script>
  </body>
</html>
