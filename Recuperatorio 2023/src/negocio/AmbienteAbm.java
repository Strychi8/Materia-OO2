package negocio;

import dao.AmbienteDao;
import datos.Ambiente;

public class AmbienteAbm {
    AmbienteDao dao = new AmbienteDao();
    
    public Ambiente traer(int idAmbiente) {
    	return dao.traer(idAmbiente);
    }
}
