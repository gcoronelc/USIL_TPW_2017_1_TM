package pe.dk.notas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
public class AbstractJdbcSupport {

  @Autowired
  protected JdbcTemplate jdbcTemplate;
  
}
