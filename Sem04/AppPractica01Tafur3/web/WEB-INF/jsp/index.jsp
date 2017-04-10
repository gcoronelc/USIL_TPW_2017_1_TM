<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>David - Fernando - Lenin</title>
  </head>

  <body>
    
    <h1>Pagos Empleados</h1>
    <form method="post" action="procesar.htm">
      <p>
        Horas Trabajadas:
        <input type="text" name="horasDia" />
      </p>
      <p>
        Dias Trabajadas:
        <input type="text" name="dias" />
      </p>
      <p>
        Pago por Hora:
        <input type="text" name="pagoHora" />
      </p>
      <p>
        <input type="submit" value="Procesar" />
      </p>
    </form>

    <h1>RESULTADO</h1>
    <p>Horas Trabajadas: ${dto.horasDia}</p>
    <p>Dias Trabajados: ${dto.dias}</p>
    <p>Pago por Hora: ${dto.pagoHora}</p>
    <p>Ingresos Totales: ${dto.ingresos}</p>
    <p>Impuesto a la Renta: ${dto.renta}</p>
    <p>Importe Neto: ${dto.neto}</p>

  </body>
</html>