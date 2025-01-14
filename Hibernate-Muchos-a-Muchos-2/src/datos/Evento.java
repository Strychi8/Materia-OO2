package datos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;

public class Evento {

	// ATRIBUTOS
	private long idEvento;
	private String evento;
	private LocalDate fecha;
	private LocalTime hora;
	private Set<Cliente> clientes;

	// CONSTRUCTOR
	public Evento() {

	};

	public Evento(String evento, LocalDate fecha, LocalTime hora) {
		this.evento = evento;
		this.fecha = fecha;
		this.hora = hora;
	}

	// GET AND SET
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

	// EQUALS
	@Override
	public boolean equals(Object obj) {
		Evento other = (Evento) obj;
		return Objects.equals(clientes, other.clientes) && Objects.equals(evento, other.evento)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(hora, other.hora) && idEvento == other.idEvento;
	}

	// TO STRING
	@Override
	public String toString() {
		return idEvento + "  " + evento + "  " + fecha + "  " + Funciones.traerHoraCorta(hora);
	}

}
