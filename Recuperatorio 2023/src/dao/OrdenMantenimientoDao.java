package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Ambiente;
import datos.OrdenMantenimiento;

public class OrdenMantenimientoDao {
	 private static Session session;
	    
	    private void iniciaOperacion() throws HibernateException{
	    	session = HibernateUtil.getSessionFactory().openSession();
	    }
	    
	    @SuppressWarnings("unchecked")
		public List<OrdenMantenimiento> traer(Ambiente ambiente) throws HibernateException{
	    	List<OrdenMantenimiento> lista = null;
	    	
	    	try {
	    		iniciaOperacion();
	    		String hql = "from OrdenMantenimiento o inner join fetch o.ambiente a where a.idAmbiente=" + ambiente.getIdAmbiente();
	    		lista = session.createQuery(hql).list();
	    	}finally {
	    		session.close();
	    	}
	    	
	    	return lista;
	    }
	    
	    @SuppressWarnings("unchecked")
		public List<OrdenMantenimiento> traer(Ambiente ambiente, boolean terminada) throws HibernateException{
	    	List<OrdenMantenimiento> lista = null;
	    	
	    	try {
	    		iniciaOperacion();
	    		String hql = "from OrdenMantenimiento o inner join fetch o.ambiente a where a.idAmbiente=" + ambiente.getIdAmbiente() +
	    				" and o.terminada=" + terminada;
	    		lista = session.createQuery(hql).list();
	    	}finally {
	    		session.close();
	    	}
	    	
	    	return lista;
	    }
	    
	    @SuppressWarnings("unchecked")
	  		public List<OrdenMantenimiento> traer(boolean pagada) throws HibernateException{
	  	    	List<OrdenMantenimiento> lista = null;
	  	    	
	  	    	try {
	  	    		iniciaOperacion();
	  	    		String hql = "from OrdenMantenimiento o where o.pagada=" + pagada;
	  	    		lista = session.createQuery(hql).list();
	  	    		for(OrdenMantenimiento orden: lista) {
	  	    			Hibernate.initialize(orden.getAmbiente());
	  	    		}
	  	    	}finally {
	  	    		session.close();
	  	    	}
	  	    	
	  	    	return lista;
	  	    }
}
