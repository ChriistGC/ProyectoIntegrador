package re.dao.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import re.dao.DAOException;
import reg.modelo.Usuario;
import re.dao.UsuarioDAO;

public class UsuarioBdDAO implements UsuarioDAO {

    final String INSERT = "INSERT INTO usuario(id_usuario, nombres, apellido, cedula, telefono, direccion, correo, sexo, ciudad) values(?,?,?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE usuario SET id_usuario = ?, nombres = ?, apellido = ?, cedula = ?, telefono = ?, direccion = ?, correo = ?, sexo = ?, ciudad = ? where id_usuario= ? ";
    final String DELETE = "DELETE FROM usuario where id_usuario=? ";
    final String GETALL = "SELECT * FROM usuario";
    final String GET0NE = "SELECT * FROM usuario where id_usuario=?";
    final String GET0NE2 = "SELECT * FROM usuario where cedula = ?";

    private Connection conn;

    public UsuarioBdDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Usuario a) throws DAOException {
        //Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(INSERT);
            stmt.setInt(1, a.getCodigo());
            stmt.setString(2, a.getNombres());
            stmt.setString(3, a.getApellidos());
            stmt.setString(4, a.getCedula());
            stmt.setString(5, a.getTelefono());
            stmt.setString(6, a.getDireccion());
            stmt.setString(7, a.getCorreo());
            stmt.setString(8, a.getSexo());
            stmt.setString(9, a.getCiudad());

            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void modificar(Usuario a) throws DAOException {
       PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(UPDATE);
            stmt.setInt(1, a.getCodigo());
            stmt.setString(2, a.getNombres());
            stmt.setString(3, a.getApellidos());
            stmt.setString(4, a.getCedula());
            stmt.setString(5, a.getTelefono());
            stmt.setString(6, a.getDireccion());
            stmt.setString(7, a.getCorreo());
            stmt.setString(8, a.getSexo());
            stmt.setString(9, a.getCiudad());
            stmt.setInt(10, a.getCodigo());

            if (stmt.executeUpdate() == 0) {
                throw new DAOException("El registro no se ha modificado");
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
            Logger.getLogger(UsuarioBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Usuario> obtenerTodos() throws DAOException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> cl = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(GETALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                cl.add(convertir(rs));
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

        return cl;
    }

    @Override
    public Usuario obtener(Integer id) throws DAOException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario cl = null;
        try {
            stmt = conn.prepareStatement(GET0NE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                cl = convertir(rs);
            } else {
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

        return cl;
    }

    private Usuario convertir(ResultSet rs) throws SQLException { //Java: JDBC – 14
        int codigo = rs.getInt("id_usuario");
        String nombres = rs.getString("nombres");
        String apellidos = rs.getString("apellido");
        String cedula = rs.getString("cedula");
        String telefono = rs.getString("telefono");
        String direccion = rs.getString("direccion");
        String correo = rs.getString("correo");
        String sexo = rs.getString("sexo");
        String ciudad = rs.getString("ciudad");
        Usuario cl = new Usuario(codigo, nombres, apellidos, cedula, telefono, direccion, correo, sexo, ciudad);
        cl.setCodigo(rs.getInt("id_usuario"));//revisar
        return cl;

    }

    @Override
    public List<Usuario> obtenerLista(Integer a) throws DAOException {return null;}

    @Override
    public Usuario obtenerUser(String user) throws DAOException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario cl = null;
        try {
            stmt = conn.prepareStatement(GET0NE2);
            stmt.setString(1, user);
            rs = stmt.executeQuery();
            if (rs.next()) {
                cl = convertir(rs);
            } else {
                //throw new DAOException("No se encontro el registro");
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

        return cl;
    }
}
