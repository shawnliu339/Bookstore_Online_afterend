package com.ncut.bookshop.service;

import java.util.ArrayList;
import java.util.List;

import com.ncut.bookshop.dao.GuestbookDAO;
import com.ncut.bookshop.model.Guestbook;

public class GuestbookService {
	private GuestbookDAO guestbookDAO = new GuestbookDAO();
	
	public List findAll(){
		List<Guestbook> guestbooks = new ArrayList<Guestbook>();
		guestbooks = guestbookDAO.findAll();
		for(Guestbook guestbook : guestbooks) {
			if(guestbook.getContent().length()>15) {
				StringBuffer strbuffer = new StringBuffer();
				strbuffer.append(guestbook.getContent().substring(0, 14)).append("...");
				guestbook.setContent(strbuffer.toString());
			}
		}
		return guestbooks;
	}
	
	public Guestbook findById(Integer id) {
		return guestbookDAO.findById(id);
	}
	
	public boolean reply(Guestbook guestbook) {
		return guestbookDAO.update(guestbook);
	}
	
	public boolean deleteById(Integer id) {
		return guestbookDAO.deleteById(id);
	}

}
