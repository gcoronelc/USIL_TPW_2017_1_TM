package pe.egcc.colegio.model;

import java.io.Serializable;

public class Empleado implements Serializable {

    private static final long serialVersionUID = 6086247716333627610L;

    
   //------------------------------------COLEGIO
        //EMPLEADO
private String IDEMP;
private String NOMBRE;
private String APELLIDO;
private String dni;
private String DIRECCION;
private String TELEFONO;
private String CORREO;
private int ESTADO;

             //USUARIO;
//private String idemp;
    private String usuario;
    private String clave;
    private String estado;
          //PERMISO;
//private String  idemp;
    private String int_moducodigo;
    private String vch_permestado;
   //MODULO;
//private String int_moducodigo;
    private int vch_modunombre;
    private String vch_moduestado;


    public Empleado() {
    }

    public String getIDEMP() {
        return IDEMP;
    }

    public void setIDEMP(String IDEMP) {
        this.IDEMP = IDEMP;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(String APELLIDO) {
        this.APELLIDO = APELLIDO;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }



    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getInt_moducodigo() {
        return int_moducodigo;
    }

    public void setInt_moducodigo(String int_moducodigo) {
        this.int_moducodigo = int_moducodigo;
    }

    public String getVch_permestado() {
        return vch_permestado;
    }

    public void setVch_permestado(String vch_permestado) {
        this.vch_permestado = vch_permestado;
    }

    public int getVch_modunombre() {
        return vch_modunombre;
    }

    public void setVch_modunombre(int vch_modunombre) {
        this.vch_modunombre = vch_modunombre;
    }

    public String getVch_moduestado() {
        return vch_moduestado;
    }

    public void setVch_moduestado(String vch_moduestado) {
        this.vch_moduestado = vch_moduestado;
    }

}
