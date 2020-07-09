package com.springExercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springExercise.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
