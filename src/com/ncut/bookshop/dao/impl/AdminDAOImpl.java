package com.ncut.bookshop.dao.impl;

import com.ncut.bookshop.model.Admin;

public interface AdminDAOImpl {
	
	Admin findByUsername(String username);
}
