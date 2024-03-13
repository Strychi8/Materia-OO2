package negocio;

import dao.RodadoDao;
import datos.Rodado;

public class RodadoAbm {
     RodadoDao dao = new RodadoDao();
     
     public Rodado traerRodado(String dominio) {
    	 return dao.traerRodado(dominio);
     }
}
