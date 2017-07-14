<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<jsp:include page="dependencias.jsp" />
		<title>EUREKA BANK</title>
  </head>
  
  <body>
  
    <jsp:include page="cabecera.jsp"/>
    <jsp:include page="menu.jsp"/>
  
    <h1>
      <i class="fa fa-globe" aria-hidden="true"></i>
      CONSULTAS GENERALES
    </h1>
    
    
    <p>Cantidad de cuentas: ${cantCuentas}</p>
    <p>Saldo en Soles: ${saldoSoles}</p>
    <p>Saldo en Dolares: ${saldoDolares}</p>
    
  </body>
</html>
