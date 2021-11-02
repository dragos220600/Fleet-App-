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

import com.fleetapp.fleetapp.models.InvoiceStatus;
import com.fleetapp.fleetapp.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {

	@Autowired private InvoiceStatusService invoiceStatusService;
	
	//Get All InvoiceStatuss
//	@GetMapping("/invoicestatuses")
//	public String getInvoiceStatuses()
//	{
//		return "InvoiceStatus";
//	}
	
	@GetMapping("/invoicestatuses")
	public String findAll(Model model){		
		model.addAttribute("invoicestatuses", invoiceStatusService.findAll());
		return "InvoiceStatus";
	}	
	
	@RequestMapping("invoicestatuses/findById") 
	@ResponseBody
	public Optional<InvoiceStatus> findById(Integer id)
	{
		return invoiceStatusService.findById(id);
	}
	
	//Add InvoiceStatus
	@PostMapping(value="invoicestatuses/addNew")
	public String addNew(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoicestatuses";
	}	
	
	@RequestMapping(value="invoicestatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoicestatuses";
	}
	
	@RequestMapping(value="invoicestatuses/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		invoiceStatusService.delete(id);
		return "redirect:/invoicestatuses";
	}
}
