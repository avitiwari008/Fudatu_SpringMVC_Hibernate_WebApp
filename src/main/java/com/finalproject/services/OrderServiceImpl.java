package com.finalproject.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalproject.dao.OrderDao;
import com.finalproject.pojo.OrderDetails;
import com.finalproject.pojo.Restaurant;
import com.finalproject.pojo.User;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

	
	@Autowired
	private OrderDao orderDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetails findOrderDetails(long OrderId) {
		// TODO Auto-generated method stub
		return orderDao.findOrderDetails(OrderId);
	}

	@Override
	public void save(OrderDetails details) {
		// TODO Auto-generated method stub
//		HttpSession session;
//		
//		User u = new User();
//		Restaurant r= new Restaurant();
//		
//		OrderDetails detail = new OrderDetails();
//		detail.setOrderdetails(details.getOrderdetails());
//		//detail.setUser(u.getFirstName());
//		detail.setOrderId(details.getOrderId());
//		detail.setRestaurant(r);
//		detail.setUser(u);
//		
//		
	orderDao.save(details);
	}

	@Override
	public void save(Restaurant res, User u, String details) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public List<OrderDetails> findallorders(long OrderId) {
		// TODO Auto-generated method stub
		return orderDao.findallorders(OrderId);
	}
	
	

}
