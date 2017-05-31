package pe.egcc.eureka.service;

import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import pe.egcc.eureka.mapper.ClienteMapper;
import pe.egcc.eureka.model.Cliente;

@Service
public class ClienteService extends AbstractJdbcSupport {

  /**
   * Consultar clñientes.
   *
   * @param criterio Puede ser paterno, materno o nombre
   * @return Lista de clientes usando Map
   */
  public List<Map<String, Object>> conClientes1(String criterio) {
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
  
  /**
   * Consultar clñientes.
   *
   * @param criterio Puede ser paterno, materno o nombre
   * @return Lista de clientes usando Bean
   */
  public List<Cliente> conClientes2(String criterio) {
    List<Cliente> lista = null;
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
    lista = jdbcTemplate.query(sql, 
            new BeanPropertyRowMapper(Cliente.class), 
            criterio, criterio, criterio);
    return lista;
  }

  
  public Cliente getCliente(String codigo){
    Cliente bean = null;
    String sql = "select "
            + "chr_cliecodigo    , "
            + "vch_cliepaterno   , "
            + "vch_cliematerno   , "
            + "vch_clienombre    , "
            + "chr_cliedni       , "
            + "vch_clieciudad    , "
            + "vch_cliedireccion , "
            + "vch_clietelefono  , "
            + "vch_clieemail       "
            + "from cliente  "
            + "where chr_cliecodigo = ? ";
    try {
      bean = jdbcTemplate.queryForObject(sql, new ClienteMapper(), codigo);
    } catch (EmptyResultDataAccessException e) {
    }
    return bean;
  }
  
}
