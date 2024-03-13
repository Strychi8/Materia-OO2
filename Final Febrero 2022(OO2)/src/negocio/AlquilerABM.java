package negocio;

import java.time.LocalDate;

import dao.AlquilerDao;
import datos.Alquiler;

public class AlquilerABM {
   AlquilerDao dao = new AlquilerDao();
   
   public Alquiler traerAlquiler(int id) {
	   return dao.traerAlquiler(id);
   }
   
   public double calcularPrecioFinal(Alquiler alquiler) {
	   return alquiler.precioFinal();
   }
   
 
}
