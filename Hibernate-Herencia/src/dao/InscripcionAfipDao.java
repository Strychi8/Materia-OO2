package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.InscripcionAfip;

public class InscripcionAfipDao {
	private static Session session;
	private Transaction tx;
	private static InscripcionAfipDao instancia = null; // Patrón Singleton

	protected InscripcionAfipDao() {
	}

	public static InscripcionAfipDao getInstance() {
		if (instancia == null)
			instancia = new InscripcionAfipDao();
		return instancia;
	}

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public InscripcionAfip traer(int idInscripcionAfip) {
		InscripcionAfip objeto = null;
		try {
			iniciaOperacion();
			objeto = (InscripcionAfip) session.createQuery("from InscripcionAfip c where c.idInscripcionAfip =" + idInscripcionAfip).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	@SuppressWarnings("unchecked")
	public List<InscripcionAfip> traer() throws HibernateException {
		List<InscripcionAfip> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from InscripcionAfip").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public int agregar(InscripcionAfip objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return id;
	}
	
	public void actualizar(InscripcionAfip objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	
	public void eliminar(InscripcionAfip objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
}
