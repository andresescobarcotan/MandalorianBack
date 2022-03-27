package com.charla.mandalorian.usecase;

import org.springframework.beans.factory.annotation.Autowired;

import com.charla.mandalorian.domain.GetImageUseCase;
import com.charla.mandalorian.domain.ImageDTO;
import com.charla.mandalorian.domain.ImageRepository;



public class GetImageUseCaseImpl implements GetImageUseCase {

	@Autowired
	private ImageRepository imageRepository;
	
	public GetImageUseCaseImpl(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}
	
	@Override
	public ImageDTO getImageFromCamera(String idCamera) {
		ImageDTO imageDTO = new ImageDTO();
		byte[] fileData = imageRepository.getImage(idCamera);
		imageDTO.setIdCamera(idCamera);
		imageDTO.setImage(fileData);
		return imageDTO;
	}

}
