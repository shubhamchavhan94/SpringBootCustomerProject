package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Claim;

@Repository

public interface ClaimRepository extends JpaRepository<Claim, Integer>{

}
