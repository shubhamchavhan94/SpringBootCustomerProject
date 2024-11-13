package com.velocity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.velocity.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	// get operation based on id
	public Customer findById(int id);

	// get customer by sorting by name
	@Query(value = "select * from customer c where name = ?1 ", nativeQuery = true)
	public List<Customer> findByName(String name);

}
