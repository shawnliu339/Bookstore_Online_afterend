package com.ncut.bookshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "tb_guestbook")
@DynamicUpdate(true)
@DynamicInsert(true)
public class Guestbook {

	private Integer id;
	private String title;
	private String content;
	private String reply;
	private String date;
	private Integer replyFlag;
	private User user;

	public Guestbook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Guestbook(Integer id, String title, String content, String reply,
			String date, Integer replyFlag, User user) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.reply = reply;
		this.date = date;
		this.replyFlag = replyFlag;
		this.user = user;
	}

	@Id
	@Column(name = "guestbook_id")
	public Integer getId() {
		return id;
	}

	@Column(name = "guestbook_title")
	public String getTitle() {
		return title;
	}

	@Column(name = "guestbook_content")
	public String getContent() {
		return content;
	}

	@Column(name = "guestbook_reply")
	public String getReply() {
		return reply;
	}

	@Column(name = "guestbook_date")
	public String getDate() {
		return date;
	}

	@Column(name = "guestbook_replyFlag")
	public Integer getReplyFlag() {
		return replyFlag;
	}

	@ManyToOne
	@JoinColumn(name = "guestbook_userId")
	public User getUser() {
		return user;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setReplyFlag(Integer replyFlag) {
		this.replyFlag = replyFlag;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Guestbook [id=" + id + ", title=" + title + ", content="
				+ content + ", reply=" + reply + ", date=" + date
				+ ", replyFlag=" + replyFlag + ", user=" + user + "]";
	}

}
