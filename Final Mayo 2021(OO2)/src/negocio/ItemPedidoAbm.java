package negocio;

import dao.ItemPedidoDao;
import datos.ItemPedido;

public class ItemPedidoAbm {
    ItemPedidoDao dao = new ItemPedidoDao();
    
    public ItemPedido traer(int idItemPedido) {
    	return dao.traer(idItemPedido);
    }
}
