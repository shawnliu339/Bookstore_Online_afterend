package com.ncut.bookshop.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.ncut.bookshop.model.User;
import com.ncut.bookshop.util.HibernateUtil;

public class UserDAOTest {

	@Test
	public void test() {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.getCurrentSession();
			
			User user = new User();
			session.beginTransaction();
			user = (User) session.get(User.class, 1);
			session.getTransaction().commit();
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
