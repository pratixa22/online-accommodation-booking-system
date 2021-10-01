package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.User;

public interface CustomerDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	List<User> findAllByRole (String role);
	//Customer findByName(String name);
}
