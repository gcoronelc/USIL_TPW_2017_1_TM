<%-- 
    Document   : repor
    Created on : 17-mar-2017, 8:10:01
    Author     : darwin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <style type="text/css">
            *{
                box-sizing: border-box;
            }
            body{
                margin: 0;
                font-family: serif;
            }

            .tabla{
                background: aqua;
                font-family: initial;
                width: 95%;
                max-width: 300px;
                margin: auto;
                padding: 5px;
            }
            .textoF{
                padding: 5px 10px;
                width: 25%;
                font-size: 20px;
                color: blue;
                text-align: center;
                font-weight: bold;

            }
            .cajaT{
                padding-left: 5px;
                padding-right: 5px;
                width: 100px;
                max-width: 250px;
                font-size: 20px; 
                color: blue;
                font-weight: bold;
            }
            h1{
                margin: 0;
                margin-top: 5px;
                padding-top: 5px;
                padding-bottom: 5px;
                text-align: center;
                font-size: 18px;  
                background: blue;
                color: blanchedalmond;
                width: 95%;
                max-width: 300px;
            }

            .btn{
                
                margin-top: 20px;
                margin-bottom: 5px;
                padding:5px 15px;
                border: 0;
                text-decoration: none;
                font-size: 12px;
                font-family: sans-serif;
                background: red;
                color: aliceblue;
                font-weight: bold;
                cursor: pointer;
            }
           

        </style>
    </head>
    <body>
         
    <center>
     <table class="tabla">
                <h1>Promedio de 3 notas</h1>
                <tr>
                    <td><label class="textoF">NOTA 1:</label></td>
                    <td class="cajaT">${n1}</td>
                </tr>
                <tr>
                    <td><label class="textoF" >NOTA 2:</label></td>
                    <td class="cajaT">${n2}</td>
                </tr>
                <tr>
                    <td><label class="textoF">NOTA 3:</label></td>
                    <td class="cajaT">${n3}</td>
                </tr>
                <tr>
                    <td><label class="textoF">PROMEDIO :</label></td>
                    <td class="cajaT">${promedio}</td>
                </tr>
                <tr>
                    <td><label class="textoF">ESTADO:</label></td>
                    <td class="cajaT">${estado}</td>
                </tr>
                <tr>
                    <td></td>
                    <td><a href="index.html" class="btn">Retornar</a></td>
                </tr>
            </table>
          </center>
    </body>
</html>
