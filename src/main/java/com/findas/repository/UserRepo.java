package com.findas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.findas.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByEmail(String emaill);

}
