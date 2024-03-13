package datos;

import java.util.Set;

public class Almacen extends Stock{
	private int idAlmacen;
    private int cantDeseable;
    private int cantMinima;
    private Set<Lote> lotes;
    
    public Almacen() {}

	public Almacen (Producto producto,int cantDeseable, int cantMinima) {
		super(producto);
		this.cantDeseable = cantDeseable;
		this.cantMinima = cantMinima;
		
	}
    
	public int getIdAlmacen() {
		return idAlmacen;
	}

	protected void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public int getCantDeseable() {
		return cantDeseable;
	}

	public void setCantDeseable(int cantDeseable) {
		this.cantDeseable = cantDeseable;
	}

	public int getCantMinima() {
		return cantMinima;
	}

	public void setCantMinima(int cantMinima) {
		this.cantMinima = cantMinima;
	}

	public Set<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(Set<Lote> lotes) {
		this.lotes = lotes;
	}

	@Override
	public String toString() {
		return "Almacen [idStock=" + this.getIdStock() + ", Producto=" + this.getProducto() + ", cantDeseable=" + cantDeseable + ", cantMinima=" + cantMinima + ", lotes=" + this.getLotes() + "]";
	}
	
	
    
    

}