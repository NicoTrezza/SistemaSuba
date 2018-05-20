package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.BoletoColectivo;
import datos.Tarjeta;

public class BoletoColectivoDao {
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
	
	public int agregar(BoletoColectivo objeto) {
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
	
	public void actualizar(BoletoColectivo objeto) throws HibernateException {
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
	
	public void eliminar(BoletoColectivo objeto) throws HibernateException {
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
	
	public BoletoColectivo traer(int idBoletoColectivo) throws HibernateException {
		BoletoColectivo objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (BoletoColectivo) session.get(BoletoColectivo.class, idBoletoColectivo);
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public BoletoColectivo traerMax() throws HibernateException {
		BoletoColectivo objeto = null;
		
		try {
			iniciaOperacion();
			String hql;
			hql = "from BoletoColectivo bc order by seccion desc";
			objeto = (BoletoColectivo) session.createQuery(hql).setMaxResults(1).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
}
