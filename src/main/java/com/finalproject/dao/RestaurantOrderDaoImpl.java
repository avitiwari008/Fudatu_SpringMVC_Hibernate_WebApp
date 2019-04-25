package com.finalproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finalproject.pojo.OrderDetails;
import com.finalproject.pojo.Restaurant;
import com.finalproject.pojo.Role;

@Repository
public class RestaurantOrderDaoImpl implements RestaurantOrderDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<OrderDetails> findAllOrder() {
Session currentSession = sessionFactory.getCurrentSession();
		//HttpSession session;

		
	//	String query="Select OrderDetails.OrderId from OrderDetails,Restaurant where Orderdetails.restaurant=Restaurant.restaurant ";
	//	Query<OrderDetails> theQuery = currentSession.createSQLQuery("from OrederDetails where orderId=1");
		
Query<OrderDetails> theQuery = currentSession.createQuery("from OrderDetails where restaurant_id=1");


List<OrderDetails> results = theQuery.list();
		
		
//		try {
//			results = theQuery.getResultList();
//		} catch (Exception e) {
//			results=null;
//		}
		return results;
	}
		
		
		
		
		
		


	

}
