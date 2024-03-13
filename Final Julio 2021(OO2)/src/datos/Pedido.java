package datos;

import java.util.Set;

public class Pedido extends Stock{
	private int idPedido;
	private Set<NotaPedido> notasPedidos;

	public Pedido() {
	}

    
	public Pedido(Producto producto) {
		super(producto);
	}


	public int getIdPedido() {
		return idPedido;
	}


	protected void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}


	public Set<NotaPedido> getNotasPedidos() {
		return notasPedidos;
	}

	public void setNotasPedidos(Set<NotaPedido> notasPedidos) {
		this.notasPedidos = notasPedidos;
	}

	@Override
	public String toString() {
		return "Pedido [idStock=" + this.getIdStock() + ", Producto=" + this.getProducto() + ", notasPedidos=" + this.getNotasPedidos() + "]";
	}

}
