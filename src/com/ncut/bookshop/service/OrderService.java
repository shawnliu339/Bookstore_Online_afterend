package com.ncut.bookshop.service;

import java.util.Date;
import java.util.List;

import com.ncut.bookshop.dao.OrderDAO;
import com.ncut.bookshop.model.OdrDtl;
import com.ncut.bookshop.model.Order;
import com.ncut.bookshop.util.Format;

public class OrderService {
	private OrderDAO orderDAO = new OrderDAO();

	public List findAll() {
		List<Order> orders = null;
		orders = orderDAO.findAll();
		return orders;
	}

	public Order findById(Integer id) {
		Order order = orderDAO.findById(id);
		return order;
	}

	public boolean cancel(Integer id) {
		return orderDAO.setStateTo0(id);
	}

	public Order findUpdateById(Integer id) {
		Order order = orderDAO.findById(id);
		String saleDate = order.getSale().getDate();
		if (saleDate == null) {
			saleDate = Format.dateFormat(new Date());
			order.getSale().setDate(saleDate);
		}

		Double saleMoney = order.getSale().getMoney();
		if (saleMoney == null || saleMoney == 0) {
			saleMoney = 0.0;
			for (OdrDtl odrDtl : order.getOdrDtls()) {
				saleMoney += odrDtl.getMoney();
			}
			saleMoney = Format.moneyFormat(saleMoney);
			order.getSale().setMoney(saleMoney);
		}
		return order;
	}

	public boolean update(Order order) {
		if (order.getSale().getMoney() == null
				|| order.getSale().getMoney().equals("")) {
			order.getSale().setMoney(0.0);
		}
		if (orderDAO.updateSale(order)) {
			return true;
		} else {
			return false;
		}
	}
}
