package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Evento;

public class EventoDao {
	// ATRIBUTOS
		private static Session session;
		private Transaction tx;

		// INICIA OPERACION
		public void iniciaOperacion() throws HibernateException {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
		}

		// MANEJA EXCEPCION
		public void manejaExcepcion(HibernateException he) throws HibernateException {
			tx.rollback();
			throw new HibernateException("ERROR en la capa de acceso a datos", he);
		}

		// TRAER ID
		public Evento traer(long idEvento) throws HibernateException {
			Evento e = null;
			try {
				iniciaOperacion();
				e = (Evento) session.get(Evento.class, idEvento);
			} finally {
				session.close();
			}
			return e;

		}
		
		// TRAER LISTA
		@SuppressWarnings("unchecked")
		public List<Evento> traer() throws HibernateException {
			List<Evento> lista = null;
			try {
				iniciaOperacion();
				String hql = "from Evento e order by e.idEvento asc";
				lista = session.createQuery(hql).list();
			} finally {
				session.close();
			}
			return lista;

		}
		
		// TRAER CLIENTE Y EVENTOS
		public Evento traerEventoYClientes(long idEvento) throws HibernateException {
			Evento e = null;
			try {
				iniciaOperacion();
				String hql = "from Evento e where e.idEvento="+idEvento;
				e = (Evento) session.createQuery(hql).uniqueResult();
				Hibernate.initialize(e.getClientes());
			} finally {
				session.close();
			}
			return e;

		}
		
		// AGREGAR
		public int agregar(Evento e) throws HibernateException {
			int id = 0;
			try {
				iniciaOperacion();
				id = Integer.parseInt(session.save(e).toString());
				tx.commit();
			} catch(HibernateException he) {
				manejaExcepcion(he);
				throw he;
			}finally {
				session.close();
			}
			return id;

		}
		
		// ACTUALIZAR
		public void actualizar(Evento e) throws HibernateException {
			try {
				iniciaOperacion();
				session.update(e);
				tx.commit();
			} catch(HibernateException he) {
				manejaExcepcion(he);
				throw he;
			}finally {
				session.close();
			}
		}
		
		// ELIMINAR
		public void eliminar(Evento e) throws HibernateException {
			try {
				iniciaOperacion();
				session.delete(e);
				tx.commit();
			} catch(HibernateException he) {
				manejaExcepcion(he);
				throw he;
			}finally {
				session.close();
			}
		}
}
