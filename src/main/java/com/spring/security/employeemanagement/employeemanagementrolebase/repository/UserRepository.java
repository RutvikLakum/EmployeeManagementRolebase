package com.spring.security.employeemanagement.employeemanagementrolebase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.employeemanagement.employeemanagementrolebase.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByusername(String username);
	
}
