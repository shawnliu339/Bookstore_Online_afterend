package com.ncut.bookshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ncut.bookshop.dao.impl.BookDAOImpl;
import com.ncut.bookshop.model.Book;
import com.ncut.bookshop.util.HibernateUtil;

public class BookDAO implements BookDAOImpl {

	@Override
	public List findAll() {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.getCurrentSession();
			
			session.beginTransaction();
			Query q = session.createQuery("from Book");
			List<Book> books = new ArrayList<Book>();
			books = q.list();
			session.getTransaction().commit();
//			sf.close();
			return books;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Book findBookById(Integer id) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.getCurrentSession();

			session.beginTransaction();
			Book book = (Book) session.get(Book.class, id);
			session.getTransaction().commit();
//			sf.close();
			return book;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean update(Book book) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.getCurrentSession();
			
			if(book.getDate().equals("")) {
				book.setDate(null);
			}
			session.beginTransaction();
			session.update(book);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Integer add(Book book) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.getCurrentSession();
			
			if(book.getDate().equals("")) {
				book.setDate(null);
			}
			session.beginTransaction();
			session.save(book);
			session.getTransaction().commit();
			return book.getId();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(Integer id) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.getCurrentSession();
			
			session.beginTransaction();
			Query q = session.createQuery("delete Book book where book.id=:id");
			q.setInteger("id", id);
			q.executeUpdate();
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
