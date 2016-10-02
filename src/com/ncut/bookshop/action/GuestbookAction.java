package com.ncut.bookshop.action;

import java.util.List;

import com.ncut.bookshop.model.Guestbook;
import com.ncut.bookshop.service.GuestbookService;
import com.ncut.bookshop.vo.GuestbookVO;
import com.opensymphony.xwork2.ActionSupport;

public class GuestbookAction extends ActionSupport {

	private Guestbook guestbook;
	private GuestbookVO guestbookVO;
	private List<Guestbook> guestbooks;
	private GuestbookService guestbookservice = new GuestbookService();
	
	public String delete() {
		if(guestbookservice.deleteById(guestbook.getId())) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String replyInput() {
		guestbook = guestbookservice.findById(guestbook.getId());
		return INPUT;
	}
	
	public String reply() {
		if(guestbookservice.reply(guestbook)) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String detail() {
		guestbook = guestbookservice.findById(guestbook.getId());
		return INPUT;
	}
	
	public String list() {
		guestbooks = guestbookservice.findAll();
		return "list";
	}
	
	public Guestbook getGuestbook() {
		return guestbook;
	}

	public void setGuestbook(Guestbook guestbook) {
		this.guestbook = guestbook;
	}

	public List<Guestbook> getGuestbooks() {
		return guestbooks;
	}

	public void setGuestbooks(List<Guestbook> guestbooks) {
		this.guestbooks = guestbooks;
	}

	public GuestbookService getGuestbookservice() {
		return guestbookservice;
	}

	public void setGuestbookservice(GuestbookService guestbookservice) {
		this.guestbookservice = guestbookservice;
	}

}
