package com.cognizant.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cognizant.dao.CustomerDAO;
import com.cognizant.entity.Customer;
import com.cognizant.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// inject customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		// get customers from service
		List<Customer> theCustomers = customerService.getCustomers();
		// add customers to model
		model.addAttribute("customers", theCustomers);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAddNewCustomer")
	public String showFormForAddNewCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "add-customer-form";
	}
	
	@GetMapping("/saveCustomer")
	public String saveCustomer (@ModelAttribute("customer") Customer theCustomer
			, BindingResult bindingResult) {
		System.out.println(theCustomer.getEmail());
		if(bindingResult.hasErrors() || theCustomer.getEmail().trim()==null || theCustomer.getEmail().trim()=="" ) {
			return "add-customer-form";
		}
		
		else {
		// save the customer using service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/showFormForAddNewCustomer";
		}
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId 
			, Model model) {
		// get customer from service
		Customer customer = customerService.getCustomer(theId);
		// set customer as a model attribute to prepopulate the form
		model.addAttribute("customer", customer);
		// send over to our update form
		return "add-customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId)  {
		// delete the customer
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	
	@PostMapping("/deleteSelected")
	public String deleteSelected(@RequestParam("checkid") int[] theIds , Model model) {
		//model.addAttribute("deleteids", theIds);
		customerService.deleteMultipleCustomer(theIds);
		System.out.println("deleteSelected deleteSelected");
		for (int i = 0; i < theIds.length; i++) {
			System.out.println(theIds[i]);
		}
		
		return "redirect:/customer/list";

		}
		
	
	
	@GetMapping("/search")
	public String search(@RequestParam("searchByName") String SearchName , Model model) {
		
	//Customer customer =	customerService.searchName(SearchName);
	// get customers from service
			List<Customer> theCustomers = customerService.searchName(SearchName);
			// add customers to model
			model.addAttribute("customers", theCustomers);
			return "list-customers";
		
	}
	
	@GetMapping("/searchByEmail")
	public String searchByEmail(@RequestParam("searchByEmail") String searchEmail , Model model) {
		
		List<Customer> theCustomers = customerService.searchByEmail(searchEmail);
		
		model.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	
	
	
	
	
	
	

}
