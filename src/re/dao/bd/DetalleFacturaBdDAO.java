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
import re.dao.DetalleFacturaDAO;
import reg.modelo.DetalleFactura;

/**
 *
 * @author kriz_
 */
public class DetalleFacturaBdDAO implements DetalleFacturaDAO {

    final String INSERT = "INSERT INTO detalle_factura(id_usuario, id_empleado, id_paquete, id_factura) values(?,?,?,?)";
    final String UPDATE = "UPDATE detalle_factura SET id_usuario = ?, id_empleado = ?, id_paquete = ?, id_factura = ? where id_usuario= ? ";
    final String DELETE = "DELETE FROM detalle_factura where id_usuario=?";
    final String GETALL = "SELECT * FROM detalle_factura";
    final String GET0NE = "SELECT * FROM detalle_factura where id_usuario=?";

    private Connection conn;

    public DetalleFacturaBdDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(DetalleFactura a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(INSERT);
            stmt.setInt(1, a.getIdUsuario());
            if (a.getIdEmpleado() != 0) {
                stmt.setInt(2, a.getIdEmpleado());
            }else{stmt.setString(2, null);}
            stmt.setInt(3, a.getIdPaquete());
            stmt.setInt(4, a.getIdFactura());

            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DetalleFacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void modificar(DetalleFactura a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(UPDATE);
            stmt.setInt(1, a.getIdUsuario());
            stmt.setInt(2, a.getIdEmpleado());
            stmt.setInt(3, a.getIdPaquete());
            stmt.setInt(4, a.getIdFactura());
            stmt.setInt(5, a.getIdUsuario());

            if (stmt.executeUpdate() == 0) {
                throw new DAOException("El registro no se ha modificado");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DetalleFacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void eliminar(DetalleFactura a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, a.getIdUsuario());

            if (stmt.executeUpdate() == 0) {
                throw new DAOException("El registro no se ha borrado");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DetalleFacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<DetalleFactura> obtenerTodos() throws DAOException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<DetalleFactura> fact = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(GETALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                fact.add(convertir(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DetalleFacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return fact;
    }

    @Override
    public List<DetalleFactura> obtenerLista(Integer a) throws DAOException {
        return null;
    }

    @Override
    public DetalleFactura obtener(Integer id) throws DAOException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DetalleFactura fact = null;
        try {
            stmt = conn.prepareStatement(GET0NE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                fact = convertir(rs);
            } else {
                throw new DAOException("No se encontro el registro");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DetalleFacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return fact;
    }

    @Override
    public DetalleFactura obtenerUser(String user) throws DAOException {
        return null;
    }

    private DetalleFactura convertir(ResultSet rs) throws SQLException { //Java: JDBC – 14
        int idUsuario = rs.getInt("id_usuario");
        int idEmpleado = rs.getInt("id_empleado");
        int idPaquete = rs.getInt("id_paquete");
        int idFactura = rs.getInt("id_factura");
        DetalleFactura fact = new DetalleFactura(idUsuario, idEmpleado, idPaquete, idFactura);
        fact.setIdFactura(rs.getInt("id_usuario"));//revisar
        return fact;
    }

}
