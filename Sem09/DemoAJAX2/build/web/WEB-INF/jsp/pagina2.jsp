<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h2>PROMEDIO DE NOTAS</h2>
    <div>
      <form>
        <div>
          <fieldset class="cajaControles">
            <legend>Practicas</legend>
            <div>
              <label>Practica 1: </label>
              <input type="text" name="pract1" />
            </div>
            <div>
              <label>Practica 2: </label>
              <input type="text" name="pract2" />
            </div>
            <div>
              <label>Practica 3: </label>
              <input type="text" name="pract3" />
            </div>
            <div>
              <label>Practica 4: </label>
              <input type="text" name="pract4" />
            </div>
          </fieldset>
          <fieldset class="cajaControles">
            <legend>Examenes</legend>
            <div>
              <label>Examen Parcial: </label>
              <input type="text" name="exaParcial" />
            </div>
            <div>
              <label>Examen Final: </label>
              <input type="text" name="exaFinal" />
            </div>
          </fieldset>
        </div>
        <div style="clear: both;">
          <input class="botonProcesar" type="button" value="Procesar" />
        </div>
      </form>
    </div>
  </body>
</html>
