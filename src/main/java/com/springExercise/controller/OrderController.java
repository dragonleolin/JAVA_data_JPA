package com.springExercise.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springExercise.Service.UserService;
import com.springExercise.entity.Order;
import com.springExercise.entity.OrderItem;
import com.springExercise.entity.Product;
import com.springExercise.repository.OrderItemRepository;
import com.springExercise.repository.OrderRepository;
import com.springExercise.repository.ProductRepository;

@RestController
//@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
	@Autowired
	ProductRepository productRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	UserService userService;

	// 取得所有產品
	@CrossOrigin(origins="*", maxAge=3600)
	@GetMapping(value="/allProductQuery", produces="application/json")
	public List<Product> getAllProduct() {
		List<Product> product = productRepository.findAll();
		for(Object obj : product) {
			if( obj instanceof Product) {
				String imgPath = ((Product) obj).getImgPath();
				if(imgPath != null) {					
					String dir = "D:\\eclipse-workspace\\data_JPA\\src\\main\\resources\\static";
					String path = dir + imgPath;
//					System.out.println("img:" + path);
					File imgFile =  new File(path);
					String encodstring = userService.encodeFileToBase64Binary(imgFile);
//					System.out.println("encodstring:" + encodstring);
					((Product) obj).setImgPath(encodstring);
				}
			}
	      
		}
		return product;
	}

	// 取得產品內容
	@CrossOrigin(origins="*", maxAge=3600)
	@GetMapping("/productQuery/{id}")
	public Product getProduct(@PathVariable("id") Integer id) {
		Product product = productRepository.findById(id).get();
		System.out.println("product:" + product);
		return product;
	}

	// 取得訂單內容
	@CrossOrigin(origins="*", maxAge=3600)
	@GetMapping("/orderQuery/{id}")
	public Order getOrder(@PathVariable("id") Integer id) {
		Order order = orderRepository.findById(id).get();
		System.out.println("product:" + order);
		return order;
	}

	// 取得訂單的詳細項目
	// http://localhost:8080/queryOrder/1
	@CrossOrigin(origins="*", maxAge=3600)
	@GetMapping("/queryOrder/{order_id}")
	public List<OrderItem> queryOrder(@PathVariable("id") Integer order_id) {
		List<OrderItem> orderById = orderItemRepository.selectOrderId(order_id);
		return orderById;

	}

	// 移除訂單項目
	@GetMapping("/deleteOrder/{id}")
	@CrossOrigin(origins="*", maxAge=3600)
	public void deleteOrder(@PathVariable("id") Integer id) {
		orderRepository.deleteById(id);
		System.out.println("移除一筆訂單");
	}

	// 移除訂單項目
	@GetMapping("/deleteOrderItem/{id}")
	@CrossOrigin(origins="*", maxAge=3600)
	public void deleteOrderItem(@PathVariable("id") Integer id) {
		orderItemRepository.deleteById(id);
		System.out.println("移除訂單項目");
	}

	// 要做之前先做/orderItem，需要輸入customer、address
	// 目前用自動生成方式取得ID，但總金額會依據order_id取計算
	// 網址輸入http://localhost:8080/order?customer=test&address=NewTaipei
	@CrossOrigin(origins="*", maxAge=3600)
	@PostMapping("/order")
	public Order insertOrder(@RequestBody Order order) {
//		Order saveFlush = orderRepository.saveAndFlush(order);
//		int id = saveFlush.getId();
//		System.out.println("id:" + id);
//		Integer totalPrice = orderItemRepository.sumOrderPrice(order.getOrder_id());
//		System.out.println("totalPrice:" + totalPrice);
//		order.setTotal_price(totalPrice);
		order.setCreare_time(UserService.getTime());
		Order saveOrder = orderRepository.save(order);
		System.out.println("save:" + saveOrder);
		return saveOrder;
	}

	// 需要輸入訂購產品的編號、數量、訂單編號
	// 網址輸入http://localhost:8080/orderItem?order_id=依訂單排序&qty=訂購數量&product_id=要購買的產品編號
	@PostMapping("/orderItem")
	@CrossOrigin(origins="*", maxAge=3600)
	public OrderItem insertOrderItem(@RequestBody OrderItem orderItem) {
		Integer product_id = orderItem.getProduct_id();
		System.out.println("product_id:" + product_id);
		Product product = productRepository.findById(product_id).get();
		System.out.println("product:" + product);
		orderItem.setPrice(product.getPrice());
		orderItem.setProductName(product.getName());
		OrderItem saveOrderItem = orderItemRepository.save(orderItem);
		System.out.println("saveOrderItem:" + saveOrderItem);
		return saveOrderItem;
	}

	

}
