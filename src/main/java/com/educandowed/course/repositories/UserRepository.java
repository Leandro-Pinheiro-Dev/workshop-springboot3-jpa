package com.educandowed.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandowed.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
