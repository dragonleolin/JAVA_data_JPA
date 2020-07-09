package com.springExercise.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity //告訴JPA這是一個實體類(和數據表映射的類)
@Table (name="orderItem")
public class OrderItem implements Serializable {
	@Id //這是一個主鍵
	@GeneratedValue(strategy = GenerationType.IDENTITY) //自增主鍵
	private Integer id;
	
	@Column(nullable=true)
	private String productName;
	@Column(nullable=true)
	private int price;
	@Column(nullable=true)
	private int qty;
	@Column(nullable=true)
	private int order_id;
	
//	@OneToOne
//	@JoinColumn(name="product_id",referencedColumnName="orderId")
	@Column(nullable=true)
	private int product_id;
	
	
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	@Override
	public String toString() {
		return "OrderItem [productName=" + productName + ", price=" + price + ", qty=" + qty + ", order_id=" + order_id
				+ ", product_id=" + product_id + "]";
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	
	
	
	
	
}

