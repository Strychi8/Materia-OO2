package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Pedido;

public class PedidoDao {
    private static Session session;
    
    private void iniciaOperacion() throws HibernateException{
    	session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public Pedido traerPedido(int idPedido) throws HibernateException{
    	Pedido objeto = null;
    	
    	try {
    		iniciaOperacion();
    		objeto = session.get(Pedido.class, idPedido);
    		Hibernate.initialize(objeto.getItemPedidos());
    	}finally {
    		session.close();
    	}
    	
    	return objeto;
    }
    
    @SuppressWarnings("unchecked")
	public List<Pedido> traerPedido(boolean esMensual) throws HibernateException{
    	List<Pedido> lista = null;
    	
    	try {
    		iniciaOperacion();
    		String hql = "from Pedido p where p.abierto=" + esMensual;
    		lista = session.createQuery(hql).list();
    		for(Pedido p: lista) {
    			Hibernate.initialize(p.getItemPedidos());
    		}
    	}finally {
    		session.close();
    	}
    	
    	return lista;
    }
    
    @SuppressWarnings("unchecked")
	public List<Pedido> traerPedido(LocalDate fechaDesde, LocalDate fechaHasta) throws HibernateException{
    	List<Pedido> lista = null;
    	
    	try {
    		iniciaOperacion();
    		String hql = "from Pedido p where p.fechaCreacion >= '" + fechaDesde + "'" + " and p.fechaCreacion <= '" + fechaHasta + "'";
    		lista = session.createQuery(hql).list();
    		for(Pedido p: lista) {
    			Hibernate.initialize(p.getItemPedidos());
    		}
    	}finally {
    		session.close();
    	}
    	
    	return lista;
    }
    
    @SuppressWarnings("unchecked")
	public List<Pedido> traerPedido(String area) throws HibernateException{
    	List<Pedido> lista = null;
    	
    	try {
    		iniciaOperacion();
    		String hql = "from Pedido p where p.area = '" + area + "'";
    		lista = session.createQuery(hql).list();
    		for(Pedido p: lista) {
    			Hibernate.initialize(p.getItemPedidos());
    		}
    	}finally {
    		session.close();
    	}
    	
    	return lista;
    }
    
    
    
    
}
