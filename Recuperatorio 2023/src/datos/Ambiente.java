package datos;

public abstract class Ambiente {
	protected int idAmbiente;
	protected String ambiente;

	public Ambiente() {
	}

	public Ambiente(String ambiente) {
		super();
		this.ambiente = ambiente;
	}

	public int getIdAmbiente() {
		return idAmbiente;
	}

	protected void setIdAmbiente(int idAmbiente) {
		this.idAmbiente = idAmbiente;
	}

	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	@Override
	public String toString() {
		return "Ambiente [idAmbiente=" + idAmbiente + ", ambiente=" + ambiente
				+ "]";
	}

}
