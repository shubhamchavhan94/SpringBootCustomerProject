package com.demo.image.service;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.demo.model.Image;
import com.demo.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;

	@Override
	public Image saveImage(MultipartFile multipartFile) throws IOException {
		String originalFilename = multipartFile.getOriginalFilename();
		String contentType = multipartFile.getContentType();
		byte[] bytes = multipartFile.getBytes();
		Image image = new Image(originalFilename, contentType, bytes);
		Image images = imageRepository.save(image);
		return images;
	}

	@Override
	public Image getImage(int id) {
		Image image = imageRepository.findById(id);
		return image;
	}
}
