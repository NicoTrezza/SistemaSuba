package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Usuario;

public class UsuarioDao {
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
	
	public int agregar(Usuario objeto) {
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
	
	public void actualizar(Usuario objeto) throws HibernateException {
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
	
	public void eliminar(Usuario objeto) throws HibernateException {
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
	
	public Usuario traer(int idUsuario) throws HibernateException {
		Usuario objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Usuario u inner join fetch u.permiso "
					+ "inner join fetch u.tipoIdentificacion "
					+ "left join fetch u.tarifaSocial "
					+ "left join fetch u.lstTarjetas "
					+ "left join fetch u.boletoEstudiantil "
					+ "where u.idUsuario="+idUsuario;
			objeto = (Usuario) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Usuario traerPorIdentificacion(long nroIdentificacion) throws HibernateException {
		Usuario objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Usuario) session.createQuery("from Usuario u where u.nroIdentificacion="+nroIdentificacion).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
}
