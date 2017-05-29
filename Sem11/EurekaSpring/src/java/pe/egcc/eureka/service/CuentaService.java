package pe.egcc.eureka.service;

import org.springframework.stereotype.Service;

@Service
public class CuentaService extends AbstractJdbcSupport{

  public int getCantCuentas(){
    String sql= "select count(*) from cuenta";
    int rowCount= jdbcTemplate.queryForObject(sql,Integer.class);
    return rowCount;
  }

  
}
