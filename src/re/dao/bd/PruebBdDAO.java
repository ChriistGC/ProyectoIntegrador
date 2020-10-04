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
import re.dao.DAOException;
import re.dao.PruebDAO;
import reg.modelo.Prueb;

/**
 *
 * @author kriz_
 */
public class PruebBdDAO implements PruebDAO{
    
    final String INSERT = "INSERT INTO prueba(id_prueba, fecha) values(?,?)";
    final String UPDATE = "UPDATE prueba SET id_prueba = ?, fecha = ? where id_prueba= ? ";
    final String DELETE = "DELETE FROM prueba where id_prueba=?";
    final String GETALL = "SELECT * FROM prueba";
    final String GET0NE = "SELECT * FROM prueba where id_prueba=?";
    
    private Connection conn;
    
    public PruebBdDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Prueb a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(INSERT);
            stmt.setInt(1, a.getCodigo());
            stmt.setString(2, a.getNombres());

            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            Logger.getLogger(PruebBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(PruebBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void modificar(Prueb a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(UPDATE);
            stmt.setInt(1, a.getCodigo());
            stmt.setString(2, a.getNombres());
            stmt.setInt(5, a.getCodigo());

            if (stmt.executeUpdate() == 0) {
                throw new DAOException("El registro no se ha modificado");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(PruebBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(PruebBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void eliminar(Prueb a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, a.getCodigo());

            if (stmt.executeUpdate() == 0) {
                throw new DAOException("El registro no se ha borrado");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(PruebBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(PruebBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Prueb> obtenerTodos() throws DAOException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Prueb> prueba = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(GETALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                prueba.add(convertir(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PruebBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(PruebBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return prueba;
    }

    @Override
    public List<Prueb> obtenerLista(Integer a) throws DAOException { return null;}

    @Override
    public Prueb obtener(Integer id) throws DAOException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Prueb prueba = null;
        try {
            stmt = conn.prepareStatement(GET0NE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                prueba = convertir(rs);
            } else {
                throw new DAOException("No se encontro el registro");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PruebBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(PruebBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return prueba;
    }

    @Override
    public Prueb obtenerUser(String user) throws DAOException {return null;}
    
    private Prueb convertir(ResultSet rs) throws SQLException { //Java: JDBC – 14
        int idPrueba=rs.getInt("id_prueba");
        String fecha=rs.getString("fecha");
        Prueb prueba = new Prueb(idPrueba, fecha);
        prueba.setCodigo(rs.getInt("id_usuario"));//revisar
        return prueba;
    }
    
}
