package com.charla.mandalorian.infrastructure;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.charla.mandalorian.domain.H2ImageRepository;
import com.charla.mandalorian.domain.Image;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.charla.mandalorian.domain.ImageRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ImageRepositoryImpl implements ImageRepository {



	@Autowired
	H2ImageRepository h2ImageRepository;

	private final String TEST_FILE = "test.jpg";

	@PostConstruct
	public void initDatabase(){
		System.out.println("Initializing Database with the test image");
		byte[] fileRead = new byte[0];
		try {
			fileRead =ImageRepositoryImpl.class.getClassLoader().getResourceAsStream(TEST_FILE).readAllBytes();
			h2ImageRepository.save(new Image(TEST_FILE, fileRead));
			System.out.println("Image by default save correctly");
		} catch (IllegalArgumentException|IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public byte[] getImage(String idCamera) {
		byte[] imageData = new byte[0];
		System.out.println("Infrastructure module");

		if(idCamera!=null) {
			Optional<Image> image = h2ImageRepository.findById(idCamera);
			imageData = image.isPresent() ? image.get().getImage() : h2ImageRepository.findById(TEST_FILE).get().getImage();

		}
		
		return imageData;
	}

	@Override
	public void createImage(String idCamera, String fileName, byte[] image) {

		h2ImageRepository.save(new Image(idCamera, image));

	}

}
