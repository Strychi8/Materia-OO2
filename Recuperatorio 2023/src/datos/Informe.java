package datos;

import java.util.List;

public class Informe {
	private List<OrdenMantenimiento> ordenes;
    private double total;
    
    public Informe(List<OrdenMantenimiento> ordenes) {
    	this.ordenes = ordenes;
    	calcularTotal(ordenes);
    }
    
    @SuppressWarnings("unused")
	private void calcularTotal(List<OrdenMantenimiento> ordenes) {
    	total = 0.0;
    	for(OrdenMantenimiento orden: ordenes) {
    		total = total + orden.getCostoDeReparacion();
    	}
    }

	public Informe(double total) {
		super();
		this.total = total;
	}

	public List<OrdenMantenimiento> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<OrdenMantenimiento> ordenes) {
		this.ordenes = ordenes;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "Informe [ordenes=" + ordenes + ", total=" + total + "]";
	}

}
