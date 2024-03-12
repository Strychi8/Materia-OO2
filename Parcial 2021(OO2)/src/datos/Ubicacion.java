package datos;

import java.time.LocalDate;

public class Ubicacion extends Lugar{
    private double longitud;
    private double latitud;
    
    public Ubicacion() {}

	public Ubicacion(String lugar, double longitud, double latitud) {
		super(lugar);
		this.longitud = longitud;
		this.latitud = latitud;
	}
	
	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	@Override
	public String toString() {
		return "Ubicacion [" + super.toString() + ", longitud=" + longitud + ", latitud=" + latitud + "]";
	}
	
	@Override
	public boolean ingresoHabilitado(int idPermiso, LocalDate dia) {
        Permiso permiso = permisos.stream().filter(t -> t.getIdPermiso()==idPermiso).toList().get(0);
		
		return dia.isEqual(permiso.getFecha());
	}
    
    
}
