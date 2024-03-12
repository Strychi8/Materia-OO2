package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PersonaDao;
import datos.Persona;

public class PersonaABM {
    PersonaDao dao = new PersonaDao();
    
    public List<Persona> traerPersona(int edadDesde, int edadHasta){
    	return dao.traerPersona(edadDesde, edadHasta);
    }
}
