<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CONSULTAS GENERALES</title>
    <link href="<c:url value="/css/estilos.css" />" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <h1>CONSULTAS GENERALES</h1>
    <jsp:include page="cabecera.jsp" />
    <div>Cantidad de cuentas: ${cantCuentas}</div>
    <div>Saldo en soles: ${saldoSoles}</div>
    <div>Saldo en dolares: ${saldoDolares}</div>
  </body>
</html>
