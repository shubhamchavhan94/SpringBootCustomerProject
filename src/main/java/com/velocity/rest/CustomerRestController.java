package com.velocity.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.velocity.model.Customer;
import com.velocity.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {
		Customer customer = customerService.getCustomer(id);
		
		System.out.println("Hello");

		System.out.println("hello controller");
		return customer;
		
	}
	@GetMapping("/customers")
	public List<Customer> getPagination(@RequestParam(defaultValue = "0") int pageNo,
			                           @RequestParam(defaultValue = "10") int pageSize){
		List<Customer> pagination = customerService.getPagination(pageNo, pageSize);
		return pagination;
	}	
}
