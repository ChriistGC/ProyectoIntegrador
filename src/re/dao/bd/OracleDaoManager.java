
package re.dao.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import re.dao.ActividadDAO;
import re.dao.DAOManager;
import re.dao.DetalleFacturaDAO;
import re.dao.EmpleadoDAO;
import re.dao.FacturaDAO;
import re.dao.LoginDAO;
import re.dao.PaqueteDAO;
import re.dao.PruebDAO;
import re.dao.RegionDAO;
import re.dao.UsuarioDAO;

/**
 *
 * @author kriz_
 */
public class OracleDaoManager implements DAOManager {
    private Connection conn;
    private UsuarioDAO usuario=null;
    private LoginDAO login=null;
    private ActividadDAO actividad=null;
    private PaqueteDAO paquete=null;
    private RegionDAO region=null;
    private PruebDAO prueba=null;
    private FacturaDAO factura=null;
    private DetalleFacturaDAO detalleFactura=null;
    private EmpleadoDAO empleado=null;
    
    public OracleDaoManager(String url, String username, String password) throws ClassNotFoundException, SQLException
    {
         Class.forName("oracle.jdbc.OracleDriver");//"oracle.jdbc.driver.OracleDriver"
          conn = DriverManager.getConnection(url, username, password);
         
    }

    @Override
    public UsuarioDAO getUsuarioDAO() {
         if(usuario==null)   {
             usuario = new UsuarioBdDAO(conn);
         } 
         return usuario;
    }

    public Connection getConn() {
        return conn;
    }

    @Override
    public LoginDAO getLoginDAO() {
        if(login==null)   {
             login = new LoginBdDAO(conn);
         } 
         return login;
    }

    @Override
    public ActividadDAO getActividadDAO() {
        if(actividad==null)   {
             actividad = new ActividadBdDAO(conn);
         } 
         return actividad;
    }

    @Override
    public PaqueteDAO getPaqueteDAO() {
        if(paquete==null){
            paquete= new PaqueteBdDAO(conn);
        }
        return paquete;
    }

    @Override
    public RegionDAO getRegionDAO() {
        if (region==null) {
            region=new RegionBdDAO(conn);
        }
        return region;
    }

    @Override
    public PruebDAO getPruebDAO() {
        if(prueba==null){
            prueba=new PruebBdDAO(conn);
        }
        
        return prueba;
    }

    @Override
    public FacturaDAO getFacturaDAO() {
        if(factura==null){
            factura=new FacturaBdDAO(conn);
        }
        return factura;
    }

    @Override
    public DetalleFacturaDAO getDetalleFacturaDAO() {
        if(detalleFactura==null){
            detalleFactura=new DetalleFacturaBdDAO(conn);
        }
        return detalleFactura;
    }

    @Override
    public EmpleadoDAO getEmpleadoDAO() {
        if(empleado==null)   {
             empleado = new EmpleadoBdDAO(conn);
         } 
         return empleado;
    }
    
}
