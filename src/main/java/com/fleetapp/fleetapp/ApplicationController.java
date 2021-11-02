package com.fleetapp.fleetapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
	
	//method to return the homepage:
	@GetMapping("/index")
	public String goHome()
	{
		return "index";
	}
	
	//method to return the login page:
	@GetMapping("/login")
	public String goToLoginPage()
	{
		return "login";
	}
	
	//method to return the logout page:
	@GetMapping("/logout")
	public String goToLogoutPage()
	{
		return "login";
	}

}
