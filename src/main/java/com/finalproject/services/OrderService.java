package com.finalproject.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.finalproject.pojo.OrderDetails;
import com.finalproject.pojo.Restaurant;
import com.finalproject.pojo.User;


public interface OrderService extends UserDetailsService {
	
	void save(Restaurant res,User u,String details);
	void save(OrderDetails details);
	public OrderDetails findOrderDetails(long OrderId);
	
	 List<OrderDetails> findallorders(long OrderId);
}
