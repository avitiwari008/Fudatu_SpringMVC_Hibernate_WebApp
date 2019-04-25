package com.finalproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalproject.dao.RestaurantDao;
import com.finalproject.pojo.Restaurant;
import com.finalproject.pojo.User;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService{

	

	@Autowired
	private RestaurantDao restaurantDao;

	@Override
	public Restaurant createRestaurantAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Restaurant rst) {
		// TODO Auto-generated method stub
		
		Restaurant rs =new Restaurant();
		rs.setRestaurantName(rst.getRestaurantName());
		rs.setRestaurantId(rst.getRestaurantId());
		rs.setRestaurantMenu(rst.getRestaurantMenu());
		rs.setCostfor2(rst.getCostfor2());
		rs.setZipcode(rst.getZipcode());
		
		restaurantDao.save(rs);
		
		
	}

	@Override
	public List<Restaurant> findAllRestaurants(String Zipcode) {
		// TODO Auto-generated method stub
		return restaurantDao.findAllRestaurants(Zipcode);
	}
	
	

	@Override
	public List<Restaurant> findAllRestaurant(String restaurantName) {
		// TODO Auto-generated method stub
		return restaurantDao.findAllRestaurant(restaurantName);
	}

	@Override
	public Restaurant findByUserName(String restaurantName) {
		// TODO Auto-generated method stub
		return restaurantDao.findByUserName(restaurantName);
	}

	

	
	
	

}
