package com.finalproject.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.finalproject.pojo.OrderDetails;

public interface RestaurantOrderServices extends UserDetailsService{

	
	
	List<OrderDetails> findAllOrder();
}
