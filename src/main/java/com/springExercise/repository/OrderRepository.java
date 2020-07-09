package com.springExercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springExercise.entity.Order;
import com.springExercise.entity.ViewInfo;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	

}
