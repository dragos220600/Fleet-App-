package com.fleetapp.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fleetapp.fleetapp.models.Country;
import com.fleetapp.fleetapp.services.CountryService;

@Controller
public class CountryController {
	
	@Autowired private CountryService countryService;
	
	//Get All Countrys
//	@GetMapping("/countries")
//	public String getCountries(Model model)//param model is needed to pass content of countryList to HTML
//	{
//		List<Country> countryList = countryService.getCountries();
//		
//		//list of countries is passed into the model object:
//		model.addAttribute("countries", countryList);//list content accessed by attribute name "countries"		
//		return "Country";// adds .html automatically
//	}
	
	@GetMapping("/countries")
	public String findAll(Model model){		
		model.addAttribute("countries", countryService.findAll());
		return "Country"; 
	}	
	
	@RequestMapping("countries/findById") 
	@ResponseBody //without this, no pre-populated form in edit mode
	public Optional<Country> findById(Integer id) //for pre-populating edit form
	{
		return countryService.findById(id);
	}
	
	
	//Add Country
	@PostMapping(value="countries/addNew")
	public String addNew(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}	
	
	@RequestMapping(value="countries/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}
	
	@RequestMapping(value="countries/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		countryService.delete(id);
		return "redirect:/countries";
	}
}
