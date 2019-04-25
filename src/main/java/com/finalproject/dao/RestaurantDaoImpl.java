package com.finalproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.finalproject.pojo.Restaurant;
import com.finalproject.pojo.User;


@Repository

public class RestaurantDaoImpl implements RestaurantDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Restaurant findByRestaurantId(int restaurantId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Restaurant> theQuery = currentSession.createQuery("from Restaurant where restaurantId=:aNumber", Restaurant.class);
		theQuery.setParameter("aNumber", restaurantId);
		Restaurant  rest = null;
		
		try {
			 rest = theQuery.getSingleResult();
		}
		catch (Exception e) {
			 rest = null;
		}
		return  rest;
		
		
		
	}

	@Override
	public void save(Restaurant rest) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		currentSession.saveOrUpdate(rest);

	}

//	@Override
//	public List<Restaurant> findAllRestaurants(int Zipcode) {
//	Session currentSession = sessionFactory.getCurrentSession();
//		
//		Query<Restaurant> theQuery = currentSession.createQuery("from Restaurant  where Zipcode =:aNumber", Restaurant.class);
//		theQuery.setParameter("aNumber", Zipcode);
//		List<Restaurant> results = theQuery.list();
//		return results;
//	}
	@Override
	public List<Restaurant> findAllRestaurants(String Zipcode) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Restaurant> theQuery = currentSession.createQuery("from Restaurant  where Zipcode =:aNumber", Restaurant.class);
		theQuery.setParameter("aNumber", Zipcode);
		
		List<Restaurant> results = theQuery.list();
		
		
		return results;
	}

	@Override
	public List<Restaurant> findAllRestaurant(String restaurantName) {
Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Restaurant> theQuery = currentSession.createQuery("from Restaurant  where restaurantName =:aNumber", Restaurant.class);
		theQuery.setParameter("aNumber", restaurantName);
		
		List<Restaurant> results = theQuery.list();
		
		
		return results;
	}

	@Override
	public Restaurant findByUserName(String restaurantName) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Restaurant> theQuery = currentSession.createQuery("from Restaurant  where restaurantName =:aNumber", Restaurant.class);
		theQuery.setParameter("aNumber", restaurantName);
		
			Restaurant  rest = null;
		
		try {
			 rest = theQuery.getSingleResult();
		}
		catch (Exception e) {
			 rest = null;
		}
		return  rest;
		
	}

//	@Override
//	public List<Restaurant> findAllRestaurants(String searchString, String searchType) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
