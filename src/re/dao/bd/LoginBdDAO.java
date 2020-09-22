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
import re.dao.LoginDAO;
import reg.modelo.Login;

/**
 *
 * @author kriz_
 */
public class LoginBdDAO implements LoginDAO{
    
    final String INSERT = "INSERT INTO login(id_usuario, id_administrador, id_agente, usuario, contrasena) values(?,?,?,?,?,?)";
    final String UPDATE = "UPDATE login SET id_usuario = ?, id_administrador = ?, id_agente = ?, usuario = ?, contrasena = ? where id_usuario= ? ";
    final String DELETE = "DELETE FROM login where id_usuario=?";
    final String GETALL = "SELECT * FROM login";
    final String GET0NE = "SELECT * FROM login where usuario=?";
    
    private Connection conn;
    
    public LoginBdDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Login a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(INSERT);
            stmt.setInt(1, a.getIdUsuario());
            stmt.setInt(2, a.getIdAdmin());
            stmt.setInt(3, a.getIdAgenVenta());
            stmt.setString(4, a.getUsuario());
            stmt.setString(5, a.getContraseña());

            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void modificar(Login a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(UPDATE);
            stmt.setInt(1, a.getIdUsuario());
            stmt.setInt(2, a.getIdAdmin());
            stmt.setInt(3, a.getIdAgenVenta());
            stmt.setString(4, a.getUsuario());
            stmt.setString(5, a.getContraseña());
            stmt.setInt(6, a.getIdUsuario());

            if (stmt.executeUpdate() == 0) {
                throw new DAOException("El registro no se ha modificado");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void eliminar(Login a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, a.getIdUsuario());

            if (stmt.executeUpdate() == 0) {
                throw new DAOException("El registro no se ha borrado");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Login> obtenerTodos() throws DAOException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Login> log = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(GETALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                log.add(convertir(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return log;
    }

    @Override
    public Login obtener(Integer id) throws DAOException {return null;}
    
    @Override
    public Login obtenerUser(String usuario) throws DAOException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Login log = null;
        try {
            stmt = conn.prepareStatement(GET0NE);
            stmt.setString(1, usuario);
            rs = stmt.executeQuery();
            if (rs.next()) {
                log = convertir(rs);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado. Intente nuevamente", "Sistema", JOptionPane.ERROR_MESSAGE);
//                throw new DAOException("No se encontro el registro");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return log;
    }
    
    private Login convertir(ResultSet rs) throws SQLException { //Java: JDBC – 14
        int idUsuario=rs.getInt("id_usuario");
        int idAdmin=rs.getInt("id_administrador");
        int idAgenVenta=rs.getInt("id_agente");
        String usuario=rs.getString("usuario");
        String contraseña=rs.getString("contrasena");
        Login log = new Login(idUsuario, idAdmin, idAgenVenta, usuario, contraseña);
        log.setIdUsuario(rs.getInt("id_usuario"));//revisar
        return log;
    }
    
}
