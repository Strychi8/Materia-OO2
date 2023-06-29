package datos;

import java.util.Objects;
import java.util.Set;

public class Cliente {
	protected int idCliente;
	protected String nroCliente;
	private Contacto contacto;
	private Set<InscripcionAfip> inscripciones;

	public Cliente() {
	}

	public Cliente(String nroCliente) {
		super();
		this.nroCliente = nroCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(String nroCliente) {
		this.nroCliente = nroCliente;
	}
    
	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public Set<InscripcionAfip> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(Set<InscripcionAfip> inscripciones) {
		this.inscripciones = inscripciones;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nroCliente=" + nroCliente + "]\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return idCliente == other.idCliente;
	}

	

}
