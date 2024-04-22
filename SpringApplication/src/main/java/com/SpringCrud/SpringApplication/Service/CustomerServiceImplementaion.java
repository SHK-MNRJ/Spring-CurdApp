package com.SpringCrud.SpringApplication.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringCrud.SpringApplication.CustomerRepository.CustomerRepository;
import com.SpringCrud.SpringApplication.DTO.CustomerDTO;
import com.SpringCrud.SpringApplication.DTO.CustomerSaveDTO;
import com.SpringCrud.SpringApplication.DTO.CustomerUpdateDTO;
import com.SpringCrud.SpringApplication.Entity.Customer;

@Service
public class CustomerServiceImplementaion implements CustomerService{
	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public String addCustomer(CustomerSaveDTO customerSaveDTO) {
		Customer customer=new Customer(
				customerSaveDTO.getCustomername(),
				customerSaveDTO.getCustomeraddress(),
				customerSaveDTO.getMobile()
		);
		customerRepo.save(customer);
		return customer.getCustomername();
	}
	
	@Override
	public List<CustomerDTO> getAllCustomer() {
		
		List<Customer> getCustomers= customerRepo.findAll();
		List<CustomerDTO> customerDTOList=new ArrayList<>();
		for(Customer members:getCustomers) {
			CustomerDTO customerDTO=new CustomerDTO(
					members.getCustomerid(),
					members.getCustomername(),
					members.getCustomeraddress(),
					members.getMobile()
					);
			customerDTOList.add(customerDTO);
		}
		//System.out.println("\n\n\n=================>"+customerDTOList);
		return customerDTOList;
	}
	
	@Override
	public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
		if(customerRepo.existsById(customerUpdateDTO.getCustomerid())) {
			Customer customer=customerRepo.getById(customerUpdateDTO.getCustomerid());
			customer.setCustomername(customerUpdateDTO.getCustomername());
			customer.setCustomeraddress(customerUpdateDTO.getCustomeraddress());
			customer.setMobile(customerUpdateDTO.getMobile());
			
			customerRepo.save(customer);
		}
		else {
			return ("Customer Id do not exist");
		}
	return "Updated...";
	}
	
	@Override
	public boolean deleteCustomer(int id) {
		if(customerRepo.existsById(id)) {
			customerRepo.deleteById(id);
		}
		else {
			System.out.println("Customer id not found");
		}
		return false;
	}
}
