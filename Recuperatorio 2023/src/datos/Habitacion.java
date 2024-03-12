package datos;

public class Habitacion extends Ambiente {
	private int plazas;
	private String nroHabitacion;

	public Habitacion() {
	}

	public Habitacion(String ambiente, int plazas, String nroHabitacion) {
		super(ambiente);
		this.plazas = plazas;
		this.nroHabitacion = nroHabitacion;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public String getNroHabitacion() {
		return nroHabitacion;
	}

	public void setNroHabitacion(String nroHabitacion) {
		this.nroHabitacion = nroHabitacion;
	}

	@Override
	public String toString() {
		return "Habitacion [" + super.toString() + ", plazas=" + plazas + ", nroHabitacion=" + nroHabitacion + "]";
	}

}
