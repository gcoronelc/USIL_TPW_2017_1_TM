package pe.dk.notas.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.dk.notas.model.Empleado;
import pe.dk.notas.service.CuentaService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
@Controller
@SessionAttributes(value = { "empSession", "usuSession", "permisos" })
public class CuentaController {

  @Autowired
  private CuentaService cuentaService;
  
  
  @RequestMapping(value = "resumenSucursal.htm", method = RequestMethod.GET)
  public String resumenSucursal(Model model){
    model.addAttribute("menuResumenSucursal", "menuItemActivo");
    return "resumenSucursal";
  }
  
  @RequestMapping(value = "resumenSucursal.htm", method = RequestMethod.POST)
  public String resumenSucursal(
          @RequestParam("sucursal") String sucursal,
          @RequestParam("moneda") String moneda,
          Model model){
    
    
    // Proceso
    List<Map<String,Object>> lista = cuentaService.getResumenSucursal(sucursal, moneda);
    model.addAttribute("lista", lista);
    model.addAttribute("menuResumenSucursal", "menuItemActivo");
    
    return "resumenSucursal";
  }
  
  
  
  @RequestMapping(value = "regRetiro.htm", method = RequestMethod.GET)
  public String regRetiro(Model model){
    model.addAttribute("menuProcesos", "menuItemActivo");
    return "regRetiro";
  }
  
  @RequestMapping(value = "regRetiro.htm", method = RequestMethod.POST)
  public String regRetiro(
      @RequestParam("cuenta") String cuenta,
      @RequestParam("importe") double importe,
      @RequestParam("clave") String clave,
      @ModelAttribute("empSession")  Empleado empleado,
      Model model){
    
    System.out.println("EMP: " + empleado.getCodigo());
    
    // Proceso
    try {
      
      cuentaService.registraRetiro(cuenta, 
          clave, importe, empleado.getCodigo());
      
      model.addAttribute("mensaje", "Proceso ejecutado correctamente.");
      
    } catch (Exception e) {

      model.addAttribute("error", e.getMessage());
      
    }
    
    model.addAttribute("menuProcesos", "menuItemActivo");
    
    return "regRetiro";
  }
  
  
  
  
}
