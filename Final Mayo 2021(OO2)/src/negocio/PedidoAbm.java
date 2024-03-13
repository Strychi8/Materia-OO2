package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PedidoDao;
import datos.Pedido;

public class PedidoAbm {
    PedidoDao dao = new PedidoDao();
    
    public Pedido traerPedido(int idPedido) {
    	return dao.traerPedido(idPedido);
    }
    
    public List<Pedido> traerPedido(boolean esMensual){
    	return dao.traerPedido(esMensual);
    }
    
    public List<Pedido> traerPedido(LocalDate fechaDesde, LocalDate fechaHasta){
    	return dao.traerPedido(fechaDesde, fechaHasta);
    }
    
    public List<Pedido> traerPedido(String area){
    	return dao.traerPedido(area);
    }
}
