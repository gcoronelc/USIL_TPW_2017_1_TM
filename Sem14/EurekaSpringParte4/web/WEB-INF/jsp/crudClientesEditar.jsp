<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CRUD DE CLIENTES</title>
    <link href="<c:url value="/css/estilos.css" />" 
          rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <h1>EUREKA BANK</h1>
    <jsp:include page="menu.jsp" />

    <h2>${ accion } CLIENTE</h2>    


    <form method="post" action="crudClienteGrabar.htm">
      
      <input type="hidden" name="codigo" value="${bean.codigo}"/>
      <input type="hidden" name="accion" value="${accion}"/>
      
      <fieldset >
        <legend>Datos</legend>

        <div>
          <label class="form-field">Código:</label>
          <span class="form-field">${bean.codigo}</span>
        </div>
        <div style="clear: both;"></div>


        <div>
          <label class="form-field">Paterno:</label>
          <input class="form-field" ${disabled} type="text" name="paterno" value="${bean.paterno}">
        </div>
        <div style="clear: both;"></div>

        <div>
          <label class="form-field">Materno:</label>
          <input class="form-field" ${disabled} type="text" name="materno" value="${bean.materno}">
        </div>
        <div style="clear: both;"></div>

        <div>
          <label class="form-field">Nombre:</label>
          <input class="form-field" ${disabled} type="text" name="nombre" value="${bean.nombre}">
        </div>
        <div style="clear: both;"></div>

        <div>
          <label class="form-field">DNI:</label>
          <input  class="form-field" ${disabled} type="text" name="dni" value="${bean.dni}">
        </div>
        <div style="clear: both;"></div>

        <div>
          <label class="form-field">Ciudad:</label>
          <input class="form-field" ${disabled} type="text" name="ciudad" value="${bean.ciudad}">
        </div>
        <div style="clear: both;"></div>

        <div>
          <label class="form-field">Dirección:</label>
          <input class="form-field" ${disabled} type="text" name="direccion" value="${bean.direccion}">
        </div>
        <div style="clear: both;"></div>

        <div>
          <label class="form-field">Teléfono:</label>
          <input  class="form-field" ${disabled} type="text" name="telefono" value="${bean.telefono}">
        </div>
        <div style="clear: both;"></div>

        <div>
          <label class="form-field">Email:</label>
          <input class="form-field" ${disabled} type="text" name="email" value="${bean.email}">
        </div>
        <div style="clear: both;"></div>

      </fieldset>

      <fieldset >
        <legend>Acciones</legend>
        
        <input class="btnMain" type="submit" value="Procesar" />
        
      </fieldset>

    </form>    



  </body>
</html>
