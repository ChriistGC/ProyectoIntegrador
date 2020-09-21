/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.modelo;

/**
 *
 * @author kriz_
 */
public class Cliente {
    
    private int codigo;
    private String nombres;
    private String apellidos;
    private String cedula;
    private String telefono;
    private String direccion;
    private String correo;
    private String sexo;
    private String ciudad;
    
    private boolean nuevo;
    
    public boolean isNuevo() {
        return nuevo;
    }

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }
    
    public Cliente(int codigo, String nombres, String apellidos, String cedula, String telefono, String direccion,String correo,String sexo,String ciudad) {
        this.setCodigo(codigo);
        this.setNombres(nombres);
        this.setApellidos(apellidos);
        this.setCedula(cedula);
        this.setTelefono(telefono);
        this.setDireccion(direccion);
        this.setCorreo(correo);
        this.setSexo(sexo);
        this.setCiudad(ciudad);
    }

    public Cliente() {
        this.setCodigo(0);
        this.setNombres(null);
        this.setApellidos(null);
        this.setCedula(null);
        this.setTelefono(null);
        this.setDireccion(null);
        this.setCorreo(null);
        this.setSexo(null);
        this.setCiudad(null);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    @Override
    public String toString() {
        return "Cliente{"+"Codigo"+codigo + "Nombres=" + getNombres() + ", Apellidos=" + getApellidos() + ", Cedula=" + getCedula() + ", Telefono=" + getTelefono() + ", Direccion=" + getDireccion() + ", Correo=" + getCorreo() + ", Sexo=" + getSexo() + ", Ciudad=" + getCiudad() + '}';
    }
}
