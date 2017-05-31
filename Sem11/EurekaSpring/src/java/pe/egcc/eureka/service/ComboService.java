package pe.egcc.eureka.service;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import pe.egcc.eureka.model.Combo;

@Service
public class ComboService extends AbstractJdbcSupport{
  
  public List<Combo> getSucursales(){
    String sql = "select chr_sucucodigo codigo, vch_sucunombre nombre from sucursal";
    List<Combo> lista = jdbcTemplate.query(sql, 
            new BeanPropertyRowMapper(Combo.class));
    return lista;
  } 
  
}
