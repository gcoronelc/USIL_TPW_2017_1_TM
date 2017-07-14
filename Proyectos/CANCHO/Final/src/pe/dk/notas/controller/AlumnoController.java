package pe.dk.notas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.dk.notas.model.Alumno;
import pe.dk.notas.model.Empleado;
import pe.dk.notas.service.AlumnoService;
import pe.dk.notas.service.EmpleadoService;
import pe.dk.notas.util.NotasUtil;



@Controller
public class AlumnoController {
	
	 @Autowired
	 private AlumnoService alumnoService;
	 private EmpleadoService empleadoService;
	
	
	@RequestMapping(value="crudAlumno.htm", method=RequestMethod.GET)
	  public String crudAlumno(Model model){

		  model.addAttribute("menuTablas", "id='current'");
		  
		  return "crudAlumno";
	  }

	  
	  
	  @RequestMapping(value="crudAlumnoConsulta.htm", method=RequestMethod.POST)
	  public String crudAlumnoConsulta(
			  @RequestParam("btnAccion") String accion,
			  @ModelAttribute Alumno bean,
			  Model model){

		  model.addAttribute("menuTablas", "id='current'");
		  
		  String destino = "crudAlumno";
		  
		  if(accion.equals("Buscar")){
			  
			  List<Alumno> lista = alumnoService.read(bean);
			  model.addAttribute("lista", lista);
			  destino = "crudAlumno";
		  }
		  if(accion.equals("Nuevo")){
			  
			  Alumno alumno = new Alumno();
			  alumno.setCodigo(NotasUtil.CRUD_NUEVO);
			  model.addAttribute("alumno", alumno);
			  model.addAttribute("accion", NotasUtil.CRUD_NUEVO);
			  destino = "crudAlumnoEditar";
			  
		  }
		 
		  return destino;
		  
	  }
	  
	  @RequestMapping(value="crudAlumnoGrabar.htm", method=RequestMethod.POST)
	  public String crudAlumnoGrabar(
			  @RequestParam("accion") String accion,
			  @ModelAttribute Alumno alumno,
			  Model model){

		String mensaje = "";
		try {
		
			switch (accion) {
			case NotasUtil.CRUD_NUEVO:
				alumnoService.crear(alumno);
				mensaje = "Alumno creado con codigo " + alumno.getCodigo() + ".";
				break;

			}
			
			model.addAttribute("mensaje", mensaje);
			
		} catch (Exception e) {
			
			model.addAttribute("error", e.getMessage());
			
		}
		 	  
		return "crudAlumno";
	  }
	  
	  @RequestMapping(value="crudAlumnoEditar.htm", method=RequestMethod.GET)
	  public String crudAlumnoEditar(
			  @RequestParam("codigo") String codigo,
			  Model model){

		  // Proceso
		  Alumno bean = alumnoService.read(codigo);
		  
		  // Reporte
		  model.addAttribute("alumno", bean);
		  model.addAttribute("accion", NotasUtil.CRUD_EDITAR);
		  
		  return "crudAlumnoEditar";
	  }
	  
	  @RequestMapping(value = "verEmpleados.htm", method=RequestMethod.GET )
	  public String conEmpleados(Model model){
	    
		model.addAttribute("menuTablas", "id='current'");  
	    return "verEmpleados";
	    
	  }
	  
	  @RequestMapping(value="verEmpleadosConsulta.htm", method=RequestMethod.POST )
	  public String verEmpleadosConsulta(
			  @RequestParam("btnAccion") String accion,
			  @ModelAttribute Empleado bean,
	          Model model){
		  
		  model.addAttribute("menuTablas", "id='current'");
		  String destino ="verEmpleados";
		  
		  if(accion.equals("Buscar")){
			  
			  List<Empleado> lista = empleadoService.read(bean);
			  model.addAttribute("lista", lista);
			  destino = "verEmpleados";
		  }
		  if(accion.equals("Nuevo")){
			  
			  Empleado empleado = new Empleado();
			  empleado.setCodigo(NotasUtil.CRUD_NUEVO);
			  model.addAttribute("empleado", empleado);
			  model.addAttribute("accion", NotasUtil.CRUD_NUEVO);
			  destino = "conEmpleadosEditar";
			  
		  }	    
	    	    
	    return destino;
	    
	  }

}
