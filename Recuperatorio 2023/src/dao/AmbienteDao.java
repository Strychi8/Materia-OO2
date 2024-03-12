package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Ambiente;

public class AmbienteDao {
    private static Session session;
    
    private void iniciaOperacion() throws HibernateException{
    	session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public Ambiente traer(int idAmbiente) throws HibernateException{
    	Ambiente objeto = null;
    	
    	try {
    		iniciaOperacion();
    		objeto = session.get(Ambiente.class, idAmbiente);
    	}finally {
    		session.close();
    	}
    	
    	return objeto;
    }
} 
