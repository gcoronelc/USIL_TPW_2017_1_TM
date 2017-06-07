package pe.egcc.venta.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import pe.egcc.venta.model.Empleado;
import pe.egcc.venta.service.VentaService;

@Controller
@SessionAttributes({"usuario"})
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @RequestMapping(value = "index.htm", method = RequestMethod.GET)
    public String home() {
        return "index";
    }
    
    @RequestMapping(value = "empleado.htm", method = RequestMethod.GET)
    public String empleado() {
        return "empleado";
    }
    
    @RequestMapping(value = "empleado.htm", method = RequestMethod.POST)
    public String empleado(
            @RequestParam("nombre") String nombre, 
            @RequestParam("apellido") String apellido,
            Model model) {
        List<Empleado> lista = ventaService.conEmpleados(nombre, apellido);
        model.addAttribute("lista", lista);
        model.addAttribute("nombre", nombre);
        model.addAttribute("apellido", apellido);
        return "empleado";
    }
    
    @RequestMapping(value = "producto.htm", method = RequestMethod.GET)
    public String producto() {
        return "producto";
    }

    @RequestMapping(value = "logon.htm", method = RequestMethod.POST)
    public String logon(
            @RequestParam("usuario") String usuario,
            @RequestParam("clave") String clave,
            Model model) {
        String destino;
        try {
            Empleado bean = ventaService.validaUsuario(usuario, clave);
            if (bean == null) {
                throw new Exception("Datos Incorrectos");
            }
            model.addAttribute("usuario", bean);
            destino = "main";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            destino = "index";
        }
        return destino;
    }

}
