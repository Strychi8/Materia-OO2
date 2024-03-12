package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Localidad;
import datos.Ubicacion;

public class LugarDao {
	 private static Session session;
     
     private void iniciaOperacion() throws HibernateException{
   	   session = HibernateUtil.getSessionFactory().openSession();
     }
     
     
     public Ubicacion traerUbicacion(int id) throws HibernateException {
   	  Ubicacion objeto = null;
   	  try {
   		  iniciaOperacion();
   		  objeto = (Ubicacion)session.get(Ubicacion.class, id);
   		  Hibernate.initialize(objeto.getPermisos());
   	  }finally {
   		  session.close();
   	  }
   	  return objeto;
     }
     
     public Localidad traerLocalidad(int id) throws HibernateException {
      	  Localidad objeto = null;
      	  try {
      		  iniciaOperacion();
      		  String hql = "from Localidad l where l.idLugar=" + id;
      		  //objeto = (Localidad)session.get(Localidad.class, id);
      		  objeto = (Localidad)session.createQuery(hql, Localidad.class).uniqueResult();
      		  Hibernate.initialize(objeto.getPermisos());
      	  }finally {
      		  session.close();
      	  }
      	  return objeto;
        }
}
