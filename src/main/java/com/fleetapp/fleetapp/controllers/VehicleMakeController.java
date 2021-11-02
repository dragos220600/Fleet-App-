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

import com.fleetapp.fleetapp.models.VehicleMake;
import com.fleetapp.fleetapp.services.VehicleMakeService;

@Controller
public class VehicleMakeController {
	
	@Autowired private VehicleMakeService vehicleMakeService;
	
	//Get All VehicleMakes
//	@GetMapping("/vehiclemakes")
//	public String getVehicleMakes()
//	{
//		return "VehicleMake";
//	}
	
	
	@GetMapping("/vehiclemakes")
	public String findAll(Model model){		
		model.addAttribute("vehiclemakes", vehicleMakeService.findAll());
		return "vehicleMake";
	}	
	
	@RequestMapping("vehiclemakes/findById") 
	@ResponseBody
	public Optional<VehicleMake> findById(Integer id)
	{
		return vehicleMakeService.findById(id);
	}
	
	//Add VehicleMake
	@PostMapping(value="vehiclemakes/addNew")
	public String addNew(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehiclemakes";
	}	
	
	@RequestMapping(value="vehiclemakes/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehiclemakes";
	}
	
	@RequestMapping(value="vehiclemakes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		vehicleMakeService.delete(id);
		return "redirect:/vehiclemakes";
	}


}
