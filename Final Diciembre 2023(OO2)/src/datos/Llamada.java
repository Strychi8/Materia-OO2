package datos;

import java.time.LocalDate;

public class Llamada {
    private int idLlamada;
    private LocalDate fecha;
    private Cliente cliente;
    private Empleado empleado;
    private int nivelSatifaccion;
    
    public Llamada() {}

	public Llamada(LocalDate fecha, Cliente cliente, Empleado empleado, int nivelSatifaccion) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.empleado = empleado;
		this.nivelSatifaccion = nivelSatifaccion;
	}

	public int getIdLlamada() {
		return idLlamada;
	}

	public void setIdLlamada(int idLlamada) {
		this.idLlamada = idLlamada;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public int getNivelSatifaccion() {
		return nivelSatifaccion;
	}

	public void setNivelSatifaccion(int nivelSatifaccion) {
		this.nivelSatifaccion = nivelSatifaccion;
	}

	@Override
	public String toString() {
		return "Llamada [idLlamada=" + idLlamada + ", fecha=" + fecha + ", cliente=" + cliente + ", empleado="
				+ empleado + ", nivelSatifaccion=" + nivelSatifaccion + "]";
	}
    
    
}
