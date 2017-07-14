
package pe.egcc.colegio.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import pe.egcc.colegio.model.Estudiante;
import pe.egcc.colegio.service.ComboService;
import pe.egcc.colegio.service.EstudianteService;
import pe.egcc.colegio.Util.ColegioUtil;

@Controller
@SessionAttributes(value = {"empSession", "usuSession", "permisos"})
public class EstudianteController {
    
    @Autowired
    private ComboService comboService;
    
    @Autowired
    private EstudianteService estudianteService;
    
        @RequestMapping(value = "crudEstudiante.htm", method = RequestMethod.GET)
    public String crudEstudiante(Model model) {
        String destino = "crudEstudiante";
//        if (!model.containsAttribute("usuario")) {
//            destino = "error/error";
//        }
        return destino;
    }
    
     @RequestMapping(value = "crudEstudianteConsultar.htm", method = RequestMethod.POST)
  public String crudEstudianteConsultar(
          @ModelAttribute Estudiante bean,
          @RequestParam("btnBuscar") String buscar,
          Model model){
    
    String destino;
    //model.addAttribute("crudClientes", "cssLinkMenuActivo");
    
    if( buscar.equals("Buscar") ){
      
      destino = "crudEstudiante";
      List<Estudiante> lista = estudianteService.getEstudiantes(bean);
      model.addAttribute("lista", lista);
      
    } else {
      
      Estudiante beanEstudiante = new Estudiante();
      beanEstudiante.setIDEST(ColegioUtil.CRUD_NUEVO);
      
      destino = "crudEstudianteEditar";
      model.addAttribute("accion", ColegioUtil.CRUD_NUEVO);
      model.addAttribute("bean", beanEstudiante);
      
    }
    
    return destino;
  }
  
  @RequestMapping(value = "crudEstudianteEditar.htm", method = RequestMethod.GET)
  public String crudEstudianteEditar(
          @RequestParam("IDEST") String codigo,
          Model model){
    
    String destino;
    //model.addAttribute("crudClientes", "cssLinkMenuActivo");
    
    // Proceso
    Estudiante beanEstudiante = estudianteService.getEstudiante(codigo);
    
    // Reporte
    destino = "crudEstudianteEditar";
    model.addAttribute("accion", ColegioUtil.CRUD_EDITAR);
    model.addAttribute("bean", beanEstudiante);
    
    return destino;
  }
  @RequestMapping(value = "crudEstudianteEliminar.htm", method = RequestMethod.GET)
  public String crudEstudianteEliminar(
          @RequestParam("IDEST") String codigo,
          Model model){
    
    String destino;
  //  model.addAttribute("crudClientes", "cssLinkMenuActivo");
    
    // Proceso
    Estudiante beanEmpleado = estudianteService.getEstudiante(codigo);
    
    // Reporte
    destino = "crudEstudianteEditar";
    model.addAttribute("accion", ColegioUtil.CRUD_ELIMINAR);
    model.addAttribute("bean", beanEmpleado);
    model.addAttribute("disabled", "disabled");
    
    
    return destino;
  }
  
  
  @RequestMapping(value = "crudEstudianteGrabar.htm", method = RequestMethod.POST)
  public String crudEstudianteGrabar(
          @RequestParam("accion") String accion,
          @ModelAttribute Estudiante empleado,
          Model model){
    
    String destino;
    //model.addAttribute("crudClientes", "cssLinkMenuActivo");
    
    // Proceso
    String mensaje = "";
    String error = "";
    try {
      switch(accion){
        case ColegioUtil.CRUD_NUEVO:
          estudianteService.crear(empleado);
          mensaje = "Estudiante creado con código " + empleado.getIDEST() + ".";
          break;
         case ColegioUtil.CRUD_EDITAR:
          estudianteService.update(empleado);
          mensaje = "Estudiante editado con código " ;
          break;
         case ColegioUtil.CRUD_ELIMINAR:
          estudianteService.delete(empleado.getIDEST());
          mensaje = "Estudiante eliminado con código ";
          break;         
          
      }
    } catch (Exception e) {
      error = e.getMessage();
    }
        
    // Reporte
    destino = "mensaje";
    model.addAttribute("titulo", accion + " EMPLEADO");
    model.addAttribute("mensaje", mensaje);
    model.addAttribute("error", error);
 
    
    return destino;
  }
  
    
}
