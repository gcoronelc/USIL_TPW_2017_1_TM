/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.henry.apppromedio.controller;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.henry.apppromedio.service.PromService;

@WebServlet(name = "AppController", urlPatterns = {"/AppController"})
public class AppController extends HttpServlet {

    @EJB
    private PromService service;

    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        //Datos
        int n1 = Integer.parseInt(request.getParameter("n1"));
        int n2 = Integer.parseInt(request.getParameter("n2"));
        int n3 = Integer.parseInt(request.getParameter("n3"));
        int n4 = Integer.parseInt(request.getParameter("n4"));
        int n5 = Integer.parseInt(request.getParameter("n5"));

        //Proceso
        int promedio = service.promediar(n1, n2, n3, n4, n5);
        int menor = service.menor(n1, n2, n3, n4, n5);

        //Reporte
        request.setAttribute("n1", n1);
        request.setAttribute("n2", n2);
        request.setAttribute("n3", n3);
        request.setAttribute("n4", n4);
        request.setAttribute("n5", n5);

        request.setAttribute("Promedio", promedio);
        request.setAttribute("Menor", menor);

        //Forward
        RequestDispatcher rd = request.getRequestDispatcher("respuesta.jsp");
        rd.forward(request, response);
    }
}
