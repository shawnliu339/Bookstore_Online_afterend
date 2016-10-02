package com.ncut.bookshop.service;

import com.ncut.bookshop.dao.AdminDAO;
import com.ncut.bookshop.model.Admin;

public class AdminService {

	public AdminService() {
		super();
		// TODO Auto-generated constructor stub
	}

	private AdminDAO adminDAO = new AdminDAO();

	public boolean checkAdminLogin(Admin checkedAdmin) {
		Admin admin = adminDAO.findByUsername(checkedAdmin.getUsername());
		if (admin.getUsername().equals(checkedAdmin.getUsername())
				&& admin.getPassword().equals(checkedAdmin.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
}
