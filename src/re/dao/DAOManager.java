
package re.dao;


public interface DAOManager {
   UsuarioDAO getUsuarioDAO();
   LoginDAO getLoginDAO();
   ActividadDAO getActividadDAO();
   PaqueteDAO getPaqueteDAO();
   RegionDAO getRegionDAO();
   PruebDAO getPruebDAO();
   FacturaDAO getFacturaDAO();
   DetalleFacturaDAO getDetalleFacturaDAO();
   EmpleadoDAO getEmpleadoDAO();
}
