package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.BoletoEstudiantil;
import datos.Permiso;

public class BoletoEstudiantilDao {
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
	
	public int agregar(BoletoEstudiantil objeto) {
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
	
	public void actualizar(BoletoEstudiantil objeto) throws HibernateException {
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
	
	public void eliminar(BoletoEstudiantil objeto) throws HibernateException {
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
	
	public BoletoEstudiantil traer(int idBoletoEstudiantil) throws HibernateException {
		BoletoEstudiantil objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (BoletoEstudiantil) session.get(BoletoEstudiantil.class, idBoletoEstudiantil);
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public BoletoEstudiantil traer(String nivelEducativo) throws HibernateException {
		BoletoEstudiantil objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (BoletoEstudiantil) session.createQuery("from BoletoEstudiantil b where b.nivelEducativo="+nivelEducativo).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
}
