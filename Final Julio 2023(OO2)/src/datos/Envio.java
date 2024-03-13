package datos;

public class Envio extends Carga{
    private String domicilioEntrega;
    
    public Envio() {}

	public Envio(String aeropuertoOrigen, String aeropuertoDestino, int peso, Cliente cliente, Vuelo vuelo,
			String domicilioEntrega) {
		super(aeropuertoOrigen, aeropuertoDestino, peso, cliente, vuelo);
		this.domicilioEntrega = domicilioEntrega;
	}

	public String getDomicilioEntrega() {
		return domicilioEntrega;
	}

	public void setDomicilioEntrega(String domicilioEntrega) {
		this.domicilioEntrega = domicilioEntrega;
	}

	@Override
	public String toString() {
		return "\nEnvio [" + super.toString() + ", domicilioEntrega=" + domicilioEntrega + "]";
	}
    
    
}
