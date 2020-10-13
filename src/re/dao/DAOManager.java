
package re.dao;


public interface DAOManager {
   UsuarioDAO getUsuarioDAO();
   LoginDAO getLoginDAO();
   ActividadDAO getActividadDAO();
   PaqueteDAO getPaqueteDAO();
   RegionDAO getRegionDAO();
   FacturaDAO getFacturaDAO();
   DetalleFacturaDAO getDetalleFacturaDAO();
   EmpleadoDAO getEmpleadoDAO();
}
