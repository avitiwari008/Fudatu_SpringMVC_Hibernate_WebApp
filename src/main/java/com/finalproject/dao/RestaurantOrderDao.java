package com.finalproject.dao;

import java.util.List;

import com.finalproject.pojo.OrderDetails;
import com.finalproject.pojo.Restaurant;

public interface RestaurantOrderDao {

	
	List<OrderDetails> findAllOrder();
}
