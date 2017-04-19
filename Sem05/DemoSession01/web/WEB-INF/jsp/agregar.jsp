<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    
    <h2>AGREGAR CIUDAD</h2>
    <form method="post" action="agregar.htm">
      Nombre de ciudad: 
      <input type="text" name="ciudad" />
      <input type="submit" value="Procesar" />
    </form>
    
    <c:if test="${mensaje != null}">
    <div style="margin: 10px; padding: 15px; 
         color: blue; background-color: #95a5a6;">
      ${mensaje}
    </div>
    </c:if>
    
    
  </body>
</html>
