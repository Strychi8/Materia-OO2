package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;

public class ClienteDao {

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
	public Cliente traer(long idCliente) throws HibernateException {
		Cliente c = null;
		try {
			iniciaOperacion();
			c = (Cliente) session.get(Cliente.class, idCliente);
		} finally {
			session.close();
		}
		return c;

	}

	// TRAER DNI
	public Cliente traer(int dni) throws HibernateException {
		Cliente c = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c where c.dni="+dni;
			c = (Cliente) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		return c;

	}
	
	// TRAER LISTA
	@SuppressWarnings("unchecked")
	public List<Cliente> traer() throws HibernateException {
		List<Cliente> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c order by c.idCliente asc";
			lista = session.createQuery(hql).list();
		} finally {
			session.close();
		}
		return lista;

	}
	
	// TRAER CLIENTE Y EVENTOS
	public Cliente traerClienteYEventos(long idCliente) throws HibernateException {
		Cliente c = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c where c.idCliente="+idCliente;
			c = (Cliente) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(c.getEventos());
		} finally {
			session.close();
		}
		return c;

	}
	
	// AGREGAR
	public int agregar(Cliente c) throws HibernateException {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(c).toString());
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
	public void actualizar(Cliente c) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(c);
			tx.commit();
		} catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	
	// ELIMINAR
	public void eliminar(Cliente c) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(c);
			tx.commit();
		} catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	
}
