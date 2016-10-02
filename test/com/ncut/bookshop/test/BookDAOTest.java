package com.ncut.bookshop.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ncut.bookshop.dao.BookDAO;
import com.ncut.bookshop.model.Book;

public class BookDAOTest {
	
	public void updateTest() {
		Book book = new Book();
		BookDAO bookDAO = new BookDAO();
		book = bookDAO.findBookById(13);
		System.out.println(book);
		book.setAuthor("×÷Õß²âÊÔ");
		bookDAO.update(book);
	}
	
	public void findBookByIdTest() {
		Book book = new Book();
		BookDAO bookDAO = new BookDAO();
		book = bookDAO.findBookById(1);
		System.out.println(book);
	}
	
	@Test
	public void findAllTest() {
		List<Book> books = new ArrayList<Book>();
		BookDAO bookDAO = new BookDAO();
		books = bookDAO.findAll();
		for(Book temp:books) {
			System.out.println(temp);
		}
	}
	
	public void addTest() {
		Book book = new Book();
		BookDAO bookDAO = new BookDAO();
		book.setISBN("123");
		book.setName("123");
		book.setAuthor("123");
		book.setPublisher("123");
		book.setPrice(123.0);
		book.setBookType("123");
		book.setNewFlag(0);
		bookDAO.add(book);
		
	}

}
