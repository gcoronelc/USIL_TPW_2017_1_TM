<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<jsp:include page="dependencias.jsp" />
<title>EUREKA BANK</title>

</head>
<body>

	<jsp:include page="cabecera.jsp" />
	<jsp:include page="menu.jsp" />


	<h1>REGISTRAR RETIRO</h1>
	<form method="post" action="regRetiro.htm">

		<fieldset>
			<legend>Datos</legend>

			<div>
				<label class="formLabel">Cuenta:</label> <input class="formInput"
					type="text" name="cuenta" />
			</div>

			<div>
				<label class="formLabel">Importe:</label> <input class="formInput"
					type="text" name="importe" />
			</div>

			<div>
				<label class="formLabel">Clave:</label> <input class="formInput"
					type="password" name="clave" />
			</div>

			<c:if test="${ mensaje != null }">
				<div class="cssMsgInfo">${ mensaje }</div>
			</c:if>

			<c:if test="${ error != null }">
				<div class="cssMsgError">${ error }</div>
			</c:if>



		</fieldset>

		<fieldset>
			<legend>Datos</legend>

			<input class="btnMain" type="submit" value="Procesar" />
		</fieldset>

	</form>



</body>
</html>