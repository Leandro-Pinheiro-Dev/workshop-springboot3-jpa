package com.educandowed.course.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.educandowed.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
