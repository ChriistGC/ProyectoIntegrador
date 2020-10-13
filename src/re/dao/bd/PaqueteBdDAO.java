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
import javax.swing.JOptionPane;
import re.dao.DAOException;
import re.dao.PaqueteDAO;
import reg.modelo.Paquete;

/**
 *
 * @author kriz_
 */
public class PaqueteBdDAO implements PaqueteDAO{
    
    final String INSERT = "INSERT INTO paquete_viaje(id_paquete, id_region, direccion, presupuesto, tipo, lugarturistico, ciudad) values(?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE paquete_viaje SET id_paquete = ?, id_region = ?, direccion = ?, presupuesto = ?, tipo = ?, lugarturistico = ?, ciudad = ? where id_paquete=? ";
    final String DELETE = "DELETE FROM paquete_viaje where id_paquete=? ";
    final String GETALL = "SELECT * FROM paquete_viaje where id_region=?";
    final String GET0NE = "SELECT * FROM paquete_viaje where id_paquete=?";

    private Connection conn;

    public PaqueteBdDAO(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void insertar(Paquete a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(INSERT);
            stmt.setInt(1, a.getId_paquete());
            stmt.setInt(2, a.getId_region());
            stmt.setString(3, a.getDireccion());
            stmt.setDouble(4, a.getPresupuesto());
            stmt.setString(5, a.getTipo());
            stmt.setString(6, a.getLugarturistico());
            stmt.setString(7, a.getCiudad());

            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            Logger.getLogger(PaqueteBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(PaqueteBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void modificar(Paquete a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            stmt = conn.prepareStatement(UPDATE);
            stmt.setInt(1, a.getId_paquete());
            stmt.setInt(2, a.getId_region());
            stmt.setString(3, a.getDireccion());
            stmt.setDouble(4, a.getPresupuesto());
            stmt.setString(5, a.getTipo());
            stmt.setString(6, a.getLugarturistico());
            stmt.setString(7, a.getCiudad());
            stmt.setInt(8, a.getId_paquete());

            if (stmt.executeUpdate() == 0) {
                throw new DAOException("El registro no se ha modificado");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(PaqueteBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(PaqueteBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void eliminar(Integer a) throws DAOException { }

    @Override
    public Paquete obtener(Integer id) throws DAOException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paquete pq = null;
        try {
            stmt = conn.prepareStatement(GET0NE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                pq = convertir(rs);
            } else {
                JOptionPane.showMessageDialog(null, "No hay seleccionado un paquete turistico", "Sistema", JOptionPane.ERROR_MESSAGE);
//                throw new DAOException("No se encontro el registro");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return pq;
    }
    
    private Paquete convertir(ResultSet rs) throws SQLException { //Java: JDBC – 14
        int idPaquete = rs.getInt("id_paquete");
        int idRegion = rs.getInt("id_region");
        String direccion = rs.getString("direccion");
        double presupuesto = rs.getDouble("presupuesto");
        String tipo = rs.getString("tipo");
        String lugarturistico = rs.getString("lugarturistico");
        String ciudad = rs.getString("ciudad");
        Paquete cl = new Paquete(idPaquete, idRegion, direccion, presupuesto, tipo, lugarturistico, ciudad);
        cl.setId_paquete(rs.getInt("id_paquete"));//revisar
        return cl;

    }

    @Override
    public List<Paquete> obtenerTodos() throws DAOException {return null;}

    @Override
    public List<Paquete> obtenerLista(Integer a) throws DAOException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Paquete> pq = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(GETALL);
            stmt.setInt(1, a);
            rs = stmt.executeQuery();
            while (rs.next()) {
                pq.add(convertir(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaqueteBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(PaqueteBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return pq;
    }

    @Override
    public Paquete obtenerUser(String user) throws DAOException {return null;}
    
}
