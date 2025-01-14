package datos;

public class Equipaje extends Carga {
	private boolean excedePeso;

	public Equipaje() {
	}

	public Equipaje(String aeropuertoOrigen, String aeropuertoDestino, int peso, Cliente cliente, Vuelo vuelo,
			boolean excedePeso) {
		super(aeropuertoOrigen, aeropuertoDestino, peso, cliente, vuelo);
		this.excedePeso = excedePeso;
	}

	public boolean isExcedePeso() {
		return excedePeso;
	}

	public void setExcedePeso(boolean excedePeso) {
		this.excedePeso = excedePeso;
	}

	@Override
	public String toString() {
		return "\nEquipaje [" + super.toString() + ", excedePeso=" + excedePeso + "]";
	}

}
