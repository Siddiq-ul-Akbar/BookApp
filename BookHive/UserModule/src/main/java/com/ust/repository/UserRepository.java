package com.ust.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User getByUserId(int id);
	
	public User findByUserIdAndPassword(int id, String password);
}
