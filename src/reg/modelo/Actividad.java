/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.modelo;

import java.sql.Date;


/**
 *
 * @author kriz_
 */
public class Actividad {
    
    private int id_registro;
    private int id_usuario;
    private int id_empleado;
    private String estado;
    private String tipoactividad;
    private String fechaactividad;

    public Actividad() {}

    public Actividad(int id_registro, int id_usuario, int id_empleado, String estado, String tipoactividad, String fechaactividad) {
        this.id_registro = id_registro;
        this.id_usuario = id_usuario;
        this.id_empleado = id_empleado;
        this.estado = estado;
        this.tipoactividad = tipoactividad;
        this.fechaactividad = fechaactividad;
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoactividad() {
        return tipoactividad;
    }

    public void setTipoactividad(String tipoactividad) {
        this.tipoactividad = tipoactividad;
    }

    public String getFechaactividad() {
        return fechaactividad;
    }

    public void setFechaactividad(String fechaactividad) {
        this.fechaactividad = fechaactividad;
    }
        
    @Override
    public String toString() {
        return "registro_actividades{" + "id_registro=" + String.valueOf(getId_registro())+ ",id_usuario=" + String.valueOf(getId_usuario())+ ",id_empleado=" + String.valueOf(getId_empleado())+",estado="
                + getEstado() + ", tipoactividad="+ getTipoactividad() + ", fechaactividad=" + getFechaactividad() + '}';
    }
    
}
