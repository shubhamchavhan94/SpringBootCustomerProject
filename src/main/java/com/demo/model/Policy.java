package com.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "policy")
public class Policy {

	/*
	 * Policy - Id Name Status
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	@NotEmpty
	private String name;
	@NotBlank
	private String status;

//	@JoinColumn(name = "customerId")
	private Integer customerId;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customer) {
		this.customerId = customer;

	}

	@Override
	public String toString() {

		return "Policy [id=" + id + ", name=" + name + ", status=" + status + ", customer=" + customerId + "]";
	}

}
