<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INICIO</title>
        <style>
            label{
                width: 100px;
                display: inline-block;
            }
            .row{
                margin: 10px;
                padding: 10px;
            }
        </style>
    </head>
    <body>
        <div style="width: 350px; margin: 10px auto;">
            <h1>INICIO DE SESION</h1>
            <form method="post" action="logon.htm">

                <div class="row">
                    <label>Usuario</label>
                    <input type="text" name="usuario" />
                </div>

                <div class="row">
                    <label>Clave</label>
                    <input type="password" name="clave" />
                </div>

                <div class="row">
                    <input type="submit" value="Ingresar al Sistema" />
                </div>

            </form>
            
            <div>
                ${error}
            </div>
        </div>
    </body>
</html>
