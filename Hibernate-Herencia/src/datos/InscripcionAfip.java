package datos;

public class InscripcionAfip {
	private int idInscripcionAfip;
	private String inscripcionAfip;
	private Cliente cliente;

	public InscripcionAfip() {
	}

	public InscripcionAfip(String inscripcionAfip,Cliente cliente) {
		super();
		this.inscripcionAfip = inscripcionAfip;
		this.cliente = cliente;
	}

	public int getIdInscripcionAfip() {
		return idInscripcionAfip;
	}

	protected void setIdInscripcionAfip(int idInscripcionAfip) {
		this.idInscripcionAfip = idInscripcionAfip;
	}

	public String getInscripcionAfip() {
		return inscripcionAfip;
	}

	public void setInscripcionAfip(String inscripcionAfip) {
		this.inscripcionAfip = inscripcionAfip;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "InscripcionAfip [idInscripcionAfip=" + idInscripcionAfip + ", inscripcionAfip=" + inscripcionAfip + "]\n";
	}

}
