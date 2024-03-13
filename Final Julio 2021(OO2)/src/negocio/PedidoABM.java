package negocio;

import dao.PedidoDao;
import datos.Pedido;
import datos.Producto;

public class PedidoABM {
   PedidoDao dao = new PedidoDao();
   
   public Pedido traerPedido(Producto p) {
	   return dao.traerPedido(p);
   }
}
