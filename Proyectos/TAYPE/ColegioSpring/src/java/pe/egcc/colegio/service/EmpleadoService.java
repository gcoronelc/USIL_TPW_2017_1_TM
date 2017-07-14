package pe.egcc.colegio.service;

import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.egcc.colegio.model.Empleado;
import pe.egcc.colegio.Mapper.EmpleadoMapper;

@Service
public class EmpleadoService extends AbstractJdbcSupport {

    private final String SQL_SELECT = "select "
            + "IDEMP      IDEMP, "
            + "NOMBRE     NOMBRE, "
            + "APELLIDO   APELLIDO, "
            + "dni        dni, "
            + "DIRECCION  DIRECCION, "
            + "TELEFONO   TELEFONO, "
            + "CORREO     CORREO, "
            + "ESTADO     ESTADO "
            + "from empleado ";

    private final String SQL_UPDATE = "update empleado set "
            + "NOMBRE= ?, "
            + "APELLIDO= ?, "
            + "dni= ?, "
            + "DIRECCION= ?, "
            + "TELEFONO= ?, "
            + "CORREO= ?, "
            + "ESTADO= ? "
            + "where IDEMP= ? ";

    private final String SQL_DELETE = "delete from empleado "
            + "where IDEMP = ? ";

    //---------------CONSULTAS-------------------
    
        public List<Empleado> conEmpleados1(String nombre, String apellidos) {
        List<Empleado> lista;
        String sql = SQL_SELECT 
                + "where NOMBRE like concat('%',?,'%')  "
                + "and APELLIDO like concat('%',?,'%') ";
        lista = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Empleado.class), nombre, apellidos);
        return lista;
    }
      public List<Map<String, Object>> conEmpleado1(String criterio) {
    List<Map<String, Object>> lista;
    String sql = SQL_SELECT
            + "where IDEMP   like ? \n"
            + "or    APELLIDO   like ? \n"
            + "or    NOMBRE    like ?";
    criterio = "%" + criterio.trim() + "%";
    lista = jdbcTemplate.queryForList(sql, criterio, criterio, criterio);
    return lista;
  }
      
        public List<Empleado> conEmpleado2(String criterio) {
    List<Empleado> lista = null;
    String sql = SQL_SELECT
            + "where APELLIDO   like ? \n"
            + "or    NOMBRE   like ? \n"
            + "or    dni    like ?";
    criterio = "%" + criterio.trim() + "%";
    lista = jdbcTemplate.query(sql, 
            new BeanPropertyRowMapper(Empleado.class), 
            criterio, criterio, criterio);
    return lista;
  }
        
     public List<Empleado> conEmpleado3(String sucursal) {
    List<Empleado> lista = null;
    String sql = SQL_SELECT
            + "where IDEST in "
            + "( select IDEST from permiso where chr_sucucodigo=? ) ";
    lista = jdbcTemplate.query(sql, 
            new BeanPropertyRowMapper(Empleado.class), sucursal);
    return lista;
  }     
    //--------------------CRUD---------------
    public Empleado getEmpleado(String codigo) {
        Empleado bean = null;
        String sql = SQL_SELECT
                + "where IDEMP = ? ";
        try {
            bean = jdbcTemplate.queryForObject(sql, new EmpleadoMapper(), codigo);
        } catch (EmptyResultDataAccessException e) {
        }
        return bean;
    }

    public List<Empleado> getEmpleados(Empleado bean) {
        List<Empleado> lista;
        String sql = SQL_SELECT
                + "where APELLIDO like concat('%',?,'%') "                
                + "and NOMBRE like concat('%',?,'%') ";
        lista = jdbcTemplate.query(sql, new EmpleadoMapper(),
                bean.getAPELLIDO(), bean.getNOMBRE());
        return lista;
    }

    @Transactional(propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void crear(Empleado empleado) {
        // Leer el contador
        String sql = "select int_contitem cont, int_contlongitud size "
                + "from contador "
                + "where vch_conttabla = 'empleado' "
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
                + "where vch_conttabla = 'empleado'";
        jdbcTemplate.update(sql, cont);

        // Insertar empleado
        sql = "insert into empleado(IDEMP, NOMBRE, "
                + "APELLIDO, dni, DIRECCION, "
                + "TELEFONO, CORREO, "
                + "ESTADO ) "
                + "values(?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, codigo, empleado.getNOMBRE(), empleado.getAPELLIDO(),
                empleado.getDni(), empleado.getDIRECCION(), empleado.getTELEFONO(),
                empleado.getCORREO(), empleado.getESTADO());

        empleado.setIDEMP(codigo);

    }

     //------------------------------------------------------------------ACTUALIZAR
    @Transactional(propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void update(Empleado empleado) {

        int filas = jdbcTemplate.update(SQL_UPDATE, empleado.getNOMBRE(), empleado.getAPELLIDO(),
                empleado.getDni(), empleado.getDIRECCION(),empleado.getTELEFONO(), empleado.getCORREO(), 
                empleado.getESTADO(), empleado.getIDEMP());

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
