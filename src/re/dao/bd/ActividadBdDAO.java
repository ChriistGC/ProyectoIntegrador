/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package re.dao.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import re.dao.ActividadDAO;
import re.dao.DAOException;
import reg.modelo.Actividad;

/**
 *
 * @author kriz_
 */
public class ActividadBdDAO implements ActividadDAO {

    final String INSERT = "INSERT INTO registro_actividades(id_registro, id_usuario, id_empleado, estado, tipoactividad, fechaactividad) values(?,?,?,?,?,?)";
    final String UPDATE = "UPDATE registro_actividades SET id_registro = ?, id_usuario = ?, id_empleado=?, estado = ?, tipoactividad = ?, fechaactividad = ? where id_usuario= ? ";
    final String DELETE = "DELETE FROM registro_actividades where id_usuario=?";
    final String GETALL = "SELECT * FROM registro_actividades";
    final String GET0NE = "SELECT * FROM registro_actividades where id_registro=?";

    private Connection conn;

    public ActividadBdDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Actividad a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(INSERT);
            stmt.setInt(1, a.getId_registro());
            if (a.getId_usuario() != 0) {
                stmt.setInt(2, a.getId_usuario());
            } else {
                stmt.setString(2, null);
            }
            if (a.getId_empleado() != 0) {
                stmt.setInt(3, a.getId_empleado());
            } else {
                stmt.setString(3, null);
            }
            stmt.setString(4, a.getEstado());
            stmt.setString(5, a.getTipoactividad());
            stmt.setString(6, a.getFechaactividad());

            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            Logger.getLogger(ActividadBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ActividadBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void modificar(Actividad a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(UPDATE);
            stmt.setInt(1, a.getId_registro());
            stmt.setInt(2, a.getId_usuario());
            stmt.setInt(3, a.getId_empleado());
            stmt.setString(4, a.getEstado());
            stmt.setString(5, a.getTipoactividad());
            stmt.setString(6, a.getFechaactividad());
            stmt.setInt(7, a.getId_usuario());

            if (stmt.executeUpdate() == 0) {
                throw new DAOException("El registro no se ha modificado");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ActividadBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ActividadBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void eliminar(Integer a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, a);

            if (stmt.executeUpdate() == 0) {
                throw new DAOException("El registro no se ha borrado");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ActividadBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ActividadBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Actividad> obtenerTodos() throws DAOException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Actividad> act = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(GETALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                act.add(convertir(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ActividadBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ActividadBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return act;
    }

    @Override
    public Actividad obtener(Integer id) throws DAOException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Actividad act = null;
        try {
            stmt = conn.prepareStatement(GET0NE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                act = convertir(rs);
            } else {
//                throw new DAOException("No se encontro el registro");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ActividadBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ActividadBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return act;
    }

    @Override
    public List<Actividad> obtenerLista(Integer a) throws DAOException {
        return null;
    }

    @Override
    public Actividad obtenerUser(String user) throws DAOException {
        return null;
    }

    private Actividad convertir(ResultSet rs) throws SQLException { //Java: JDBC – 14
        int idRegistro = rs.getInt("id_registro");
        int idUsuario = rs.getInt("id_usuario");
        int idEmpleado = rs.getInt("id_empleado");
        String estado = rs.getString("estado");
        String tipoActividad = rs.getString("tipoactividad");
        String fechaActividad = rs.getString("fechaactividad");
        Actividad act = new Actividad(idRegistro, idUsuario, idEmpleado, estado, tipoActividad, fechaActividad);
        act.setId_usuario(rs.getInt("id_usuario"));//revisar
        return act;
    }
}
