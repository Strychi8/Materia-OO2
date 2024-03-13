package negocio;

import dao.AbonadoDao;
import datos.Abonado;

public class AbonadoAbm {
    AbonadoDao dao = new AbonadoDao();
    
    public Abonado traerAbonado(long dni) {
    	return dao.traerAbonado(dni);
    }
} 
