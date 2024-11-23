package com.velocity.image.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.velocity.model.Image;
import com.velocity.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService{

	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	public Image uploadImage(MultipartFile file) throws IOException {
		String filename = file.getOriginalFilename();
		Image image = new Image(filename, file.getContentType(), file.getBytes());
		Image image2 = imageRepository.save(image);
		return image2;
	}

	@Override
	public Image getImage(Integer id) {
		Image image = imageRepository.findById(id);
		return image;
	}

	
}
