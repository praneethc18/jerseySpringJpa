package com.jersey.spring.service;

import java.util.List;

import com.jersey.spring.dao.entity.User;

public interface UserManager {

	void insertUser(User user);
	
	User getUserById(int userId);
	
	User getUser(String username);
	
	List<User> getUsers();
}
