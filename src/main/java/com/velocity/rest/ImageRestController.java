package com.velocity.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.velocity.image.service.ImageService;
import com.velocity.model.Image;

@RequestMapping("/api")
@RestController
public class ImageRestController {

	@Autowired
	private ImageService imageService;

	@PostMapping("/customers/image")
	public Image uploadImage(@RequestBody MultipartFile file) throws IOException{
		Image image = imageService.uploadImage(file);
		return image;
	}

	@GetMapping("/customers/image/{id}")
	public Image getImage(@PathVariable ("id") Integer id) {
		Image image = imageService.getImage(id);
		return image;
	}
}
