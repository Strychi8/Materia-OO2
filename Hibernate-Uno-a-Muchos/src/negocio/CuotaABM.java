package negocio;

import java.time.LocalDate;

import dao.CuotaDao;
import dao.PrestamoDao;
import datos.Cuota;
import datos.Prestamo;

public class CuotaABM {
      CuotaDao dao = new CuotaDao();
      PrestamoDao prestamoDao = new PrestamoDao();
      
      public Cuota traerIdCuota(long idCuota) { 
    	  return dao.traer(idCuota);
      }
      
      public Cuota traerNroCuotaYPrestamo(int nroCuota, long idPrestamo) throws Exception {
    	  if(prestamoDao.traer(idPrestamo) == null) {
    		  throw new Exception("ERROR: No hay ningun prestamo con esa ID");
    	  }
    	 
    	  if(dao.traerNroCuotaYPrestamo(nroCuota, idPrestamo) == null) {
    		  throw new Exception("ERROR: No hay ningun prestamo o nroCuota con esa ID");
    	  }
    	  
    	  return dao.traerNroCuotaYPrestamo(nroCuota, idPrestamo);
      }
      
      public int agregarCuota(int nroCuota, LocalDate fechaVencimiento, double saldoPendiente, double amortizacion,
    		double interesCuota, double cuota, double deuda, boolean cancelada, LocalDate fechaDePago,
			double punitorios, Prestamo prestamo) {
    	  
    	  return dao.agregar(new Cuota(nroCuota,fechaVencimiento, saldoPendiente,  amortizacion,
     	    	 interesCuota, cuota, deuda,  cancelada,  fechaDePago, punitorios,  prestamo));
      }
}
