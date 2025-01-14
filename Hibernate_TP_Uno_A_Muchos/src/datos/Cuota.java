package datos;

import java.time.LocalDate;

public class Cuota {
	private long idCuota;
	private int nroCuota;
	private LocalDate fechaVencimiento;
	private double saldoPendiente;
	private double amortizacion;
	private double interesCuota;
	private double cuota;
	private double deuda;
	private boolean cancelada;
	private LocalDate fechaDePago;
	private double punitorios;
	private Prestamo prestamo; //Un Prestamo tiene muchas Cuotas.
	
	public Cuota() {
	}

	public Cuota(int nroCuota, LocalDate fechaVencimiento, double saldoPendiente, LocalDate fechaDePago,
			double punitorios, Prestamo prestamo) {
		this.nroCuota = nroCuota;
		this.fechaVencimiento = fechaVencimiento;
		this.saldoPendiente = saldoPendiente;
		this.fechaDePago = fechaDePago;
		this.punitorios = punitorios;
		// Calculables
		this.amortizacion = (saldoPendiente * interesCuota)/ (Math.pow((1 + interesCuota),2) - 1);
		this.interesCuota = saldoPendiente * interesCuota;
		this.cuota = amortizacion + interesCuota;
		this.deuda = saldoPendiente - amortizacion;
		this.prestamo = prestamo;
	}

	public Cuota(int nroCuota, LocalDate fechaVencimiento, double saldoPendiente, double amortizacion,
			double interesCuota, double cuota, double deuda, LocalDate fechaDePago, double punitorios) {
		super();
		this.nroCuota = nroCuota; // id ?
		this.fechaVencimiento = fechaVencimiento;
		this.saldoPendiente = saldoPendiente;
		this.amortizacion = amortizacion;
		this.interesCuota = interesCuota;
		this.cuota = cuota;
		this.deuda = deuda;
		this.cancelada = false;
		this.fechaDePago = fechaDePago;
		this.punitorios = punitorios;
		
	}

	public long getIdCuota() {
		return idCuota;
	}

	protected void setIdCuota(long idCuota) {
		this.idCuota = idCuota;
	}

	public int getNroCuota() {
		return nroCuota;
	}

	public void setNroCuota(int nroCuota) {
		this.nroCuota = nroCuota;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public double getSaldoPendiente() {
		return saldoPendiente;
	}

	public void setSaldoPendiente(double saldoPendiente) {
		this.saldoPendiente = saldoPendiente - amortizacion;
	}

	public double getAmortizacion() {
		return amortizacion;
	}

	public void setAmortizacion(double amortizacion) {
		this.amortizacion = (saldoPendiente * interesCuota)
				/ (Math.pow((1 + interesCuota), /*this.prestamo.getCantCuotas()*/ 2 ) - 1);
	}

	public double getInteresCuota() {
		return interesCuota;
	}

	public void setInteresCuota(double interesCuota) {
		this.interesCuota = saldoPendiente * interesCuota;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = amortizacion + interesCuota;
	}

	public double getDeuda() {
		return deuda;
	}

	public void setDeuda(double deuda) {
		this.deuda = saldoPendiente - amortizacion;
	}

	public boolean isCancelada() {
		return cancelada;
	}

	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}

	public LocalDate getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public double getPunitorios() {
		return punitorios;
	}

	public void setPunitorios(double punitorios) {
		this.punitorios = punitorios;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	@Override
	public String toString() {
		return "Cuota [idCuota=" + idCuota + ", nroCuota=" + nroCuota + ", fechaVencimiento=" + fechaVencimiento
				+ ", saldoPendiente=" + saldoPendiente + ", amortizacion=" + amortizacion + ", interesCuota="
				+ interesCuota + ", cuota=" + cuota + ", deuda=" + deuda + ", cancelada=" + cancelada + ", fechaDePago="
				+ fechaDePago + ", punitorios=" + punitorios + "]";
	}

}
