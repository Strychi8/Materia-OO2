package negocio;

import java.time.LocalDateTime;
import java.util.List;

import dao.CargaDao;
import datos.Carga;
import datos.Cliente;
import datos.Envio;
import datos.Equipaje;
import datos.Vuelo;

public class CargaAbm {
    CargaDao dao = new CargaDao();
    
    public List<Carga> traer(Cliente cliente){
    	return dao.traer(cliente);
    }
    
    public List<Equipaje> traer(Vuelo vuelo, boolean excedido){
    	return dao.traer(vuelo, excedido);
    }
    
    public List<Envio> traer(LocalDateTime desde, LocalDateTime hasta){
    	return dao.traer(desde, hasta);
    }
    
}
