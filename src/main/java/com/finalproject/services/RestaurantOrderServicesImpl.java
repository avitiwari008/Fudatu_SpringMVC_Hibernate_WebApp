package com.finalproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalproject.dao.RestaurantOrderDao;
import com.finalproject.pojo.OrderDetails;


@Service
@Transactional
public class RestaurantOrderServicesImpl implements RestaurantOrderServices {

	@Autowired	
	private RestaurantOrderDao restOD;
	
	@Override
	public List<OrderDetails> findAllOrder() {
		
		// TODO Auto-generated method stub
		return restOD.findAllOrder();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
