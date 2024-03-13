package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Cliente;

public class ClienteDao {
     private static Session session;
     
     private void iniciaOperacion() throws HibernateException{
    	 session = HibernateUtil.getSessionFactory().openSession();
     }
     
     public Cliente traer(long dni) throws HibernateException{
    	 Cliente objeto = null;
    	 
    	 try {
    		 iniciaOperacion();
    		 objeto = (Cliente) session.createQuery("from Cliente c where c.dni=" + dni).uniqueResult();
    	 }finally {
    		 session.close();
    	 }
    	 
    	 return objeto;
     }
}
