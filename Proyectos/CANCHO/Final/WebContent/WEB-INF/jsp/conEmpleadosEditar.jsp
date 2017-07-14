<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="dependencias.jsp" />
<title>SISTEMA DE MATRICULAS</title>

</head>

<body>

  <jsp:include page="cabecera.jsp"/>
  <jsp:include page="menu.jsp"/>

  <h1>${accion} ALUMNO</h1>
  
  <form method="post" action="crudAlumnoGrabar.htm">
  <fieldset>
    <legend>Datos</legend>
    
    <input type="hidden" name="codigo" value="${empleado.codigo}"/>
    <input type="hidden" name="accion" value="${accion}"/>
    
  
    <div>
      <label class="formLabel">Código:</label>
      <span class="formImput">${empleado.codigo}</span>
    </div>
    
    <div>
      <label class="formLabel">Paterno:</label>
      <input  type="text"
              name="paterno" 
              class="formImput"
              ${ disabled }
              value="${alumno.paterno}" />
    </div>
    
    <div>
      <label class="formLabel">Materno:</label>
      <input  type="text"
              name="materno" 
              class="formImput"
              ${ disabled }
              value="${alumno.materno}" />
    </div>
  
    <div>
      <label class="formLabel">Nombre:</label>
      <input  type="text"
              name="nombre" 
              class="formImput"
              ${ disabled }
              value="${alumno.nombre}" />
    </div>
   
    
    <div>
      <label class="formLabel">Ciudad:</label>
      <input  type="text"
              name="ciudad" 
              class="formImput"
              ${ disabled }
              value="${alumno.ciudad}" />
    </div>
    
    <div>
      <label class="formLabel">Dirección:</label>
      <input  type="text"
              name="direccion" 
              class="formImput"
              ${ disabled }
              value="${alumno.direccion}" />
    </div>   

  </fieldset>
  
  <fieldset>
    <legend>Acción</legend>
    
    <input class="btnMain" type="submit" value="Procesar" />
    <button class="btnMain"><a href="crudAlumno.htm">Cancelar</a></button>
    
  </fieldset>
  
  </form>
  
  
  
  
</body>

</html>
