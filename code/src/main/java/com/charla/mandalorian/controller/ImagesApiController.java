package com.charla.mandalorian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import com.charla.mandalorian.domain.GetImageUseCase;
import com.charla.mandalorian.domain.ImageDTO;
import com.charla.mandalorian.domain.PostImageUseCase;
import com.charla.mandalorian.rest.api.ImagesApi;

import lombok.RequiredArgsConstructor;

@Controller
public class ImagesApiController implements ImagesApi {

	@Autowired 
	GetImageUseCase getImageUseCase;
	
	@Autowired
	PostImageUseCase postImageUseCase;
	
	private final String TEST_CAM = "TESTCAM";
	
/*	@Override
	public ResponseEntity<InlineResponse200DTO> imagesGet(String idCamera) {
		String camera = idCamera == null ? TEST_CAM: idCamera;
		ImageDTO imageDTO = getImageUseCase.getImageFromCamera(idCamera);
		InlineResponse200DTO response = imageDTOInlineResponseMapper.ImageDTOtoInlineResponse(imageDTO);
		return new ResponseEntity<InlineResponse200DTO>(response, HttpStatus.OK);
	}*/
	


	@Override
	public ResponseEntity<Resource> imagesGet(String idCamera) {
		String camera = idCamera == null ? TEST_CAM: idCamera;
		ImageDTO imageDTO = getImageUseCase.getImageFromCamera(idCamera);
		return new ResponseEntity<Resource>(new ByteArrayResource(imageDTO.getImage()), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> imagesIdCameraPost(String idCamera, MultipartFile file) {
		postImageUseCase.postImage(idCamera, file);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
