package com.ncut.bookshop.dao.impl;

import java.util.List;

import com.ncut.bookshop.model.Order;

public interface OrderDAOImpl {

	boolean setStateTo0(Integer id);
	
	Order findById(Integer id);
	
	List findAll();
	
	boolean updateSale(Order order);
	
	List getTop10();
}
