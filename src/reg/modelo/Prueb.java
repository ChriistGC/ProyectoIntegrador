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
public class Prueb {

    private int codigo;
    private String nombres;

    public Prueb(int codigo, String nombres) {
        this.codigo = codigo;
        this.nombres = nombres;
    }

    public Prueb() {}

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
    
    @Override
    public String toString() {
        return "Usuario{" + "Codigo" + String.valueOf(this.codigo) + "Nombres=" + getNombres() + '}';
    } 
    
    
}
