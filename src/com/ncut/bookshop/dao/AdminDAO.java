package com.ncut.bookshop.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ncut.bookshop.dao.impl.AdminDAOImpl;
import com.ncut.bookshop.model.Admin;
import com.ncut.bookshop.util.HibernateUtil;

public class AdminDAO implements AdminDAOImpl {

	@Override
	public Admin findByUsername(String username) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.getCurrentSession();
			
			session.beginTransaction();
			Admin admin = new Admin();
			Query q = session.createQuery("from Admin admin where admin.username = :username");
			q.setString("username", username);
			admin = (Admin) q.uniqueResult();
			session.getTransaction().commit();
			return admin;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
