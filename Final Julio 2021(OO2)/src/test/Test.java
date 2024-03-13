package test;

import datos.Almacen;
import datos.Lote;
import negocio.AlmacenABM;
import negocio.PedidoABM;
import negocio.ProductoABM;
import negocio.StockABM;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ProductoABM productoAbm = new ProductoABM();
        AlmacenABM almacenAbm = new AlmacenABM();
        PedidoABM pedidoAbm = new PedidoABM();
        StockABM stockAbm = new StockABM();
        
        System.out.println("\n1) Traer Producto por codigo:\n" + productoAbm.traerProducto("001"));
        System.out.println("\n2) Traer Almacen para el Producto por codigo:\n" + almacenAbm.traerAlmacen(productoAbm.traerProducto("001")));
        System.out.println("\n4) Traer Pedido para el Producto por codigo:\n" + pedidoAbm.traerPedido(productoAbm.traerProducto("001")));
       
	}

}
