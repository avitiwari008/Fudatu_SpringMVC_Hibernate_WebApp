package com.finalproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.dao.OrderDao;
import com.finalproject.dao.RestaurantDao;
import com.finalproject.dao.UserDao;
import com.finalproject.exception.RestaurantException;
import com.finalproject.pojo.Restaurant;
import com.finalproject.services.OrderService;
import com.finalproject.services.RestaurantService;
import com.finalproject.services.UserService;




@Controller
@RequestMapping("/cust")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderService orderService;
	
	
		@GetMapping("/processManagerRegistrationForm")
		public String processManagerRegistrationForm(
				@Valid @ModelAttribute("restaurant") Restaurant rs,HttpServletRequest request,
				BindingResult theBindingResult,
				Model model) {
			
			
			
			return "customer-home";
			
	}
	
	
	
	
		@PostMapping("/processManagerRegistrationForm")
		public ModelAndView processManagerRegistrationForm(
				@Valid@ModelAttribute("restaurant") Restaurant rs,
			BindingResult theBindingResult,HttpServletRequest request,HttpSession session,
			Model model) {
			
			//String keyword = request.getParameter("Zipcode");
	        String crite = request.getParameter("Zipcodet");
	      
	        List<Restaurant> rest = restaurantService.findAllRestaurants(crite);
	       
	        
	        
			model.addAttribute("rest", rest);
	       
	      
			return new ModelAndView("Result", "rest", rest);
	
		}
	
}
