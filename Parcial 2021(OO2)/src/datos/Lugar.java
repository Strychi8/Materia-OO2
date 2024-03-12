package datos;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public abstract class Lugar {
    protected int idLugar;
    protected String lugar;
    protected Set<Permiso> permisos;
    
    public Lugar() {}

	public Lugar(String lugar) {
		super();
		this.lugar = lugar;
	}

	public int getIdLugar() {
		return idLugar;
	}

	protected void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Set<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(Set<Permiso> permisos) {
		this.permisos = permisos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idLugar);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lugar other = (Lugar) obj;
		return idLugar == other.idLugar;
	}

	@Override
	public String toString() {
		return "Lugar [idLugar=" + idLugar + ", lugar=" + lugar;
	}
	
	public abstract boolean ingresoHabilitado(int idPermiso, LocalDate dia);
    
	
    
}
