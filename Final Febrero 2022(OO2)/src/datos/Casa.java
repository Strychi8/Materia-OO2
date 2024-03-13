package datos;

public class Casa extends Propiedad {
	private boolean tienePatio;

	public Casa() {
	}

	public Casa(double precioBase, String direccion) {
		super(precioBase, direccion);
		this.tienePatio = false;
	}

	public boolean isTienePatio() {
		return tienePatio;
	}

	public void setTienePatio(boolean tienePatio) {
		this.tienePatio = tienePatio;
	}

	@Override
	public String toString() {
		return super.toString() + ", Casa [tienePatio=" + tienePatio + "]";
	}
	
	public double precioPorNoche() {
		if(tienePatio==true) {
			return (precioBase/10) *100;
		}
		return precioBase;
	}

}
