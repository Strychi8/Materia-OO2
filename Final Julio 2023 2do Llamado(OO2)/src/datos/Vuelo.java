package datos;

import java.time.LocalDateTime;
import java.util.Set;

public class Vuelo {
    private int idVuelo;
    private String vuelo;
    private LocalDateTime fechaHoraArribo;
    private LocalDateTime fechaHoraPartida;
    private int pesoMaximoEquipaje;
    private Set<Carga> cargas;
    
    public Vuelo() {}

	public Vuelo(int idVuelo, String vuelo, LocalDateTime fechaHoraArribo, LocalDateTime fechaHoraPartida,
			int pesoMaximoEquipaje) {
		super();
		this.idVuelo = idVuelo;
		this.vuelo = vuelo;
		this.fechaHoraArribo = fechaHoraArribo;
		this.fechaHoraPartida = fechaHoraPartida;
		this.pesoMaximoEquipaje = pesoMaximoEquipaje;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	protected void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getVuelo() {
		return vuelo;
	}

	public void setVuelo(String vuelo) {
		this.vuelo = vuelo;
	}

	public LocalDateTime getFechaHoraArribo() {
		return fechaHoraArribo;
	}

	public void setFechaHoraArribo(LocalDateTime fechaHoraArribo) {
		this.fechaHoraArribo = fechaHoraArribo;
	}

	public LocalDateTime getFechaHoraPartida() {
		return fechaHoraPartida;
	}

	public void setFechaHoraPartida(LocalDateTime fechaHoraPartida) {
		this.fechaHoraPartida = fechaHoraPartida;
	}

	public int getPesoMaximoEquipaje() {
		return pesoMaximoEquipaje;
	}

	public void setPesoMaximoEquipaje(int pesoMaximoEquipaje) {
		this.pesoMaximoEquipaje = pesoMaximoEquipaje;
	}
	
	

	public Set<Carga> getCargas() {
		return cargas;
	}

	public void setCargas(Set<Carga> cargas) {
		this.cargas = cargas;
	}

	@Override
	public String toString() {
		return "Vuelo [idVuelo=" + idVuelo + ", vuelo=" + vuelo + ", fechaHoraArribo=" + fechaHoraArribo
				+ ", fechaHoraPartida=" + fechaHoraPartida + ", pesoMaximoEquipaje=" + pesoMaximoEquipaje + ", cargas="
				+ cargas + "]";
	}

	public String toStringSinCarga() {
		return "Vuelo [idVuelo=" + idVuelo + ", vuelo=" + vuelo + ", fechaHoraArribo=" + fechaHoraArribo
				+ ", fechaHoraPartida=" + fechaHoraPartida + ", pesoMaximoEquipaje=" + pesoMaximoEquipaje + "]";
	}
    
	
    
}
