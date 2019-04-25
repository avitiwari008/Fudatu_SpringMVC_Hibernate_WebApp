package com.finalproject.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;




@Entity

public class OrderDetails {
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="user_id")
	private User user;
	
	
	@Override
	public String toString() {
		return "Order [user=" + user + ", restaurant=" + restaurant + ", OrderId=" + OrderId + ", Orderdetails="
				+ Orderdetails + "]";
	}


	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private long OrderId;

	
	@Column(name = "Orderdetails")
	private String Orderdetails;

	public OrderDetails() {}
	
	
//	public Order(User user,Restaurant restaurant,long OrderId,String Orderdetails) {
//        this.user=user;
//        this.restaurant=restaurant;
//        this.OrderId=OrderId;
//        this.Orderdetails=Orderdetails;
//    }

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Restaurant getRestaurant() {
		return restaurant;
	}


	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}


	public long getOrderId() {
		return OrderId;
	}


	public void setOrderId(long orderId) {
		OrderId = orderId;
	}


	public String getOrderdetails() {
		return Orderdetails;
	}


	public void setOrderdetails(String orderdetails) {
		Orderdetails = orderdetails;
	}
	
	
	
}
