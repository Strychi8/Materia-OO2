package datos;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Cliente {

	// ATRIBUTOS
	private long idCliente;
	private String apellido;
	private String nombre;
	private int dni;
	private LocalDate fechaDeNacimiento;
	private boolean baja;
	private Set<Evento> eventos;

	// CONSTRUCTOR
	public Cliente() {
	};

	public Cliente(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.baja = false;
	}

	

	// GET AND SET
	public long getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public boolean isBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	public Set<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}

	// EQUALS
	@Override
	public boolean equals(Object obj) {
		Cliente other = (Cliente) obj;
		return Objects.equals(apellido, other.apellido) && baja == other.baja && dni == other.dni
				&& Objects.equals(eventos, other.eventos) && Objects.equals(fechaDeNacimiento, other.fechaDeNacimiento)
				&& idCliente == other.idCliente && Objects.equals(nombre, other.nombre);
	}

	// TO STRING
	@Override
	public String toString() {
		return idCliente + "  " + apellido + "  " + nombre + " DNI: " + dni + "  F. Nacimiento: "
				+ Funciones.traerFechaCorta(fechaDeNacimiento) + "  " + baja;
	}
	
	// HASHCODE
	@Override
	public int hashCode() {
		return Objects.hash(apellido, baja, dni, eventos, fechaDeNacimiento, idCliente, nombre);
	}

}
