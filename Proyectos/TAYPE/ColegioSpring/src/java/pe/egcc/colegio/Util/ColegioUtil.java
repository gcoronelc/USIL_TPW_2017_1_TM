package pe.egcc.colegio.Util;

import java.util.List;
import pe.egcc.colegio.model.Combo;

public class ColegioUtil {
    
        private ColegioUtil() {
    }

    public static void selectComboOption(List<Combo> lista, String codigo) {
        for (Combo combo : lista) {
            if (combo.getCodigo().equals(codigo)) {
                combo.setSelected("selected");
            }
        }
    }
    
    // CONSTANTES DEL CRUD
    
    public static final String CRUD_NUEVO = "NUEVO";
    public static final String CRUD_EDITAR = "EDITAR";
    public static final String CRUD_ELIMINAR = "ELIMINAR";
}
