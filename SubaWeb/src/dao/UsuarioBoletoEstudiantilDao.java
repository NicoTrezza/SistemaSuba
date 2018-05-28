package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.UsuarioBoletoEstudiantil;

public class UsuarioBoletoEstudiantilDao {
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
	
	public int agregar(UsuarioBoletoEstudiantil objeto) {
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
	
	public void actualizar(UsuarioBoletoEstudiantil objeto) throws HibernateException {
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
	
	public void eliminar(UsuarioBoletoEstudiantil objeto) throws HibernateException {
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
	
	public UsuarioBoletoEstudiantil traer(int idUsuarioBoletoEstudiantil) throws HibernateException {
		UsuarioBoletoEstudiantil objeto = null;
		
		try {
			iniciaOperacion();
			String hql = "from UsuarioBoletoEstudiantil ube "
					+ "inner join fetch ube.usuario "
					+ "inner join fetch ube.usuario.permiso "
					+ "inner join fetch ube.usuario.tipoIdentificacion "
					+ "left join fetch ube.usuario.tarifaSocial "
					+ "left join fetch ube.usuario.lstTarjetas "
					+ "left join fetch ube.usuario.boletoEstudiantil " 
					+ "inner join fetch ube.boletoEstudiantil "
					+ "where ube.idUsuarioBoletoEstudiantil="+idUsuarioBoletoEstudiantil;
			objeto = (UsuarioBoletoEstudiantil) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public UsuarioBoletoEstudiantil traerPorUsuario(int idUsuario) throws HibernateException {
		UsuarioBoletoEstudiantil objeto = null;
		
		try {
			iniciaOperacion();
			String hql = "from UsuarioBoletoEstudiantil ube "
					+ "inner join fetch ube.usuario "
					+ "inner join fetch ube.usuario.permiso "
					+ "inner join fetch ube.usuario.tipoIdentificacion "
					+ "left join fetch ube.usuario.tarifaSocial "
					+ "left join fetch ube.usuario.lstTarjetas "
					+ "left join fetch ube.usuario.boletoEstudiantil " 
					+ "inner join fetch ube.boletoEstudiantil "
					+ "where ube.usuario.idUsuario="+idUsuario;
			objeto = (UsuarioBoletoEstudiantil) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
}
