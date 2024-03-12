package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Vacuna;

public class VacunaDao {
     private static Session session;
     private Transaction tx;
     
     private void iniciaOperacion() throws HibernateException{
    	 session = HibernateUtil.getSessionFactory().openSession();
    	 tx = session.beginTransaction();
     }
     
     public Vacuna traerVacuna(int codigo) throws HibernateException{
    	 Vacuna objeto = null;
    	 try {
    		 iniciaOperacion();
    		 String hql = "from Vacuna v where v.codigo='" + codigo + "'";
    		 objeto = (Vacuna) session.createQuery(hql).uniqueResult();
    	 }finally {
    		 session.close();
    	 }
    	 return objeto;
     }
}
