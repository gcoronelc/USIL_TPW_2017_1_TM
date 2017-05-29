package pe.egcc.eureka.service;

import org.springframework.stereotype.Service;

@Service
public class CuentaService extends AbstractJdbcSupport{

  public int getCantCuentas(){
    String sql= "select count(*) from cuenta";
    int rowCount= jdbcTemplate.queryForObject(sql,Integer.class);
    return rowCount;
  }
  
  public double getSaldoTotal(String moneda){
    String sql= "select sum(dec_cuensaldo) saldo "
            + "from cuenta "
            + "where chr_monecodigo = ?";
    Object[] args = {moneda};
    double saldo = jdbcTemplate.queryForObject(sql, args, Double.class);
    return saldo;
  }

}
