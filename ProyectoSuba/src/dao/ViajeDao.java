package dao;

import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Viaje;

public class ViajeDao {
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
	
	public int agregar(Viaje objeto) {
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
	
	public void actualizar(Viaje objeto) throws HibernateException {
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
	
	public void eliminar(Viaje objeto) throws HibernateException {
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
	
	public Viaje traer(int idViaje) throws HibernateException {
		Viaje objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Viaje) session.get(Viaje.class, idViaje);
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Viaje> traer() throws HibernateException {
		List<Viaje> viajes = null;
		
		try {
			iniciaOperacion();
			viajes = session.createQuery("from Viaje").list();
		} finally {
			session.close();
		}
		
		return viajes;
	}
	
	@SuppressWarnings("unchecked")
	public List<Viaje> traerPorTransporte(GregorianCalendar fechaInicio, GregorianCalendar fechaFin) {
		List<Viaje> viajes = null;
		try {
			iniciaOperacion();
			String hql = "from Viaje v "
					+ "inner join fetch v.tarjeta "
					+ "inner join fetch v.maquina "
					+ "where v.fechaHora between :fechaI and :fechaF "
					+ "order by v.maquina.tipo desc, v.fechaHora asc";
			viajes = session.createQuery(hql).setParameter("fechaI", fechaInicio).setParameter("fechaF", fechaFin).list();
		} finally {
			session.close();
		}
		return viajes;
	}
	
	@SuppressWarnings("unchecked")
	public List<Viaje> traerEnColectivo(GregorianCalendar fechaInicio, GregorianCalendar fechaFin) {
		List<Viaje> viajes = null;
		try {
			iniciaOperacion();
			String hql = "from Viaje v "
					+ "inner join fetch v.tarjeta "
					+ "inner join fetch v.maquina "
					+ "where v.fechaHora between :fechaI and :fechaF "
					+ "and v.maquina.tipo = 1 "
					+ "order by v.maquina.tipo desc, v.fechaHora asc";
			viajes = session.createQuery(hql).setParameter("fechaI", fechaInicio).setParameter("fechaF", fechaFin).list();
		} finally {
			session.close();
		}
		return viajes;
	}
	
	@SuppressWarnings("unchecked")
	public List<Viaje> traerEnTren(GregorianCalendar fechaInicio, GregorianCalendar fechaFin) {
		List<Viaje> viajes = null;
		try {
			iniciaOperacion();
			String hql = "from Viaje v "
					+ "inner join fetch v.tarjeta "
					+ "inner join fetch v.maquina "
					+ "inner join fetch v.maquina.estacion "
					+ "where v.fechaHora between :fechaI and :fechaF "
					+ "and v.maquina.tipo = 2 "
					+ "order by v.maquina.tipo desc, v.fechaHora asc, v.valor desc";
			viajes = session.createQuery(hql).setParameter("fechaI", fechaInicio).setParameter("fechaF", fechaFin).list();
		} finally {
			session.close();
		}
		return viajes;
	}
	
	@SuppressWarnings("unchecked")
	public List<Viaje> traerEnSubte(GregorianCalendar fechaInicio, GregorianCalendar fechaFin) {
		List<Viaje> viajes = null;
		try {
			iniciaOperacion();
			String hql = "from Viaje v "
					+ "inner join fetch v.tarjeta "
					+ "inner join fetch v.maquina "
					+ "inner join fetch v.maquina.estacion "
					+ "where v.fechaHora between :fechaI and :fechaF "
					+ "and v.maquina.tipo = 3 "
					+ "order by v.maquina.tipo desc, v.fechaHora asc, v.valor desc";
			viajes = session.createQuery(hql).setParameter("fechaI", fechaInicio).setParameter("fechaF", fechaFin).list();
		} finally {
			session.close();
		}
		return viajes;
	}
}
