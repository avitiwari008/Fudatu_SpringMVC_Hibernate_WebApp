package com.finalproject.dao;

import java.util.List;

import com.finalproject.pojo.Restaurant;
import com.finalproject.pojo.User;


public interface RestaurantDao {
	
	Restaurant findByUserName(String restaurantName);
	List<Restaurant> findAllRestaurants(String Zipcode);
	Restaurant findByRestaurantId (int restaurantId);
	
	void save( Restaurant rest);
	List<Restaurant> findAllRestaurant( String restaurantName);

}
