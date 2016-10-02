package com.ncut.bookshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ncut.bookshop.dao.impl.OrderDAOImpl;
import com.ncut.bookshop.model.Order;
import com.ncut.bookshop.util.HibernateUtil;
import com.ncut.bookshop.vo.BookOmit;

public class OrderDAO implements OrderDAOImpl {

	@Override
	public Order findById(Integer id) {
		SessionFactory sf = new HibernateUtil().getSessionFactory();
		Session session = sf.getCurrentSession();

		Order order = new Order();
		session.beginTransaction();
		order = (Order) session.get(Order.class, id);
		order.getOdrDtls().isEmpty();
		session.getTransaction().commit();
		return order;
	}

	@Override
	public List findAll() {
		SessionFactory sf = new HibernateUtil().getSessionFactory();
		Session session = sf.getCurrentSession();

		session.beginTransaction();
		Query q = session.createQuery("from Order order");
		List<Order> orders = q.list();
		session.getTransaction().commit();
		return orders;
	}

	@Override
	public boolean setStateTo0(Integer id) {
		try {
			SessionFactory sf = new HibernateUtil().getSessionFactory();
			Session session = sf.getCurrentSession();

			session.beginTransaction();
			Query q = session
					.createQuery("update Order o set o.state=0 where o.id = "
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
	public boolean updateSale(Order order) {
		try {
			SessionFactory sf = new HibernateUtil().getSessionFactory();
			Session session = sf.getCurrentSession();

			session.beginTransaction();
			/*Query q = session
					.createQuery("update Order odr set odr.state=:state, odr.sale.date=:date, odr.sale.money=:money where odr.id=:id");
			q.setInteger("state", order.getState());
			q.setString("date", order.getSale().getDate());
			q.setDouble("money", order.getSale().getMoney());
			q.setInteger("id", order.getId());
			q.executeUpdate();*/
			Order updateOrder = (Order) session.get(Order.class, order.getId());
			updateOrder.setState(order.getState());
			updateOrder.getSale().setMoney(order.getSale().getMoney());
			updateOrder.getSale().setDate(order.getSale().getDate());
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List getTop10() {
		SessionFactory sf = new HibernateUtil().getSessionFactory();
		Session session = sf.getCurrentSession();

		List<BookOmit> top10 = null;
		session.beginTransaction();
		/*select od.book.id, od.book.name, od.book.publisher, od.book.price, allAmount from(
		 * select od.book.id, sum(od.amount) as allAmount from OdrDtl od group by od.book.id
		 * ) order by allAmount desc
		 * 
		 * ¸Ä£º
		 * select
		 *   od.book.id,
		 *   od.book.name, 
		 *   od.book.publisher, 
		 *   od.book.price 
		 * from 
		 *   OdrDtl od 
		 * where 
		 *   od.book.id in(
		 *     select
		 *       od.book.id
		 *     from 
		 *       OdrDtl od 
		 *     group by 
		 *       od.book.id
		 *     )
		 * 
		 * select od.book.id, od.book.ISBN, od.book.name, od.book.publisher, od.book.price, od.amount from OdrDtl od where od.book.id in (select od.book.id from OdrDtl od group by od.book.id)
		 * select new com.ncut.bookshop.vo.BookOmit(od.book.id, od.book.ISBN, od.book.name, od.book.publisher, od.book.price, od.amount) from OdrDtl od where od.book.id in (select od.book.id from OdrDtl od group by od.book.id)
		 * */
		Query q = session.createQuery("select new com.ncut.bookshop.vo.BookOmit(od.book.id, od.book.ISBN, od.book.name, od.book.publisher, od.book.price, od.amount) from OdrDtl od where od.book.id in (select od.book.id from od group by od.book.id)");
		top10 = q.list();
		session.getTransaction().commit();
		return top10;
	}

}
