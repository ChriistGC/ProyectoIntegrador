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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import re.dao.DAOException;
import re.dao.RegionDAO;
import reg.modelo.Region;

/**
 *
 * @author kriz_
 */
public class RegionBdDAO implements RegionDAO{
    
    final String GET0NE = "SELECT * FROM region where id_region=?";
    
    private Connection conn;

    public RegionBdDAO(Connection conn) {
        this.conn = conn;
    }
        
    @Override
    public void insertar(Region a) throws DAOException {}

    @Override
    public void modificar(Region a) throws DAOException {}

    @Override
    public void eliminar(Region a) throws DAOException {}

    @Override
    public List<Region> obtenerTodos() throws DAOException {return null;}

    @Override
    public List<Region> obtenerLista(Integer a) throws DAOException {return null;}

    @Override
    public Region obtener(Integer id) throws DAOException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Region rg = null;
        try {
            stmt = conn.prepareStatement(GET0NE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                rg = convertir(rs);
            } else {
                throw new DAOException("No se encontro el registro");
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegionBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(RegionBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return rg;
    }

    @Override
    public Region obtenerUser(String user) throws DAOException {return null;}
    
    private Region convertir(ResultSet rs) throws SQLException { //Java: JDBC – 14
        int codigo = rs.getInt("id_region");
        String region = rs.getString("nombre");
        Region rg = new Region(codigo, region);
        rg.setCod(rs.getInt("id_region"));//revisar
        return rg;

    }
    
}
