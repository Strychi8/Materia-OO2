package negocio;

import java.time.LocalDate;

import dao.EspacioDao;
import datos.Aula;
import datos.Espacio;

public class EspacioAbm {
      EspacioDao dao = new EspacioDao();
    	  
      public Espacio traer(LocalDate fecha,char turno,Aula aula) {
    	  return dao.traer(fecha, turno, aula);
      }
      
      public int agregar(LocalDate fecha, char turno, Aula aula, boolean libre) throws Exception {
    	  if(traer(fecha,turno,aula) != null) {
    		  throw new Exception("ERROR: Ya existe el objeto en la BD");
    	  }
    	  Espacio espacio = new Espacio(fecha,turno,aula,libre);
    	  return dao.agregar(espacio);
      }
      
      public void agregarEspacioMes(int mes, int anio, char turno, Aula aula) throws Exception {
    	  LocalDate fecha = LocalDate.of(anio, mes, 1);
    	  int ultimoDiaMes = fecha.getMonth().length(fecha.isLeapYear());
          
    	  if(traer(fecha,turno,aula) != null) {
    		  throw new Exception("ERROR: Ya existe ese objeto");
    	  }
    		for(int i = 1; i<=ultimoDiaMes; i++) {
    			try {
    				agregar(fecha, turno, aula, true);
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
    			fecha = fecha.plusDays(1);
    		}
    	  
      }
}
