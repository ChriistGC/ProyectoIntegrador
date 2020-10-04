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
import re.dao.EmpleadoDAO;
import reg.modelo.Empleado;

/**
 *
 * @author Astaroth
 */
public class EmpleadoBdDAO implements EmpleadoDAO {
    final String INSERT = "INSERT INTO empleado(id_empleado, nombres, apellidos, cargo, cedula, telefono, direccion, correo, sexo, ciudad) values(?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE empleado SET id_empleado = ?, nombres = ?, apellidos = ?,cargo = ?, cedula = ?, telefono = ?, direccion = ?, correo = ?, sexo = ?, ciudad = ? where id_empleado=? ";
    final String DELETE = "DELETE FROM empleado where id_empleado=? ";
    final String GETALL = "SELECT * FROM empleado";
    final String GET0NE = "SELECT * FROM empleado where id_empleado=?";

    private Connection conn;

    public EmpleadoBdDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Empleado a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(INSERT);
            stmt.setInt(1, a.getCod_empleado());
            stmt.setString(2, a.getNombres());
            stmt.setString(3, a.getApellidos());
            stmt.setString(4, a.getCargo());
            stmt.setString(5, a.getCedula());
            stmt.setString(6, a.getTelefono());
            stmt.setString(7, a.getDireccion());
            stmt.setString(8, a.getCorreo());
            stmt.setString(9, a.getSexo());
            stmt.setString(10, a.getCiudad());

            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void modificar(Empleado a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(UPDATE);
            stmt.setInt(1, a.getCod_empleado());
            stmt.setString(2, a.getNombres());
            stmt.setString(3, a.getApellidos());
            stmt.setString(4, a.getCargo());
            stmt.setString(5, a.getCedula());
            stmt.setString(6, a.getTelefono());
            stmt.setString(7, a.getDireccion());
            stmt.setString(8, a.getCorreo());
            stmt.setString(9, a.getSexo());
            stmt.setString(10, a.getCiudad());
            stmt.setInt(11, a.getCod_empleado());
           
           

            if (stmt.executeUpdate() == 0) {
                throw new DAOException("El registro no se ha modificado");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void eliminar(Empleado a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, a.getCod_empleado());

            if (stmt.executeUpdate() == 0) {
                throw new DAOException("El registro no se ha borrado");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Empleado> obtenerTodos() throws DAOException {
       PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Empleado> cl = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(GETALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                cl.add(convertir(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return cl;
    }

    @Override
    public Empleado obtener(Integer id) throws DAOException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleado cl = null;
        try {
            stmt = conn.prepareStatement(GET0NE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                cl = convertir(rs);
            } else {
                throw new DAOException("No se encontro el registro");
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return cl;
    }
    private Empleado convertir(ResultSet rs) throws SQLException { //Java: JDBC – 14
        int codigo = rs.getInt("id_empleado");
        String nombres = rs.getString("nombres");
        String apellidos = rs.getString("apellidos");
        String cargo = rs.getString("cargo");
        String cedula = rs.getString("cedula");
        String telefono = rs.getString("telefono");
        String direccion = rs.getString("direccion");
        String correo = rs.getString("correo");
        String sexo = rs.getString("sexo");
        String ciudad = rs.getString("ciudad");
        Empleado cl = new Empleado(codigo, nombres, apellidos,cargo,cedula, telefono, direccion, correo, sexo, ciudad);
        cl.setCod_empleado(rs.getInt("id_empleado"));//revisar
        return cl;

    }

    @Override
    public Empleado obtenerUser(String user) throws DAOException {
        return null;
    }

    @Override
    public List<Empleado> obtenerLista(Integer a) throws DAOException {return null;}
    
}
