<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CONSULTAR CLIENTES X SUCURSAL</title>
    <jsp:include page="dependencias.jsp" />
  </head>
  <body>

    <h1>
      <i class="fa fa-id-card-o" aria-hidden="true"></i>
      CONSULTAR CLIENTES X SUCURSAL
    </h1>

    <jsp:include page="menu.jsp" />

    <div>
      <form method="post" action="resumenSucursal.htm">
        <table>
          <tr>
            <td>
              <label>Sucursal</label><br/>
              <input type="text" name="sucursal" />
            </td>
            <td>
              <label>Moneda</label><br/>
              <input type="text" name="moneda" />
            </td>
            
            <td>
              <button class="btnMain" type="submit">
                <i class="fa fa-search" aria-hidden="true"></i>
                Consultar
              </button>
            </td>
          </tr>
        </table>
      </form>
    </div>

    <div>
      <h2>REPORTE</h2>
      <table border="1">

        <thead>
          <tr>
            <th>CODIGO</th>
            <th>NOMBRE</th>
            <th>CANTIDAD</th>
            <th>IMPORTE</th>
          </tr>
        </thead>


        <tbody>

          <c:forEach items="${lista}" var="r">
            <tr>
              <td>${r.tipocodigo}</td>
              <td>${r.tiponombre}</td>
              <td>${r.cant}</td>
              <td>${r.importe}</td>
            </tr>
          </c:forEach>

        </tbody>

      </table>
    </div>

  </body>
</html>
