package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Peaje {
	protected int idPeaje;
	protected LocalDate fecha;
	protected LocalTime hora;
	protected double precio;

	public Peaje() {

	}

	public Peaje(LocalDate fecha, LocalTime hora, double precio) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
	}

	public int getIdPeaje() {
		return idPeaje;
	}

	public void setIdPeaje(int idPeaje) {
		this.idPeaje = idPeaje;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Peaje [idPeaje=" + idPeaje + ", fecha=" + fecha + ", hora=" + hora + ", precio=" + precio + "]";
	}
	
	public double calcularDescuento(double porcentajeDescuento) {
		double descuento = 0;
		int diaHabil = fecha.getDayOfWeek().getValue();
		
		if(diaHabil >= 1 && diaHabil <=5 || getHora().isBefore(LocalTime.of(7, 0))
				|| getHora().isAfter(LocalTime.of(19, 0))){
			descuento = (porcentajeDescuento * getPrecio()) / 100;
		}
		
		
		return descuento;
	}

}
