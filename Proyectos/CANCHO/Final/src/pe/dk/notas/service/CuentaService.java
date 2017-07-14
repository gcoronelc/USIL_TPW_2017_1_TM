package pe.dk.notas.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
@Service
public class CuentaService extends AbstractJdbcSupport {

  public int getCantCuentas() {
    String sql = "select count(*) from cuenta";
    int rowCount = jdbcTemplate.queryForObject(sql, Integer.class);
    return rowCount;
  }

  public double getSaldoTotal(String moneda) {
    String sql = "select sum(dec_cuensaldo) from cuenta " 
        + "where chr_monecodigo = ?";
    Object[] args = { moneda };
    Double saldo = jdbcTemplate.queryForObject(sql, args, Double.class);
    return saldo;
  }

  public List<Map<String, Object>> getResumenSucursal(String sucursal, String moneda) {
    String sql = "select sucucodigo, sucunombre, " 
        + "monecodigo, monenombre, " 
        + "tipocodigo, tiponombre, "
        + "count(*) cant, " 
        + "sum(moviimporte) importe " 
        + "from v_movimiento " 
        + "where sucucodigo = ? "
        + "and monecodigo = ? " 
        + "group by sucucodigo, sucunombre, " 
        + "monecodigo, monenombre, "
        + "tipocodigo, tiponombre";
    List<Map<String, Object>> lista = jdbcTemplate.queryForList(sql, sucursal, moneda);
    return lista;
  }

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public void registraRetiro(String cuenta, String clave, double importe, String codEmp) {

    try {
      
      // Verificar datos
      String sql = "select "
          + "dec_cuensaldo saldo, "
          + "int_cuencontmov cont " 
          + "from cuenta " 
          + "where chr_cuencodigo = ? "
          + "and vch_cuenestado = 'ACTIVO' " 
          + "for update ";
      Map<String,Object> rec = jdbcTemplate.queryForMap(sql, cuenta);
      double saldo = Double.parseDouble(rec.get("saldo").toString());
      int cont = Integer.parseInt(rec.get("cont").toString());
      
      // Verificar saldo
      if(saldo < importe ){
        throw new RuntimeException("No tienes saldo ...");
      }
      
      // Actualizar datos
      saldo -= importe;
      cont++;
      
      // Actualizar cuenta
      sql = "update cuenta set "
          + "dec_cuensaldo = ?, "
          + "int_cuencontmov = ? "
          + "where chr_cuencodigo = ? ";
      int filas = jdbcTemplate.update(sql, saldo, cont, cuenta);
      if(filas == 0){
        throw new RuntimeException("No es posible actualizar la cuenta.");
      }

      // Registrar el movimiento
      sql = "insert into movimiento(chr_cuencodigo,int_movinumero,"
          + "dtt_movifecha,chr_emplcodigo,chr_tipocodigo,"
          + "dec_moviimporte) values(?,?,SYSDATE(),?,'004',?)";
      jdbcTemplate.update(sql, cuenta, cont,codEmp, importe);
      
    } catch (EmptyResultDataAccessException e) {
      
      throw new RuntimeException("Datos incorrectos");
      
    }

  }

}
