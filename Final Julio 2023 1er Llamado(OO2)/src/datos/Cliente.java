package datos;

public class Cliente extends Persona {
	private boolean activo;

	public Cliente() {
	}

	public Cliente(String nombre, String apellido, long dni, boolean activo) {
		super(nombre, apellido, dni);
		this.activo = activo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Cliente [" + super.toString() + ", activo=" + activo + "]";
	}

}
