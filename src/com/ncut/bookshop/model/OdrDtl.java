package com.ncut.bookshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

@Entity
@Table(name = "tb_orderDetail")
@DynamicInsert(true)
@DynamicUpdate(true)
public class OdrDtl {
	private Integer id;
	private Order order;
	private Book book;
	private Integer amount;
	private Double money;

	public OdrDtl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OdrDtl(Integer id, Order order, Book book, Integer amount,
			Double money) {
		super();
		this.id = id;
		this.order = order;
		this.book = book;
		this.amount = amount;
		this.money = money;
	}

	@Id
	@GeneratedValue
	@Column(name = "odrDtl_id")
	public Integer getId() {
		return id;
	}

	@ManyToOne
	@JoinColumn(name = "odrDtl_orderId")
	public Order getOrder() {
		return order;
	}
	
	@OneToOne
	@JoinColumn(name="odrDtl_bookId")
	public Book getBook() {
		return book;
	}

	@Column(name = "odrDtl_amount")
	public Integer getAmount() {
		return amount;
	}

	@Column(name = "odrDtl_money")
	public Double getMoney() {
		return money;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setBook(Book book) {
		this.book = book;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "OdrDtl [id=" + id + ", order=" + order + ", book=" + book
				+ ", amount=" + amount + ", money=" + money + "]";
	}

}
