<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CRUD DE CLIENTES</title>
    <link href="<c:url value="/css/estilos.css" />" 
          rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <h1>EUREKA BANK</h1>
    <jsp:include page="menu.jsp" />
    
    <h2>${titulo}</h2>
    
    <c:if test="${not empty mensaje}">
      <div class="cssMsgInfo">${mensaje}</div>
    </c:if>
    
    <c:if test="${not empty error}">
      <div class="cssMsgError">${error}</div>
    </c:if>
    
    </div>
  </body>
</html>
