package com.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.finalproject.services.UserService;



@Controller
public class AdminController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/manager")
	public String showEmployeePage() {
		
		return "RestaurantView";
	}
	
	
	
	@GetMapping("/admin")
	public String showAdminPage() {
		
		return "manager";
	}
	
	@GetMapping("/customer")
	public String showUserPage() {
		
		return "customer-home";
	}
}
