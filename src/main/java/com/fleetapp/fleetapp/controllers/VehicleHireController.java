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

import com.fleetapp.fleetapp.models.VehicleHire;
import com.fleetapp.fleetapp.services.ClientService;
import com.fleetapp.fleetapp.services.EmployeeService;
import com.fleetapp.fleetapp.services.LocationService;
import com.fleetapp.fleetapp.services.VehicleHireService;
import com.fleetapp.fleetapp.services.VehicleService;

@Controller
public class VehicleHireController {
	
	@Autowired private VehicleHireService vehicleHireService;
	@Autowired private ClientService clientService;
	@Autowired private EmployeeService employeeService;
	@Autowired private LocationService locationService;
	@Autowired private VehicleService vehicleService;
	
	//Get All VehicleHires
//	@GetMapping("/vehiclehires")
//	public String getVehicleHires()
//	{
//		return "VehicleHire";
//	}
	
	@GetMapping("/vehiclehires")
	public String findAll(Model model){		
		model.addAttribute("vehiclehires", vehicleHireService.findAll());
		model.addAttribute("clients", clientService.findAll());
		model.addAttribute("employees", employeeService.findAll());
		model.addAttribute("locations", locationService.findAll());
		model.addAttribute("vehicles", vehicleService.findAll());

		return "VehicleHire";
	}	
	
	@RequestMapping("vehiclehires/findById") 
	@ResponseBody
	public Optional<VehicleHire> findById(Integer id)
	{
		return vehicleHireService.findById(id);
	}
	
	//Add VehicleHire
	@PostMapping(value="vehiclehires/addNew")
	public String addNew(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehiclehires";
	}	
	
	@RequestMapping(value="vehiclehires/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehiclehires";
	}
	
	@RequestMapping(value="vehiclehires/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		vehicleHireService.delete(id);
		return "redirect:/vehiclehires";
	}


}
