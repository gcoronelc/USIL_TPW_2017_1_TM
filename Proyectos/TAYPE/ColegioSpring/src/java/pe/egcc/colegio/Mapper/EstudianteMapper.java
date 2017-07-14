package pe.egcc.colegio.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import pe.egcc.colegio.model.Estudiante;

public class EstudianteMapper implements RowMapper<Estudiante> {

    @Override
    public Estudiante mapRow(ResultSet rs, int i) throws SQLException {
        Estudiante bean1 = new Estudiante();
        bean1.setIDEST(rs.getString("IDEST"));
        bean1.setAPELLIDO(rs.getString("APELLIDO"));
        bean1.setNOMBRE(rs.getString("NOMBRE"));
        bean1.setDNI(rs.getString("DNI"));
        bean1.setDIRECCION(rs.getString("DIRECCION"));
        bean1.setCORREO(rs.getString("CORREO"));
        bean1.setAPONOMBRE(rs.getString("APONOMBRE"));
        bean1.setAPOCORREO(rs.getString("APOCORREO"));
        bean1.setAPOTELEFONO(rs.getString("APOTELEFONO"));
        return bean1;
    }
}
