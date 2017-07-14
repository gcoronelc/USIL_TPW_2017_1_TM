<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<jsp:include page="dependencias.jsp" />
<title>SISTEMA DE MATRICULAS</title>

</head>
<body>

	<jsp:include page="cabecera.jsp" />
	<jsp:include page="menu.jsp" />


	<h2>Cambio de clave</h2>



	<form method="post" action="CambioClave.htm">

		<fieldset>
			<legend>Ingrese sus Datos</legend>

			<div>
				<label class="formLabel">Contraseña Actual:</label> <input
					class="formInput" type="password" name="contra" />
			</div>

			<div>
				<label class="formLabel">Contraseña Nueva</label> <input
					class="formInput" type="password" name="nuevacontra" />
			</div>

		</fieldset>
		
		<c:if test="${ mensaje != null }">
			<div class="cssMsgInfo">${ mensaje }</div>
		</c:if>

		<c:if test="${ error != null }">
			<div class="cssMsgError">${ error }</div>
		</c:if>
		<fieldset>
			<legend>Acciones</legend>

			<input class="btnMain" type="submit" value="Procesar" />
		</fieldset>

	</form>



</body>
</html>