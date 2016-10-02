package com.ncut.bookshop.action;

import java.util.List;

import com.ncut.bookshop.dao.OrderDAO;
import com.ncut.bookshop.model.Order;
import com.ncut.bookshop.service.BookService;
import com.ncut.bookshop.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;

public class RemittanceAction extends ActionSupport {

	private Order order;
	private List<Order> orders;
	private OrderService orderservice = new OrderService();
	
	public String cancel() {
		if(orderservice.cancel(order.getId())) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String update() {
		if(orderservice.update(order)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String updateInput() {
		order = orderservice.findUpdateById(order.getId());
		return INPUT;
	}
	
	public String detail() {
		order = orderservice.findById(order.getId());
		return INPUT;
	}
	
	public String list() {
		orders = orderservice.findAll();
		return "list";
	}

	public Order getOrder() {
		return order;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public OrderService getOrderservice() {
		return orderservice;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void setOrderservice(OrderService orderservice) {
		this.orderservice = orderservice;
	}
}
