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
import re.dao.FacturaDAO;
import reg.modelo.Factura;

/**
 *
 * @author kriz_
 */
public class FacturaBdDAO implements FacturaDAO{
    
    final String INSERT = "INSERT INTO factura(id_factura, fechaventa, fechaviaje, metodopago, interespago, IVA, total) values(?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE factura SET id_factura = ?, fechaventa = ?, fechaviaje = ?, metodopago = ?, interespago = ?, IVA = ?, total = ? where id_factura= ? ";
    final String DELETE = "DELETE FROM factura where id_factura=?";
    final String GETALL = "SELECT * FROM factura";
    final String GET0NE = "SELECT * FROM factura where id_factura=?";
    
    private Connection conn;

    public FacturaBdDAO(Connection conn) {
        this.conn = conn;
    }
        
    @Override
    public void insertar(Factura a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(INSERT);
            stmt.setInt(1, a.getIdFactura());
            stmt.setString(2, a.getFechaVenta());
            stmt.setString(3, a.getFechaViaje());
            stmt.setString(4, a.getMtdoPago());
            stmt.setInt(5, a.getInteresPago());
            stmt.setInt(6, a.getIVA());
            stmt.setDouble(7, a.getTotal());

            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            Logger.getLogger(FacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(FacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void modificar(Factura a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(UPDATE);
            stmt.setInt(1, a.getIdFactura());
            stmt.setString(2, a.getFechaVenta());
            stmt.setString(3, a.getFechaViaje());
            stmt.setString(4, a.getMtdoPago());
            stmt.setInt(5, a.getInteresPago());
            stmt.setInt(6, a.getIVA());
            stmt.setDouble(7, a.getTotal());
            stmt.setInt(8, a.getIdFactura());

            if (stmt.executeUpdate() == 0) {
                throw new DAOException("El registro no se ha modificado");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(FacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(FacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void eliminar(Factura a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, a.getIdFactura());

            if (stmt.executeUpdate() == 0) {
                throw new DAOException("El registro no se ha borrado");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(FacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(FacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Factura> obtenerTodos() throws DAOException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Factura> fact = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(GETALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                fact.add(convertir(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(FacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(FacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return fact;
    }

    @Override
    public List<Factura> obtenerLista(Integer a) throws DAOException {return null;}

    @Override
    public Factura obtener(Integer id) throws DAOException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Factura fact = null;
        try {
            stmt = conn.prepareStatement(GET0NE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                fact = convertir(rs);
            } else {
//                throw new DAOException("No se encontro el registro");
            }

        } catch (SQLException ex) {
            Logger.getLogger(FacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(FacturaBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return fact;
    }

    @Override
    public Factura obtenerUser(String user) throws DAOException {return null;}
    
    private Factura convertir(ResultSet rs) throws SQLException { //Java: JDBC – 14
        int codigo = rs.getInt("id_factura");
        String fechaVenta = rs.getString("fechaventa");
        String fechaViaje = rs.getString("fechaviaje");
        String mtdoPago = rs.getString("metodopago");
        int interesPago = rs.getInt("interespago");
        int IVA = rs.getInt("IVA");
        int total = rs.getInt("total");
        Factura fact = new Factura(codigo, fechaVenta, fechaViaje, mtdoPago, interesPago, IVA, total);
        fact.setIdFactura(rs.getInt("id_factura"));//revisar
        return fact;
    }
    
}
