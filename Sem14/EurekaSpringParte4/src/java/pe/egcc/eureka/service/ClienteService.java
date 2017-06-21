package pe.egcc.eureka.service;

import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.egcc.eureka.mapper.ClienteMapper;
import pe.egcc.eureka.model.Cliente;

@Service
public class ClienteService extends AbstractJdbcSupport {

  private final String SQL_SELECT = "select "
            + "chr_cliecodigo      codigo,"
            + "vch_cliepaterno     paterno,"
            + "vch_cliematerno     materno,"
            + "vch_clienombre      nombre,"
            + "chr_cliedni         dni,"
            + "vch_clieciudad      ciudad,"
            + "vch_cliedireccion   direccion,"
            + "vch_clietelefono    telefono,"
            + "vch_clieemail       email "
            + "from cliente ";
  
  /**
   * Consultar clñientes.
   *
   * @param criterio Puede ser paterno, materno o nombre
   * @return Lista de clientes usando Map
   */
  public List<Map<String, Object>> conClientes1(String criterio) {
    List<Map<String, Object>> lista;
    String sql = SQL_SELECT
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
    String sql = SQL_SELECT
            + "where vch_cliepaterno   like ? \n"
            + "or    vch_cliematerno   like ? \n"
            + "or    vch_clienombre    like ?";
    criterio = "%" + criterio.trim() + "%";
    lista = jdbcTemplate.query(sql, 
            new BeanPropertyRowMapper(Cliente.class), 
            criterio, criterio, criterio);
    return lista;
  }
  
  /**
   * Consultar clñientes.
   *
   * @param criterio Puede ser paterno, materno o nombre
   * @return Lista de clientes usando Bean
   */
  public List<Cliente> conClientes3(String sucursal) {
    List<Cliente> lista = null;
    String sql = SQL_SELECT
            + "where chr_cliecodigo in "
            + "( select chr_cliecodigo from cuenta where chr_sucucodigo=? ) ";
    lista = jdbcTemplate.query(sql, 
            new BeanPropertyRowMapper(Cliente.class), sucursal);
    return lista;
  }

  
  public Cliente getCliente(String codigo){
    Cliente bean = null;
    String sql = SQL_SELECT
            + "where chr_cliecodigo = ? ";
    try {
      bean = jdbcTemplate.queryForObject(sql, new ClienteMapper(), codigo);
    } catch (EmptyResultDataAccessException e) {
    }
    return bean;
  }
  
  public List<Cliente> getClientes( Cliente bean ){
    List<Cliente> lista;
    String sql = SQL_SELECT
            + "where vch_cliepaterno like concat('%',?,'%') "
            + "and vch_cliematerno like concat('%',?,'%') "
            + "and vch_clienombre  like concat('%',?,'%') ";
    lista = jdbcTemplate.query(sql, new ClienteMapper(), 
            bean.getPaterno(), bean.getMaterno(), bean.getNombre());
    return lista;
  }
  
  @Transactional(propagation = Propagation.REQUIRED,
          rollbackFor = Exception.class)
  public void crear(Cliente cliente) {
    // Leer el contador
    String sql = "select int_contitem cont, int_contlongitud size "
            + "from contador "
            + "where vch_conttabla = 'Cliente' "
            + "for update";
    Map<String,Object> rec = jdbcTemplate.queryForMap(sql);
    int cont = Integer.parseInt(rec.get("cont").toString());
    int size = Integer.parseInt(rec.get("size").toString());
    
    System.out.println("CONT: " + cont);
    
    try {
      Thread.currentThread().sleep(2000);
    } catch (Exception e) {
    }
    
    // Generar Codigo
    cont++;
    String codigo = String.format("%" + size + "s", cont).replace(' ', '0' );
    
    // Actualizar el contador
    sql = "update contador set int_contitem = ? "
            + "where vch_conttabla = 'Cliente'";
    jdbcTemplate.update(sql, cont);
    
    // Insertar cliente
    sql = "insert into cliente(chr_cliecodigo,vch_cliepaterno,"
            + "vch_cliematerno,vch_clienombre,chr_cliedni,"
            + "vch_clieciudad,vch_cliedireccion,"
            + "vch_clietelefono,vch_clieemail) "
            + "values(?,?,?,?,?,?,?,?,?)";
    jdbcTemplate.update(sql, codigo, cliente.getPaterno(), cliente.getMaterno(),
            cliente.getNombre(),cliente.getDni(),cliente.getCiudad(),
            cliente.getDireccion(),cliente.getTelefono(),cliente.getEmail());
    
    cliente.setCodigo(codigo);
    
  }
  
}
