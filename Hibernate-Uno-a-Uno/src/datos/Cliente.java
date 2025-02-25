package datos;

import java.time.LocalDate;

public class Cliente {
	private long idCliente;
	private String apellido;
	private String nombre;
	private int dni;
	private LocalDate fechaNacimiento;
	private boolean baja;
	private Contacto contacto;

	public Cliente() {
	}

	public Cliente(String apellido, String nombre, int dni, LocalDate fechaNacimiento,Contacto contacto) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.baja = false;
		setContacto(contacto);
	}

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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean isBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni
				+ ", fechaNacimiento=" + fechaNacimiento + ", baja=" + baja + ", contacto=" + contacto + "]\n";
	}

}
