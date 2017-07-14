
package pe.egcc.colegio.service;

import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.egcc.colegio.model.Estudiante;
import pe.egcc.colegio.Mapper.EstudianteMapper;

@Service
public class EstudianteService extends AbstractJdbcSupport {
    
    
     private final String SQL_SELECT = "select "
            + "IDEST         IDEST, "
            + "APELLIDO      APELLIDO, "
            + "NOMBRE        NOMBRE, "
            + "DNI           DNI, "
            + "DIRECCION     DIRECCION, "
            + "CORREO        CORREO, "
            + "APONOMBRE     APONOMBRE, "
            + "APOCORREO     APOCORREO, "
            + "APOTELEFONO   APOTELEFONO "
            + "from estudiante ";

    private final String SQL_UPDATE = "update estudiante set "
            + "APELLIDO=?, "
            + "NOMBRE=?, "
            + "DNI=?, "
            + "DIRECCION=?, "
            + "CORREO=?, "
            + "APONOMBRE=?, "
            + "APOCORREO=?, "
            + "APOTELEFONO=? "
            + "where IDEST= ? ";

    private final String SQL_DELETE = "delete from estudiante "
            + "where IDEST = ? ";

    //---------------CONSULTAS-------------------
     //--------------------CRUD---------------
    public Estudiante getEstudiante(String codigo) {
        Estudiante bean = null;
        String sql = SQL_SELECT
                + "where IDEST = ? ";
        try {
            bean = jdbcTemplate.queryForObject(sql, new EstudianteMapper(), codigo);
        } catch (EmptyResultDataAccessException e) {
        }
        return bean;
    }

    public List<Estudiante> getEstudiantes(Estudiante bean) {
        List<Estudiante> lista;
        String sql = SQL_SELECT
                + "where APELLIDO like concat('%',?,'%') "                
                + "and NOMBRE like concat('%',?,'%') ";
        lista = jdbcTemplate.query(sql, new EstudianteMapper(),
                bean.getAPELLIDO(), bean.getNOMBRE());
        return lista;
    }

    @Transactional(propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void crear(Estudiante estudiante) {
        // Leer el contador
        String sql = "select int_contitem cont, int_contlongitud size "
                + "from contador "
                + "where vch_conttabla = 'estudiante' "
                + "for update";
        Map<String, Object> rec = jdbcTemplate.queryForMap(sql);
        int cont = Integer.parseInt(rec.get("cont").toString());
        int size = Integer.parseInt(rec.get("size").toString());

        System.out.println("CONT: " + cont);

        try {
            Thread.currentThread().sleep(2000);
        } catch (Exception e) {
        }

        // Generar Codigo
        cont++;
        String codigo = String.format("%" + size + "s", cont).replace(' ', '0');

        // Actualizar el contador
        sql = "update contador set int_contitem = ? "
                + "where vch_conttabla = 'estudiante'";
        jdbcTemplate.update(sql, cont);

        // Insertar empleado
        sql = "insert into estudiante(IDEST, APELLIDO, "
                + "NOMBRE, DNI, DIRECCION, "
                + "CORREO, APONOMBRE, "
                + "APOCORREO,APOTELEFONO ) "
                + "values(?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, codigo, estudiante.getAPELLIDO(), estudiante.getNOMBRE(),
                estudiante.getDNI(), estudiante.getDIRECCION(), estudiante.getCORREO(),
                estudiante.getAPONOMBRE(), estudiante.getAPOCORREO(), estudiante.getAPOTELEFONO());

        estudiante.setIDEST(codigo);

    }

     //------------------------------------------------------------------ACTUALIZAR
    @Transactional(propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void update(Estudiante estudiante) {

        int filas = jdbcTemplate.update(SQL_UPDATE, estudiante.getAPELLIDO(), estudiante.getNOMBRE(),
                estudiante.getDNI(), estudiante.getDIRECCION(), estudiante.getCORREO(),
                estudiante.getAPONOMBRE(), estudiante.getAPOCORREO(), estudiante.getAPOTELEFONO(), estudiante.getIDEST());

        if (filas != 1) {
            throw new RuntimeException("Error en el proceso.");
        }

    }
 //DELETE

    @Transactional(propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void delete(String codigo) {

        int filas = jdbcTemplate.update(SQL_DELETE, codigo);

        if (filas == 0) {
            throw new RuntimeException("El Laboratorio no existe.");
        }

    }
}
