package dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Carga;
import datos.Cliente;
import datos.Envio;
import datos.Equipaje;
import datos.Vuelo;

public class CargaDao {
 private static Session session;
     
     private void iniciaOperacion() throws HibernateException{
    	 session = HibernateUtil.getSessionFactory().openSession();
     }
     
     @SuppressWarnings("unchecked")
	public List<Carga> traer(Cliente cliente) throws HibernateException{
    	 List<Carga> lista = null;
    	 
    	 try {
    		 iniciaOperacion();
    		 String hql = "from Carga c inner join fetch c.cliente cl where cl.idCliente = " + cliente.getIdCliente();
    		 lista = session.createQuery(hql).list();
    		 for(Carga c: lista) {
    			 Hibernate.initialize(c.getVuelo());
    		 }
    	 }finally {
    		 session.close();
    	 }
    	 
    	 return lista;
     }
     
     @SuppressWarnings("unchecked")
	public List<Equipaje> traer(Vuelo vuelo,boolean excedido) throws HibernateException{
    	 List<Equipaje> lista = null;
    	 
    	 try {
    		 iniciaOperacion();
    		 String hql = "from Equipaje e inner join fetch e.cliente inner join fetch e.vuelo v where v.idVuelo = " + vuelo.getIdVuelo() +
    				 " and e.excedePeso = " + excedido;
    		 lista = session.createQuery(hql).list();
    		
    	 }finally {
    		 session.close();
    	 }
    	 
    	 return lista;
     }
     
     @SuppressWarnings("unchecked")
 	public List<Envio> traer(LocalDateTime desde, LocalDateTime hasta) throws HibernateException{
     	 List<Envio> lista = null;
     	 
     	 try {
     		 iniciaOperacion();
     		 String hql = "from Envio e inner join fetch e.vuelo v where v.fechaHoraArribo >= '" + desde + "'" + 
     		 " and v.fechaHoraPartida <= '" + hasta + "'";
     		 lista = session.createQuery(hql).list();
     		 for(Envio c: lista) {
     			 Hibernate.initialize(c.getCliente());
     		 }
     	 }finally {
     		 session.close();
     	 }
     	 
     	 return lista;
      }
}
