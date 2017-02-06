package com.jersey.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.spring.dao.UserDAOImpl;
import com.jersey.spring.dao.entity.User;

@Component("userManagerImpl")
public class UserManagerImpl  {

	@Autowired
	private UserDAOImpl userDAO;
	
	@Transactional
	public void insertUser(User user) {
		userDAO.insertUser(user);
		
//		throw new RuntimeException("Throw after insert ");
	}

	@Transactional
	public User getUserById(int userId) {
		
		
		return userDAO.getUserById(userId);
	}
	
	@Transactional
	public User getUser(String username) {
		return userDAO.getUser(username);
	}

	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

}
