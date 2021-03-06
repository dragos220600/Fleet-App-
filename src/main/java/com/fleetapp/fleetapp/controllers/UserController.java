package com.fleetapp.fleetapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fleetapp.fleetapp.models.User;
import com.fleetapp.fleetapp.services.UserService;
import com.fleetapp.fleetapp.services.CountryService;
import com.fleetapp.fleetapp.services.UserService;

@Controller
public class UserController {
	
	@Autowired private UserService userService;
	
	//Get All Users
//	@GetMapping("/users")
//	public String getUsers()
//	{
//		return "User";
//	}
	
	@GetMapping("/users")
	public String findAll(Model model){		
		model.addAttribute("users", userService.findAll());
		return "User";
	}	
	
	@RequestMapping("users/findById") 
	@ResponseBody
	public Optional<User> findById(Integer id)
	{
		return userService.findById(id);
	}
	
//	@RequestMapping("users/findByUserName") 
//	@ResponseBody
//	public User findByUserName(String username)
//	{
//		return userService.findByUserName(username);
//	}
	
	//Add User
	@PostMapping(value="users/addNew")
	public String addNew(User user) {
		userService.save(user);
		return "redirect:/users";
	}	
	
	@RequestMapping(value="users/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(User user) {
		userService.save(user);
		return "redirect:/users";
	}
	
	@RequestMapping(value="users/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		userService.delete(id);
		return "redirect:/users";
	}


}
