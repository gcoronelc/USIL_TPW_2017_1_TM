<!-- EGCC -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>EGCC - PRESTAMO</title>
  </head>

  <body>
    <h1>PRESTAMO SPRING</h1>
    <fieldset>
      <legend>DATOS</legend>
      <form method="post" action="prestamo.htm">
        <div>
          <label>Meses</label>
          <input type="text" name="meses"/>
        </div>
        <div>
          <label>Capital</label>
          <input type="text" name="capital"/>
        </div>
        <div>
          <label>Interes</label>
          <input type="text" name="interes"/>
        </div>
        <div>
          <input type="submit" value="Procesar"/>
        </div>
      </form>
    </fieldset>
    <c:if test="${lista != null}">
    <div>
      <h2>CRONOGRAMA DE PAGOS</h2>
      <table border="1">
        <tr>
          <th>MES</th>
          <th>CAPITAL<br/>INICIAL</th>
          <th>CAPITAL</th>
          <th>INTERES</th>
          <th>IMPORTE<br/>CUOTA</th>
        </tr>
        <c:forEach items="${lista}" var="r">
          <tr>
            <td>${r.mes}</td>
            <td>${r.capitalInicial}</td>
            <td>${r.capital}</td>
            <td>${r.interes}</td>
            <td>${r.total}</td>
          </tr>
        </c:forEach>
      </table>
    </div>
    </c:if>
  </body>
</html>
