<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>LISTA DE CIUDADES</title>
  </head>
  <body>
    <h1>LISTA DE CIUDADES</h1>

    <c:if test="${mensaje != null}">
      <div style="color:red;">
        ${mensaje}
      </div>
    </c:if>

    <c:if test="${sessionScope.lista != null}">
      <ol>
        <c:forEach items="${sessionScope.lista}" var="ciudad">
          <li>${ciudad}</li>
          <a href="#">Delete</a>
        </c:forEach>
      </ol>
    </c:if>


  </body>
</html>
