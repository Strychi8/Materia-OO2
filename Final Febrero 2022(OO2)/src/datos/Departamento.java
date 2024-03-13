package datos;

public class Departamento extends Propiedad {
	private int cantidadAmbientes;
	private int nroPiso;
	private boolean tieneAscensor;

	public Departamento() {
	}

	public Departamento(double precioBase, String direccion, int cantidadAmbientes, int nroPiso) {
		super(precioBase, direccion);
		this.cantidadAmbientes = cantidadAmbientes;
		this.nroPiso = nroPiso;
		this.tieneAscensor = false;
	}

	public int getCantidadAmbientes() {
		return cantidadAmbientes;
	}

	public void setCantidadAmbientes(int cantidadAmbientes) {
		this.cantidadAmbientes = cantidadAmbientes;
	}

	public int getNroPiso() {
		return nroPiso;
	}

	public void setNroPiso(int nroPiso) {
		this.nroPiso = nroPiso;
	}

	public boolean isTieneAscensor() {
		return tieneAscensor;
	}

	public void setTieneAscensor(boolean tieneAscensor) {
		this.tieneAscensor = tieneAscensor;
	}

	@Override
	public String toString() {
		return super.toString() + ", Departamento [cantidadAmbientes=" + cantidadAmbientes + ", nroPiso=" + nroPiso
				+ ", tieneAscensor=" + tieneAscensor + "]";
	}
	
	public double precioPorNoche() {
		return precioBase + (cantidadAmbientes*100);
	}

}
