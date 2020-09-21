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
    private int idAdmin;
    private int idAgenVenta;
    private String Usuario;
    private String Contraseña;
    
    public Login(){}
    public Login(int idUsuario,int idAdmin, int idAgenVenta, String Usuario, String Contraseña){
        this.setIdUsuario(idUsuario);
        this.setIdAdmin(idAdmin);
        this.setIdAgenVenta(idAgenVenta);
        this.setUsuario(Usuario);
        this.setContraseña(Contraseña);
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getIdAgenVenta() {
        return idAgenVenta;
    }

    public void setIdAgenVenta(int idAgenVenta) {
        this.idAgenVenta = idAgenVenta;
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
