package apppromedio.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import appromedio.service.MateService;

@WebServlet(name = "PromedioController", urlPatterns = {"/panchito"})
public class PromedioController extends HttpServlet {

   private MateService service;

   @Override
   public void init() throws ServletException {
      service = new MateService();
   }

   @Override
   protected void service(HttpServletRequest request,
           HttpServletResponse response) throws ServletException, IOException {

      // Datos
      int n1 = Integer.parseInt(request.getParameter("n1"));
      int n2 = Integer.parseInt(request.getParameter("n2"));
      int n3 = Integer.parseInt(request.getParameter("n3"));
      int n4 = Integer.parseInt(request.getParameter("n4"));
      int n5 = Integer.parseInt(request.getParameter("n5"));

      // Proceso
      int promedio = service.calcPromedio(n1, n2, n3, n4, n5);
      int menor = service.calcMenor(n1, n2, n3, n4, n5);

      // Reporte
      request.setAttribute("n1", n1);
      request.setAttribute("n2", n2);
      request.setAttribute("n3", n3);
      request.setAttribute("n4", n4);
      request.setAttribute("n5", n5);

      request.setAttribute("menor", menor);
      request.setAttribute("promedio", promedio);

      // Forward
      RequestDispatcher rd;
      rd = request.getRequestDispatcher("repo.jsp");
      rd.forward(request, response);

   }

}
