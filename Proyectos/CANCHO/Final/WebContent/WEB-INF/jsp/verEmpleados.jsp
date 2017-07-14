<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="dependencias.jsp" />

<title>CONSULTAR EMPLEADOS</title>

</head>
<body>

	<jsp:include page="cabecera.jsp"/>
  	<jsp:include page="menu.jsp"/>
	<h1>MANTENIMIENTO DE EMPLEADOS</h1>
<fieldset>
    <legend>Control</legend>
		<form method="post" action="verEmpleadosConsulta.htm">
			<table>
	      <tr>
	      
	        <td>
	          <label>Paterno:</label><br/>
	          <input type="text" name="paterno" />
	        </td>
	        
	        <td>
            <label>Materno:</label><br/>
            <input type="text" name="materno" />
          </td>
          
          <td>
            <label>Nombre:</label><br/>
            <input type="text" name="nombre" />
          </td>
          
          <td style="vertical-align: bottom;">
            <input class="btnDefault" type="submit" name="btnAccion" value="Buscar" />
            <input class="btnDefault" type="submit" name="btnAccion" value="Nuevo" />
          </td>
	      
	      </tr>
	    
	    </table>
		</form>
		
		</fieldset>
	
  <c:if test="${ not empty mensaje }">
    <div class="cssMsgInfo">${mensaje}</div>
  </c:if>
  
  <c:if test="${ not empty error }">
    <div class="cssMsgError">${error}</div>
  </c:if>
  
  <c:if test="${ not empty lista }">
  
  <fieldset>
    <legend>Resultado</legend>
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
	</fieldset>
</c:if>
</body>

</html>>