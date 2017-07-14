
package pe.egcc.colegio.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import pe.egcc.colegio.model.Empleado;
public class EmpleadoMapper implements RowMapper<Empleado> {
    
        @Override
    public Empleado mapRow(ResultSet rs, int i) throws SQLException {
        Empleado bean1 = new Empleado();
        bean1.setIDEMP(rs.getString("IDEMP"));
        bean1.setNOMBRE(rs.getString("NOMBRE"));
        bean1.setAPELLIDO(rs.getString("APELLIDO"));
        bean1.setDni(rs.getString("dni"));
        bean1.setDIRECCION(rs.getString("DIRECCION"));
        bean1.setTELEFONO(rs.getString("TELEFONO"));
        bean1.setCORREO(rs.getString("CORREO"));
        bean1.setESTADO(Integer.valueOf(rs.getString("ESTADO")));
        return bean1;
    }
}
