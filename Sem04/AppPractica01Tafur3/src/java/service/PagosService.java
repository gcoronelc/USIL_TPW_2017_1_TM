package service;

import model.PagosModel;
import org.springframework.stereotype.Service;

@Service
public class PagosService {

  public PagosModel Procesos(PagosModel model) {

    //variables
    int ingresos;
    double renta = 0;
    double neto;

    //Proceso
    ingresos = (model.getHorasDia() * model.getDias() * model.getPagoHora());
    if (ingresos > 1500) {
      renta = ingresos * 0.08;
    }
    neto = ingresos - renta;

    model.setIngresos(ingresos);
    model.setRenta(renta);
    model.setNeto(neto);

    return model;
  }

}
