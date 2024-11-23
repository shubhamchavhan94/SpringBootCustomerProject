package com.velocity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "claim")
public class Claim {

	// Id Claim type Claim amount userId(Fk)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String claimType;
	private long claimAmount;
	private Integer userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public long getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(long claimAmount) {
		this.claimAmount = claimAmount;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Claim [id=" + id + ", claimType=" + claimType + ", claimAmount=" + claimAmount + ", userId=" + userId
				+ "]";
	}

}
