package com.velocity.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.velocity.model.Image;

@Repository
public interface ImageRepository extends CrudRepository<Image, Serializable>{

	public Image findById(Integer id);
}
