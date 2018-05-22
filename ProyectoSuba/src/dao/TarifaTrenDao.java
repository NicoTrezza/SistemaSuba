package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.TarifaTren;

public class TarifaTrenDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Error en la capa de acceso a datos", he);
	}
	
	public int agregar(TarifaTren objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	public void actualizar(TarifaTren objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public void eliminar(TarifaTren objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public TarifaTren traer(int idTarifaTren) throws HibernateException {
		TarifaTren objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (TarifaTren) session.get(TarifaTren.class, idTarifaTren);
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public TarifaTren traerMax() throws HibernateException {
		TarifaTren objeto = null;
		
		try {
			iniciaOperacion();
			String hql;
			hql = "from TarifaTren tt order by valor desc";
			objeto = (TarifaTren) session.createQuery(hql).setMaxResults(1).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
}
