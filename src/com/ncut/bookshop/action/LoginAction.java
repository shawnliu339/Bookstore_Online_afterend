package com.ncut.bookshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ncut.bookshop.model.Admin;
import com.ncut.bookshop.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private Admin admin = new Admin();
	private AdminService adminService = new AdminService();
	private Map<String, Object> session;

	@Override
	public String execute() throws Exception {
		if(session.get("admin") == null) {
			return INPUT;
		} else {
			return SUCCESS;
		}
	}

	public String login() {
		if(adminService.checkAdminLogin(admin)) {
			session.put("admin", admin);
			return SUCCESS;
		} else {
			return INPUT;
		}
	}
	
	public String logout() {
		session.clear();
		return INPUT;
	}

	public Admin getAdmin() {
		return admin;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
