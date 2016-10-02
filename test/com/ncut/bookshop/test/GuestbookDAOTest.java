package com.ncut.bookshop.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ncut.bookshop.dao.GuestbookDAO;
import com.ncut.bookshop.model.Guestbook;
import com.ncut.bookshop.vo.GuestbookVO;

public class GuestbookDAOTest {

	GuestbookDAO gbDAO = new GuestbookDAO();
	Guestbook gb = new Guestbook();
	List<Guestbook> gbs = new ArrayList<Guestbook>();

	public void findAllTest() {
		gbs = gbDAO.findAll();
		for (Guestbook gb : gbs) {
			System.out.println(gb);
		}
	}

	public void findByIdTest() {
		gb = gbDAO.findById(6);
		System.out.println(gb);
	}

	public void updateTest() {
		gb.setId(6);
		gb.setReply("ceshi");
		gbDAO.update(gb);
		System.out.println(gbDAO.findById(6));
	}

	@Test
	public void findByIdToVOTest() {
		GuestbookVO gbVO = gbDAO.findByIdToVO(6);
		System.out.println(gbVO);
	}

}
