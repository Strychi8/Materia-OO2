package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Propiedad;

public class PropiedadDao {
     private static Session session;
     private Transaction tx;
     
     private void iniciaOperacion()throws HibernateException{
    	 session = HibernateUtil.getSessionFactory().openSession();
    	 tx = session.beginTransaction();
     }
     
     @SuppressWarnings("unchecked")
	public List<Propiedad> traerPropiedad() throws HibernateException{
    	 List<Propiedad> lista = null;
    	 try {
    		 iniciaOperacion();
    		 String hql = "from Propiedad";
    		 lista = session.createQuery(hql).list();
    	 }finally {
    		 session.close();
    	 }
    	 return lista;
     }
     
     @SuppressWarnings("unchecked")
 	public List<Propiedad> traerPropiedad(boolean tieneAscensor) throws HibernateException{
     	 List<Propiedad> lista = null;
     	 try {
     		 iniciaOperacion();
     		 String hql = "from Propiedad p where p.tieneAscensor=" + tieneAscensor;
     		 lista = session.createQuery(hql).list();
     	 }finally {
     		 session.close();
     	 }
     	 return lista;
      }
}
