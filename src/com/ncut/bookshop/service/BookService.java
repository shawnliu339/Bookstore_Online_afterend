package com.ncut.bookshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ncut.bookshop.dao.BookDAO;
import com.ncut.bookshop.model.Book;
import com.ncut.bookshop.util.ConnectionFactory;

public class BookService {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	private BookDAO bookDAO = new BookDAO();

	public Integer add(Book book) {
		bookDAO.add(book);
		return book.getId();
	}
	
	public boolean delete(Integer id) {
		return bookDAO.delete(id);
	}
	
	public boolean update(Book book) {
		return bookDAO.update(book);
	}
	
	public List<String> getTypes() {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT DISTINCT book_type ");
			sql.append("FROM tb_book ");
			pstm = conn.prepareStatement(sql.toString());
			rs = pstm.executeQuery();

			List<String> types = new ArrayList<String>();
			String type = null;
			while (rs.next()) {
				type = new String();
				type = rs.getString("book_type");
				types.add(type);
			}
			return types;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}
	
	public List<Book> findBooksByType(String type){
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT book_id, book_name, book_publisher, book_price ");
			sql.append("FROM tb_book ");
			sql.append("WHERE book_type = ? ");
			pstm = conn.prepareStatement(sql.toString());
			pstm.setString(1, type);
			rs = pstm.executeQuery();
			List<Book> books = new ArrayList<Book>();
			Book book = null;
			while(rs.next()) {
				Integer id = rs.getInt("book_id");
				String name = rs.getString("book_name");
				String publisher = rs.getString("book_publisher");
				Double price = rs.getDouble("book_price");
				
				book = new Book();
				book.setId(id);
				book.setName(name);
				book.setPublisher(publisher);
				book.setPrice(price);
				books.add(book);
			}
			return books;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}
	public Book findBookById(Integer id) {
		return bookDAO.findBookById(id);
	}

	public List<Book> findBookByLike(Book keyBook) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			String keyName = keyBook.getName();
			if (keyName != null && !keyName.equals("")) {
				sql.append("SELECT * FROM tb_book ");
				sql.append("WHERE book_name LIKE '%" + keyName + "%' ");
			}
			pstm = conn.prepareStatement(sql.toString());
			rs = pstm.executeQuery();
			List<Book> books = new ArrayList<Book>();

			while (rs.next()) {

				Integer id = rs.getInt("book_id");
				String ISBN = rs.getString("book_ISBN");
				String name = rs.getString("book_name");
				String author = rs.getString("book_author");
				String publisher = rs.getString("book_publisher");
				String date = rs.getString("book_date");
				Double price = rs.getDouble("book_price");
				String introduction = rs.getString("book_introduction");
				String bookType = rs.getString("book_type");
				String img = rs.getString("book_img");
				Integer newFlag = rs.getInt("book_newFlag");
				Integer commend = rs.getInt("book_commend");

				Book book = new Book();
				book.setId(id);
				book.setISBN(ISBN);
				book.setName(name);
				book.setAuthor(author);
				book.setPublisher(publisher);
				book.setDate(date);
				book.setPrice(price);
				book.setIntroduction(introduction);
				book.setBookType(bookType);
				book.setImg(img);
				book.setNewFlag(newFlag);
				book.setCommend(commend);
				books.add(book);

			}
			return books;
		} catch (Exception e) {
			System.out.println("finding book by like is error");
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	public List<Book> findAll() {
		return bookDAO.findAll();
	}

	public static void main(String[] args) {
		BookService bookDao = new BookService();
		Book keyBook = new Book();
		System.out.println(bookDao.getTypes());
		System.out.println(bookDao.findBooksByType("¼ÆËã»ú"));

	}
}
