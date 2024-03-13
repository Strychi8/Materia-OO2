package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Rodado;

public class RodadoDao {
	 private static Session session;
	    
	    private void iniciaOperacion() throws HibernateException{
	    	session = HibernateUtil.getSessionFactory().openSession();
	    }
	    
	   public Rodado traerRodado(String dominio) throws HibernateException {
		   Rodado objeto = null;
		   
		   try {
			   iniciaOperacion();
			   String hql = "from Rodado r where r.dominio='" + dominio + "'";
			   objeto = (Rodado) session.createQuery(hql).uniqueResult();
			   Hibernate.initialize(objeto.getAbonado());
		   }finally {
			   session.close();
		   }
		   
		   return objeto;
	   }
}
