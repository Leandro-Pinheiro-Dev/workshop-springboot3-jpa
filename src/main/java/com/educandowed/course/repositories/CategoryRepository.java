package com.educandowed.course.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.educandowed.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
