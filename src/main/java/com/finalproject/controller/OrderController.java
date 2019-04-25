package com.finalproject.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.dao.OrderDao;
import com.finalproject.dao.RestaurantDao;
import com.finalproject.dao.UserDao;
import com.finalproject.pojo.OrderDetails;
import com.finalproject.pojo.Restaurant;
import com.finalproject.pojo.User;
import com.finalproject.services.OrderService;
import com.finalproject.services.RestaurantService;
import com.finalproject.services.UserService;




@Controller
@RequestMapping("/order")
public class OrderController {
	
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
	
	@PostMapping("/orderController")
	public ModelAndView processManagerRegistrationForm(
		@Valid @ModelAttribute("order") Restaurant rs,
		BindingResult theBindingResult,HttpServletRequest request,HttpSession session,Principal principal,Authentication auth,
		Model model) {
		
		String product = request.getParameter("rb");
		List<Restaurant> rest = restaurantService.findAllRestaurant(product);     
		model.addAttribute("rest", rest);
		session.setAttribute("ro", product);
		
		
	return new ModelAndView("demo", "rest", rest);
	}
	
	
	List<String> r= new ArrayList();
	@PostMapping("/OrderConfirm")
	public ModelAndView processOrderConfirm(
			@Valid @ModelAttribute("restaurant") Restaurant rs,
			BindingResult theBindingResult,HttpServletRequest request,HttpSession session,Principal principal,
			Model model) {
			
		String  product = request.getParameter("rb");
		
			
		r.add(product);
	        
			model.addAttribute("r", r);
			
			
		return new ModelAndView("OrderCart", "r", r);
		
		
	}
		
		@PostMapping("/OrderRemove")
		public ModelAndView processOrderRemove(
				@Valid @ModelAttribute("restaurant") Restaurant rs,
				BindingResult theBindingResult,HttpServletRequest request,HttpSession session,
				Model model) {
				
			
			
				//String  product = request.getParameter("rb");
				     
				     r.remove(0);
		
			return new ModelAndView("OrderCart", "r", r);
		}		
			
			
			@PostMapping("/OrderConfirmation")
			public ModelAndView processOrderConfirmation(
					@Valid @ModelAttribute("restaurant") Restaurant rs,
					BindingResult theBindingResult,HttpServletRequest request,HttpSession session,Principal principal,
					Model model) {
				
			
			
				return new ModelAndView("Confirmation", "r", r);

}
	
	
	
			@PostMapping("/odetails")
			public String processOrderRegistrationdetails (
					@Valid @ModelAttribute("restaurant") OrderDetails order,HttpSession session,Principal principal,HttpServletRequest request,
					BindingResult theBindingResult,
					Model theModel)throws EmailException {
				String rso=(String) session.getAttribute("ro");
			     User us=userService.findByUserName(principal.getName());
				
				Restaurant rsss=restaurantService.findByUserName(rso);
				

					User u=userService.findbyUuid(us.getUserId());
					
					OrderDetails detail = new OrderDetails();
					detail.setUser(u);
					detail.setRestaurant(rsss);
					detail.setOrderdetails(request.getParameter("Orderdetails"));
					orderService.save(detail);
					Email email = new SimpleEmail();
					email.setHostName("smtp.googlemail.com");
					email.setSmtpPort(465);
					//User your gmail username and password
					email.setAuthenticator(new DefaultAuthenticator("yourmail@gmail.com", "password"));
					email.setSSLOnConnect(true);
					email.setFrom("no-reply@gmail.com");
					email.setSubject("TestMail");
					email.setMsg("Your Order has been received");
					email.addTo("recievermail@gmail.com");
					email.send();
				
				return "OrderDone";
				
			}
	
			@PostMapping("/exportData")
			public ModelAndView exportData(
					@ModelAttribute("orderdetails") OrderDetails o, Model model,HttpSession session,Principal principal,HttpServletRequest request ) {
				
				String oder=	request.getParameter("orderid");
				
					List<OrderDetails> orderList = orderService.findallorders(Long.valueOf(oder));
					
					return new ModelAndView(new PDFOrderReportView(), "orderList", orderList);
				
				
			}
			
			

}
