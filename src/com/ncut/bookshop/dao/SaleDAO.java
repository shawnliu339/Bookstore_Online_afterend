package com.ncut.bookshop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ncut.bookshop.dao.impl.SaleDAOImpl;
import com.ncut.bookshop.model.Sale;
import com.ncut.bookshop.util.HibernateUtil;

public class SaleDAO implements SaleDAOImpl {

	@Override
	public Sale findById(Integer id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		
		Sale sale = new Sale();
		session.beginTransaction();
		sale = (Sale) session.get(Sale.class, id);
		session.getTransaction().commit();
		return sale;
	}
	
	public static void main(String[] args) {
		SaleDAO saleDAO = new SaleDAO();
		Sale sale = saleDAO.findById(2);
		System.out.println(sale);
	}

}
