package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Policy;

@Repository

public interface PolicyRepository extends JpaRepository<Policy, Integer>{

}
