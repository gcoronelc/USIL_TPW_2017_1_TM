package pe.egcc.appsuma.controller;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.appsuma.service.MateService;

@WebServlet(name = "SumaController", urlPatterns = {"/SumaController"})
public class SumaController extends HttpServlet {

  @EJB
  private MateService service;
  
  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
  
    // Datos
    int n1 = Integer.parseInt(request.getParameter("num1"));
    int n2 = Integer.parseInt(request.getParameter("num2"));
    
    // Proceso
    int suma = service.sumar(n1, n2);
    
    // Reporte
    request.setAttribute("num1", n1);
    request.setAttribute("num2", n2);
    request.setAttribute("suma", suma);
    
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("repo.jsp");
    rd.forward(request, response);
    
  }
  
}
