package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Materia;

public class MateriaDao {
    private static Session session;
    
    private void iniciaOperacion() throws HibernateException{
    	session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public Materia traerMateria(int idMateria) throws HibernateException{
    	Materia objeto = null;
    	
    	try {
    		iniciaOperacion();
    		objeto = session.get(Materia.class, idMateria);
    	}finally {
    		session.close();
    	}
    	
    	return objeto;
    }
}
