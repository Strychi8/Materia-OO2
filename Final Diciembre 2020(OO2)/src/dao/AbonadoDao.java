package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Abonado;

public class AbonadoDao {
	 private static Session session;
	    
	    private void iniciaOperacion() throws HibernateException{
	    	session = HibernateUtil.getSessionFactory().openSession();
	    }
	    
	    public Abonado traerAbonado(long dni) throws HibernateException{
	    	Abonado objeto = null;
	    	
	    	try {
	    		iniciaOperacion();
	    		objeto = (Abonado) session.createQuery("from Abonado a where a.dni=" + dni).uniqueResult();
	    	}finally {
	    		session.close();
	    	}
	    	
	    	return objeto;
	    }
}
