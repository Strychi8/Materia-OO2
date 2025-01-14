package datos;

public class Carga {
    protected int idCarga;
    protected String aeropuertoOrigen;
    protected String aeropuertoDestino;
    protected int peso;
    protected Cliente cliente;
    protected Vuelo vuelo;
    
    public Carga() {}

	public Carga(String aeropuertoOrigen, String aeropuertoDestino, int peso, Cliente cliente, Vuelo vuelo) {
		super();
		this.aeropuertoOrigen = aeropuertoOrigen;
		this.aeropuertoDestino = aeropuertoDestino;
		this.peso = peso;
		this.cliente = cliente;
		this.vuelo = vuelo;
	}

	public int getIdCarga() {
		return idCarga;
	}

	protected void setIdCarga(int idCarga) {
		this.idCarga = idCarga;
	}

	public String getAeropuertoOrigen() {
		return aeropuertoOrigen;
	}

	public void setAeropuertoOrigen(String aeropuertoOrigen) {
		this.aeropuertoOrigen = aeropuertoOrigen;
	}

	public String getAeropuertoDestino() {
		return aeropuertoDestino;
	}

	public void setAeropuertoDestino(String aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	@Override
	public String toString() {
		return "Carga [idCarga=" + idCarga + ", aeropuertoOrigen=" + aeropuertoOrigen + ", aeropuertoDestino="
				+ aeropuertoDestino + ", peso=" + peso + ", cliente=" + cliente + ", vuelo=" + vuelo.toStringSinCarga() + "]";
	}
    
    
}
