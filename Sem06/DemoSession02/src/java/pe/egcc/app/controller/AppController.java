package pe.egcc.app.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("lista")
public class AppController {
  
  @RequestMapping(value = "/")
  public String home(Model model){
    // Inicializando lista
    List<String> lista = new ArrayList<>();
    lista.add("CHICLAYO");
    lista.add("PACHERRES");
    lista.add("TRUJILLO");
    model.addAttribute("lista", lista);
    // Cargando la página inicial
    return "index";
  }
  
  @RequestMapping(value = "agregar.htm", method = RequestMethod.GET)
  public String agregar(){
    return "agregar";
  }
  
  @RequestMapping(value = "agregar.htm", method = RequestMethod.POST)
  public String agregar(
          @RequestParam("ciudad") String ciudad,
          @ModelAttribute("lista") List<String> lista,
          Model model
    ){
    // Proceso
    lista.add(ciudad);
    model.addAttribute("mensaje", "Ciudad " + ciudad + " agrgada.");
    // Forward
    return "agregar";
  }
  
  @RequestMapping(value = "listar.usil", method = RequestMethod.GET)
  public String listar(){
    return "lista";
  }
  
  @RequestMapping(value = "limpiar.htm", method = RequestMethod.GET)
  public String limpiar(SessionStatus sessionStatus){
    // Limpiar datos de session
    sessionStatus.setComplete();
    // Forward
    return "redirect:/";
  }
  
  
}
