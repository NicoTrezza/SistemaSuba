package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.BoletoTren;
import datos.Estacion;

public class BoletoTrenDao {
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
	
	public int agregar(BoletoTren objeto) {
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
	
	public void actualizar(BoletoTren objeto) throws HibernateException {
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
	
	public void eliminar(BoletoTren objeto) throws HibernateException {
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
	
	public BoletoTren traer(int idBoletoTren) throws HibernateException {
		BoletoTren objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (BoletoTren) session.get(BoletoTren.class, idBoletoTren);
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public BoletoTren traer(Estacion estacionI, Estacion estacionE) throws HibernateException {
		BoletoTren objeto = null;
		
		try {
			iniciaOperacion();
			String hql;
			hql = "from BoletoTren bt "
					+ "inner join fetch bt.tarifaTren "
					+ "inner join fetch bt.estacionIngreso "
					+ "inner join fetch bt.estacionEgreso "
					+ "where bt.estacionIngreso.idEstacion=" + estacionI.getIdEstacion()
					+ " and bt.estacionEgreso.idEstacion=" + estacionE.getIdEstacion();
			objeto = (BoletoTren) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
}
