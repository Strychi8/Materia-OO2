package negocio;

import dao.EdificioDao;
import datos.Edificio;

public class EdificioAbm {
    EdificioDao dao = new EdificioDao();
    
    public Edificio traerEdificioConAulas(int id) {
    	return dao.traerEdificioConAulas(id);
    }
}
