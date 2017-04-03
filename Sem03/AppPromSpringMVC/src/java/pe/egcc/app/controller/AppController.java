package pe.egcc.app.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.egcc.app.model.PromedioModel;
import pe.egcc.app.service.PromedioService;

@Controller
public class AppController {
  
  @Autowired
  private PromedioService service;
  
  @RequestMapping(value = "/")
  public String home(){
    return "index";
  }
  
  @RequestMapping(value = "procesar.egcc", method = RequestMethod.POST)
  public String procesar(HttpServletRequest request, Model model){
    // Datos
    PromedioModel dto = new PromedioModel();
    dto.setNota1(Integer.parseInt(request.getParameter("nota1")));
    dto.setNota2(Integer.parseInt(request.getParameter("nota2")));
    // Proceso
    dto = service.procesarNotas(dto);
    // Reporte
    model.addAttribute("dto", dto);
    return "index";
  }
  
}
