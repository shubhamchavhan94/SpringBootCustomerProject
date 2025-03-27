package com.demo.image.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.demo.model.Image;

public interface ImageService {

	// to upload/save a file using multipart file
	public Image saveImage(MultipartFile multipartFile) throws IOException;
	
	public Image getImage(int id);
}