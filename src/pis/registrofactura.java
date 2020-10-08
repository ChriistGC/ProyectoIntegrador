/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pis;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import re.dao.DAOException;
import re.dao.FacturaDAO;
import reg.modelo.Factura;

/**
 *
 * @author Astaroth
 */
public class registrofactura  extends AbstractTableModel{
    private FacturaDAO fact;
    private List<Factura> datos = new ArrayList<>();

    public registrofactura(FacturaDAO fact) {
        this.fact = fact;
    }
    public void updateModel() throws DAOException {
        datos = fact.obtenerTodos();
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "idFactura";
            case 1:
                return "Fechaventa";
            case 2:
                return "MetodosPago";
            case 3:
                return "Total";
            default:
                return "[no]";
        }

    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Factura act = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return act.getIdFactura();
            case 1:
                return act.getFechaVenta();
            case 2:
                return act.getTotal();
            case 3:
                return act.getMtdoPago();
            default:
                return "";
        }
    }



}

    
    
    
    

