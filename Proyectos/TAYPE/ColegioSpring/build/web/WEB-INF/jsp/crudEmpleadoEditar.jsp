<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<c:url value="menu/menu.css" />" 
              rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/estilos.css" />" 
              rel="stylesheet" type="text/css"/>
        <link href="<c:url  value='/bootstrap/css/bootstrap.min.css' />"rel="stylesheet" type="text/css"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <div class="contenedor">
            <div class="cabecera">
                <jsp:include page="cabecera.jsp"/>
                <jsp:include page="menu.jsp"/>
            </div>
            <section class="section_formPrincipal"> 

                <h2>${ accion } EMPLEADO</h2>    


                <form method="post" action="crudEmpleadoGrabar.htm">

                    <input type="hidden" name="IDEMP" value="${bean.IDEMP}"/>
                    <input type="hidden" name="accion" value="${accion}"/>

                    <fieldset >

                        <div>
                            <label class="form-field">Código:</label>
                            <span class="form-field">${bean.IDEMP}</span>
                        </div>
                        <div style="clear: both;"></div>

                        <div>
                            <label class="form-field">Nombre:</label>
                            <input class="form-field" ${disabled} type="text" name="NOMBRE" value="${bean.NOMBRE}">
                        </div>
                        <div style="clear: both;"></div>
                        <div>
                            <label class="form-field">Apellidos:</label>
                            <input class="form-field" ${disabled} type="text" name="APELLIDO" value="${bean.APELLIDO}">
                        </div>
                        <div style="clear: both;"></div>
                        <div>
                            <label class="form-field">DNI:</label>
                            <input  class="form-field" ${disabled} type="text" name="dni" value="${bean.dni}">
                        </div>
                        <div style="clear: both;"></div>

                        <div>
                            <label class="form-field">Dirección:</label>
                            <input class="form-field" ${disabled} type="text" name="DIRECCION" value="${bean.DIRECCION}">
                        </div>
                        <div style="clear: both;"></div>

                        <div>
                            <label class="form-field">Teléfono:</label>
                            <input  class="form-field" ${disabled} type="text" name="TELEFONO" value="${bean.TELEFONO}">
                        </div>
                        <div style="clear: both;"></div>

                        <div>
                            <label class="form-field">Email:</label>
                            <input class="form-field" ${disabled} type="text" name="CORREO" value="${bean.CORREO}">
                        </div>
                        <div style="clear: both;"></div>
                        <div>
                            <label class="form-field">ESTADO:</label>
                            <input class="form-field" ${disabled} type="text" name="ESTADO" value="${bean.ESTADO}">
                        </div>
                        <div style="clear: both;"></div>
                    </fieldset>

                    <fieldset >
                        <legend>Acciones</legend>

                        <input class="btnMain" type="submit" value="Procesar" />

                    </fieldset>

                </form>    

            </section>
            <jsp:include page="footer.jsp" />

        </div>

    </body>
</html>
