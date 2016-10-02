package com.ncut.bookshop.vo;

public class GuestbookVO {

	private Integer id;
	private String title;
	private String content;
	private String reply;
	private String date;
	private Integer replyFlag;
	private String username;

	public GuestbookVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GuestbookVO(Integer id, String title, String content, String reply,
			String date, Integer replyFlag, String username) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.reply = reply;
		this.date = date;
		this.replyFlag = replyFlag;
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getReply() {
		return reply;
	}

	public String getDate() {
		return date;
	}

	public Integer getReplyFlag() {
		return replyFlag;
	}

	public String getUsername() {
		return username;
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

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((reply == null) ? 0 : reply.hashCode());
		result = prime * result
				+ ((replyFlag == null) ? 0 : replyFlag.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GuestbookVO other = (GuestbookVO) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (reply == null) {
			if (other.reply != null)
				return false;
		} else if (!reply.equals(other.reply))
			return false;
		if (replyFlag == null) {
			if (other.replyFlag != null)
				return false;
		} else if (!replyFlag.equals(other.replyFlag))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GuestbookVO [id=" + id + ", title=" + title + ", content="
				+ content + ", reply=" + reply + ", date=" + date
				+ ", replyFlag=" + replyFlag + ", username=" + username + "]";
	}

}
