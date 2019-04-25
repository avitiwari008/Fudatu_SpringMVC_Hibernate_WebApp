package com.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class LoginController {
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
	
		return "Login";
		
	}
	
	@GetMapping("/accessdenied")
	public String showAccessDenied() {
		
		return "accessdenied";
		
	}

}
