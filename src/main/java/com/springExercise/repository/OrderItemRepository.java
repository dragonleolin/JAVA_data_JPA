package com.springExercise.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.springExercise.entity.OrderItem;
import com.springExercise.entity.ViewInfo;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{ 
	// SELECT b.* FROM order_item b LEFT JOIN order_list bc ON b.order_id = bc.id
	// WHERE bc.number='${number}'
	//	@Query(value = "SELECT new com.springExercise.entity.ViewInfo(a, b) FROM OrderItem a LEFT JOIN Order b ON a.order_id = b.id WHERE b.id=1", nativeQuery = true)
	//	public List<ViewInfo> findProduct(OrderItem order_id);
	
	 @Query(value="SELECT b.* FROM order_item b LEFT JOIN order_list bc ON b.order_id = bc.id WHERE b.order_id = ?1", nativeQuery = true)
	    List<OrderItem> selectOrderId(Integer id);
	 
	 @Query(value="SELECT SUM(`price`*`qty`) AS total_price FROM order_item WHERE order_id = ?1", nativeQuery = true)
	 	Integer sumOrderPrice(Integer id);
	
}
