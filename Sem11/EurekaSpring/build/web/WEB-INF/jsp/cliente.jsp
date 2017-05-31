<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CONSULTAR CLIENTE</title>
    <link href="<c:url value="/css/estilos.css" />" 
          rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <h1>CONSULTAR CLIENTE</h1>
    <jsp:include page="menu.jsp"/>

    <div style="margin: 10px;">
      <form method="post" action="cliente.htm">
        <table>
          <tr>
            <td>
              <label>Código del cliente</label><br/>
              <input type="text" name="codigo" 
                     size="40" value="${codigo}"/>
            </td>
            <td>
              <input class="btnMain" type="submit" value="Consultar" />
            </td>
          </tr>
        </table>
      </form>
    </div>

    <c:if test="${not empty error }">
      <div class="cssMsgError">${error}</div>
    </c:if>
    <c:if test="${not empty bean }">
      <h2>DATOS DEL CLIENTE</h2>
      <table>
        <tr>
          <td width="100">CODIGO:</td>
          <td>${bean.codigo}</td>
        </tr>
        <tr>
          <td>PATERNO:</td>
          <td>${bean.paterno}</td>
        </tr>
        
      </table>
    </c:if>

  </body>
</html>
