package pe.egcc.app.service;

import org.springframework.stereotype.Service;
import pe.egcc.app.model.PromedioModel;

@Service
public class PromedioService {

  public PromedioModel procesarNotas(PromedioModel model){
    // Variables
    int prom;
    String cond;
    // Proceso
    prom = (model.getNota1() + model.getNota2()) / 2;
    cond = "Aprobado";
    if(prom < 13.0){
      cond =  "Desaprobado";
    }
    // Reporte
    model.setProm(prom);
    model.setCond(cond);
    return model;
  }
  
}
