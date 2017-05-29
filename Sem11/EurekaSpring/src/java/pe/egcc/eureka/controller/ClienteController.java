package pe.egcc.eureka.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.egcc.eureka.service.ClienteService;

@Controller
public class ClienteController {
  
  @Autowired
  private ClienteService clienteService;
  
  @RequestMapping(value = "conClientesV1.htm", method = RequestMethod.GET)
  public String conClienteV1(){
    return "conClientes1";
  }
  
  @RequestMapping(value = "conClientesV1.htm", method = RequestMethod.POST)
  public String conClienteV1(
          @RequestParam("criterio") String criterio,
          Model model){
    // Proceso
    List<Map<String,Object>> lista;
    lista = clienteService.conClientes(criterio);
    // Reporte
    model.addAttribute("criterio", criterio);
    model.addAttribute("lista", lista);
    return "conClientes1";
  }
  
  
}
