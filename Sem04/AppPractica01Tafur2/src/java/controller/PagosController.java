package controller;

import javax.servlet.http.HttpServletRequest;
import model.PagosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
  public String procesar(
          @RequestParam("horas") int horasDia,
          @RequestParam("dias") int dias,
          @RequestParam("pago_hora") int pagoHora,
          Model model) {
    
    // Datos
    PagosModel dto = new PagosModel(horasDia, dias, pagoHora);

    // Proceso
    dto = service.Procesos(dto);
    
    // Reporte
    model.addAttribute("dto", dto);
    return "index";
  }

}
