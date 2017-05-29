package pe.egcc.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.egcc.eureka.service.CuentaService;

@Controller
public class AppController {
  
  @Autowired
  private CuentaService cuentaService;

  @RequestMapping(value = "index.htm", method = RequestMethod.GET)
  public String home(){
    return "index";
  }
  
  @RequestMapping(value = "generales.htm", method = RequestMethod.GET)
  public String generales(Model model){
    model.addAttribute("cantCuentas", cuentaService.getCantCuentas());
    return "generales";
  }

  
}
