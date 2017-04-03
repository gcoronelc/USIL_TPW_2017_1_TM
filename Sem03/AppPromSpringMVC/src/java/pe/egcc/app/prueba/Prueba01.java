package pe.egcc.app.prueba;

import pe.egcc.app.model.PromedioModel;
import pe.egcc.app.service.PromedioService;

public class Prueba01 {

  public static void main(String[] args) {
    // Datos
    PromedioModel model = new PromedioModel(12, 16);
    // Proceso
    PromedioService service = new PromedioService();
    model = service.procesarNotas(model);
    // Reporte
    System.out.println("Nota 1: " + model.getNota1());
    System.out.println("Nota 2: " + model.getNota2());
    System.out.println("Promedio: " + model.getProm());
    System.out.println("Condición: " + model.getCond());
  }
  
}
