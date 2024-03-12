package negocio;

import dao.AulaDao;
import datos.Aula;

public class AulaAbm {
     AulaDao dao = new AulaDao();
     
     public Aula traer(int id) {
    	 return dao.traer(id);
     }
}
