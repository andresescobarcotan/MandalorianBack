package com.charla.mandalorian.usecase;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.charla.mandalorian.domain.ImageRepository;
import com.charla.mandalorian.domain.PostImageUseCase;

public class PostImageUseCaseImpl implements PostImageUseCase {
	
	@Autowired
	private ImageRepository imageRepository;
	
	public PostImageUseCaseImpl(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}
	@Override
	public void postImage(String idCamera, MultipartFile file) {
		try {
			String fileName = file.getOriginalFilename();
			byte[] dataImage = file.getBytes();
			this.imageRepository.createImage(idCamera, fileName, dataImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
