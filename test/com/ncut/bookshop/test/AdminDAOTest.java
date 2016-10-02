package com.ncut.bookshop.test;

import org.junit.Test;

import com.ncut.bookshop.dao.AdminDAO;
import com.ncut.bookshop.model.Admin;

public class AdminDAOTest {
	
	AdminDAO adminDAO = new AdminDAO();
	Admin admin = null;

	@Test
	public void findByUsernameTest() {
		admin = adminDAO.findByUsername("admin");
		System.out.println(admin);
	}

}
