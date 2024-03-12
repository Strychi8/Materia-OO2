package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Materia;
import datos.NotaPedido;

public class NotaPedidoDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR al acceder a la capa de datos", he);
	}

	public NotaPedido traerNotaPedidoConMateria(int idNotaPedido) throws HibernateException {
		NotaPedido objeto = null;

		try {
			iniciaOperacion();
			String hql = "from NotaPedido n inner join fetch n.materia where n.idNotaPedido =" + idNotaPedido;
			objeto = (NotaPedido) session.createQuery(hql).uniqueResult();
			// Hibernate.initialize(objeto.getMateria());
		} finally {
			session.close();
		}

		return objeto;
	}

	@SuppressWarnings("unchecked")
	public List<NotaPedido> traer(LocalDate fechaExamen) throws HibernateException {
		List<NotaPedido> lista = null;

		try {
			iniciaOperacion();
			String hql = "from NotaPedido n inner join fetch n.materia where n.fecha = '" + fechaExamen + "'";
			lista = session.createQuery(hql).list();
		} finally {
			session.close();
		}

		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<NotaPedido> traerFinales(LocalDate desde, LocalDate hasta) throws HibernateException {
		List<NotaPedido> lista = null;

		try {
			iniciaOperacion();
			String hql = "from NotaPedido n inner join fetch n.materia where n.fechaExamen >= '" + desde + "'"
					+ " and n.fechaExamen <= '" + hasta + "'";
			lista = session.createQuery(hql).list();
		} finally {
			session.close();
		}

		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<NotaPedido> traerFinales(LocalDate desde, LocalDate hasta, Materia materia) throws HibernateException {
		List<NotaPedido> lista = null;

		try {
			iniciaOperacion();
			String hql = "from NotaPedido n inner join fetch n.materia m where m.idMateria =" + materia.getIdMateria()
					+ " and n.fechaExamen >= '" + desde + "'" + " and n.fechaExamen <= '" + hasta + "'";
			lista = session.createQuery(hql).list();
		} finally {
			session.close();
		}

		return lista;
	}
	
	public int agregar(NotaPedido objeto) {
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
	
	

}
