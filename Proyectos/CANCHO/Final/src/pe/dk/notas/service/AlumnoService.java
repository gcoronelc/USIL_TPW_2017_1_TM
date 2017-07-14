package pe.dk.notas.service;



import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.dk.notas.model.Alumno;


@Service
public class AlumnoService extends AbstractJdbcSupport {
	
	
	
	
	private final String SQL_SELECT = "select " 
			+ "chr_alucodigo     codigo, " 
			+ "vch_alupaterno    paterno, "
			+ "vch_alumaterno    materno, " 
			+ "vch_alunombre     nombre, " 
			+ "chr_aludni        dni, "
			+ "vch_aluciudad     ciudad, " 
			+ "vch_aludireccion  direccion, " 
			+ "vch_alutelefono   telefono, "
			+ "vch_aluemail      email " 
			+ "from alumno ";
	
	private final String SQL_INSERT = "insert into "
	          + "alumno(chr_alucodigo,vch_alupaterno,"
	          + "vch_alumaterno,vch_alunombre,chr_aludni,"
	          + "vch_aluciudad,vch_aludireccion,"
	          + "vch_alutelefono,vch_aluemail) "
	          + "values(?,?,?,?,?,?,?,?,?)";
	
	
	private final String SQL_UPDATE = "update alumno set "
	          + "vch_alupaterno = ?,"
	          + "vch_alumaterno = ?,"
	          + "vch_alunombre = ?,"
	          + "chr_aludni = ?,"
	          + "vch_aluciudad = ?,"
	          + "vch_aludireccion = ?,"
	          + "vch_alutelefono = ?,"
	          + "vch_aluemail = ? "
	          + "where chr_alucodigo = ? ";
	
	private final String SQL_DELETE = "delete from alumno "
	          + "where chr_alucodigo = ? ";	
	
	public Alumno read(String codigo) {
		Alumno bean = null;
		try {
			String sql = SQL_SELECT 
					+ "where chr_alucodigo = ? ";
			bean = jdbcTemplate.queryForObject(sql, 
					new BeanPropertyRowMapper<Alumno>(Alumno.class),
					codigo);
		} catch (EmptyResultDataAccessException e) {
			
		}
		return bean;
	}

	public List<Alumno>read(Alumno bean) {
		String sql = SQL_SELECT 
				+ "where vch_alupaterno like concat('%',?,'%') "
				+ "or vch_alumaterno like concat('%',?,'%') " 
				+ "or vch_alunombre like concat('%',?,'%') ";
		List<Alumno> lista = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Alumno>(Alumno.class),
				bean.getPaterno(), bean.getMaterno(), bean.getNombre());
		return lista;
	}
	
	
	//Insertar Alumno
	
	  @Transactional(propagation = Propagation.REQUIRED,
	          rollbackFor = Exception.class)
	  public void crear(Alumno alumno) {
		    
		    // Leer el contador
		    String sql = "select int_contitem cont, int_contlongitud size "
		            + "from contador "
		            + "where vch_conttabla = 'Alumno' "
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
		    jdbcTemplate.update(SQL_INSERT, codigo, alumno.getPaterno(), 
		    		alumno.getMaterno(),alumno.getNombre(),alumno.getDni(),
		    		alumno.getCiudad(),alumno.getDireccion(),
		            alumno.getTelefono(),alumno.getEmail());
		    
		    alumno.setCodigo(codigo);
		    
		  }
	  
	  //Editar Alumno
	  
	  @Transactional(propagation = Propagation.REQUIRED,
	          rollbackFor = Exception.class)
	  public void update(Alumno alumno) {
	    
	    int filas = jdbcTemplate.update(SQL_UPDATE, alumno.getPaterno(), 
	    		alumno.getMaterno(),alumno.getNombre(),alumno.getDni(),
	    		alumno.getCiudad(),alumno.getDireccion(),
	    		alumno.getTelefono(),alumno.getEmail(), alumno.getCodigo());
	    
	    if( filas != 1){
	      throw new RuntimeException("Error en el proceso.");
	    }
	    
	  }
	  
	  
	  //Borrar Alumno
	  
	 /* @Transactional(propagation = Propagation.REQUIRED,
	          rollbackFor = Exception.class)
	  public void delete(String codigo) {
	    
	    // VERIFICAR CUENTAS DEL CLIENTE 
	    String sql="select count(1) from cuenta where chr_cliecodigo = ?";
	    
	    int cuentas = jdbcTemplate.queryForObject(sql, Integer.class,codigo);
	    
	    if(cuentas > 0)
	    {
	      throw new RuntimeException("El cliente no puede ser eliminado.");  
	    }
	    
	    int filas = jdbcTemplate.update(SQL_DELETE, codigo);
	    
	    if( filas == 0){
	      throw new RuntimeException("El cliente no existe.");
	    }
	    
	  }
	*/
	  
	  //Actualizar contraseña
	  public void updateclave(String nueva, String codigo) {
		  
		  String sql="update usuario set "
				  + "vch_emplclave = SHA(?) "
				  + "where chr_emplcodigo = ? ";
				  
		  
		  int filas = jdbcTemplate.update(sql, nueva, codigo);
		  if(filas == 0){
		        throw new RuntimeException("No es posible actualizar la contraseña.");
		      }
		  
		  
	  }
	  
	  
	
	
	
	

}
