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
public class Login {
    
    private int idUsuario;
    private int idEmpleado;
    private String Usuario;
    private String Contraseña;
    
    public Login(){}
    public Login(int idUsuario,int idEmpleado, String Usuario, String Contraseña){
        this.setIdUsuario(idUsuario);
        this.setIdEmpleado(idEmpleado);
        this.setUsuario(Usuario);
        this.setContraseña(Contraseña);
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
}
