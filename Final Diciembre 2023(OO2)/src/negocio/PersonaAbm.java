package negocio;

import dao.PersonaDao;
import datos.Empleado;
import datos.Persona;

public class PersonaAbm {
    PersonaDao dao = new PersonaDao();
    
    public Persona traerPersona(long dni) {
    	return dao.traerPersona(dni);
    }
    
    public boolean agregarPersona(String nombre, String apellido, long dni, int sueldoBase) throws Exception {
    	if(traerPersona(dni) != null) {
    		throw new Exception("ERROR: Ya existe ese dni");
    	}
    	return dao.agregar(new Empleado(nombre,apellido,dni,sueldoBase)) != 0;
    }
}
