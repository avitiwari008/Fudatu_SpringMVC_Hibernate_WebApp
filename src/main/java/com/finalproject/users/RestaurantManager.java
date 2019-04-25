package com.finalproject.users;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.finalproject.Validation.FieldMatcher;
import com.finalproject.Validation.ValidEmail;




public class RestaurantManager {
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String userName;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String password;


//	@NotNull(message = "is required")
//	@Size(min = 1, message = "is required")
//	private String restaurantName;

//	@NotNull(message = "is required")
//	@Size(min = 1, message = "is required")
//	private String zipCode;

	@ValidEmail
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String email;
	
	public RestaurantManager() {
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
//
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public String getMatchingPassword() {
//		return matchingPassword;
//	}
//
//	public void setMatchingPassword(String matchingPassword) {
//		this.matchingPassword = matchingPassword;
//	}

//	public String getFirstName() {
//		return firstName;
//	}

//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}

//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
