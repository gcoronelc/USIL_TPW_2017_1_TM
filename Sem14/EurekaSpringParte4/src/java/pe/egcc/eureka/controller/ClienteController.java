package pe.egcc.eureka.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

  /*
  INICIO DEL CRID
  */
  
  
  @RequestMapping(value = "crudClientes.htm", method = RequestMethod.GET)
  public String crudClientes(Model model){
    
    
    model.addAttribute("crudClientes", "cssLinkMenuActivo");
    
    return "crudClientes";
  } 
  
  @RequestMapping(value = "crudClientesConsultar.htm", method = RequestMethod.POST)
  public String crudClientesConsultar(
          @ModelAttribute Cliente bean,
          @RequestParam("btnBuscar") String buscar,
          Model model){
    
    String destino;
    model.addAttribute("crudClientes", "cssLinkMenuActivo");
    
    if( buscar.equals("Buscar") ){
      
      destino = "crudClientes";
      List<Cliente> lista = clienteService.getClientes(bean);
      model.addAttribute("lista", lista);
      
    } else {
      
      Cliente beanCliente = new Cliente();
      beanCliente.setCodigo(EurekaUtil.CRUD_NUEVO);
      
      destino = "crudClientesEditar";
      model.addAttribute("accion", EurekaUtil.CRUD_NUEVO);
      model.addAttribute("bean", beanCliente);
      
    }
    
    return destino;
  }
  
  @RequestMapping(value = "crudClienteEditar.htm", method = RequestMethod.GET)
  public String crudClienteEditar(
          @RequestParam("codigo") String codigo,
          Model model){
    
    String destino;
    model.addAttribute("crudClientes", "cssLinkMenuActivo");
    
    // Proceso
    Cliente beanCliente = clienteService.getCliente(codigo);
    
    // Reporte
    destino = "crudClientesEditar";
    model.addAttribute("accion", EurekaUtil.CRUD_EDITAR);
    model.addAttribute("bean", beanCliente);
    
    return destino;
  }
  
  @RequestMapping(value = "crudClienteEliminar.htm", method = RequestMethod.GET)
  public String crudClienteEliminar(
          @RequestParam("codigo") String codigo,
          Model model){
    
    String destino;
    model.addAttribute("crudClientes", "cssLinkMenuActivo");
    
    // Proceso
    Cliente beanCliente = clienteService.getCliente(codigo);
    
    // Reporte
    destino = "crudClientesEditar";
    model.addAttribute("accion", EurekaUtil.CRUD_ELIMINAR);
    model.addAttribute("bean", beanCliente);
    model.addAttribute("disabled", "disabled");
    
    
    return destino;
  }
  
  
  @RequestMapping(value = "crudClienteGrabar.htm", method = RequestMethod.POST)
  public String crudClienteGrabar(
          @RequestParam("accion") String accion,
          @ModelAttribute Cliente cliente,
          Model model){
    
    String destino;
    model.addAttribute("crudClientes", "cssLinkMenuActivo");
    
    // Proceso
    String mensaje = "";
    String error = "";
    try {
      switch(accion){
        case EurekaUtil.CRUD_NUEVO:
          clienteService.crear(cliente);
          mensaje = "Cliente creado con código " + cliente.getCodigo() + ".";
          break;
          
          
      }
    } catch (Exception e) {
      error = e.getMessage();
    }
        
    // Reporte
    destino = "mensaje";
    model.addAttribute("titulo", accion + " CLIENTE");
    model.addAttribute("mensaje", mensaje);
    model.addAttribute("error", error);
 
    
    return destino;
  }
  
  
  
}
