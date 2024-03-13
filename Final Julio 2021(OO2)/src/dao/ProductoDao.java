package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Producto;

public class ProductoDao {
     private static Session session;
     private Transaction tx;
     
     private void iniciaOperacion() throws HibernateException{
    	 session = HibernateUtil.getSessionFactory().openSession();
    	 tx = session.beginTransaction();
     }
     
     public Producto traerProducto(String codigo) throws HibernateException{
    	 Producto objeto = null;
    	 try {
    		 iniciaOperacion();
    		 String hql = "from Producto p where p.codigo='" + codigo + "'" ;
    		 objeto = (Producto) session.createQuery(hql).uniqueResult();
    	 }finally {
    		 session.close();
    	 }
    	 return objeto;
     }
     
     
     
}
