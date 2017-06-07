<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
    .menuItem{
        display: inline-block;
        float: left;
        background-color: cadetblue;
        color: white;
        margin: 5px;
        padding: 5px 15px;
        vertical-align: middle;
        text-decoration: none;
    }
</style>
<div>
    Usuario: ${usuario.nombre}  ${usuario.apellido}
</div>
<div>
    <a class="menuItem" href="empleado.htm">Empleados</a>
    <a class="menuItem" href="producto.htm">Productos</a>
    <a class="menuItem" href="#">Ventas</a>
</div>
<div style="clear: both;"></div>