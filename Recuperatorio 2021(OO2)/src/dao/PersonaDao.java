package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Persona;

public class PersonaDao {
	 private static Session session;
     
     private void iniciaOperacion() throws HibernateException{
    	 session = HibernateUtil.getSessionFactory().openSession();
     }
     
     @SuppressWarnings("unchecked")
	public List<Persona> traerPersona(int edadDesde, int edadHasta) throws HibernateException{
    	 List<Persona> lista = null;
    	 
    	 try {
    		 iniciaOperacion();
    		 String hql = "from Persona p where p.fechaNacimiento >='" + edadDesde + "'" + " and p.fechaNacimiento <='" + edadHasta + "'";
    		 lista = session.createQuery(hql).list();
    	 }finally {
    		 session.close();
    	 }
    	 return lista;
     }
     
}
