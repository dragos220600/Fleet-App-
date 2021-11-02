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

import com.fleetapp.fleetapp.models.VehicleStatus;
import com.fleetapp.fleetapp.services.VehicleStatusService;

@Controller
public class VehicleStatusController {
	
	@Autowired private VehicleStatusService vehicleStatusService;
	
	//Get All VehicleStatuss
//	@GetMapping("/vehiclestatuses")
//	public String getVehicleStatuses()
//	{
//		return "VehicleStatus";
//	}
	
	@GetMapping("/vehiclestatuses")
	public String findAll(Model model){		
		model.addAttribute("vehiclestatuses", vehicleStatusService.findAll());
		return "vehicleStatus";
	}	
	
	@RequestMapping("vehiclestatuses/findById") 
	@ResponseBody
	public Optional<VehicleStatus> findById(Integer id)
	{
		return vehicleStatusService.findById(id);
	}
	
	//Add VehicleStatus
	@PostMapping(value="vehiclestatuses/addNew")
	public String addNew(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehiclestatuses";
	}	
	
	@RequestMapping(value="vehiclestatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehiclestatuses";
	}
	
	@RequestMapping(value="vehiclestatuses/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		vehicleStatusService.delete(id);
		return "redirect:/vehiclestatuses";
	}


}
