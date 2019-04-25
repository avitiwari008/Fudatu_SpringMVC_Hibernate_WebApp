package com.finalproject.controller;


import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalproject.pojo.Restaurant;
import com.finalproject.pojo.User;
import com.finalproject.services.UserService;
import com.finalproject.users.Admin;
import com.finalproject.users.Customer;
import com.finalproject.users.RestaurantManager;



@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
	}
	
	@GetMapping("/showRegistrationForm")
	public String showMyLoginPage(Model theModel) {
		theModel.addAttribute("customer", new Customer());
		
		return "registration-form";
	}
		
	
	
	@GetMapping("/showManagerRegistrationForm")
	public String showManagerRegistrationForm(Model theModel) {
		theModel.addAttribute("restaurantmanager", new RestaurantManager());
		
		return "restaurantmanagerregistration";
	}

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(
			@Valid @ModelAttribute("customer") Customer customer,
			BindingResult theBindingResult, 
			Model theModel) {
		
		String userName = customer.getUserName();
		logger.info("Processing registration form for: " + userName);
		
	
		if (theBindingResult.hasErrors()){
			return "registration-form";
		}
		
		
		User existing = userService.findByUserName(userName);
		if(existing != null) {
			theModel.addAttribute("customer", new Customer());
			theModel.addAttribute("registrationError", "User name already exists.");
			
			logger.warning("User name already exists.");
        	return "registration-form";	
		}
		
		//create user account
		
		userService.save(customer);
		
		logger.info("Successfully created user: " + userName);
        
        return "registrationconfirmation";	
		
	}
	
	
	
	@PostMapping("/processManagerRegistrationForm")
	public String processManagerRegistrationForm(
			@Valid @ModelAttribute("restaurantmanager") RestaurantManager manager,
			BindingResult theBindingResult,
			Model theModel) {
		
		String userName = manager.getUserName();
		
		if(theBindingResult.hasErrors()) {
			return "restaurantmanagerregistration";
		}
		
		User existing = userService.findByUserName(userName);
		if(existing != null) {
			theModel.addAttribute("restaurantmanager", new RestaurantManager());
			theModel.addAttribute("registrationError", "User name already exists");
			
			logger.warning("User name already exists");
			return "restaurantmanagerregistration";
		}
		
		userService.saveManager(manager);
		return "registrationconfirmation";
		
	}
	
	
	@GetMapping("/restdetails")
	public String BrowseRestaurants(Model model,Restaurant rs) {
		

		
		
		return "customer-home";
		
		
		
	}
}
