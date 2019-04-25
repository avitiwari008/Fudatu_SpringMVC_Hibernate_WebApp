package com.finalproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finalproject.pojo.OrderDetails;
import com.finalproject.pojo.Restaurant;


@Repository
public class OrderDaoImpl implements OrderDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	

	@Override
	public OrderDetails findOrderDetails(long OrderId) {
		// TODO Auto-generated method stub
		
		
Session currentSession = sessionFactory.getCurrentSession();
		
		Query<OrderDetails> theQuery = currentSession.createQuery("from Order where OrderId=:aNumber", OrderDetails.class);
		theQuery.setParameter("aNumber", OrderId);
		OrderDetails  rest = null;
		
		try {
			 rest = theQuery.getSingleResult();
		}
		catch (Exception e) {
			 rest = null;
		}
		return  rest;
		
	}



	@Override
	public void save(OrderDetails details) {
		// TODO Auto-generated method stub
		
Session currentSession = sessionFactory.getCurrentSession();

		
		currentSession.saveOrUpdate(details);
	}



	@Override
	public List<OrderDetails> findallorders(long OrderId) {
	
		
Session currentSession = sessionFactory.getCurrentSession();
		
		Query<OrderDetails> theQuery = currentSession.createQuery("from OrderDetails  where OrderId =:aNumber", OrderDetails.class);
		theQuery.setParameter("aNumber", OrderId);
		
		List<OrderDetails> results = theQuery.list();
		
		
		return results;
		
	}

}
