package com.ncut.bookshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ncut.bookshop.dao.impl.GuestbookDAOImpl;
import com.ncut.bookshop.model.Guestbook;
import com.ncut.bookshop.util.HibernateUtil;
import com.ncut.bookshop.vo.GuestbookVO;

public class GuestbookDAO implements GuestbookDAOImpl {

	@Override
	public List findAll() {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.getCurrentSession();

			List<Guestbook> guestbooks = new ArrayList<Guestbook>();
			session.beginTransaction();
			Query q = session.createQuery("from Guestbook");
			guestbooks = q.list();
			session.getTransaction().commit();
			return guestbooks;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Guestbook findById(Integer id) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.getCurrentSession();
			
			Guestbook guestbook = new Guestbook();
			session.beginTransaction();
			guestbook = (Guestbook) session.get(Guestbook.class, id);
			session.getTransaction().commit();
			return guestbook;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteById(Integer id) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.getCurrentSession();

			session.beginTransaction();
			Query q = session.createQuery("delete Guestbook gb where gb.id = "
					+ id);
			q.executeUpdate();
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Guestbook guestbook) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.getCurrentSession();

			session.beginTransaction();
			Query q = session
					.createQuery("update Guestbook gb set gb.reply=?, gb.replyFlag=? where gb.id=?");
			q.setString(0, guestbook.getReply());
			if (guestbook.getReply().equals("")) {
				q.setInteger(1, 0);
			} else {
				q.setInteger(1, 1);
			}

			q.setInteger(2, guestbook.getId());
			q.executeUpdate();
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public GuestbookVO findByIdToVO(Integer id) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.getCurrentSession();
			
			session.beginTransaction();
			Query q = session.createQuery("select new com.ncut.bookshop.vo.GuestbookVO(gb.id, gb.title, gb.content, gb.reply, gb.date, gb.replyFlag, u.username) from Guestbook gb join gb.user u where gb.id = " + id);
			GuestbookVO guestbookVO = (GuestbookVO) q.uniqueResult();
			session.getTransaction().commit();
			return guestbookVO;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
