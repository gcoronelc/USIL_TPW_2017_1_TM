/*-----------------

 para crear todo esto hacer clic derecho dentro del paquete CONTROLLER y  crear un -Servlet 
-------------------------
 */
package controller;

import service.PromService;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//agregar un -name- y separar con una coma dentro del parentesis de esta forma ---- name = "promedioNotas",
@WebServlet(name = "promController", urlPatterns = {"/promController"})
public class PromController extends HttpServlet {
 /* borrar todo el contenido dentro de esta llave 
    escribir en mayuscula @EJB  ctrl+ espacio elejir la primera opcion y importar */
 @EJB
 /* la palabra promSERVICE es una clase del paquete SERVICE*/
private PromService service;
 
 
/*  ATAJO PARA QUE SALGA @Override -- poner en mayuscula SERVICE ctrl+ espacio elejir la primera opcion importar */
  
//luego tinenes que completar los dos datos,   req--request   y   resp--response 
    @Override
  protected void service(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException { //dentro de estas llaves comensamos a trabajar
        
        int n1 = Integer.parseInt(request.getParameter("n1"));
        int n2 = Integer.parseInt(request.getParameter("n2"));
        int n3 = Integer.parseInt(request.getParameter("n3"));
        
        int promedio = service.prom(n1, n2, n3);
        String estado = service.condicion(promedio);

        request.setAttribute("n1", n1);
        request.setAttribute("n2", n2);
        request.setAttribute("n3", n3);
        request.setAttribute("promedio", promedio);
        request.setAttribute("estado", estado);
        
        // Forward
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("repor.jsp"); /* para procesar y visualizar el JSP*/
        rd.forward(request, response);
    }
 
}
