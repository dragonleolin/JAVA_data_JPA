package com.springExercise.entity;

import java.io.Serializable;

public class ViewInfo implements Serializable{
	
	private Order order;
	private OrderItem orderItem;
//	private Product product;
	
	public ViewInfo() {
	}
	
	public ViewInfo(Order order) {
		OrderItem orderItem = new OrderItem();
		Product product = new Product();
		this.order = order;
		this.orderItem = orderItem;
//		this.product = product;
	}
	
	public ViewInfo(OrderItem orderItem) {
		Order order = new Order();
		Product product = new Product();
		this.order = order;
		this.orderItem = orderItem;
//		this.product = product;
	}
	
//	public ViewInfo(Product product) {
//		Order order = new Order();
//		OrderItem orderItem = new OrderItem();
//		this.order = order;
//		this.orderItem = orderItem;
//		this.product = product;
//	}
//	
	public ViewInfo(Order order, OrderItem orderItem, Product product) {
		super();
		this.order = order;
		this.orderItem = orderItem;
//		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
	
	
	
	
}
