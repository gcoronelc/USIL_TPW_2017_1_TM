package pe.egcc.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.egcc.app.model.EGCCPrestamoModel;
import pe.egcc.app.service.EGCCPrestamoService;

// EGCC
@Controller
public class AppController {

  @Autowired
  private EGCCPrestamoService service;

  @RequestMapping(value = "/")
  public String home(Model model) {
    // Cargando la página inicial
    return "index";
  }

  @RequestMapping(value = "prestamo.htm", method = RequestMethod.POST)
  public String agregar(
          @RequestParam("meses") int meses,
          @RequestParam("capital") double capital,
          @RequestParam("interes") int interes,
          Model model
  ) {
    // Proceso
    List<EGCCPrestamoModel> lista = service.procPrestamo(capital, interes, meses);
    model.addAttribute("lista", lista);
    // Forward
    return "index";
  }

}
