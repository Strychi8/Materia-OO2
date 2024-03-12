package negocio;

import java.util.List;

import dao.OrdenMantenimientoDao;
import datos.Ambiente;
import datos.OrdenMantenimiento;

public class OrdenMantenimientoAbm {
    OrdenMantenimientoDao dao = new OrdenMantenimientoDao();
    
    public List<OrdenMantenimiento> traer(Ambiente ambiente){
    	return dao.traer(ambiente);
    }
    public List<OrdenMantenimiento> traer(Ambiente ambiente, boolean terminada){
    	return dao.traer(ambiente,terminada);
    }
    public List<OrdenMantenimiento> traer(boolean pagada){
    	return dao.traer(pagada);
    }
}
