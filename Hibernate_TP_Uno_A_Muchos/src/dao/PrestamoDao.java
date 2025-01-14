package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Prestamo;

public class PrestamoDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.getTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(Prestamo p) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(p).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(Prestamo p) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(p);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public void eliminar(Prestamo p) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(p);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public Prestamo traer(long idPrestamo) throws HibernateException {
		Prestamo p = null;
		try {
			iniciaOperacion();
			p = (Prestamo) session
					.createQuery("from Prestamo p inner join fetch p.cliente c where p.idPrestamo=" + idPrestamo)
					.uniqueResult();
		} finally {
			session.close();
		}
		return p;
	}

	public Prestamo traerPrestamoYCuota(long idPrestamo) throws HibernateException {
		Prestamo p = null;
		try {
			iniciaOperacion();
			String hql = "from Prestamo p where p.idPrestamo = " + idPrestamo;
			p = (Prestamo) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(p.getCuotas());
		} finally {
			session.close();
		}
		return p;
	}

	@SuppressWarnings("unchecked")
	public List<Prestamo> traer(Cliente c) throws HibernateException {
		List<Prestamo> lista = null;
		try {
			iniciaOperacion();
			lista = session
					.createQuery("from Prestamo p inner join fetch p.cliente c where c.idCliente=" + c.getIdCliente())
					.list();
		} finally {
			session.close();
		}
		return lista;
	}

}
