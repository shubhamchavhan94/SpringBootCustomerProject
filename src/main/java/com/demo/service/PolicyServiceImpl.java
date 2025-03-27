package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Policy;
import com.demo.repository.PolicyRepository;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyRepository policyRepository;
	
	@Override
	public Policy savePolicy(Policy policy) {
		Policy policy2 = policyRepository.save(policy);
		return policy2;
	}

}
