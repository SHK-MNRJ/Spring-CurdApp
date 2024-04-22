package com.SpringCrud.SpringApplication.Controller;

import java.util.*;
import com.SpringCrud.SpringApplication.DTO.*;
import com.SpringCrud.SpringApplication.Service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(path="/getAll")
	public List<CustomerDTO> getAllCustomer() {
		List<CustomerDTO> allCustomers=customerService.getAllCustomer();
		return allCustomers;
	}
	
	@PostMapping(path="/save")
	public String saveCustomer(@RequestBody CustomerSaveDTO customerSaveDTO) {
		String id=customerService.addCustomer(customerSaveDTO);
		return id;
	}

	@PostMapping(path="/update")
	public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
		String id=customerService.updateCustomer(customerUpdateDTO);
		return id;
	}
	
	@DeleteMapping(path="/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable(value="id") int id) {
		boolean deletecustomer=customerService.deleteCustomer(id);
		return "Deleted...";
	}
}
