package com.springExercise.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springExercise.entity.Order;
import com.springExercise.entity.OrderItem;
import com.springExercise.entity.Product;
import com.springExercise.entity.ViewInfo;
import com.springExercise.repository.OrderItemRepository;
import com.springExercise.repository.OrderRepository;
import com.springExercise.repository.ProductRepository;

@RestController
public class OrderController {
	@Autowired
	ProductRepository productRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderItemRepository orderItemRepository;

	// 取得產品內容
	@GetMapping("/productQuery/{id}")
	public Product getProduct(@PathVariable("id") Integer id) {
		Product product = productRepository.findById(id).get();
		System.out.println("product:" + product);
		return product;
	}

	// 取得訂單內容
	@GetMapping("/orderQuery/{id}")
	public Order getOrder(@PathVariable("id") Integer id) {
		Order order = orderRepository.findById(id).get();
		System.out.println("product:" + order);
		return order;
	}

	// 取得訂單的詳細項目
	// http://localhost:8080/queryOrder/1
	@GetMapping("/queryOrder/{id}")
	public List<OrderItem> queryOrder(@PathVariable("id") Integer id) {
		List<OrderItem> orderById = orderItemRepository.selectOrderId(id);
		return orderById;

	}

	// 移除訂單項目
	@GetMapping("/deleteOrder/{id}")
	public void deleteOrder(@PathVariable("id") Integer id) {
		orderRepository.deleteById(id);
		System.out.println("移除一筆訂單");
	}

	// 移除訂單項目
	@GetMapping("/deleteOrderItem/{id}")
	public void deleteOrderItem(@PathVariable("id") Integer id) {
		orderItemRepository.deleteById(id);
		System.out.println("移除訂單項目");
	}

	// 要做之前先做/orderItem，需要輸入customer、address
	// 目前用自動生成方式取得ID，但總金額會依據order_id取計算
	// 網址輸入http://localhost:8080/order?customer=test&address=NewTaipei
	@PostMapping("/order")
	public Order insertOrder(Order order) {
		Order saveFlush = orderRepository.saveAndFlush(order);
		int id = saveFlush.getId();
		System.out.println("id:" + id);
		Integer totalPrice = orderItemRepository.sumOrderPrice(id);
		order.setCreare_time(getTime());
		System.out.println("totalPrice:" + totalPrice);
		order.setTotal_price(totalPrice);
		Order saveOrder = orderRepository.save(order);
		System.out.println("save:" + saveOrder);
		return saveOrder;
	}

	// 需要輸入訂購產品的編號、數量、訂單編號
	// 網址輸入http://localhost:8080/orderItem?order_id=依訂單排序&qty=訂購數量&product_id=要購買的產品編號
	@PostMapping("/orderItem")
	public OrderItem insertOrderItem(OrderItem orderItem) {
		Integer product_id = orderItem.getProduct_id();
		Product product = productRepository.findById(product_id).get();
		System.out.println("product:" + product);
		orderItem.setPrice(product.getPrice());
		orderItem.setProductName(product.getName());
		OrderItem saveOrderItem = orderItemRepository.save(orderItem);
		System.out.println("saveOrderItem:" + saveOrderItem);
		return orderItem;
	}

	// 取得時間
	public String getTime() {
		// 用Timestamp來記錄日期時間還是很方便的，但有時候顯示的時候是不需要小數位後面的毫秒的，這樣就需要在轉換為String時重新定義格式
		SimpleDateFormat time = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		String strDate = time.format(date);
		return strDate;
	}

}
