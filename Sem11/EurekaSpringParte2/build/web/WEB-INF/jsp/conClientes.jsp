<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CONSULTAR CLIENTES</title>
    <jsp:include page="dependencias.jsp" />
  </head>
  <body>
    <h1>
      <i class="fa fa-users" aria-hidden="true"></i>
      CONSULTAR CLIENTES
    </h1>
    
    <jsp:include page="menu.jsp" />

    <div>
      <form method="post" action="conClientes.htm">
        <table>
          <tr>
            <td>
              <label>Paterno, Materno o Nombre</label><br/>
              <input type="text" name="criterio"
                     size="40"/>
            </td>
            <td>
              <button class="btnMain" type="submit">
                <i class="fa fa-search" aria-hidden="true"></i>
                Buscar
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
            <th>PATERNO</th>
            <th>MATERNO</th>
            <th>NOMBRE</th>
            <th>CIUDAD</th>
            <th>DIRECCION</th>
          </tr>
        </thead>
        
        
        <tbody>
          
          <c:forEach items="${lista}" var="r">
          <tr>
            <td>${r.codigo}</td>
            <td>${r.paterno}</td>
            <td>${r.materno}</td>
            <td>${r.nombre}</td>
            <td>${r.ciudad}</td>
            <td>${r.direccion}</td>
          </tr>
          </c:forEach>
          
        </tbody>

      </table>
    </div>

  </body>
</html>
