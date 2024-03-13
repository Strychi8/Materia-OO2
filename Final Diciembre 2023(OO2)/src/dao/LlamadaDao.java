package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Empleado;
import datos.Llamada;

public class LlamadaDao {
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
	    
	    @SuppressWarnings("unchecked")
		public List<Llamada> traerLlamadas() throws HibernateException{
	    	List<Llamada> lista = null;
	    	
	    	try {
	    		iniciaOperacion();
	    		lista = session.createQuery("from Llamada l inner join fetch l.empleado e inner join fetch l.cliente c").list();
               
	    	}finally {
	    		session.close();
	    	}
	    	
	    	return lista;
	    }
	    
	    public int agregar(Llamada objeto) {
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
	    
	    @SuppressWarnings("unchecked")
		public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta) throws HibernateException{
	    	List<Llamada> lista = null;
	    	
	    	try {
	    		iniciaOperacion();
	    		String hql = "from Llamada l where l.fecha>='" + desde + "'" + " and l.fecha<='" + hasta + "'";
	    		lista = session.createQuery(hql).list();
                for(Llamada l: lista) {
                	Hibernate.initialize(l.getCliente());
                	Hibernate.initialize(l.getEmpleado());
                }
	    	}finally {
	    		session.close();
	    	}
	    	
	    	return lista;
	    }
	    
	    @SuppressWarnings("unchecked")
		public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta, Empleado empleado) throws HibernateException{
	    	List<Llamada> lista = null;
	    	
	    	try {
	    		iniciaOperacion();
	    		String hql = "from Llamada l inner join fetch l.empleado e where e.idPersona = " + empleado.getIdPersona() + 
	    				" and l.fecha >= '" + desde + "'" + " and l.fecha <= '" + hasta + "'";
	    		lista = session.createQuery(hql).list();
                for(Llamada l: lista) {
                	Hibernate.initialize(l.getCliente());
                }
	    	}finally {
	    		session.close();
	    	}
	    	
	    	return lista;
	    }
}
