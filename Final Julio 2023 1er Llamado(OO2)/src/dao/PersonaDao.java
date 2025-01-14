package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Persona;

public class PersonaDao {
    private static Session session;
    private Transaction tx;
    
    private void iniciaOperacion() throws HibernateException{
    	session = HibernateUtil.getSessionFactory().openSession();
    	tx = session.beginTransaction();
    }
    
    private void manejaExcepcion(HibernateException he) throws HibernateException{
    	tx.rollback();
    	throw new HibernateException("ERROR al acceder a la capa de datos:",he);
    }
    
    public Persona traerPersona(long dni) throws HibernateException{
    	Persona objeto = null;
    	
    	try {
    		iniciaOperacion();
    		objeto = (Persona) session.createQuery("from Persona p where p.dni=" + dni).uniqueResult();
    	}finally {
    		session.close();
    	}
    	
    	return objeto;
    }
    
    public int agregar(Persona objeto) {
    	int id = 0;
    	
    	try {
    		iniciaOperacion();
    		id = Integer.parseInt(session.save(objeto).toString());
    		tx.commit();
    	}catch(HibernateException he) {
    		manejaExcepcion(he);
    		throw he;
    	}finally {
    		session.close();
    	}
    	
    	
    	return id;
    }
    
}
