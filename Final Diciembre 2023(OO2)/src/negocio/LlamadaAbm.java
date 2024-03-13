package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.LlamadaDao;
import datos.Cliente;
import datos.Empleado;
import datos.Llamada;

public class LlamadaAbm {
    LlamadaDao dao = new LlamadaDao();
    
    public List<Llamada> traerLlamadas(){
    	return dao.traerLlamadas();
    }
       
    public boolean agregarLlamada(LocalDate fecha, Cliente cliente, Empleado empleado, int nivelSatifaccion) {
    	return dao.agregar(new Llamada(fecha,cliente,empleado,nivelSatifaccion)) != 0;
    }
    
    public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta){
    	return dao.traerLlamada(desde, hasta);
    }
    
    public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta, Empleado empleado){
    	return dao.traerLlamada(desde, hasta, empleado);
    }
    
    public double calcularPorcentajeNivelDeSatisfaccion(LocalDate desde, LocalDate hasta, Empleado empleado, int nivelSatisfaccion) {
    	double total = 0;
    	
    	
    	
    	return total;
    }
} 
