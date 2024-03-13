package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Alquiler;

public class AlquilerDao {
	private static Session session;
    private Transaction tx;
    
    private void iniciaOperacion() throws HibernateException{
   	 session = HibernateUtil.getSessionFactory().openSession();
   	 tx = session.beginTransaction();
    }
    
    private void manejaExcepcion(HibernateException he) throws HibernateException{
    	tx.rollback();
    	throw new HibernateException("ERROR en la capa al acceder a los datos",he);
    }
    
    public int agregar(Alquiler alquiler,int codigo) {
    	int id = 0;
    	try {
    		iniciaOperacion();
    		id = Integer.parseInt(session.save(alquiler).toString());
    		tx.commit();
    	}catch(HibernateException he) {
    		manejaExcepcion(he);
    		throw he;
    	}finally {
    		session.close();
    	}
    	return id;
    }
    public Alquiler traerAlquiler(int id) throws HibernateException{
    	Alquiler objeto = null;
    	try {
    		iniciaOperacion();
    		objeto = (Alquiler)session.get(Alquiler.class, id);
    	}finally {
    		session.close();
    	}
    	return objeto;
    }
}
