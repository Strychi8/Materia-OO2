package negocio;

import dao.VueloDao;
import datos.Vuelo;

public class VueloAbm {
     VueloDao dao = new VueloDao();
     
     public Vuelo traer(String vuelo) {
    	 return dao.traer(vuelo);
     }
}
