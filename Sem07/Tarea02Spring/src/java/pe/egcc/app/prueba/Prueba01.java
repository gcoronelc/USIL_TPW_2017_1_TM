package pe.egcc.app.prueba;

import java.util.List;
import pe.egcc.app.model.EGCCPrestamoModel;
import pe.egcc.app.service.EGCCPrestamoService;

public class Prueba01 {

  public static void main(String[] args) {
    // Datos
    double capital = 1200.0;
    double interes = 4;
    int meses = 12;
    // Proceso
    EGCCPrestamoService service = new EGCCPrestamoService();
    List<EGCCPrestamoModel> repo;
    repo = service.procPrestamo(capital, interes, meses);
    // Reporte
    for (EGCCPrestamoModel bean : repo) {
      String linea = bean.getMes() + 
              " - " + bean.getCapitalInicial() +
              " - " + bean.getCapital() +
              " - " + bean.getInteres() +
              " - " + bean.getTotal();
      System.out.println(linea);
    }
  }
  
}
