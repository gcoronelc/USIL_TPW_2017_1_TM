package pe.dk.notas.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.dk.notas.model.Empleado;


@Service
public class EmpleadoService extends AbstractJdbcSupport{

	private final String SQL_SELECT = "select "
			+ "chr_emplcodigo     codigo, "
			+ "vch_emplpaterno    paterno, "
			+ "vch_emplmaterno    materno, "
			+ "vch_emplnombre     nombre, "
			+ "vch_emplciudad     ciudad, "
			+ "vch_empldireccion  direccion "
			+ "from empleado ";
	
	
	private final String SQL_INSERT = "insert into "
	          + "empleado(chr_emplcodigo,vch_emplpaterno, "
	          + "vch_emplmaterno,vch_emplnombre, "
	          + "vch_emplciudad,vch_empldireccion) "
	          + "values(?,?,?,?,?,?)";
	
	public Empleado read(String codigo) {
		Empleado bean = null;
		try {
			String sql = SQL_SELECT 
					+ "where chr_emplcodigo = ? ";
			bean = jdbcTemplate.queryForObject(sql, 
					new BeanPropertyRowMapper<Empleado>(Empleado.class),
					codigo);
		} catch (EmptyResultDataAccessException e) {
			
		}
		return bean;
	}

	public List<Empleado>read(Empleado bean) {
		String sql = SQL_SELECT 
				+ "where vch_emplpaterno like concat('%',?,'%') "
				+ "or vch_emplmaterno like concat('%',?,'%') " 
				+ "or vch_emplnombre like concat('%',?,'%') ";
		List<Empleado> lista = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Empleado>(Empleado.class),
				bean.getPaterno(), bean.getMaterno(), bean.getNombre());
		return lista;
	}
	
	//Insertar nuevo Empleado
	
	@Transactional(propagation = Propagation.REQUIRED,
	          rollbackFor = Exception.class)
	  public void crear(Empleado empleado) {
		    
		    // Leer el contador
		    String sql = "select int_contitem cont, int_contlongitud size "
		            + "from contador "
		            + "where vch_conttabla = 'Empleado' "
		            + "for update";
		    Map<String,Object> rec = jdbcTemplate.queryForMap(sql);
		    int cont = Integer.parseInt(rec.get("cont").toString());
		    int size = Integer.parseInt(rec.get("size").toString());
		    
		    // Generar Codigo
		    cont++;
		    String codigo = String.format("%" + size + "s", cont).replace(' ', '0' );
		    
		    // Actualizar el contador
		    sql = "update contador set int_contitem = ? "
		            + "where vch_conttabla = 'Alumno'";
		    jdbcTemplate.update(sql, cont);
		    
		    // Insertar cliente
		    jdbcTemplate.update(SQL_INSERT, codigo, empleado.getPaterno(), 
		    		empleado.getMaterno(),empleado.getNombre(),
		    		empleado.getCiudad(),empleado.getDireccion());
		           	    
		    empleado.setCodigo(codigo);
		    
		  }
	
	
	public Empleado validar(String usuario, String clave){
		Empleado bean = null;
		try {
			String sql = SQL_SELECT 
					+ "where chr_emplcodigo = ("
					+ "select chr_emplcodigo from usuario "
					+ "where vch_emplusuario = ? "
					+ "and vch_emplclave = SHA(?)) ";
			bean = jdbcTemplate.queryForObject(sql, 
					new BeanPropertyRowMapper<Empleado>(Empleado.class), 
					usuario, clave);
			
			
		} catch (EmptyResultDataAccessException e) {
		}
		return bean;
	}
	
	
	public Map<String, String> leerPermisos(String codEmp){
		
		Map<String, String> permisos = new HashMap<>();
		
		// Recupero la lista
		String sql = "select int_moducodigo cod, vch_permestado estado "
				+ "from permiso where chr_emplcodigo = ?";
		List<Map<String,Object>> lista = jdbcTemplate.queryForList(sql, codEmp);
		
		// Pasar la lista a un Map
		for (Map<String, Object> map : lista) {
			permisos.put(
					"op" + map.get("cod").toString(), 
					map.get("estado").toString());
		}
		
		return permisos;
	}
	
	
}
