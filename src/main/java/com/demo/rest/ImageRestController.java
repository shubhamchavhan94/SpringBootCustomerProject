package com.demo.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.image.service.ImageService;
import com.demo.model.Image;


@RestController
@RequestMapping("/api")

public class ImageRestController {

	@Autowired
	private ImageService imageService;


	@PostMapping("/images")
	public Image saveImage(@RequestParam("file") MultipartFile multipartFile) throws IOException {
		Image saveImage = imageService.saveImage(multipartFile);
		return saveImage;

	}
	
	@GetMapping("/images/{id}")
	public Image getImage(@PathVariable int id) {
		Image image = imageService.getImage(id);
		return image;
	}
}
