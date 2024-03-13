package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PeajeDao;
import datos.Abonado;
import datos.Manual;
import datos.Peaje;
import datos.Rodado;
import datos.Telepeaje;

public class PeajeAbm {
    PeajeDao dao = new PeajeDao();
    
    public List<Manual> traerManual(){
    	return dao.traerManual();
    }
    
    public List<Telepeaje> traerTelepeaje(){
    	return dao.traerTelepeaje();
    }
    
    public List<Manual> traerManual(LocalDate fecha){
    	return dao.traerManual(fecha);
    }
    
    public List<Telepeaje> traerTelepeaje(Rodado rodado){
    	return dao.traerTelepeaje(rodado);
    }
    
    public List<Telepeaje> traerTelepeaje(Abonado abonado){
    	return dao.traerTelepeaje(abonado);
    }
    
    public double cerrarCaja(LocalDate fecha) {
    	double caja = 0;
    	
    	for(Peaje peaje: dao.traerManual()) {
    		if(peaje.getFecha().equals(fecha)) {
    			caja = caja + peaje.getPrecio();
    		}
    	}
    	
    	return caja;
    }
    
    
}
