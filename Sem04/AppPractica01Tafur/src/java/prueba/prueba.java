package prueba;

import model.PagosModel;
import service.PagosService;

public class prueba {

  public static void main(String[] args) {
    
    // Datos
    PagosModel model = new PagosModel(6, 20, 120);
    
    // Proceso
    PagosService service = new PagosService();
    model = service.Procesos(model);

    // Reporte
    System.out.println("Horas x Día: " + model.getHorasDia());
    System.out.println("Dias Trabajados: " + model.getDias());
    System.out.println("Pago x Hora: " + model.getPagoHora());
    System.out.println("Ingresos: " + model.getIngresos());
    System.out.println("Renta: " + model.getRenta());
    System.out.println("Neto: " + model.getNeto());

  }

}
