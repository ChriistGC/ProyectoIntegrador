/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pis;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import re.dao.ActividadDAO;
import re.dao.DAOException;
import reg.modelo.Actividad;

/**
 *
 * @author Astaroth
 */
public class Actividadempleado extends AbstractTableModel{
    private ActividadDAO act;
    private List<Actividad> datos = new ArrayList<>();

    


    Actividadempleado(ActividadDAO actividadDAO) {
        this.act = actividadDAO;
    }

    
 

    public void updateModel() throws DAOException {
        datos = act.obtenerTodos();
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "idEmpleado";
            case 1:
                return "Estado";
            case 2:
                return "Tipo de Actividad";
            case 3:
                return "Fecha de Actividad";
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
        Actividad act = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return act.getId_empleado();
            case 1:
                return act.getEstado();
            case 2:
                return act.getTipoactividad();
            case 3:
                return act.getFechaactividad();
            default:
                return "";
        }
    }



}
