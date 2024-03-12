package dao;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Aula;
import datos.Espacio;

public class EspacioDao {
	 private static Session session;
     private Transaction tx;
     
     private void iniciaOperacion() throws HibernateException{
    	 session = HibernateUtil.getSessionFactory().openSession();
    	 tx = session.beginTransaction();
     }
     
     private void manejaExcepcion(HibernateException he) throws HibernateException{
    	 tx.rollback();
    	 throw new HibernateException("ERROR en el acceso a la capa de datos",he);
     }
     
     public Espacio traer(LocalDate fecha, char turno, Aula aula) throws HibernateException{
    	 Espacio objeto = null;
    	 try {
    		 iniciaOperacion();
    		 String hql = "from Espacio e inner join fetch e.aula a inner join fetch a.edificio where a.idAula=" + aula.getIdAula() +
    				 " and e.fecha='" + fecha + "' and e.turno='" + turno + "'";
    		 objeto = (Espacio) session.createQuery(hql).uniqueResult();
    	 }finally {
    		 session.close();
    	 }
    	 return objeto;
     }
     
     public int agregar(Espacio espacio) {
    	 int id = 0;
    	 try {
    		 iniciaOperacion();
    		 id = Integer.parseInt(session.save(espacio).toString());
    		 tx.commit();
    	 }catch(HibernateException he){
    		 manejaExcepcion(he);
    		 throw he;
    	 }finally {
    		 session.close();
    	 }
    	 return id;
     }

     
    
     
}
