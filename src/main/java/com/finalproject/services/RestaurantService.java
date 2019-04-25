package com.finalproject.services;

import java.util.List;

import com.finalproject.pojo.Restaurant;
import com.finalproject.pojo.User;

public interface RestaurantService {
	
	
	Restaurant findByUserName(String restaurantName);
	List<Restaurant>findAllRestaurants(String Zipcode);
	Restaurant createRestaurantAccount();
	void add(Restaurant rs);
	List<Restaurant> findAllRestaurant( String restaurantName);
}
