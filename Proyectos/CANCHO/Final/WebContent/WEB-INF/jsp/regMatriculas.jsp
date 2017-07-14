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
	<form method="post" action="regMatriculas.htm">

		<fieldset>
			<legend>Datos de Matricula</legend>
			    <input type="hidden" name="codigo" value="${alumno.codigo}"/>
   				<input type="hidden" name="accion" value="${accion}"/>

			<div>
				<label class="formLabel">Código De Matricula:</label>
				 <span class="formImput">${alumno.codigo}</span>
			</div>


			<div>
				<label class="formLabel">Cuenta:</label> <select name="sucursal">
					<option value="000">Seleccione ...</option>
				</select>
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
			<legend>Acciones</legend>

			<input class="btnMain" type="submit" value="Procesar" />
		</fieldset>

	</form>
</body>
</html>