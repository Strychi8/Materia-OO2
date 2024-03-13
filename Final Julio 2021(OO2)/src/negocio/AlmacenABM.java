package negocio;

import dao.AlmacenDao;
import datos.Almacen;
import datos.Producto;

public class AlmacenABM {
    AlmacenDao dao = new AlmacenDao();
    
    public Almacen traerAlmacen(Producto p) {
    	return dao.traerAlmacen(p);
    }
}
