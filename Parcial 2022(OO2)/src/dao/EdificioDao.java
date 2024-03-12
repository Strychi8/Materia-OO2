package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Edificio;

public class EdificioDao {
	 private static Session session;
     
     private void iniciaOperacion() throws HibernateException{
    	 session = HibernateUtil.getSessionFactory().openSession();    	
     }
       
     public Edificio traerEdificioConAulas(int id) throws HibernateException{
    	 Edificio objeto = null;
    	 try {
    		 iniciaOperacion();
    		 objeto = (Edificio) session.get(Edificio.class, id);
    		 Hibernate.initialize(objeto.getAulas());
    	 }finally {
    		 session.close();
    	 }
    	 return objeto;
     }
}
