package com.demo.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.demo.model.Claim;
import com.demo.model.Customer;
import com.demo.model.Policy;
import com.demo.service.ClaimService;
import com.demo.service.CustomerService;
import com.demo.service.PolicyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	Logger logger = LoggerFactory.getLogger(CustomerRestController.class);
	@Autowired
	private CustomerService customerService;

	@Autowired
	private PolicyService policyService;

	@Autowired
	private ClaimService claimService;

	// get operation based on id
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {
		Customer customer = customerService.getCustomer(id);
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

	// save customer operation
	@PostMapping("/customers/save")
	public Customer saveCustomer(@RequestBody @Valid Customer customer) {
		logger.info("Inside saveCustomer() method of rest controller.");
		Customer saveCustomer = customerService.saveCustomer(customer);
		return saveCustomer;
	}

	// get all customers operation
	@GetMapping("/customers/getall")
	public List<Customer> getAllCustomers(Customer customer) {
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

	// ---------

	@PostMapping("/customers/save/policy/claim")
	public Customer saveCustomerPolicyClaim(@RequestBody @Valid Customer customer) {

		// save customer
		Customer saveCustomer = customerService.saveCustomer(customer);

		// multiple policy

		List<Policy> policyList = saveCustomer.getPolicyList();

		for (Policy policy : policyList) {
			policy.setCustomerId(customer.getId());
			policyService.savePolicy(policy);
		}

		// multiple claim

		List<Claim> claimList = saveCustomer.getClaimList();

		for (Claim claim : claimList) {
			claim.setCustomerId(customer.getId());
			claimService.saveClaim(claim);
		}

		return saveCustomer;

	}
}
