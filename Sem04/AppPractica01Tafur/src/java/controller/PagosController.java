package controller;

import javax.servlet.http.HttpServletRequest;
import model.PagosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.PagosService;

@Controller
public class PagosController {

  @Autowired
  private PagosService service;

  @RequestMapping(value = "/")
  public String home() {
    return "index";
  }

  @RequestMapping(value = "procesar.htm", method = RequestMethod.POST)
  public String procesar(HttpServletRequest request, Model model) {
    
    // Datos
    PagosModel dto = new PagosModel();
    dto.setHorasDia(Integer.parseInt(request.getParameter("horas")));
    dto.setDias(Integer.parseInt(request.getParameter("dias")));
    dto.setPagoHora(Integer.parseInt(request.getParameter("pago_hora")));

    // Proceso
    dto = service.Procesos(dto);
    
    // Reporte
    model.addAttribute("dto", dto);
    return "index";
  }

}
