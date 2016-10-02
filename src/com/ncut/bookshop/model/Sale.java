package com.ncut.bookshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "tb_sale", schema = "dbo")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Sale {

	private Integer id;
	private Order order;
	private Double money;
	private String date;

	public Sale() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sale(Integer id, Order order, Double money, String date) {
		super();
		this.id = id;
		this.order = order;
		this.money = money;
		this.date = date;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	@OneToOne
	@JoinColumn(name = "orderId")
	public Order getOrder() {
		return order;
	}

	public Double getMoney() {
		return money;
	}

	public String getDate() {
		return date;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", order=" + order + ", money=" + money
				+ ", date=" + date + "]";
	}

}
