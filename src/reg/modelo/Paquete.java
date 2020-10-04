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
public class Paquete {
    
    private int id_paquete;
    private int id_region;
    private String direccion;
    private double presupuesto;
    private String tipo;
    private String lugarturistico;
    private String ciudad;

    public Paquete(int id_paquete, int id_region, String direccion, double presupuesto, String tipo, String lugarturistico, String ciudad) {
        this.id_paquete = id_paquete;
        this.id_region = id_region;
        this.direccion = direccion;
        this.presupuesto = presupuesto;
        this.tipo = tipo;
        this.lugarturistico = lugarturistico;
        this.ciudad = ciudad;
    }

    public Paquete() {}

    public int getId_paquete() {
        return id_paquete;
    }

    public void setId_paquete(int id_paquete) {
        this.id_paquete = id_paquete;
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLugarturistico() {
        return lugarturistico;
    }

    public void setLugarturistico(String lugarturistico) {
        this.lugarturistico = lugarturistico;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    @Override
    public String toString() {
        return "paquete_viaje{" + "id_paquete=" + String.valueOf(getId_paquete())+ ",id_region=" + String.valueOf(getId_region())+ ",direccion="
                +getDireccion() + ", presupuesto=" + String.valueOf(getPresupuesto()) + ", tipo=" + getTipo() + ", lugarturistico=" + getLugarturistico() 
                +",ciudad="+getCiudad()+ '}';
    }  
    
    
}
