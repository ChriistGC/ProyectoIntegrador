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
import re.dao.PaqueteDAO;
import reg.modelo.Paquete;

/**
 *
 * @author kriz_
 */
public class PaqueteTableModel extends AbstractTableModel {

    private PaqueteDAO paquete;
    private double presupuesto;
    private List<Paquete> datos = new ArrayList<>();

    public PaqueteTableModel(PaqueteDAO paquete) {
        this.paquete = paquete;
    }

    public void updateModel(int id_region) throws DAOException {
        datos = paquete.obtenerLista(id_region);
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "Id Paquete";
            case 1:
                return "Id Region";
            case 2:
                return "Direccion";
            case 3:
                return "Presupuesto";
            case 4:
                return "Tipo";
            case 5:
                return "Lugar Turistico";
            case 6:
                return "Ciudad";
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
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Paquete pq = datos.get(rowIndex);
        Object resp = null;
        if (pq.getPresupuesto()<=getPresupuesto()) {
            switch (columnIndex) {
                case 0:
                    resp = pq.getId_paquete();
                    break;
                case 1:
                    resp = pq.getId_region();
                    break;
                case 2:
                    resp = pq.getDireccion();
                    break;
                case 3:
                    resp = pq.getPresupuesto();
                    break;
                case 4:
                    resp = pq.getTipo();
                    break;
                case 5:
                    resp = pq.getLugarturistico();
                    break;
                case 6:
                    resp = pq.getCiudad();
                    break;
                default:
                    resp = "";
                    break;
            }

        }
        return resp;
    }
}
