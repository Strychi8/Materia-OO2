package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Permiso;

public class PermisoDao {
      private static Session session;
      
      private void iniciaOperacion() throws HibernateException{
    	  session = HibernateUtil.getSessionFactory().openSession();
      }
          
      public Permiso traerPermiso(int id) throws HibernateException {
    	  Permiso objeto = null;
    	  try {
    		  iniciaOperacion();
    		  String hql = "from Permiso p inner join fetch p.persona inner join fetch p.rodado where p.idPermiso=" + id;
    		  //objeto = (Permiso)session.createQuery(hql, Permiso.class).uniqueResult();
    		  objeto = (Permiso)session.createQuery(hql, Permiso.class).uniqueResult();
    		  Hibernate.initialize(objeto.getDesdeHasta());
    	  }finally {
    		  session.close();
    	  }
    	  return objeto;
      }
}
