package com.springExercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springExercise.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	//新增產品的SQL語法
	//	INSERT INTO `product`(`name`, `location`, `descript`, `price`, `unit`) VALUES ("西瓜","台南","好吃新鮮
	//			，清甜優雅。",16,"斤"),
	//			("鳳梨","台南","果物因產地及氣候而有不同風貌，照片僅供參考，將以新鮮度及品質為出貨標準。",80,"個")
	@Query(value="SELECT b.* FROM product b ", nativeQuery = true)
    List<Product> findAll();
}
