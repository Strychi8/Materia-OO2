package dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Dispositivo;
import datos.Evento;

public class EventoDao {
	 private static Session session;
     private Transaction tx;
     
     private void iniciaOperacion() throws HibernateException{
   	  session = HibernateUtil.getSessionFactory().openSession();
   	  tx = session.beginTransaction();
     }
     
     private void manejaExcepcion(HibernateException he) throws HibernateException{
    	 tx.rollback();
    	 throw new HibernateException("ERROR en la capa al acceder a los datos",he);
     }
     
     public Evento traer(Dispositivo dispositivo, LocalDateTime fechaHora) throws HibernateException{
    	 Evento objeto = null;
    	 try {
    		 iniciaOperacion();
    		 String hql = "from Evento e inner join fetch e.dispositivo d where d.idDispositivo=" + dispositivo.getIdDispositivo() +
    				 " and e.fechaHora='" + fechaHora + "'";
    		 objeto = (Evento) session.createQuery(hql).uniqueResult();
    	 }finally {
    		 session.close();
    	 }
    	 return objeto;
     }
     
     public int agregar(Evento evento) {
    	 int id = 0;
    	 try {
    		 iniciaOperacion();
    		 id = Integer.parseInt(session.save(evento).toString());
    	 }catch(HibernateException he) {
    		 manejaExcepcion(he);
    		 throw he;
    	 }finally {
    		 session.close();
    	 }
    	 return id;
     }
     
     @SuppressWarnings("unchecked")
 	public List<Evento> traer() throws HibernateException{
     	  List<Evento> lista = null;
     	  try {
     		  iniciaOperacion();
     		  lista = session.createQuery("from Evento e inner join fetch e.dispositivo d").list();
     
     	  }finally {
     		  session.close();
     	  }
     	  return lista;
       }
     
     @SuppressWarnings("unchecked")
	public List<Evento> traer(LocalDateTime fechaHoraDesde,LocalDateTime fechaHoraHasta){
    	 List<Evento> lista = null;
    	 try {
    		 iniciaOperacion();
    		 String hql = "from Evento e inner join fetch e.dispositivo d where e.fechaHora>='" + fechaHoraDesde + "'" + " and e.fechaHora<='" + fechaHoraHasta + "'";
    		 lista = session.createQuery(hql).list();
    		 
    	 }finally {
    		 session.close();
    	 }
    	 return lista;
     }
     
     @SuppressWarnings("unchecked")
 	public List<Evento> traer(LocalDateTime fechaHoraDesde,LocalDateTime fechaHoraHasta,Dispositivo dispositivo){
     	 List<Evento> lista = null;
     	 try {
     		 iniciaOperacion();
     		 String hql = "from Evento e inner join fetch e.dispositivo d where d.idDispositivo=" + dispositivo.getIdDispositivo() 
     		 + " and e.fechaHora>='" + fechaHoraDesde + "'" + " and e.fechaHora<='" + fechaHoraHasta + "'";
     		 lista = session.createQuery(hql).list();
     		
     	 }finally {
     		 session.close();
     	 }
     	 return lista;
      }
     
}
