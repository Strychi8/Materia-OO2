package negocio;

import java.util.List;

import dao.DispositivoDao;
import datos.Dispositivo;

public class DispositivoABM {
    DispositivoDao dao = new DispositivoDao();
    
    public List<Dispositivo> traer(){
    	return dao.traer();
    }
    
    public Dispositivo traer(String nombre) {
    	return dao.traer(nombre);
    }
    
    public List<Dispositivo> traerTodosLosDispositivosSensorTemperatura(){
    	return dao.traerTodosLosDispositivosSensorTemperatura();
    }
}
