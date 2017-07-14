package pe.dk.notas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.dk.notas.model.Empleado;
import pe.dk.notas.service.AlumnoService;
import pe.dk.notas.service.CuentaService;
import pe.dk.notas.service.EmpleadoService;
import pe.dk.notas.util.NotasUtil;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
@Controller
@SessionAttributes(value = { "empSession", "usuSession", "permisos" })

public class AppController {

	@Autowired
	private CuentaService cuentaService;
	private AlumnoService alumnoService;
	
	@Autowired
	private EmpleadoService empleadoService;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home1(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "index";
	}

	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String home2(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "index";
	}
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String home3(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "main";
	}

	@RequestMapping(value = "/logon.htm", method = RequestMethod.POST)
	public String logon(
		@RequestParam("usuario") String usuario,
		@RequestParam("clave") String clave,
		Model model) {

		String destino;	
		try {
			
			// Proceso
			Empleado bean = empleadoService.validar(usuario, clave);
			if(bean ==  null){
				throw new Exception("Datos incorrectos");
			}
			destino = "main";
			model.addAttribute("empSession", bean);
			model.addAttribute("usuSession", usuario);
			
			// Cargar permisos
			model.addAttribute("permisos", 
					empleadoService.leerPermisos(bean.getCodigo()));
			
		} catch (Exception e) {

			destino = "index";
			model.addAttribute("error", e.getMessage());
			
		}
		
		return destino;
	}

	@RequestMapping(value = "/generales.htm", method = RequestMethod.GET)
	public String generales(Model model) {

		model.addAttribute("menuGenerales", "id='current'");

		model.addAttribute("cantCuentas", cuentaService.getCantCuentas());
		model.addAttribute("saldoSoles", cuentaService.getSaldoTotal("01"));
		model.addAttribute("saldoDolares", cuentaService.getSaldoTotal("02"));

		return "generales";
	}
	
	  @RequestMapping(value = "CambioClave.htm", method = RequestMethod.GET)
	  public String CambioClave(Model model) {		  
	    model.addAttribute("menuProcesos", "menuItemActivo");
	    return "CambioClave";
	  }
	  
	  @RequestMapping(value = "CambioClave.htm", method = RequestMethod.POST)
	  public String CambioClave(
			  @RequestParam("nuevacontra")String nueva,
			  @ModelAttribute("empSession")  Empleado empleado,	
			  @RequestParam("contra")String clave,
			  		  
			  Model model){
		  
		  try {
			  alumnoService.updateclave(nueva, empleado.getCodigo());
			
		} catch (Exception e) {
			
			 model.addAttribute("error", e.getMessage());
			
		}
	    model.addAttribute("menuProcesos", "menuItemActivo");
	    
	    return "CambioClave";
	  }
	  
	  

}
