package com.finalproject.dao;

import java.util.List;

import com.finalproject.pojo.User;



public interface UserDao {
	
	User findByUserName(String userName);
	
	 void save(User user);
	
	 List<User> findAllCustomers();
	 User findbyUuid(long userId);

}
