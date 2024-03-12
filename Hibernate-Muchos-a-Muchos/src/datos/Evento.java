package datos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Evento {
	private long idEvento;
	private String evento;
	private LocalDate fecha;
	private LocalTime hora;
	private Set<Cliente> clientes;

	public Evento() {
	}

	public Evento(String evento, LocalDate fecha, LocalTime hora, Set<Cliente> clientes) {
		super();
		this.evento = evento;
		this.fecha = fecha;
		this.hora = hora;
		this.clientes = clientes;
	}

	public long getIdEvento() {
		return idEvento;
	}

	protected void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "\nEvento [idEvento=" + idEvento + ", evento=" + evento + ", fecha=" + fecha + ", hora=" + hora + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEvento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return idEvento == other.idEvento;
	}
	
	
	
}