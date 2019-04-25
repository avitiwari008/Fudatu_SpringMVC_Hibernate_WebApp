package com.finalproject.dao;

import java.util.List;

import com.finalproject.pojo.OrderDetails;

public interface OrderDao {
	
	public OrderDetails findOrderDetails(long OrderId);
	
	void save(OrderDetails details);
	
	List<OrderDetails> findallorders(long OrderId);
	
}
