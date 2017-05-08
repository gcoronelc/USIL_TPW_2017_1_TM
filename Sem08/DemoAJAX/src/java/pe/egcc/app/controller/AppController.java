package pe.egcc.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(){
    return "index";
  }
  
  @RequestMapping(value = "/pagina1.htm")
  public String pagina1(){
    return "pagina1";
  }
  
  @RequestMapping(value = "/pagina2.htm", method = RequestMethod.GET)
  public String pagina2(){
    return "pagina2";
  }
  
  
}
