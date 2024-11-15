package com.velocity.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		System.out.println("hello everyone");
		System.out.println("Good Morning...");
		System.out.println("hello controller");
		return customer;

	}

	@GetMapping("/customers")
	public List<Customer> getPagination(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize) {
		List<Customer> pagination = customerService.getPagination(pageNo, pageSize);
		return pagination;
	}

	// get operation based on city
	@GetMapping("/customers/getCity/{city}")
	public List<Customer> getByCity(@PathVariable("city") String city) {
		List<Customer> list = customerService.getByCity(city);
		return list;
	}

	@GetMapping("/customers/getName/{name}")
	public List<Customer> getCustomerByName(@PathVariable("name") String name) {
		List<Customer> customerByName = customerService.getCustomerByName(name);
		return customerByName;
	}

	// ---------------------
	// save customer operation
	@PostMapping("/customers/save")
	public Customer saveCustomer(@RequestBody Customer customer) {
		Customer saveCustomer = customerService.saveCustomer(customer);
		return saveCustomer;
	}

	// get all customers operation
	@GetMapping("/customers/getall")
	public List<Customer> getAllCustomers(Customer customer){
		List<Customer> allCustomers = customerService.getAllCustomers(customer);
		return allCustomers;
	}

	// update customer operation
	@PutMapping("/customers/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		Customer updateCustomer = customerService.updateCustomer(customer);
		return updateCustomer;
	}

	// delete customer operation
	@DeleteMapping("/customers/delete/{id}")
	public String deleteCustomer(@PathVariable("id") Integer id) {
		customerService.deleteCustomer(id);
		return "Data deleted successfully";
	}
}
