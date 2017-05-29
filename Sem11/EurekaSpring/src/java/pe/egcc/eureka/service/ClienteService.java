package pe.egcc.eureka.service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends AbstractJdbcSupport {

  /**
   * Consultar clñientes.
   *
   * @param criterio Puede ser paterno, materno o nombre
   * @return Lista de clientes
   */
  public List<Map<String, Object>> conClientes(String criterio) {
    List<Map<String, Object>> lista;
    String sql = "select \n"
            + "chr_cliecodigo      codigo,\n"
            + "vch_cliepaterno     paterno,\n"
            + "vch_cliematerno     materno,\n"
            + "vch_clienombre      nombre,\n"
            + "chr_cliedni         dni,\n"
            + "vch_clieciudad      ciudad,     \n"
            + "vch_cliedireccion   direccion,\n"
            + "vch_clietelefono    telefono,\n"
            + "vch_clieemail       email \n"
            + "from cliente \n"
            + "where vch_cliepaterno   like ? \n"
            + "or    vch_cliematerno   like ? \n"
            + "or    vch_clienombre    like ?";
    criterio = "%" + criterio.trim() + "%";
    lista = jdbcTemplate.queryForList(sql, criterio, criterio, criterio);
    return lista;
  }

}
