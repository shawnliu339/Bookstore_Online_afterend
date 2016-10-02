package com.ncut.bookshop.action;

import java.util.List;

import com.ncut.bookshop.model.Book;
import com.ncut.bookshop.service.BookService;
import com.opensymphony.xwork2.ActionSupport;

public class bookAction extends ActionSupport{
	
	private BookService bookservice = new BookService();
	private List<Book> books;
	private Book book;
	
	public String detail() {
		book = bookservice.findBookById(book.getId());
		return INPUT;
	}
	
	public String list() {
		books = bookservice.findAll();
		return "list";
	}
	
	public String updateInput() {
		book = bookservice.findBookById(book.getId());
		return INPUT;
	}
	
	public String update() {
		
		if(bookservice.update(book)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
		
	}
	
	public String delete() {
		
		if(bookservice.delete(book.getId())) {
			return SUCCESS;
		} else {
			return ERROR;
		}
		
	}
	
	public String add() {
		bookservice.add(book);
		return SUCCESS;
	}

	public BookService getBookservice() {
		return bookservice;
	}

	public void setBookservice(BookService bookservice) {
		this.bookservice = bookservice;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
