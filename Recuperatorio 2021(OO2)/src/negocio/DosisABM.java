package negocio;

import java.time.LocalTime;
import java.util.List;

import dao.DosisDao;
import datos.Dosis;
import datos.Vacuna;

public class DosisABM {
    DosisDao dao = new DosisDao();
    
    public List<Dosis> traerDosis(Vacuna vacuna){
    	return dao.traerDosis(vacuna);
    }
    
    public List<Dosis> traerDosis(LocalTime horaDesde,LocalTime horaHasta){
    	return dao.traerDosis(horaDesde,horaHasta);
    }
    
    public List<Dosis> traerDosis(LocalTime horaDesde,LocalTime horaHasta,boolean tieneComorbilidad){
    	return dao.traerDosis(horaDesde,horaHasta,tieneComorbilidad);
    }
}
