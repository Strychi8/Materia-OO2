package datos;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class OrdenMantenimiento {
	private int idOrdenMantenimiento;
	private String nroOrdenMantenimiento;
	private Ambiente ambiente;
	private double costoDeReparacion;
	private String motivo;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private boolean terminada;
	private boolean pagada;
	private String estadoDuranteLaReparacion;

	public OrdenMantenimiento() {
		
	}

	public OrdenMantenimiento(String nroOrdenMantenimiento, Ambiente ambiente, double costoDeReparacion, String motivo,
			LocalDate fechaInicio, LocalDate fechaFin, boolean terminada, boolean pagada,
			String estadoDuranteLaReparacion) {
		super();
		this.nroOrdenMantenimiento = nroOrdenMantenimiento;
		this.ambiente = ambiente;
		this.costoDeReparacion = costoDeReparacion;
		this.motivo = motivo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.terminada = terminada;
		this.pagada = pagada;
		this.estadoDuranteLaReparacion = estadoDuranteLaReparacion;
	}

	public int getIdOrdenMantenimiento() {
		return idOrdenMantenimiento;
	}

	protected void setIdOrdenMantenimiento(int idOrdenMantenimiento) {
		this.idOrdenMantenimiento = idOrdenMantenimiento;
	}

	public double getCostoDeReparacion() {
		return costoDeReparacion;
	}

	public void setCostoDeReparacion(double costoDeReparacion) {
		this.costoDeReparacion = costoDeReparacion;
	}

	public String getNroOrdenMantenimiento() {
		return nroOrdenMantenimiento;
	}

	public void setNroOrdenMantenimiento(String nroOrdenMantenimiento) {
		this.nroOrdenMantenimiento = nroOrdenMantenimiento;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isTerminada() {
		return terminada;
	}

	public void setTerminada(boolean terminada) {
		this.terminada = terminada;
	}

	public boolean isPagada() {
		return pagada;
	}

	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}

	public String getEstadoDuranteLaReparacion() {
		return estadoDuranteLaReparacion;
	}

	public void setEstadoDuranteLaReparacion(String estadoDuranteLaReparacion) {
		this.estadoDuranteLaReparacion = estadoDuranteLaReparacion;
	}

	@Override
	public String toString() {
		return "\nOrdenMantenimiento [idOrdenMantenimiento=" + idOrdenMantenimiento + ", nroOrdenMantenimiento="
				+ nroOrdenMantenimiento + ", ambiente=" + ambiente + ", costoDeReparacion=" + costoDeReparacion
				+ ", motivo=" + motivo + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", terminada="
				+ terminada + ", pagada=" + pagada + ", estadoDuranteLaReparacion=" + estadoDuranteLaReparacion + "]";
	} 
	
	public long tiempoDeEjecucion() {
		return DAYS.between(fechaInicio,fechaFin);
	}

}
