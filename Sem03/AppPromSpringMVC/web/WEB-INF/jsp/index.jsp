<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome to Spring Web MVC project</title>
  </head>

  <body>
    <h1>PROMEDIO</h1>
    <form method="post" action="procesar.egcc">
      <p>
        Nota 1:
        <input type="text" name="nota1" />
      </p>
      <p>
        Nota 2:
        <input type="text" name="nota2" />
      </p>
      <p>
        <input type="submit" value="Procesar" />
      </p>
    </form>
    
    <c:if test="${dto != null}">
    <h1>RESULTADO</h1>
    <p>Nota 1: ${dto.nota1}</p>
    <p>Nota 2: ${dto.nota2}</p>
    <p>Promedio: ${dto.prom}</p>
    <p>Condición: ${dto.cond}</p>
    </c:if>
    
  </body>
</html>
