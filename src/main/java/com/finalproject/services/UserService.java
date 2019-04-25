package com.finalproject.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.finalproject.pojo.User;
import com.finalproject.users.Admin;
import com.finalproject.users.Customer;
import com.finalproject.users.RestaurantManager;



public interface UserService extends UserDetailsService{
	
	
	User findByUserName(String userName);
	
	User findbyUuid(long userId);
	
	List<User> findAllCustomers();
	
	void save(Customer customer);
	void saveEmployee(Admin adm);
	void saveManager(RestaurantManager rm);

}
