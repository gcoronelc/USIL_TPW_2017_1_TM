
package pe.egcc.colegio.service;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
 import pe.egcc.colegio.model.Combo;

@Service
public class ComboService extends AbstractJdbcSupport{
    
     public List<Combo> getSeccion(){
    String sql = "select IDGRADO codigo, NOMBRE nombre from grado";
    List<Combo> lista = jdbcTemplate.query(sql, 
            new BeanPropertyRowMapper(Combo.class));
    return lista;
  } 
}
