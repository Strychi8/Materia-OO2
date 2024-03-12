package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Aula;

public class AulaDao {
     private static Session session;
     
     private void iniciaOperacion() throws HibernateException{
    	 session = HibernateUtil.getSessionFactory().openSession();
     }
       
     public Aula traer(int id) throws HibernateException{
    	 Aula objeto = null;
    	 try {
    		 iniciaOperacion();
    		 String hql = "from Aula a inner join fetch a.edificio where a.idAula=" + id;
    		 objeto = (Aula) session.createQuery(hql).uniqueResult();
    	 }finally {
    		 session.close();
    	 }
    	 return objeto;
     }
     
}
