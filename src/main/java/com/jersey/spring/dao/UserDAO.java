package com.jersey.spring.dao;

import java.util.List;

import com.jersey.spring.dao.entity.User;

public interface UserDAO {

	void insertUser(User user);
	
	User getUserById(int userId);
	
	User getUser(String username);
	
	List<User> getUsers();
}
