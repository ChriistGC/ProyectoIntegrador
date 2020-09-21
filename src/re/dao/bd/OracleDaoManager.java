
package re.dao.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import re.dao.DAOManager;
import re.dao.ClienteDAO;

/**
 *
 * @author kriz_
 */
public class OracleDaoManager implements DAOManager {
    private Connection conn;
    private ClienteDAO cliente=null;
    
    public OracleDaoManager(String url, String username, String password) throws ClassNotFoundException, SQLException
    {
         Class.forName("oracle.jdbc.OracleDriver");//"oracle.jdbc.driver.OracleDriver"
          conn = DriverManager.getConnection(url, username, password);
         
    }

    @Override
    public ClienteDAO getClienteDAO() {
         if(cliente==null)   {
             cliente = new ClienteBdDAO(conn);
         } 
         return cliente;
    }

    public Connection getConn() {
        return conn;
    }
    
}
