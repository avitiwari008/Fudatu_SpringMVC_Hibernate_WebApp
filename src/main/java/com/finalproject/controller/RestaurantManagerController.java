package com.finalproject.controller;

import java.security.Principal;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.dao.OrderDao;
import com.finalproject.dao.RestaurantDao;
import com.finalproject.pojo.OrderDetails;
import com.finalproject.pojo.Restaurant;
import com.finalproject.pojo.User;
import com.finalproject.services.RestaurantOrderServices;
import com.finalproject.services.RestaurantService;
import com.finalproject.services.UserService;
import com.finalproject.users.RestaurantManager;

@Controller
@RequestMapping("/rm")
public class RestaurantManagerController {
	
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private RestaurantDao restaurantDao;
	@Autowired
	private RestaurantOrderServices restO;

	@Autowired
	private OrderDao orderDao;

	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
		
		
	}
	
	@GetMapping("/restaurant-accounts")
	public String AddRestaurantStuff(Model model) {
		model.addAttribute("restaurant",new Restaurant());
		
		return "RestaurantView";
		
		
		
	}
	
	@GetMapping("/restorder")
	public String AddRestaurant(Model model) {
		model.addAttribute("restaurant",new OrderDetails());
		
		return "SeeOrders";
		
		
		
	}
	
//	@PostMapping("/rmconfirm")
//	public String RMconfirm(Model model) {
//		model.addAttribute("restaurant",new OrderDetails());
//		
//		
//		return "RMorderconfirm";
//		
//		
//		
//	}
//	
//	
//	@PostMapping("/rest")
//	public ModelAndView processOrderConfirm(
//			@Valid @ModelAttribute("restaurant") OrderDetails rs,
//			BindingResult theBindingResult,HttpServletRequest request,HttpSession session,Principal principal,
//			Model model) {
//		
//		
//		List<OrderDetails> order=	restO.findAllOrder();
//		
//		
//			
//		
//		
//		
//		model.addAttribute("order", order);
//			
//		return new ModelAndView("Demo2", "order", order);
//		
//		
//	}
	
	
	@PostMapping("/processManagerRegistrationForm")
	public String processManagerRegistrationForm(
			@Valid @ModelAttribute("restaurant") Restaurant manager,
			BindingResult theBindingResult,
			Model theModel) {
		
			restaurantService.add(manager);
		
		return "registrationconfirmation";
		
	}

}
