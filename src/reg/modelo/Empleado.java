
package reg.modelo;

/**
 *
 * @author Astaroth
 */
public class Empleado {
    private int cod_empleado;//Variable entera para el codigo
    private String nombres;//Variable String para el ingreso de los nombres(Varchar2)
    private String apellidos;//Variable String para el ingreso de los apellidos(Varchar2)
    private String cargo;
    private String cedula;//Variable String para el ingreso de la cedula(Varchar2)
    private String telefono;//Variable String para el ingreso del telefono(Varchar2)
    private String direccion;//Variable String para el ingreso de la direccion(Varchar2)
    private String correo;//Variable String para el ingreso del correo(Varchar2)
    private String sexo;//Variable String para el ingreso del sexo(Varchar2)
    private String ciudad;//Variable String para el ingreso de la ciudad(Varchar2)
    
    private boolean nuevo;//Variable boleana por si se llega a contratar a un nuevo empleado 
    
    public boolean isNuevo() {//Por si existe un nuevo empleado
        return nuevo;
    }

    public Empleado() { //Constructor sin parametros
    }

    public Empleado(int cod_empleado, String nombres, String apellidos, String cargo, String cedula, String telefono, String direccion, String correo, String sexo, String ciudad) {//Constructor con parametros
        this.cod_empleado = cod_empleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.sexo = sexo;
        this.ciudad = ciudad;
        
    }
    //Incorporacion de los metodos setter and getter

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(int cod_empleado) {
        this.cod_empleado = cod_empleado;
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
        return "empleado{"+"iD del empleado"+String.valueOf(this.cod_empleado)+"Nombres=" + getNombres() + ", Apellidos=" +", Cargo="+getCargo()+
                getApellidos() + ", Cedula=" + getCedula() + ", Telefono=" + getTelefono() + ", Direccion=" + 
                getDireccion() + ", Correo=" + getCorreo() + ", Sexo=" + getSexo() + ", Ciudad=" + getCiudad() + '}';}
    
}
