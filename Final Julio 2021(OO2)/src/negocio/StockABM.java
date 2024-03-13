package negocio;

import dao.StockDao;
import datos.Almacen;
import datos.Producto;

public class StockABM {
    StockDao dao = new StockDao();
    
    public Almacen traerAlmacen(Producto p) {
    	return dao.traerAlmacen(p);
    }
}
