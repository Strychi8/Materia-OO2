package datos;

public class Persona {
     protected int idPersona;
     protected String nombre;
     protected String apellido;
     protected long dni;
         
     public Persona() {
    	 
     }

	public Persona(String nombre, String apellido, long dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}


	public int getIdPersona() {
		return idPersona;
	}


	protected void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public long getDni() {
		return dni;
	}


	public void setDni(long dni) {
		this.dni = dni;
	}


	@Override
	public String toString() {
		return "\nPersona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ "]";
	}
     
	
     
}
