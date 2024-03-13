package test;

import java.time.LocalDate;

import negocio.ItemPedidoAbm;
import negocio.PedidoAbm;

public class TestOO2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        PedidoAbm pedidoAbm = new PedidoAbm();
        ItemPedidoAbm itemPedidoAbm = new ItemPedidoAbm();
        
        System.out.println("\n1) Traer e imprimir el Pedido 18:\n" + pedidoAbm.traerPedido(18));
        //System.out.println("\n2) Traer e imprimir todo el listado de pedidos mensuales:\n" + pedidoAbm.traerPedido(false));
        System.out.println("\n4) Traer e imprimir todos los pedidos entre las fechas: \n" + pedidoAbm.traerPedido(LocalDate.of(2021, 05, 15), LocalDate.of(2021, 06, 16)));
        System.out.println("\n5) Traer e imprimir todos los pedidos del area 2:\n" + pedidoAbm.traerPedido("area2"));
        
        System.out.println("\n6) Traer e imprimir ItemPedido id = 2:\n" + itemPedidoAbm.traer(2));
	}

}
