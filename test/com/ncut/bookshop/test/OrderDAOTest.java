package com.ncut.bookshop.test;

import java.util.List;

import org.junit.Test;

import com.ncut.bookshop.dao.OrderDAO;
import com.ncut.bookshop.model.Order;
import com.ncut.bookshop.vo.BookOmit;

public class OrderDAOTest {

	OrderDAO orderDAO = new OrderDAO();
	Order order;
	List<Order> orders;

	public void findByIdTest() {
		order = orderDAO.findById(1);
		System.out.println(order.getOdrDtls());
	}

	public void findAllTest() {
		orders = orderDAO.findAll();
		System.out.println(orders);
	}

	public void setStateTo0Test() {
		orderDAO.setStateTo0(1);
	}
	@Test
	public void updateSaleTest() {
		order = orderDAO.findById(1);//获取id为1的订单
		order.setState(3);//设置订单状态为3
		order.getSale().setDate("");//设置订单日期为空
		order.getSale().setMoney(999.9);//设置订单金额为999
		System.out.println(order.getSale());//打印修改前的销售信息（与订单的表做了one to one）
		orderDAO.updateSale(order);//修改  ！出错
	}

	
	public void getTop10Test() {
		List<BookOmit> o = orderDAO.getTop10();
		int i = 1;
		for(BookOmit temp : o) {
			System.out.println(i+"-->"+temp);
			i++;
		}
	}

}
