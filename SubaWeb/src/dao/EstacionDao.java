package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Estacion;

public class EstacionDao {
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
	
	public int agregar(Estacion objeto) {
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
	
	public void actualizar(Estacion objeto) throws HibernateException {
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
	
	public void eliminar(Estacion objeto) throws HibernateException {
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
	
	public Estacion traer(int idEstacion) throws HibernateException {
		Estacion objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Estacion) session.get(Estacion.class, idEstacion);
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public Estacion traer(String nombre) throws HibernateException {
		Estacion objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Estacion) session.createQuery("from Estacion e where e.nombre='"+nombre+"'").uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Estacion> traer() throws HibernateException {
		List<Estacion> estaciones = null;
		
		try {
			iniciaOperacion();
			estaciones = session.createQuery("from Estacion").list();
		} finally {
			session.close();
		}
		
		return estaciones;
	}
}
