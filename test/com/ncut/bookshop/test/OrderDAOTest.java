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
		order = orderDAO.findById(1);//��ȡidΪ1�Ķ���
		order.setState(3);//���ö���״̬Ϊ3
		order.getSale().setDate("");//���ö�������Ϊ��
		order.getSale().setMoney(999.9);//���ö������Ϊ999
		System.out.println(order.getSale());//��ӡ�޸�ǰ��������Ϣ���붩���ı�����one to one��
		orderDAO.updateSale(order);//�޸�  ������
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
