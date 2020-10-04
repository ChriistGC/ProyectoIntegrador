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
public class DetalleFactura {
    
    private int idUsuario;
    private int idEmpleado;
    private int idPaquete;
    private int idFactura;

    public DetalleFactura() {}

    public DetalleFactura(int idUsuario, int idEmpleado, int idPaquete, int idFactura) {
        this.idUsuario = idUsuario;
        this.idEmpleado = idEmpleado;
        this.idPaquete = idPaquete;
        this.idFactura = idFactura;
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

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
    
    @Override
    public String toString() {
        return "detalle_factura{" + "id_usuario" + String.valueOf(getIdUsuario()) + ", id_empleado" + String.valueOf(getIdEmpleado()) + ", id_paquete="
                + String.valueOf(getIdPaquete()) + ", id_factura" + String.valueOf(getIdFactura()) +'}';
    }
    
}
