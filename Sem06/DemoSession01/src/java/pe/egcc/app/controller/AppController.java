package pe.egcc.app.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
  
  @RequestMapping(value = "/")
  public String home(){
    return "index";
  }
  
  @RequestMapping(value = "agregar.htm", method = RequestMethod.GET)
  public String agregar(){
    return "agregar";
  }
  
  @RequestMapping(value = "agregar.htm", method = RequestMethod.POST)
  public String agregar(
          @RequestParam("ciudad") String ciudad,
          HttpSession session,
          Model model
    ){
    // Definiendo la lista
    List<String> lista;
    if(session.getAttribute("lista") == null){
      lista = new ArrayList<>();
      session.setAttribute("lista", lista);
    } else {
      lista = (List<String>) session.getAttribute("lista");
    }
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
  public String limpiar(HttpSession session, Model model){
    // Limpiar datos de session
    session.invalidate();
    model.addAttribute("mensaje", "Lista vacía.");
    // Forward
    return "redirect:/";
  }
  
  
}
