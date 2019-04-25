package com.finalproject.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.pojo.OrderDetails;
import com.finalproject.services.RestaurantOrderServices;



@Controller
@RequestMapping("/rmm")
public class RestaurantorderController {

	
	
	@Autowired
	private RestaurantOrderServices restO;

	

	
	
	
	@PostMapping("/rmconfirm")
	public String RMconfirm(Model model) {
		model.addAttribute("restaurant",new OrderDetails());
			
	
		return "RMorderconfirm";
		
		
		
	}
	List<OrderDetails>order = new ArrayList<>();
	
	@PostMapping("/rest")
	public ModelAndView processOrderConfirm(
			@Valid @ModelAttribute("restaurant") OrderDetails rs,
			BindingResult theBindingResult,HttpServletRequest request,HttpSession session,Principal principal,
			Model model) {
		
	
		order =	restO.findAllOrder();
		
		model.addAttribute("order", order);
			
		return new ModelAndView("Demo2", "order", order);
		
		
	}
	
	
	

}



