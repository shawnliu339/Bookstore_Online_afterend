package com.ncut.bookshop.dao.impl;

import java.util.List;

import com.ncut.bookshop.model.Book;

public interface BookDAOImpl {
	
	Integer add(Book book);
	
	boolean delete(Integer id);
	
	boolean update(Book book);
	
	Book findBookById(Integer id);
	
	List findAll();
	
}
