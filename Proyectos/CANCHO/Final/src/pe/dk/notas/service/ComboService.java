package pe.dk.notas.service;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import pe.dk.notas.model.Combo;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
@Service
public class ComboService extends AbstractJdbcSupport{

  public List<Combo> getSucursales() {
    String sql = "select "
            + "chr_sucucodigo codigo, "
            + "vch_sucunombre nombre  "
            + "from sucursal";
    List<Combo> lista = jdbcTemplate.query(sql,
            new BeanPropertyRowMapper(Combo.class));
    return lista;
  }

}
