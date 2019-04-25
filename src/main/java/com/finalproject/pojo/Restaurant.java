package com.finalproject.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurant {
	
	
	@Column(name = "restaurantName")
	private String restaurantName;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int restaurantId;
	
	@Column(name = "Zipcode")
	private String Zipcode;
	
	@Column(name = "restaurantMenu")
	private String restaurantMenu;
	
	@Column(name = "Costfor2")
	private String Costfor2;

	public Restaurant() {}
	
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getZipcode() {
		return Zipcode;
	}
	public void setZipcode(String Zipcode) {
		this.Zipcode = Zipcode;
	}
	public String getRestaurantMenu() {
		return restaurantMenu;
	}
	public void setRestaurantMenu(String restaurantMenu) {
		this.restaurantMenu = restaurantMenu;
	}
	public String getCostfor2() {
		return Costfor2;
	}
	public void setCostfor2(String costfor2) {
		this.Costfor2 = costfor2;
	}
	
}
