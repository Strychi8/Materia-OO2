package datos;

public class Empleado extends Persona {
	private int sueldoBase;

	public Empleado() {
	}

	public Empleado(String nombre, String apellido, long dni, int sueldoBase) {
		super(nombre, apellido, dni);
		this.sueldoBase = sueldoBase;
	}

	public int getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(int sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	@Override
	public String toString() {
		return "Empleado [" + super.toString() + ", sueldoBase=" + sueldoBase + "]";
	}

}
