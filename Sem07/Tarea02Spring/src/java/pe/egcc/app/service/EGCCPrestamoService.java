package pe.egcc.app.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import pe.egcc.app.model.EGCCPrestamoModel;

@Service
public class EGCCPrestamoService {

  public List<EGCCPrestamoModel> procPrestamo(double capital, double porcInteres, int meses) {
    List<EGCCPrestamoModel> lista = new ArrayList<>();
    // ------------------------------------------------------------------------------------
    double factInteres = porcInteres / 100;
    double cuotaMensual = redondear(((factInteres * capital) / (1 - (Math.pow((1 + factInteres), -meses)))));
    for (int mes = 1; mes <= meses; mes++) {
      double cuotaInteres = redondear(factInteres * capital);
      double cuotaCapital = redondear(cuotaMensual - cuotaInteres);
      double deudaInicial = redondear(capital);
      EGCCPrestamoModel bean = new EGCCPrestamoModel(mes,deudaInicial, cuotaCapital, cuotaInteres, cuotaMensual);
      lista.add(bean);
      capital -= cuotaCapital;
    }
    // -------------------------------------------------------------------------
    return lista;
  }


  private double redondear(double valor) {
    valor *= 100.0;
    valor = Math.round(valor);
    valor /= 100;
    return valor;
  }

}
