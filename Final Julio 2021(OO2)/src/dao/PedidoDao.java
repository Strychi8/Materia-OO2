package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.NotaPedido;
import datos.Pedido;
import datos.Producto;

public class PedidoDao {
	 private static Session session;
     private Transaction tx;
     
     private void iniciaOperacion() throws HibernateException{
    	 session = HibernateUtil.getSessionFactory().openSession();
    	 tx = session.beginTransaction();
     }
     
     public Pedido traerPedido(Producto p) throws HibernateException{
    	 Pedido objeto = null;
    	 try {
    		 iniciaOperacion();
    		 String hql = "from Pedido p inner join fetch p.producto pr where pr.idProducto=" +  p.getIdProducto();
    		 objeto = (Pedido) session.createQuery(hql).uniqueResult();
    		 Hibernate.initialize(objeto.getProducto());
    		 Hibernate.initialize(objeto.getNotasPedidos());
    		 for(NotaPedido n: objeto.getNotasPedidos()) {
    			 Hibernate.initialize(n.getCliente());
    			 //Hibernate.initialize(n);
    		 }
    	 }finally {
    		 session.close();
    	 }
    	 return objeto;
     }
}
