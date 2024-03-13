package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Almacen;
import datos.Lote;
import datos.Producto;

public class StockDao {
	private static Session session;
    private Transaction tx;
    
    private void iniciaOperacion() throws HibernateException{
   	 session = HibernateUtil.getSessionFactory().openSession();
   	 tx = session.beginTransaction();
    }
    
    public Almacen traerAlmacen(Producto p) throws HibernateException{
   	 Almacen objeto = null;
   	 try {
   		 iniciaOperacion();
   		 String hql = "from Almacen a inner join fetch a.producto p where p.idProducto=" +  p.getIdProducto();
   		 objeto = (Almacen) session.createQuery(hql).uniqueResult();
   		 Hibernate.initialize(objeto.getProducto());
   		 Hibernate.initialize(objeto.getLotes());
   		 for(Lote l: objeto.getLotes()) {
   			 Hibernate.initialize(l);
   		 }
   	 }finally {
   		 session.close();
   	 }
   	 return objeto;
    }
}
