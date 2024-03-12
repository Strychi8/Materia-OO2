package datos;

import java.time.LocalDate;
import java.util.Set;

public class Prestamo {
	private long idPrestamo;
	private LocalDate fecha;
	private double monto;
	private double interes;
	private int cantCuotas;
	private boolean prestamoFinalizado;
	private Cliente cliente;
	private Set<Cuota> cuotas;

	public Prestamo() {
	}

	public Prestamo(LocalDate fecha, double monto, double interes, int cantCuotas, boolean prestamoFinalizado,
			Cliente cliente) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.interes = interes;
		this.cantCuotas = cantCuotas;
		this.prestamoFinalizado = prestamoFinalizado;
		this.cliente = cliente;
	}

	public long getIdPrestamo() {
		return idPrestamo;
	}

	protected void setIdPrestamo(long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public int getCantCuotas() {
		return cantCuotas;
	}

	public void setCantCuotas(int cantCuotas) {
		this.cantCuotas = cantCuotas;
	}

	public boolean isPrestamoFinalizado() {
		return prestamoFinalizado;
	}

	public void setPrestamoFinalizado(boolean prestamoFinalizado) {
		this.prestamoFinalizado = prestamoFinalizado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
   public Set<Cuota> getCuotas() {
		return cuotas;
	}

	public void setCuotas(Set<Cuota> cuotas) {
		this.cuotas = cuotas;
	}
	
	@Override
	public String toString() {
		return "Prestamo [idPrestamo=" + idPrestamo + ", fecha=" + fecha + ", monto=" + monto + ", interes=" + interes
				+ ", cantCuotas=" + cantCuotas + ", prestamoFinalizado=" + prestamoFinalizado + "]\n";
	}

	
	

}
