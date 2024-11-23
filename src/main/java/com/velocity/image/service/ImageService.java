package com.velocity.image.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.velocity.model.Image;

public interface ImageService {

	public Image uploadImage(MultipartFile file) throws IOException;
	
	public Image getImage(Integer id);
}
