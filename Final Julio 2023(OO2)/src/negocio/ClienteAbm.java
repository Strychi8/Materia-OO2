package negocio;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteAbm {
    ClienteDao dao = new ClienteDao();
    
    public Cliente traer(long dni) {
    	return dao.traer(dni);
    }
}
