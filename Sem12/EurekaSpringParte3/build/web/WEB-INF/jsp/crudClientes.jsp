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
    
    <h2>CRUD DE CLIENTES</h2>
    
    <fieldset>
      <legend>Panel de Control</legend>
      <form method="post" action="crudClientesConsultar.htm">
        <div>
          
          <div class="form-field">
            <label>Paterno:</label>
            <input type="text" name="paterno" />
          </div>

          <div class="form-field">
            <label>Materno:</label>
            <input type="text" name="materno" />
          </div>
          
          <div class="form-field">
            <label>Nombre:</label>
            <input type="text" name="nombre" />
          </div>
          
          <div class="form-field">
            <input style="margin:10px 5px 0 5px; padding: 5px;"
                   type="submit" 
                   name="btnBuscar" 
                   value="Buscar" />
            <input style="margin-top:10px 5px 0 5px; padding: 5px;"
                   type="submit" 
                   name="btnBuscar" 
                   value="Nuevo" />
          </div>
          
          
          
          
        </div>
      </form>
    </fieldset>
    
    <div >
      <h2>RESULTADO</h2>
      
      <p>Pronto veras el resultado</p>
      
    </div>
  </body>
</html>
