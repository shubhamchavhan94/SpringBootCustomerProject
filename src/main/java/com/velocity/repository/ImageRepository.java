package com.velocity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velocity.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

	
	//get operation on file based on id
	public Image findById(int id);
}