package com.ncut.bookshop.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "tb_order", schema = "dbo")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Order {
	private Integer id;
	private Integer goodsAmount;
	private String username;
	private String truename;
	private String address;
	private Integer ZIP;
	private String tel;
	private String email;
	private String payType;
	private String delivery;
	private Double discount;
	private String date;
	private String memo;
	private Integer state;
	private Sale sale;
	private Set<OdrDtl> odrDtls = new HashSet<OdrDtl>();

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Integer id, Integer goodsAmount, String username,
			String truename, String address, Integer zIP, String tel,
			String email, String payType, String delivery, Double discount,
			String date, String memo, Integer state, Sale sale,
			Set<OdrDtl> odrDtls) {
		super();
		this.id = id;
		this.goodsAmount = goodsAmount;
		this.username = username;
		this.truename = truename;
		this.address = address;
		ZIP = zIP;
		this.tel = tel;
		this.email = email;
		this.payType = payType;
		this.delivery = delivery;
		this.discount = discount;
		this.date = date;
		this.memo = memo;
		this.state = state;
		this.sale = sale;
		this.odrDtls = odrDtls;
	}

	@Id
	@GeneratedValue
	@Column(name = "order_id")
	public Integer getId() {
		return id;
	}

	@Column(name = "order_goodsAmount")
	public Integer getGoodsAmount() {
		return goodsAmount;
	}

	@Column(name = "order_username")
	public String getUsername() {
		return username;
	}

	@Column(name = "order_truename")
	public String getTruename() {
		return truename;
	}

	@Column(name = "order_address")
	public String getAddress() {
		return address;
	}

	@Column(name = "order_ZIP")
	public Integer getZIP() {
		return ZIP;
	}

	@Column(name = "order_tel")
	public String getTel() {
		return tel;
	}

	@Column(name = "order_email")
	public String getEmail() {
		return email;
	}

	@Column(name = "order_payType")
	public String getPayType() {
		return payType;
	}

	@Column(name = "order_delivery")
	public String getDelivery() {
		return delivery;
	}

	@Column(name = "order_discount")
	public Double getDiscount() {
		return discount;
	}

	@Column(name = "order_date")
	public String getDate() {
		return date;
	}

	@Column(name = "order_memo")
	public String getMemo() {
		return memo;
	}

	@Column(name = "order_state")
	public Integer getState() {
		return state;
	}

	@OneToOne(mappedBy = "order", cascade=CascadeType.ALL)
	public Sale getSale() {
		return sale;
	}

	@OneToMany(mappedBy = "order")
	@OrderBy("id")
	public Set<OdrDtl> getOdrDtls() {
		return odrDtls;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setGoodsAmount(Integer goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setZIP(Integer zIP) {
		ZIP = zIP;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public void setOdrDtls(Set<OdrDtl> odrDtls) {
		this.odrDtls = odrDtls;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", goodsAmount=" + goodsAmount
				+ ", username=" + username + ", truename=" + truename
				+ ", address=" + address + ", ZIP=" + ZIP + ", tel=" + tel
				+ ", email=" + email + ", payType=" + payType + ", delivery="
				+ delivery + ", discount=" + discount + ", date=" + date
				+ ", memo=" + memo + ", state=" + state + "]";
	}

}
