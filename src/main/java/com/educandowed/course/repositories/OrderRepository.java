package com.educandowed.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandowed.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
