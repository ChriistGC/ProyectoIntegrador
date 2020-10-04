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
public class Factura {
    
    private int idFactura;
    private String fechaVenta; 
    private String fechaViaje; 
    private String mtdoPago; 
    private int interesPago; 
    private int IVA; 
    private double total;

    public Factura() {}

    public Factura(int idFactura, String fechaVenta, String fechaViaje, String mtdoPago, int interesPago, int IVA, double total) {
        this.idFactura = idFactura;
        this.fechaVenta = fechaVenta;
        this.fechaViaje = fechaViaje;
        this.mtdoPago = mtdoPago;
        this.interesPago = interesPago;
        this.IVA = IVA;
        this.total = total;
    }         

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(String fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public String getMtdoPago() {
        return mtdoPago;
    }

    public void setMtdoPago(String mtdoPago) {
        this.mtdoPago = mtdoPago;
    }

    public int getInteresPago() {
        return interesPago;
    }

    public void setInteresPago(int interesPago) {
        this.interesPago = interesPago;
    }

    public int getIVA() {
        return IVA;
    }

    public void setIVA(int IVA) {
        this.IVA = IVA;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    @Override
    public String toString() {
        return "factura{" + "id_factura" + String.valueOf(getIdFactura()) + ",fechaventa=" + getFechaVenta() + ", fechaviaje="
                + getFechaViaje() + ", metodopago=" + getMtdoPago() + ", interespago=" + getInteresPago() + ", IVA="
                + getIVA() + ", total=" + getTotal() + '}';
    }
    
}
