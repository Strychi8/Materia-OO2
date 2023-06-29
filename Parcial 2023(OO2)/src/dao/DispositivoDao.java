package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Dispositivo;

public class DispositivoDao {
      private static Session session;
      
      private void iniciaOperacion() throws HibernateException{
    	  session = HibernateUtil.getSessionFactory().openSession();

      }
      
      @SuppressWarnings("unchecked")
	public List<Dispositivo> traer() throws HibernateException{
    	  List<Dispositivo> lista = null;
    	  try {
    		  iniciaOperacion();
    		  lista = session.createQuery("from Dispositivo").list();
    	  }finally {
    		  session.close();
    	  }
    	  return lista;
      }
      
      public Dispositivo traer(String nombre) throws HibernateException {
    	  Dispositivo objeto = null;
    	  try {
    		  iniciaOperacion();
    		  String hql = "from Dispositivo d where d.nombre='" + nombre + "'";
    		  objeto = (Dispositivo) session.createQuery(hql).uniqueResult();
    	  }finally {
    		  session.close();
    	  }
    	  return objeto;
      }
      
      @SuppressWarnings("unchecked")
	public List<Dispositivo> traerTodosLosDispositivosSensorTemperatura(){
    	  List<Dispositivo> lista = null;
    	  try {
    		  iniciaOperacion();
    		  String hql = "from SensorTemperatura";
    		  lista = (List<Dispositivo>) session.createQuery(hql).list();
    	  }finally {
    		  session.close();
    	  }
    	  return lista;
      }
}
