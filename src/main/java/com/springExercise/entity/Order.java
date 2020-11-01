package com.springExercise.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

@Entity // 告訴JPA這是一個實體類(和數據表映射的類)
@Table(name = "orderList")
public class Order implements Serializable {
	@Id // 這是一個主鍵
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增主鍵
	private Integer id;

	@Column
	@CreatedDate()
	private String creare_time;

	@Column(nullable = true)
	private String customer;

	@Column(nullable = true)
	private String address;

	@Column(nullable = true)
	private int total_price;

	@Column(nullable = true)
	private int order_id;

	@Column(nullable = true)
	private String phone;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getCreare_time() {
		return creare_time;
	}

	public void setCreare_time(String creare_time) {
		this.creare_time = creare_time;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", creare_time=" + creare_time + ", customer=" + customer + ", address=" + address
				+ ", total_price=" + total_price + ", order_id=" + order_id + ", phone=" + phone + "]";
	}

}
