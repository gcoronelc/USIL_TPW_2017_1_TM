package pe.egcc.eureka.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.egcc.eureka.model.Cliente;
import pe.egcc.eureka.model.Combo;
import pe.egcc.eureka.service.ClienteService;
import pe.egcc.eureka.service.ComboService;
import pe.egcc.eureka.util.EurekaUtil;

@Controller
public class ClienteController {
  
  @Autowired
  private ClienteService clienteService;
  
  @Autowired
  private ComboService comboService;
  
  @RequestMapping(value = "conClientesV1.htm", method = RequestMethod.GET)
  public String conClienteV1(Model model){
    model.addAttribute("menuClientes1", "cssLinkMenuActivo");
    return "conClientes1";
  }
  
  @RequestMapping(value = "conClientesV1.htm", method = RequestMethod.POST)
  public String conClienteV1(
          @RequestParam("criterio") String criterio,
          Model model){
    // Proceso
    List<Map<String,Object>> lista;
    lista = clienteService.conClientes1(criterio);
    // Reporte
    model.addAttribute("menuClientes1", "cssLinkMenuActivo");
    model.addAttribute("criterio", criterio);
    model.addAttribute("lista", lista);
    return "conClientes1";
  }
  
  @RequestMapping(value = "cliente.htm", method = RequestMethod.GET)
  public String conCliente(Model model){
    model.addAttribute("menuCliente", "cssLinkMenuActivo");
    return "cliente";
  }
  
  @RequestMapping(value = "cliente.htm", method = RequestMethod.POST)
  public String conCliente(@RequestParam("codigo") String codigo, Model model){
    // Proceso
    Cliente bean = clienteService.getCliente(codigo);
    model.addAttribute("codigo", codigo);
    if(bean == null){
      model.addAttribute("error", "Código no existe.");
    } else {
      model.addAttribute("bean", bean);
    }
    return "cliente";
  }
  
  @RequestMapping(value = "conClientesV2.htm", method = RequestMethod.GET)
  public String conClienteV2(Model model){
    
    // Proceso Caso 1
    List<Map<String,Object>> lista;
    lista = clienteService.conClientes1("");
    
    // Proceso Caso 2
    // List<Cliente> lista;
    // lista = clienteService.conClientes2("");
    
    // Reporte
    model.addAttribute("lista", lista);
    model.addAttribute("menuClientes2", "cssLinkMenuActivo");
    return "conClientes2";
  }
  
  @RequestMapping(value = "conClientesV2.htm", method = RequestMethod.POST)
  public String conClienteV2(
          @RequestParam("criterio") String criterio,
          Model model){
    

    // Proceso Caso 1
    // List<Map<String,Object>> lista;
    // lista = clienteService.conClientes1(criterio);
    
    // Proceso Caso 2
    List<Cliente> lista;
    lista = clienteService.conClientes2(criterio);
    
    
    // Reporte
    model.addAttribute("menuClientes2", "cssLinkMenuActivo");
    model.addAttribute("criterio", criterio);
    model.addAttribute("lista", lista);
    return "conClientes2";
  }
  
  @RequestMapping(value = "conClientesV3.htm", method = RequestMethod.GET)
  public String conClienteV3(Model model){
    
    // Proceso Caso 1
    List<Combo> sucursales;
    sucursales = comboService.getSucursales();
   
    // Reporte
    model.addAttribute("sucursales", sucursales);
    model.addAttribute("menuClientes3", "cssLinkMenuActivo");
    return "conClientes3";
  }
  
  @RequestMapping(value = "conClientesV3.htm", method = RequestMethod.POST)
  public String conClienteV3(
          @RequestParam("sucursal") String sucursal,
          Model model){
       
    // Proceso
    
    List<Combo> sucursales;
    sucursales = comboService.getSucursales();
    EurekaUtil.selectComboOption(sucursales, sucursal);
    
    
    List<Cliente> lista;
    lista = clienteService.conClientes3(sucursal);
    
    
    // Reporte
    model.addAttribute("menuClientes3", "cssLinkMenuActivo");
    model.addAttribute("criterio", sucursal);
    model.addAttribute("sucursales", sucursales);
    model.addAttribute("lista", lista);
    return "conClientes3";
  }
  
  
  @RequestMapping(value = "crudClientes.htm", method = RequestMethod.GET)
  public String crudClientes(Model model){
    
    
    model.addAttribute("crudClientes", "cssLinkMenuActivo");
    
    return "crudClientes";
  }
  
  @RequestMapping(value = "crudClientesConsultar.htm", method = RequestMethod.POST)
  public String crudClientesConsultar(
          @RequestParam("btnBuscar") String buscar,
          Model model){
    
    System.out.println("buscar: " + buscar);
    
    String destino = (buscar.equals("Buscar")?"crudClientes":"crudClientesEditar");
    
    model.addAttribute("crudClientes", "cssLinkMenuActivo");
    model.addAttribute("mensaje", "Muy pronto .... en USIL.");
    
    return destino;
  }
  
  
}
