package pe.egcc.venta.service;

import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import pe.egcc.venta.model.Empleado;

@Service
public class VentaService extends AbstractJdbcSupport {

    public Empleado validaUsuario(String usuario, String clave) {
        Empleado bean = null;
        try {
            String sql = "select idemp,nombre,apellido,email,telefono "
                    + "from empleado  "
                    + "where idemp =  "
                    + "(select idemp from usuario  "
                    + "where usuario = ?  "
                    + "and clave = SHA(?) "
                    + "and estado = 1)";
            bean = (Empleado) jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper(Empleado.class), usuario, clave);
        } catch (EmptyResultDataAccessException e) {
        }
        return bean;
    }

    public List<Empleado> conEmpleados(String nombre, String apellido) {
        List<Empleado> lista;
        String sql = "select idemp,nombre,apellido,email,telefono "
                + "from empleado  "
                + "where nombre like concat('%',?,'%')  "
                + "and apellido like concat('%',?,'%') ";
        lista = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(Empleado.class), nombre, apellido);
        return lista;
    }

}
