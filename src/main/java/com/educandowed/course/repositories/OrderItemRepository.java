package com.educandowed.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandowed.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
