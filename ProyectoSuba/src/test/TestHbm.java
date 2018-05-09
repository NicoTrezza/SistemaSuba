package test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.HibernateUtil;

public class TestHbm {

	public static void main(String[] args) {
		Session session;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.close();
	}
}
