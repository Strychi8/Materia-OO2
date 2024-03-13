package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.ItemPedido;

public class ItemPedidoDao {
	  private static Session session;
	    
	    private void iniciaOperacion() throws HibernateException{
	    	session = HibernateUtil.getSessionFactory().openSession();
	    }
	    
	    public ItemPedido traer(int idItemPedido) throws HibernateException{
	    	ItemPedido objeto = null;
	    	
	    	try {
	    		iniciaOperacion();
	    		String hql = "from ItemPedido i where i.idItemPedido =" + idItemPedido;
	    		objeto = (ItemPedido) session.createQuery(hql).uniqueResult();
	    		Hibernate.initialize(objeto.getInsumo());
	    		Hibernate.initialize(objeto.getPedido());
	    	}finally {
	    		session.close();
	    	}
	    	
	    	return objeto;
	    }
}
