package com.ncut.bookshop.dao.impl;

import java.util.List;

import com.ncut.bookshop.model.Guestbook;
import com.ncut.bookshop.vo.GuestbookVO;

public interface GuestbookDAOImpl {
	
	List findAll();
	
	Guestbook findById(Integer id);
	
	GuestbookVO findByIdToVO(Integer id);
	
	boolean deleteById(Integer id);
	
	boolean update(Guestbook guestbook);
}
