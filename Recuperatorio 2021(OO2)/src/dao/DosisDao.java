package dao;

import java.time.LocalTime;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Dosis;
import datos.Vacuna;

public class DosisDao {
	 private static Session session;
     private Transaction tx;
     
     private void iniciaOperacion() throws HibernateException{
    	 session = HibernateUtil.getSessionFactory().openSession();
    	 tx = session.beginTransaction();
     }
     
     @SuppressWarnings("unchecked")
	public List<Dosis> traerDosis(Vacuna vacuna) throws HibernateException{
    	 List<Dosis> lista = null;
    	 try {
    		 iniciaOperacion();
    		 String hql = "from Dosis d inner join fetch d.vacuna v where v.idVacuna=" + vacuna.getIdVacuna();
    		 lista = session.createQuery(hql).list();
    	 }finally {
    		 session.close();
    	 }
    	 return lista;
     }
     
     @SuppressWarnings("unchecked")
 	public List<Dosis> traerDosis(LocalTime horaDesde, LocalTime horaHasta) throws HibernateException{
     	 List<Dosis> lista = null;
     	 try {
     		 iniciaOperacion();
     		 String hql = "from Dosis d where d.hora>='" + horaDesde + "'" + " and d.hora<='" + horaHasta + "'";
     		 lista = session.createQuery(hql).list();
     	 }finally {
     		 session.close();
     	 }
     	 return lista;
      }
     
     @SuppressWarnings("unchecked")
  	public List<Dosis> traerDosis(LocalTime horaDesde, LocalTime horaHasta, boolean tieneComorbilidad) throws HibernateException{
      	 List<Dosis> lista = null;
      	 try {
      		 iniciaOperacion();
      		 String hql = "from Dosis d inner join fetch d.persona p where p.tieneComorbilidad=" + tieneComorbilidad + 
      				 " and d.hora>='" + horaDesde + "'" + " and d.hora<='" + horaHasta + "'";
      		 lista = session.createQuery(hql).list();
      	 }finally {
      		 session.close();
      	 }
      	 return lista;
       }
}
