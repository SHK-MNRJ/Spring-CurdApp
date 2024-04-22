package com.SpringCrud.SpringApplication.Service;

import java.util.*;
import com.SpringCrud.SpringApplication.DTO.*;

public interface CustomerService {
	String addCustomer(CustomerSaveDTO customerSaveDTO);
	List<CustomerDTO> getAllCustomer();
	String updateCustomer(CustomerUpdateDTO customerUpdateDTO);
	boolean deleteCustomer(int id);
}
