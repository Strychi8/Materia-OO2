package negocio;

import dao.PermisoDao;
import datos.Permiso;

public class PermisoAbm {
     PermisoDao dao = new PermisoDao();
     
     public Permiso traerPermiso(int id) {
    	 return dao.traerPermiso(id);
     }
}
