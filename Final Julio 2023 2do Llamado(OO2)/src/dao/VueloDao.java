package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Vuelo;

public class VueloDao {
     private static Session session;
     
     private void iniciaOperacion() throws HibernateException{
    	 session = HibernateUtil.getSessionFactory().openSession();
     }
     
     public Vuelo traer(String vuelo) throws HibernateException{
    	 Vuelo objeto = null;
    	 
    	 try {
    		 iniciaOperacion();
    		 String hql = "from Vuelo v where v.vuelo = '" + vuelo + "'";
    		 objeto = (Vuelo) session.createQuery(hql).uniqueResult();
    		 Hibernate.initialize(objeto.toString());
    	 }finally {
    		 session.close();
    	 }
    	 
    	 return objeto;
     }
}
