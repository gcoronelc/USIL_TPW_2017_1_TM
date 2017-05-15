package pe.egcc.app.service;

import org.springframework.stereotype.Service;
import pe.egcc.app.model.PromedioModel;

@Service
public class AppService {

  public PromedioModel promediar(PromedioModel promedioModel) {
  
      // Tarea para ustedes
      
      promedioModel.setPromFinal(100);
      
      
      return promedioModel;
  
  }
  
}
