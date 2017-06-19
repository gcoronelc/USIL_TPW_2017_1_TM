package pe.egcc.eureka.util;

import java.util.List;
import pe.egcc.eureka.model.Combo;

public final class EurekaUtil {

  private EurekaUtil() {
  }
  
  
  public static void selectComboOption(List<Combo> lista, String codigo){
    for (Combo combo : lista) {
      if(combo.getCodigo().equals(codigo)){
        combo.setSelected("selected");
      }
    }
  }
  
  
}
