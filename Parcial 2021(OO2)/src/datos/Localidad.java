package datos;

import java.time.LocalDate;

public class Localidad extends Lugar {
    private String codPostal;
    private boolean cumplirCuarentena;
    
    public Localidad() {}

	public Localidad(String lugar, String codPostal, boolean cumplirCuarentena) {
		super(lugar);
		this.codPostal = codPostal;
		this.cumplirCuarentena = cumplirCuarentena;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public boolean isCumplirCuarentena() {
		return cumplirCuarentena;
	}

	public void setCumplirCuarentena(boolean cumplirCuarentena) {
		this.cumplirCuarentena = cumplirCuarentena;
	}

	@Override
	public String toString() {
		return "Localidad [" + super.toString() + ", codPostal=" + codPostal + ", cumplirCuarentena=" + cumplirCuarentena + "]";
	}

	@Override
	public boolean ingresoHabilitado(int idPermiso, LocalDate dia) {
        Permiso permiso = permisos.stream().filter(t -> t.getIdPermiso()==idPermiso).toList().get(0);
		
		return !dia.isBefore(permiso.getFecha()) && !dia.isAfter(permiso.getFecha().plusDays(permiso.getCantDias()));
	}
	
    
    
}
