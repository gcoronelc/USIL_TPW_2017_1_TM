<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CONSULTAR CLIENTES V1</title>
    <link href="<c:url value="/css/estilos.css" />" 
          rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <h1>CONSULTAR CLIENTES V1</h1>
    <jsp:include page="cabecera.jsp" />
    <div style="margin: 10px;">
      <form method="post" action="conClientesV1.htm">
        <table>
          <tr>
            <td>
              <label>Paterno, Materno o Nombre</label><br/>
              <input type="text" name="criterio" size="40"/>
            </td>
            <td>
              <input class="btnMain" type="submit" value="Consultar" />
            </td>
          </tr>
        </table>
      </form>
    </div>
    <div style="margin: 10px;">
      <h2>REPORTE</h2>
      <table border="1">
        <thead>
          <tr>
            <th>CODIGO</th>
            <th>PATERNO</th>
            <th>MATERNO</th>
            <th>NOMBRE</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${lista}" var="r">
          <tr>
            <td>${r.codigo}</td>
            <td>${r.paterno}</td>
            <td>${r.materno}</td>
            <td>${r.nombre}</td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </body>
</html>
