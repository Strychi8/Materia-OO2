package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Abonado;
import datos.Manual;
import datos.Rodado;
import datos.Telepeaje;

public class PeajeDao {
    private static Session session;
    
    private void iniciaOperacion() throws HibernateException{
    	session = HibernateUtil.getSessionFactory().openSession();
    }
    
    @SuppressWarnings("unchecked")
	public List<Manual> traerManual() throws HibernateException{
    	List<Manual> lista = null;
    	
    	try {
    		iniciaOperacion();
    		lista = session.createQuery("from Manual").list();
    	}finally {
    		session.close();
    	}
    	
    	return lista;
    }
    
    @SuppressWarnings("unchecked")
	public List<Telepeaje> traerTelepeaje() throws HibernateException{
    	List<Telepeaje> lista = null;
    	
    	try {
    		iniciaOperacion();
    		lista = session.createQuery("from Telepeaje").list();
    		for(Telepeaje l: lista) {
    			Hibernate.initialize(l.getRodado());
    			Hibernate.initialize(l.getRodado().getAbonado());
    		}
    	}finally {
    		session.close();
    	}
    	
    	return lista;
    }
    
    @SuppressWarnings("unchecked")
	public List<Manual> traerManual(LocalDate fecha) throws HibernateException{
    	List<Manual> lista = null;
    	
    	try {
    		iniciaOperacion();
    		String hql = "from Manual m where m.fecha='" + fecha + "'";
    		lista = session.createQuery(hql).list();
    		
    	}finally {
    		session.close();
    	}
    	
    	return lista;
    }
    
    @SuppressWarnings("unchecked")
   	public List<Telepeaje> traerTelepeaje(Rodado rodado) throws HibernateException{
       	List<Telepeaje> lista = null;
       	
       	try {
       		iniciaOperacion();
       		lista = session.createQuery("from Telepeaje t inner join fetch t.rodado r where r.idRodado=" + rodado.getIdRodado()).list();
       		for(Telepeaje l: lista) {
       			Hibernate.initialize(l.getRodado().getAbonado());
       		}
       	}finally {
       		session.close();
       	}
       	
       	return lista;
       }
    
    @SuppressWarnings("unchecked")
   	public List<Telepeaje> traerTelepeaje(Abonado abonado) throws HibernateException{
       	List<Telepeaje> lista = null;
       	
       	try {
       		iniciaOperacion();
       		String hql = "from Telepeaje t inner join fetch t.rodado r inner join fetch r.abonado a where a.idAbonado=" + abonado.getIdAbonado();
       		lista = session.createQuery(hql).list();
       		
       	}finally {
       		session.close();
       	}
       	
       	return lista;
       }
    
    
}
